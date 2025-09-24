package UI;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Class.RandomList;

public class RandomMenuUI extends JPanel implements ActionListener,KeyListener{
    
    public RandomList randomlist = new RandomList();
    private DefaultListModel defmodel = new DefaultListModel<>(); 
    private JLabel menu;
    private JTextField input;
    private JTextArea foodlistname;
    private JScrollPane scrollPane;
    private JList foodlist;
    private JButton spin, spinall, add, delete, clear, catalog;
    private PresetList presetList;
    private String foodname;
    private Dialogbox dialogbox;
    private Catalog catalogUI;
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
        this.setLayout(null);
    }

    private void setComponent(){
        menu = new JLabel("MENU");
        menu.setFont(new Font("Verdana", Font.PLAIN, 40));
        this.add(menu);

        presetList = new PresetList();
        this.add(presetList);

        catalog = new JButton("CATALOG");
        catalog.setFont(new Font("Verdana", Font.PLAIN, 18));
        catalog.addActionListener(this);
        this.add(catalog);

        foodlist = new JList<String>(defmodel);
        foodlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        foodlist.setVisibleRowCount(-1);
        
        scrollPane = new JScrollPane(foodlist);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);
        
        input = new JTextField("foodname",20);
        input.addKeyListener(this);
        this.add(input);

        spin = new JButton("SPIN");
        spin.setFont(new Font("Verdana", Font.PLAIN, 18));
        spin.addActionListener(this);
        this.add(spin);
        
        spinall = new JButton("SPINALL");
        spinall.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(spinall);

        add = new JButton("ADD");
        add.setFont(new Font("Verdana", Font.PLAIN, 18));
        add.addActionListener(this);
        this.add(add);
        
        delete = new JButton("DELETE");
        delete.setFont(new Font("Verdana", Font.PLAIN, 10));
        delete.addActionListener(this);
        this.add(delete);
        
        clear = new JButton("CLEAR");
        clear.setFont(new Font("Verdana", Font.PLAIN, 18));
        clear.addActionListener(this);
        this.add(clear);

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
     
    private void setComponentLocation(){
        menu.setBounds(230, 50, 200, 50);
        presetList.setBounds(40, 200, 400, 100);
        catalog.setBounds(460, 220, 100, 50);
        foodlist.setBounds(40, 300, 400, 150);
        scrollPane.setBounds(40, 300, 400, 100);
        input.setBounds(40, 430, 400, 50);
        clear.setBounds(460, 300, 100, 50);
        delete.setBounds(460, 365, 100, 50);
        add.setBounds(460, 430, 100, 50);
        spinall.setBounds(100, 550, 150, 150);
        spin.setBounds(300, 550, 150, 150);
        
    }

    private void Finally(){
        this.setOpaque(false);//พื้นหลังโปร่งใส่
        this.setSize(600, 800);
    }


     @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == add){
            randomlist.addtoList(input.getText());
            addToJlist(input.getText());
            input.setText("");  
    }
        if(e.getSource() == clear){
            randomlist.clearList();
            defmodel.clear();
            
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
            dialogbox = new Dialogbox(randomlist.getRandom());
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