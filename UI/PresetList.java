package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Class.RandomList;
import FoodData.DataMethod;

public class PresetList extends JPanel implements ActionListener {
    private JCheckBox foodpreset1,foodpreset2,foodpreset3;
    private JCheckBox foodpreset4,foodpreset5,foodpreset6;
    private JCheckBox foodpreset7,foodpreset8,foodpreset9;
    private JCheckBox GetAll;
    private JPanel psPanel = new JPanel();
    private RandomList randomList;
    private DataMethod dataMethod = new DataMethod();
    private DefaultListModel defmodel;

    public PresetList(RandomList randomList, DefaultListModel dListModel){
        Initial();
        setComponent();
        setComponentLocation();
        Finally();
        this.randomList = randomList;
        this.defmodel = dListModel;
    }
    
    private void Initial(){
        psPanel.setLayout(new GridLayout(4, 3, 10, 10));
    }
    
    private void setComponent(){
        foodpreset1 = new JCheckBox("ThaiFood");
        foodpreset1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodpreset1.addActionListener(this);
        psPanel.add(foodpreset1);

        foodpreset2 = new JCheckBox("JapaneseFood");
        foodpreset2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodpreset2.addActionListener(this);
        psPanel.add(foodpreset2);

        foodpreset3 = new JCheckBox("ChineseFood");
        foodpreset3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodpreset3.addActionListener(this);
        psPanel.add(foodpreset3);

        foodpreset4 = new JCheckBox("EnglishFood");
        foodpreset4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodpreset4.addActionListener(this);
        psPanel.add(foodpreset4);

        foodpreset5 = new JCheckBox("KoreanFood");
        foodpreset5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodpreset5.addActionListener(this);
        psPanel.add(foodpreset5);

        foodpreset6 = new JCheckBox("IndiaFood");
        foodpreset6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodpreset6.addActionListener(this);
        psPanel.add(foodpreset6);

        foodpreset7 = new JCheckBox("MaxicoFood");
        foodpreset7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodpreset7.addActionListener(this);
        psPanel.add(foodpreset7);

        foodpreset8 = new JCheckBox("ItalianFood");
        foodpreset8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodpreset8.addActionListener(this);
        psPanel.add(foodpreset8);

        foodpreset9 = new JCheckBox("VietnamFood");
        foodpreset9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        foodpreset9.addActionListener(this);
        psPanel.add(foodpreset9);

        GetAll = new JCheckBox("All");
        GetAll.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GetAll.addActionListener(this);
        psPanel.add(GetAll);

        this.add(psPanel);

    }

    private void setComponentLocation(){
        psPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 40));
    }

    private void Finally(){
        this.setOpaque(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == GetAll){
            if(GetAll.isSelected()){
                foodpreset1.setSelected(true);
                foodpreset2.setSelected(true);
                foodpreset3.setSelected(true);
                foodpreset4.setSelected(true);
                foodpreset5.setSelected(true);
                foodpreset6.setSelected(true);
                foodpreset7.setSelected(true);
                foodpreset8.setSelected(true);
                foodpreset9.setSelected(true);

                dataMethod.getPreset(randomList,defmodel, "ThaiFood");
                dataMethod.getPreset(randomList,defmodel, "JapaneseFood");
                dataMethod.getPreset(randomList,defmodel, "ChineseFood");
                dataMethod.getPreset(randomList,defmodel, "EnglishFood");
                dataMethod.getPreset(randomList,defmodel, "KoreanFood");
                dataMethod.getPreset(randomList,defmodel, "IndianFood");
                dataMethod.getPreset(randomList,defmodel, "MaxicoFood");
                dataMethod.getPreset(randomList,defmodel, "ItalianFood");
                dataMethod.getPreset(randomList,defmodel, "VietnamFood");
            }
            else{
                foodpreset1.setSelected(false);
                foodpreset2.setSelected(false);
                foodpreset3.setSelected(false);
                foodpreset4.setSelected(false);
                foodpreset5.setSelected(false);
                foodpreset6.setSelected(false);
                foodpreset7.setSelected(false);
                foodpreset8.setSelected(false);
                foodpreset9.setSelected(false);

                
                dataMethod.removePreset(randomList,defmodel, "ThaiFood");
                dataMethod.removePreset(randomList,defmodel, "JapaneseFood");
                dataMethod.removePreset(randomList,defmodel, "ChineseFood");
                dataMethod.removePreset(randomList,defmodel, "EnglishFood");
                dataMethod.removePreset(randomList,defmodel, "KoreanFood");
                dataMethod.removePreset(randomList,defmodel, "IndianFood");
                dataMethod.removePreset(randomList,defmodel, "MaxicoFood");
                dataMethod.removePreset(randomList,defmodel, "ItalianFood");
                dataMethod.removePreset(randomList,defmodel, "VietnamFood");
            }  
        }
        
        
        
        if(e.getSource() == foodpreset1){
            if(foodpreset1.isSelected()){
                dataMethod.getPreset(randomList,defmodel, "ThaiFood");
            }
            else{
                dataMethod.removePreset(randomList,defmodel, "ThaiFood");
                
            }  
        }

        if(e.getSource() == foodpreset2){
            if(foodpreset2.isSelected()){
                dataMethod.getPreset(randomList,defmodel, "JapaneseFood");
            }
            else{
                dataMethod.removePreset(randomList,defmodel, "JapaneseFood");
                
            }  
        }

        if(e.getSource() == foodpreset3){
            if(foodpreset3.isSelected()){
                dataMethod.getPreset(randomList,defmodel, "ChineseFood");
            }
            else{
                dataMethod.removePreset(randomList,defmodel, "ChineseFood");
                
            }  
        }

        if(e.getSource() == foodpreset4){
            if(foodpreset4.isSelected()){
                dataMethod.getPreset(randomList,defmodel, "EnglishFood");
            }
            else{
                dataMethod.removePreset(randomList,defmodel, "EnglishFood");
                
            }  
        }

        if(e.getSource() == foodpreset5){
            if(foodpreset5.isSelected()){
                dataMethod.getPreset(randomList,defmodel, "KoreanFood");
            }
            else{
                dataMethod.removePreset(randomList,defmodel, "KoreanFood");
                
            }  
        }

        if(e.getSource() == foodpreset6){
            if(foodpreset6.isSelected()){
                dataMethod.getPreset(randomList,defmodel, "IndiaFood");
            }
            else{
                dataMethod.removePreset(randomList,defmodel, "IndiaFood");
                
            }  
        }

        if(e.getSource() == foodpreset7){
            if(foodpreset7.isSelected()){
                dataMethod.getPreset(randomList,defmodel, "MaxicoFood");
            }
            else{
                dataMethod.removePreset(randomList,defmodel, "MaxicoFood");
                
            }  
        }

        if(e.getSource() == foodpreset8){
            if(foodpreset8.isSelected()){
                dataMethod.getPreset(randomList,defmodel, "ItalianFood");
            }
            else{
                dataMethod.removePreset(randomList,defmodel, "ItalianFood");
                
            }  
        }

        if(e.getSource() == foodpreset9){
            if(foodpreset9.isSelected()){
                dataMethod.getPreset(randomList,defmodel, "VietnamFood");
            }
            else{
                dataMethod.removePreset(randomList,defmodel, "VietnamFood");
                
            }  
        }

        

        
    }
}
