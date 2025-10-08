package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Class.RandomList;

public class Keepbox extends JDialog implements ActionListener {

    private JLabel randomfood, keepfood;
    private String randomname;
    private JFrame frame;
    private RandomList randomList;
    private DefaultListModel defmodel;
    private JPanel keepfoodPanel, lbuttonPanel;
    private JButton keep,delete;
    
    public Keepbox(String randomname, RandomList randomList, DefaultListModel defmodel, JFrame frame){
        this.randomname = randomname;
        this.randomList = randomList;
        this.defmodel = defmodel;
        Initial();
        setComponent();
        setComponentLocation();
        Finally();
        this.frame = frame;
        
    }

    private void Initial(){
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    private void setComponent(){
        randomfood = new JLabel(randomname, SwingConstants.CENTER);
        randomfood.setFont(new Font("Tahoma" ,Font.PLAIN, 40));

        keepfood = new JLabel("Keep: " + randomname + " ?");
        keepfood.setFont(new Font("Tahoma", Font.PLAIN, 40));
        
        keep = new JButton("KEEP");
        keep.setFont(new Font("Tahoma", Font.PLAIN, 18));
        keep.setPreferredSize(new Dimension(150, 60));
        keep.addActionListener(this);

        delete = new JButton("DELETE");
        delete.setFont(new Font("Tahoma", Font.PLAIN, 18));
        delete.setPreferredSize(new Dimension(150, 60));
        delete.addActionListener(this);

    }
    private void setComponentLocation(){

        keepfoodPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 70));
        keepfoodPanel.setPreferredSize(new Dimension(600, 200));
        keepfoodPanel.add(keepfood);
        this.add(keepfoodPanel);

        lbuttonPanel = new JPanel();
        lbuttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        lbuttonPanel.setPreferredSize(new Dimension(600, 200));
        lbuttonPanel.add(keep);
        lbuttonPanel.add(delete); 
        this.add(lbuttonPanel);

    }
    private void Finally(){
        this.setSize(600,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == keep){

            new Dialogbox(randomList, defmodel, frame).setVisible(true);
            this.setVisible(false);
        }

        if(e.getSource() == delete){

            for(int i = 0; i < randomList.getListLength(); i++){
                if(randomList.getName(i).equals(randomname)){
                    randomList.removeFormList(i);
                    defmodel.removeElementAt(i);
                }
            }

            new Dialogbox(randomList, defmodel, frame).setVisible(true);
            this.setVisible(false);
        }

        
    }
    
}
