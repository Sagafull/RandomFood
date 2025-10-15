package UI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import javax.swing.*;
import javax.swing.event.*;

import Class.RandomList;
import FoodData.CatalogMethod;

public class Catalog extends JDialog implements ActionListener,ListSelectionListener {
    private RandomList randomList;
    private RandomList tmp = new RandomList();
    private RandomList tmp2 = new RandomList();
    private JList cataloglist,menulist;
    private JScrollPane scrollPane;
    private JLabel cat,catlist,menu;
    private JButton delete,add,remove,rename;
    private CatalogMethod catalogmethod = new CatalogMethod();
    private JScrollPane scrollPanecat,scrollPanemenu;
    private DefaultListModel defmodelcat = new DefaultListModel<>();
    private DefaultListModel defmodelmenu = new DefaultListModel<>();
    private DefaultListModel defmodelfoodlist;
    private JPanel topPanel, centerPanel, leftPanel, rightPanel, bottomPanel;

    public Catalog(RandomList randomList, DefaultListModel defmodelfoodlist){
        Initial();
        resetJlist();
        setComponent();
        setComponentLocation();
        Finally();
        this.randomList = randomList;
        this.defmodelfoodlist = defmodelfoodlist;
    }

    private void Initial(){
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    private void setComponent(){

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        
        cat = new JLabel("Catalog", SwingConstants.CENTER);
        cat.setFont(new Font("Arial Rounded MT Bold" ,Font.PLAIN, 60));
        cat.setForeground(Color.decode("#98623C"));
        
        catlist = new JLabel("Catalog List");
        catlist.setFont(new Font("Arial Rounded MT Bold" ,Font.PLAIN, 25));
        catlist.setForeground(Color.decode("#98623C"));

        menu = new JLabel("Menu List");
        menu.setFont(new Font("Arial Rounded MT Bold" ,Font.PLAIN, 25));
        menu.setForeground(Color.decode("#98623C"));

        add = new JButton("ADD");
        add.setFont(new Font("Arial Rounded MT Bold" ,Font.BOLD, 20));
        add.setBackground(Color.decode("#98FB98"));
        add.setBorder(BorderFactory.createLineBorder(Color.decode("#4CBB17"), 4));
        add.setPreferredSize(new Dimension(120, 60));
        add.addActionListener(this);

        remove = new JButton("Remove");
        remove.setFont(new Font("Arial Rounded MT Bold" ,Font.BOLD, 20));
        remove.setPreferredSize(new Dimension(120, 60));
        remove.setBackground(Color.decode("#FFE49D"));
        remove.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 4));
        remove.addActionListener(this);

        delete = new JButton("DELETE");
        delete.setFont(new Font("Arial Rounded MT Bold" ,Font.BOLD, 20));
        delete.setPreferredSize(new Dimension(120, 60));
        delete.setBackground(Color.decode("#FF4040"));
        delete.setBorder(BorderFactory.createLineBorder(Color.decode("#8B0000"), 4));
        delete.addActionListener(this);

        
        menulist = new JList<>(defmodelmenu);
        menulist.setFont(new Font("Tahoma" ,Font.PLAIN, 20));
        menulist.setFocusable(false);
        scrollPanemenu = new JScrollPane(menulist);
        scrollPanemenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        cataloglist = new JList<>(defmodelcat);
        cataloglist.setFont(new Font("Arial Rounded MT Bold" ,Font.PLAIN, 20));
        cataloglist.addListSelectionListener(this);
        scrollPanecat = new JScrollPane(cataloglist);
        scrollPanecat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
    }

    private void setComponentLocation(){

        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        topPanel.setPreferredSize(new Dimension(600, 100));
        topPanel.add(cat);
        this.add(topPanel);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setPreferredSize(new Dimension(600, 550));
        // leftPanel, rightPanel ใน centerPanel
        {
            leftPanel = new JPanel();
            leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
            leftPanel.setPreferredSize(new Dimension(300, 500));
            leftPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,5));
            leftPanel.add(catlist);
            leftPanel.add(Box.createVerticalStrut(15));
            leftPanel.add(scrollPanecat);

            rightPanel = new JPanel();
            rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
            rightPanel.setPreferredSize(new Dimension(300, 500));
            rightPanel.setBorder(BorderFactory.createEmptyBorder(10,5,10,10));
            rightPanel.add(menu);
            rightPanel.add(Box.createVerticalStrut(15));
            rightPanel.add(scrollPanemenu);
        }
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);
        this.add(centerPanel);

        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 30));
        bottomPanel.setPreferredSize(new Dimension(600, 150));
        bottomPanel.add(add);
        bottomPanel.add(remove);
        bottomPanel.add(delete);
        this.add(bottomPanel);
        
    }
    
    public void resetJlist(){
        for(int i = 0; i < catalogmethod.getCatalogListLength(); i++){
            defmodelcat.addElement(catalogmethod.getCatalogName(i));
        }
    }

    private void Finally(){
        
        topPanel.setOpaque(false);
        centerPanel.setOpaque(false);
        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#FAE5C7"));
        this.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        //topPanel, centerPanel, leftPanel, rightPanel, bottomPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            catalogmethod.getCatalog(this.randomList, catalogmethod.getCatalogName(cataloglist.getSelectedValue().toString()));
            
            catalogmethod.getCatalog(this.tmp, catalogmethod.getCatalogName(cataloglist.getSelectedValue().toString()));
            
            for(int i = 0; i < tmp.getListLength(); i++){
                if(!(defmodelfoodlist.contains(tmp.getName(i)))){
                    defmodelfoodlist.addElement(tmp.getName(i));
                }
            }
            tmp.clearList();
        }
        if(e.getSource() == remove){
            catalogmethod.removeCatalog(this.randomList, catalogmethod.getCatalogName(cataloglist.getSelectedValue().toString()));

            catalogmethod.getCatalog(this.tmp, catalogmethod.getCatalogName(cataloglist.getSelectedValue().toString()));

            for(int i = 0; i < defmodelfoodlist.size(); i++){
                System.out.println(defmodelfoodlist.get(i));
            }
            System.out.println(tmp.listToString());

            for(int i = 0; i < tmp.getListLength(); i++){
                for(int j = 0; j < defmodelfoodlist.size(); j++){
                    if(defmodelfoodlist.get(j).equals(tmp.getName(i))){
                        defmodelfoodlist.remove(j);
                    }
                }
            }
            tmp.clearList();
        }

        if(e.getSource() == delete){
            tmp2.clearList();
            defmodelmenu.clear();
            catalogmethod.deleteCatalog(catalogmethod.getCatalogName(cataloglist.getSelectedValue().toString()));
            defmodelcat.removeElement(cataloglist.getSelectedValue().toString());
            cataloglist.removeAll();
            cataloglist.setModel(defmodelcat);
            
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
      
        if(cataloglist.getSelectedIndex() != -1){
        catalogmethod.getCatalog(tmp2, catalogmethod.getCatalogName(cataloglist.getSelectedValue().toString()));
        System.out.println(catalogmethod.getCatalogName(cataloglist.getSelectedIndex()));
        System.out.println(cataloglist.getSelectedValue());
        System.out.println(cataloglist.getSelectedIndex());
        for(int i = 0; i < tmp2.getListLength(); i++){
        defmodelmenu.addElement(tmp2.getName(i));
        }
        if(e.getValueIsAdjusting()){
            defmodelmenu.clear();
            tmp2.clearList();
            
        }
    }
}
}
