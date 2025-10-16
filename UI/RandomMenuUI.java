package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

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
    private JLabel menu,scatalog, leftIcon, rightIcon, centerIcon;
    private JPanel topPanel, bottomPanel, rightPanel, inputPanel, presetPanel, scrollPanel, centerPanel, leftPanel;
    private JPanel rightCPanel, spinBPanel, groupCPanel;
    private JDialog eDialog;
    private JDialog savedialog = new JDialog();
    private JTextField input,einput;
    private JTextArea foodlistname;
    private JScrollPane scrollPane;
    private JList foodlist;
    private JButton  add, delete, clear, catalog, save, esave, spin;
    private PresetList presetList;
    private String foodname;
    private Dialogbox dialogbox;
    private Catalog catalogUI;
    private JFrame frame;

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
        menu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 80));
        menu.setForeground(Color.decode("#98623C"));
        menu.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        

        presetList = new PresetList(randomlist,defmodel);
        
        save = new JButton("SAVE");
        save.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        save.setBackground(Color.decode("#FFE49D"));
        save.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 4));
        save.addActionListener(this);

        catalog = new JButton("CATALOG");
        catalog.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        catalog.setBackground(Color.decode("#FFE49D"));
        catalog.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 4));
        catalog.addActionListener(this);


        scatalog = new JLabel("Catalog Name");
        scatalog.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        scatalog.setForeground(Color.decode("#98623C"));

        einput = new JTextField();
        einput.setPreferredSize(new Dimension(300, 35));
        einput.setFont(new Font("Tahoma", Font.PLAIN, 16));
        einput.addKeyListener(this);

        esave = new JButton("Save");
        esave.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        esave.setPreferredSize(new Dimension(80, 35));
        esave.setBackground(Color.decode("#FFE49D"));
        esave.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 3));
        esave.addActionListener(this);

        eDialog = new JDialog();
        eDialog.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
        eDialog.add(scatalog);
        eDialog.add(einput);
        eDialog.add(esave);
        eDialog.getContentPane().setBackground(Color.decode("#FAE5C7"));
        
        foodlist = new JList<String>(defmodel);
        foodlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        foodlist.setVisibleRowCount(-1);
        
        scrollPane = new JScrollPane(foodlist);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 150));
        
        input = new JTextField("Food name...");
        input.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
        spin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        spin.setPreferredSize(new Dimension(180, 100));
        spin.setBackground(Color.decode("#FFE49D"));
        spin.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 8));
        spin.addActionListener(this);
        
        add = new JButton("ADD");
        add.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        add.setBackground(Color.decode("#98FB98"));
        add.setBorder(BorderFactory.createLineBorder(Color.decode("#4CBB17"), 4));
        add.addActionListener(this);
        
        delete = new JButton("DELETE");
        delete.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        delete.setBackground(Color.decode("#FF4040"));
        delete.setBorder(BorderFactory.createLineBorder(Color.decode("#8B0000"), 4));
        delete.addActionListener(this);
        
        clear = new JButton("CLEAR");
        clear.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        clear.setBackground(Color.decode("#FFE49D"));
        clear.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 4));
        clear.addActionListener(this);
        
        centerIcon = new JLabel();
        centerIcon.setIcon(new ImageIcon(new ImageIcon("UI/image/pigCorn.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

    }

    private void setComponentLocation(){

        topPanel = new JPanel();
        topPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        topPanel.add(menu);
        this.add(topPanel);
        topPanel.setOpaque(false);
        
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 500));
        {
            // leftPanel
            {
                leftPanel = new JPanel();
                leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
                leftPanel.setMaximumSize(new Dimension(450, 500));

                presetPanel = new JPanel();
                presetPanel.setMaximumSize(new Dimension(450, 170));
                presetPanel.add(presetList);
                presetPanel.setOpaque(false);
                
                scrollPanel = new JPanel();
                scrollPanel.setMaximumSize(new Dimension(450, 170));
                scrollPanel.add(scrollPane);
                scrollPanel.setOpaque(false);
                    
                inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
                inputPanel.setMaximumSize(new Dimension(450, 160));
                inputPanel.add(input);
                inputPanel.setOpaque(false);

                leftPanel.add(presetPanel);
                leftPanel.add(scrollPanel);
                leftPanel.add(inputPanel);
                leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 11, 0, 0));
                leftPanel.setOpaque(false);

            }
            // rightPanel
            {
                rightPanel = new JPanel();
                rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
                rightPanel.setMaximumSize(new Dimension(130, 500));
                
                rightCPanel = new JPanel();
                rightCPanel.setMaximumSize(new Dimension(130, 150));
                rightCPanel.add(centerIcon);
                rightCPanel.setOpaque(false);


                groupCPanel = new JPanel();
                groupCPanel.setLayout(new GridLayout(5,0,0,20));
                groupCPanel.setMaximumSize(new Dimension(130, 350));
                groupCPanel.add(save);
                groupCPanel.add(catalog);
                groupCPanel.add(clear);
                groupCPanel.add(delete);
                groupCPanel.add(add);
                groupCPanel.setBorder(BorderFactory.createEmptyBorder(0, 2, 30, 20));
                groupCPanel.setOpaque(false);

                rightPanel.add(rightCPanel);
                rightPanel.add(groupCPanel);
                rightPanel.setOpaque(false);
            }
        }
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);
        this.add(centerPanel);
        centerPanel.setOpaque(false);
         
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
        bottomPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 140));
        {
            spinBPanel = new JPanel();
            spinBPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 140));
            spinBPanel.add(spin);
            spinBPanel.setOpaque(false);
        }
        bottomPanel.add(spinBPanel);
        this.add(bottomPanel);
        bottomPanel.setOpaque(false);
        
        eDialog.setSize(450, 150);
    }
    
    private void Finally(){
        
        this.setOpaque(false);
        this.setSize(600, 800);
        eDialog.setLocationRelativeTo(null);
        eDialog.setResizable(false);

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
            
            if(!catalogMethod.catalogContain(einput.getText()) && !randomlist.isEmpty()){
                catalogMethod.createCatalog(randomlist, einput.getText());
                einput.setText("");
                eDialog.setVisible(false);
            }
            
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
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        if(e.getSource() == input){
            if(input.getText().length() >= 20){
            e.consume();
        }

        if(e.getKeyChar() == ' ' || e.getKeyChar() == '.' || e.getKeyChar() == ':'){
            e.consume();
        }

        }

        if(e.getSource() == einput){
            if(einput.getText().length() >= 20){
            e.consume();
            }
            if(e.getKeyChar() == ' ' || e.getKeyChar() == '.' || e.getKeyChar() == ':'){
                e.consume();
            }

        }
        
    }
    

    @Override
    public void keyPressed(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}
}