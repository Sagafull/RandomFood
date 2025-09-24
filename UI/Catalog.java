package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import Class.RandomList;
import FoodData.CatalogMethod;

public class Catalog extends JDialog implements ActionListener {
    private RandomList randomList;
    private RandomList tmp = new RandomList();
    private JList cataloglist,menulist;
    private JScrollPane scrollPane;
    private JLabel cat,catlist,menu;
    private JButton delete,add,remove,rename;
    private CatalogMethod catalogmethod = new CatalogMethod();
    private DefaultListModel defmodelcat = new DefaultListModel<>();
    private DefaultListModel defmodelmenu = new DefaultListModel<>();
    private DefaultListModel defmodelfoodlist;

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
        this.setLayout(null);
    }

    private void setComponent(){

        scrollPane = new JScrollPane();
        this.add(scrollPane);
        
        cat = new JLabel("Catalog");
        cat.setFont(new Font("Verdana" ,Font.PLAIN, 40));
        this.add(cat);

        catlist = new JLabel("Catalog List");
        catlist.setFont(new Font("Verdana" ,Font.PLAIN, 20));
        this.add(catlist);

        menu = new JLabel("Menu List");
        menu.setFont(new Font("Verdana" ,Font.PLAIN, 20));
        this.add(menu);

        menulist = new JList<>(defmodelmenu);
        menulist.setFont(new Font("Verdana" ,Font.PLAIN, 20));
        scrollPane.setViewportView(menulist);
        this.add(menulist);

        add = new JButton("ADD");
        add.setFont(new Font("Verdana" ,Font.PLAIN, 20));
        add.addActionListener(this);
        this.add(add);

        remove = new JButton("Remove");
        remove.setFont(new Font("Verdana" ,Font.PLAIN, 20));
        remove.addActionListener(this);
        this.add(remove);

        delete = new JButton("DELETE");
        delete.setFont(new Font("Verdana" ,Font.PLAIN, 20));
        this.add(delete);
        
        cataloglist = new JList<>(defmodelcat);
        cataloglist.setFont(new Font("Verdana" ,Font.PLAIN, 20));
        scrollPane.setViewportView(cataloglist);
        this.add(cataloglist);
    }

    private void setComponentLocation(){
        cat.setBounds(100,20,200,50); //Catalog
        menu.setBounds(300, 110, 100, 50); //MenuList
        catlist.setBounds(30, 110, 150, 50); //CatalogList
        
        cataloglist.setBounds(30, 150, 200, 300);
        menulist.setBounds(300,150,200,300);

        add.setBounds(20, 500, 100, 100);
        remove.setBounds(200, 500, 100, 100);
        delete.setBounds(400, 500, 100, 100);
    }
    
    private void resetJlist(){
        for(int i = 0; i < catalogmethod.getCatalogListLength(); i++){
            defmodelcat.addElement(catalogmethod.getCatalogName(i));
        }
    }

    private void Finally(){
        this.setSize(550, 670);
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
                if((defmodelfoodlist.get(i).equals(tmp.getName(i)))){
                    defmodelfoodlist.removeElementAt(i);
                }
            }
            tmp.clearList();
        }

    }
}
