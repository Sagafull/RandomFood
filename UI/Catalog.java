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
        cat.setFont(new Font("Tahoma" ,Font.PLAIN, 60));
        
        catlist = new JLabel("Catalog List");
        catlist.setFont(new Font("Tahoma" ,Font.PLAIN, 25));

        menu = new JLabel("Menu List");
        menu.setFont(new Font("Tahoma" ,Font.PLAIN, 25));

        add = new JButton("ADD");
        add.setFont(new Font("Tahoma" ,Font.PLAIN, 20));
        add.setPreferredSize(new Dimension(120, 60));
        add.addActionListener(this);

        remove = new JButton("Remove");
        remove.setFont(new Font("Tahoma" ,Font.PLAIN, 20));
        remove.setPreferredSize(new Dimension(120, 60));
        remove.addActionListener(this);

        delete = new JButton("DELETE");
        delete.setFont(new Font("Tahoma" ,Font.PLAIN, 20));
        delete.setPreferredSize(new Dimension(120, 60));
        delete.addActionListener(this);

        menulist = new JList<>(defmodelmenu);
        menulist.setFont(new Font("Tahoma" ,Font.PLAIN, 20));
        menulist.setFocusable(false);
        scrollPane.setViewportView(menulist);
        
        cataloglist = new JList<>(defmodelcat);
        cataloglist.setFont(new Font("Tahoma" ,Font.PLAIN, 20));
        cataloglist.addListSelectionListener(this);
        scrollPane.setViewportView(cataloglist);
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
        leftPanel.add(new JScrollPane(cataloglist));

        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(300, 500));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10,5,10,10));
        rightPanel.add(menu);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(new JScrollPane(menulist));
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
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            catalogmethod.getCatalog(this.randomList, catalogmethod.getCatalogName(cataloglist.getSelectedIndex()));
            
            catalogmethod.getCatalog(this.tmp, catalogmethod.getCatalogName(cataloglist.getSelectedIndex()));
            
            for(int i = 0; i < tmp.getListLength(); i++){
                if(!(defmodelfoodlist.contains(tmp.getName(i)))){
                    defmodelfoodlist.addElement(tmp.getName(i));
                }
            }
            tmp.clearList();
        }
        if(e.getSource() == remove){
            catalogmethod.removeCatalog(this.randomList, catalogmethod.getCatalogName(cataloglist.getSelectedIndex()));

            catalogmethod.getCatalog(this.tmp, catalogmethod.getCatalogName(cataloglist.getSelectedIndex()));

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
            catalogmethod.deleteCatalog(catalogmethod.getCatalogName(cataloglist.getSelectedIndex()));
            defmodelcat.removeElementAt(cataloglist.getSelectedIndex());
            catalogmethod.InstallCatalogNameList();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
      
        if(cataloglist.getSelectedIndex() != -1){
        catalogmethod.getCatalog(tmp2, catalogmethod.getCatalogName(cataloglist.getSelectedIndex()));
        for(int i = 0; i < tmp2.getListLength(); i++){
        defmodelmenu.addElement(tmp2.getName(i));
        }
        if(e.getValueIsAdjusting()){
            defmodelmenu.clear();
            tmp2.clearList();
            catalogmethod.InstallCatalogNameList();
        }
    }
}
}
