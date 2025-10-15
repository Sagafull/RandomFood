package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Class.RandomList;

public class Keepbox extends JDialog implements ActionListener {

    private JLabel keepfood;
    private String randomname;
    private JFrame frame;
    private RandomList randomList;
    private DefaultListModel defmodel;
    private JPanel keepfoodPanel, lbuttonPanel;
    private JButton keep,delete;
    private Dialogbox dialogbox;
    
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

        keepfood = new JLabel(randomname);
        keepfood.setFont(new Font("TH Sarabun New", Font.BOLD, 40));
        keepfood.setForeground(Color.decode("#98623C"));
        
        keep = new JButton("KEEP");
        keep.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
        keep.setBackground(Color.decode("#98FB98"));
        keep.setBorder(BorderFactory.createLineBorder(Color.decode("#4CBB17"), 6));
        keep.setPreferredSize(new Dimension(160, 100));
        keep.addActionListener(this);

        delete = new JButton("DELETE");
        delete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
        delete.setBackground(Color.decode("#FF4040"));
        delete.setBorder(BorderFactory.createLineBorder(Color.decode("#8B0000"), 4));
        delete.setPreferredSize(new Dimension(160, 100));
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
        keepfoodPanel.setOpaque(false);
        lbuttonPanel.setOpaque(false);
        this.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        this.getContentPane().setBackground(Color.decode("#FAE5C7"));
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
            if(!randomList.isEmpty()){
                new Dialogbox(randomList, defmodel, frame).setVisible(true);
            }
            else{
                new Farewell(frame).setVisible(true);
            }
            
            

            this.setVisible(false);
        }

        
    }
    
}

