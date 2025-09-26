package UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
        menu.setFont(new Font("Tahoma", Font.PLAIN, 40));
        this.add(menu);

        presetList = new PresetList(randomlist,defmodel);
        this.add(presetList);
        
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
        this.add(scrollPane);
        
        input = new JTextField("foodname",20);
        input.addKeyListener(this);
        this.add(input);

        spin = new JButton("SPIN");
        spin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        spin.addActionListener(this);
        this.add(spin);
        
        add = new JButton("ADD");
        add.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add.addActionListener(this);
        this.add(add);
        
        delete = new JButton("DELETE");
        delete.setFont(new Font("Tahoma", Font.PLAIN, 10));
        delete.addActionListener(this);
        this.add(delete);
        
        clear = new JButton("CLEAR");
        clear.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
        save.setBounds(460, 150, 100, 50);
        catalog.setBounds(460, 220, 100, 50);
        foodlist.setBounds(40, 300, 400, 150);
        scrollPane.setBounds(40, 300, 400, 100);
        input.setBounds(40, 430, 400, 50);
        clear.setBounds(460, 300, 100, 50);
        delete.setBounds(460, 365, 100, 50);
        add.setBounds(460, 430, 100, 50);
        spin.setBounds(300, 550, 150, 150);

        eDialog.setSize(300, 100);
        
    }

    private void Finally(){
        this.setOpaque(false);//พื้นหลังโปร่งใส่
        this.setSize(600, 800);
        eDialog.setLocationRelativeTo(null);
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