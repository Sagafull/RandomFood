package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import Class.RandomList;
import FoodData.DataMethod;

public class PresetList extends JPanel implements ActionListener {
    private JCheckBox foodpreset1,foodpreset2,foodpreset3;
    private JCheckBox foodpreset4,foodpreset5,foodpreset6;
    private JCheckBox foodpreset7,foodpreset8,foodpreset9;
    private JCheckBox GetAll;
    private RandomList randomList;
    private DataMethod dataMethod = new DataMethod();
    private DefaultListModel defmodel;

    public PresetList(RandomList randomList,DefaultListModel dListModel){
        Initial();
        setComponent();
        Finally();
        this.randomList = randomList;
        this.defmodel = dListModel;
    }
    
    private void Initial(){this.setLayout(new GridLayout(3, 3));}
    
    private void setComponent(){
        foodpreset1 = new JCheckBox("ThaiFood");
        foodpreset1.addActionListener(this);
        this.add(foodpreset1);

        foodpreset2 = new JCheckBox("JapaneseFood");
        foodpreset2.addActionListener(this);
        this.add(foodpreset2);

        foodpreset3 = new JCheckBox("ChineseFood");
        this.add(foodpreset3);

        foodpreset4 = new JCheckBox("preset4");
        this.add(foodpreset4);

        foodpreset5 = new JCheckBox("preset5");
        this.add(foodpreset5);

        foodpreset6 = new JCheckBox("preset6");
        this.add(foodpreset6);

        foodpreset7 = new JCheckBox("preset7");
        this.add(foodpreset7);

        foodpreset8 = new JCheckBox("preset8");
        this.add(foodpreset8);

        foodpreset9 = new JCheckBox("preset9");
        this.add(foodpreset9);

        GetAll = new JCheckBox("GETALL");
        GetAll.addActionListener(this);
        this.add(GetAll);

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
