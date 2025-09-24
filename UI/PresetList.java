package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PresetList extends JPanel implements ActionListener {
    private JCheckBox foodpreset1,foodpreset2,foodpreset3;
    private JCheckBox foodpreset4,foodpreset5,foodpreset6;
    private JCheckBox foodpreset7,foodpreset8,foodpreset9;

    public PresetList(){
        Initial();
        setComponent();
        Finally();
    }
    
    private void Initial(){this.setLayout(new GridLayout(3, 3));}
    
    private void setComponent(){
        foodpreset1 = new JCheckBox("preset1");
        this.add(foodpreset1);

        foodpreset2 = new JCheckBox("preset2");
        this.add(foodpreset2);

        foodpreset3 = new JCheckBox("preset3");
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

    }
    private void Finally(){
        this.setOpaque(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //ทำไงก็ได้ ติ๊ก แล้้วมันเพิ่ม preset เข้า randomlist
        //เอาติ๊กออก แล้วมันลบ preset นั้นจาก randomlist
    }
}
