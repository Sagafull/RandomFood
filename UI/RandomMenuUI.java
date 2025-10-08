package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.*;

import Class.RandomList;
import FoodData.CatalogMethod;
import FoodData.DataMethod;

public class RandomMenuUI extends JPanel implements ActionListener,KeyListener{
    
    public RandomList randomlist = new RandomList();
    private DefaultListModel defmodel = new DefaultListModel<>(); 
    private DataMethod dataMethod = new DataMethod();
    private CatalogMethod catalogMethod = new CatalogMethod();
    private JLabel menu,warnningempthy;
    private JTextField input,einput;
    private JTextArea foodlistname;
    private JScrollPane scrollPane;
    private JList foodlist;
    private JButton  add, delete, clear, catalog, save, esave,ok;
    private CustomeButton spin;
    private JDialog eDialog;
    private PresetList presetList;
    private String foodname;
    private Dialogbox dialogbox;
    private JDialog savedialog = new JDialog();
    private Catalog catalogUI;
    private JPanel topPanel, bottomPanel, rightPanel, inputPanel, presetPanel, scrollPanel, centerPanel, leftPanel;
    JFrame frame;

    public RandomMenuUI(JFrame frame){
        Initial();
        setComponent();
        setComponentLocation();
        Finally();
        this.frame = frame;
    }

    public RandomList getraRandomList(){
        return this.randomlist;
    }

    private void Initial(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void setComponent(){
        menu = new JLabel("MENU", SwingConstants.CENTER);
        menu.setFont(new Font("Tahoma", Font.PLAIN, 80));
        menu.setForeground(Color.WHITE);
        menu.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        

        presetList = new PresetList(randomlist,defmodel);
        
        save = new JButton("SAVE");
        save.setFont(new Font("Tahoma", Font.BOLD, 18));
        save.addActionListener(this);

        catalog = new JButton("CATALOG");
        catalog.setFont(new Font("Tahoma", Font.BOLD, 16));
        catalog.addActionListener(this);

        einput = new JTextField();
        einput.setColumns(20);
        esave = new JButton("Save");
        eDialog = new JDialog();
        eDialog.setLayout(new FlowLayout());
        esave.addActionListener(this);
        eDialog.add(einput);
        eDialog.add(esave);
        
        foodlist = new JList<String>(defmodel);
        foodlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        foodlist.setVisibleRowCount(-1);
        
        scrollPane = new JScrollPane(foodlist);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 150));
        
        input = new JTextField("Food name...");
        input.setPreferredSize(new Dimension(400, 50));
        input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (input.getText().equals("Food name...")) {
                    input.setText("");
                    input.setForeground(Color.BLACK); // กลับเป็นสีปกติเมื่อพิมพ์
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (input.getText().isEmpty()) {
                    input.setText("Food name...");
                    input.setForeground(Color.GRAY); // กลับเป็นสีจางเมื่อว่าง
                }
            }
        });
        input.addKeyListener(this);

        spin = new CustomeButton("SPIN");
        spin.setFont(new Font("Tahoma", Font.BOLD, 25));
        spin.setPreferredSize(new Dimension(220, 120));
        spin.setRadius(365);
        spin.setColor(Color.getHSBColor(64, 66, 52));
        spin.setColorOver(Color.getHSBColor(0, 57, 62));
        spin.addActionListener(this);
        
        add = new JButton("ADD");
        add.setFont(new Font("Tahoma", Font.BOLD, 18));
        add.setBackground(Color.GREEN);
        add.addActionListener(this);
        
        delete = new JButton("DELETE");
        delete.setFont(new Font("Tahoma", Font.BOLD, 18));
        delete.setBackground(Color.PINK);
        delete.addActionListener(this);
        this.add(delete);
        
        clear = new JButton("CLEAR");
        clear.setFont(new Font("Tahoma", Font.BOLD, 18));
        clear.setBackground(Color.RED);
        clear.addActionListener(this);

    }

    private void setComponentLocation(){

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 120));
        topPanel.add(menu);
        this.add(topPanel);
        
        
        
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setPreferredSize(new Dimension(600, 500));
        // โค้ดใน centerPanel
        {
            // leftPanel
            {
                presetPanel = new JPanel();
                presetPanel.setPreferredSize(new Dimension(440, 170));
                presetPanel.add(presetList);
                
                scrollPanel = new JPanel();
                scrollPanel.setPreferredSize(new Dimension(440, 170));
                scrollPanel.add(scrollPane);
                    
                inputPanel = new JPanel();
                inputPanel.setPreferredSize(new Dimension(440, 160));
                inputPanel.setBorder(BorderFactory.createEmptyBorder(45, 0, 0, 0));
                inputPanel.add(input);

                leftPanel = new JPanel();
                leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
                leftPanel.setPreferredSize(new Dimension(450, 500));
                leftPanel.add(presetPanel);
                leftPanel.add(scrollPanel);
                leftPanel.add(inputPanel);
                leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

            }
            // rightPanel
            {
                rightPanel = new JPanel();
                rightPanel.setLayout(new GridLayout(5,0,0,20));
                rightPanel.setPreferredSize(new Dimension(150, 500));;
                rightPanel.add(save);
                rightPanel.add(catalog);
                rightPanel.add(clear);
                rightPanel.add(delete);
                rightPanel.add(add);
                rightPanel.setBorder(BorderFactory.createEmptyBorder(150, 0, 30, 40));
            }
        }
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);
        this.add(centerPanel);
        

        
        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(600, 180));
        bottomPanel.add(spin);
        this.add(bottomPanel);
        
        eDialog.setSize(300, 100);

        this.revalidate();
        this.repaint();
    }
    
    private void Finally(){
        this.setOpaque(false);//พื้นหลังโปร่งใส่
        topPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        inputPanel.setOpaque(false);
        presetPanel.setOpaque(false);
        scrollPanel.setOpaque(false);
        centerPanel.setOpaque(false);
        leftPanel.setOpaque(false);

        
        this.setBackground(Color.BLACK);
        //topPanel, bottomPanel, rightPanel, inputPanel, presetPanel, scrollPanel, centerPanel, leftPanel;
        this.setSize(600, 800);
        eDialog.setLocationRelativeTo(null);
        UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
    }

    

    private void addToJlist(String name){
        if(!(defmodel.contains(name)) && (!name.isBlank()) && !(name == null) && !(name.equals("Food name..."))){
            defmodel.addElement(name);
        }
    }

    private void removeFormJlist(String name){
        for(int i = 0 ; i < defmodel.size() ; i++){
            if(defmodel.get(i).equals(name)){
                defmodel.remove(i);
            }
        }
    }
     

     @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == add){
            
            if(!(input.getText().equals("Food name..."))){
                randomlist.addtoList(input.getText());
                addToJlist(input.getText());
            }
            input.setText("Food name...");
            input.setForeground(Color.GRAY);
        }
        if(e.getSource() == clear){
            randomlist.clearList();
            defmodel.clear();
            
        }

        if(e.getSource() == save){
            eDialog.setVisible(true);
            
        }

        if(e.getSource() == esave){
            eDialog.setVisible(false);
            catalogMethod.createCatalog(randomlist, einput.getText());
        }

        if(e.getSource() == delete){
            randomlist.removeFormList(randomlist.getName(foodlist.getSelectedIndex()));
            defmodel.remove(foodlist.getSelectedIndex());
        }
        if(e.getSource() == catalog){
            catalogUI = new Catalog(randomlist, defmodel);
            catalogUI.setVisible(true);
        }
        if(e.getSource() == spin ){
            dialogbox = new Dialogbox(randomlist,defmodel,frame);
            dialogbox.setVisible(true);
            if(dialogbox.isActive()){
                frame.setFocusable(false);
            }
            if(randomlist.isEmpty()){
                warnningempthy.setVisible(true);
            }
            else{
                warnningempthy.setVisible(false);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(input.getText().length() >= 20){
            e.consume();
        }
     }

     @Override
     public void keyPressed(KeyEvent e) {}

     @Override
     public void keyReleased(KeyEvent e) {}
}