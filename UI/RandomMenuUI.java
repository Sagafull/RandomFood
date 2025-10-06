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
    private JLabel menu;
    private JTextField input,einput;
    private JTextArea foodlistname;
    private JScrollPane scrollPane;
    private JList foodlist;
    private JButton spin, add, delete, clear, catalog, save, esave,ok;
    private JDialog eDialog;
    private PresetList presetList;
    private String foodname;
    private Dialogbox dialogbox;
    private JDialog savedialog = new JDialog();
    private Catalog catalogUI;
    private JPanel menuPanel, spinPanel, gbuttonPanel, inputPanel, presetPanel, scrollPanel, centerPanel;
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
        this.setLayout(new BorderLayout());
    }

    private void setComponent(){
        menu = new JLabel("MENU", SwingConstants.CENTER);
        menu.setFont(new Font("Tahoma", Font.BOLD, 50));
        menu.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));
        

        presetList = new PresetList(randomlist,defmodel);
        
        
        save = new JButton("SAVE");
        save.setFont(new Font("Tahoma", Font.PLAIN, 18));
        save.addActionListener(this);
        this.add(save);

        catalog = new JButton("CATALOG");
        catalog.setFont(new Font("Tahoma", Font.PLAIN, 18));
        catalog.addActionListener(this);
        this.add(catalog);

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

        spin = new JButton("SPIN");
        spin.setFont(new Font("Tahoma", Font.PLAIN, 25));
        spin.setPreferredSize(new Dimension(160, 80));
        spin.addActionListener(this);
        
        add = new JButton("ADD");
        add.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add.addActionListener(this);
        this.add(add);
        
        delete = new JButton("DELETE");
        delete.setFont(new Font("Tahoma", Font.PLAIN, 18));
        delete.addActionListener(this);
        this.add(delete);
        
        clear = new JButton("CLEAR");
        clear.setFont(new Font("Tahoma", Font.PLAIN, 18));
        clear.addActionListener(this);
        this.add(clear);

        

    }

    private void setComponentLocation(){

        menuPanel = new JPanel();
        menuPanel.add(menu);
        this.add(menuPanel, BorderLayout.NORTH);
        
        foodlist.setBounds(40, 300, 400, 150);
        
        gbuttonPanel = new JPanel();
        gbuttonPanel.setLayout(new GridLayout(5,0,0,20));
        gbuttonPanel.setBackground(Color.BLUE);
        gbuttonPanel.add(save);
        gbuttonPanel.add(catalog);
        gbuttonPanel.add(clear);
        gbuttonPanel.add(delete);
        gbuttonPanel.add(add);
        gbuttonPanel.setBorder(BorderFactory.createEmptyBorder(150, 0, 50, 30));
        this.add(gbuttonPanel, BorderLayout.EAST);
        
        presetPanel = new JPanel();
        presetPanel.setBackground(Color.YELLOW);
        presetPanel.add(presetList);
        
        scrollPanel = new JPanel();
        scrollPanel.setBackground(Color.ORANGE);
        scrollPanel.add(scrollPane);
        
        inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(Color.GREEN);
        inputPanel.add(input);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 50, 20));

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.CYAN);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(presetPanel);
        centerPanel.add(scrollPanel);
        centerPanel.add(inputPanel);
        this.add(centerPanel, BorderLayout.CENTER);
        

        
        spinPanel = new JPanel();
        spinPanel.setBackground(Color.RED);
        spinPanel.add(spin);
        this.add(spinPanel, BorderLayout.SOUTH);
        
        eDialog.setSize(300, 100);

        this.revalidate();
        this.repaint();
    }
    
    private void Finally(){
        this.setOpaque(false);//พื้นหลังโปร่งใส่
        this.setSize(600, 800);
        eDialog.setLocationRelativeTo(null);
        UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
    }

    

    private void addToJlist(String name){
        if(!(defmodel.contains(name)) && (!name.isBlank()) && !(name == null)){
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
            randomlist.addtoList(input.getText());
            addToJlist(input.getText());
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