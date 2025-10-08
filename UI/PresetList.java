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
        psPanel.add(foodpreset3);

        foodpreset4 = new JCheckBox("preset4");
        foodpreset4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        psPanel.add(foodpreset4);

        foodpreset5 = new JCheckBox("preset5");
        foodpreset5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        psPanel.add(foodpreset5);

        foodpreset6 = new JCheckBox("preset6");
        foodpreset6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        psPanel.add(foodpreset6);

        foodpreset7 = new JCheckBox("preset7");
        foodpreset7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        psPanel.add(foodpreset7);

        foodpreset8 = new JCheckBox("preset8");
        foodpreset8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        psPanel.add(foodpreset8);

        foodpreset9 = new JCheckBox("preset9");
        foodpreset9.setFont(new Font("Tahoma", Font.PLAIN, 14));
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

        
    }
}
