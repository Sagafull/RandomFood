package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Class.RandomList;

public class Keepbox extends JDialog implements ActionListener {

    private JLabel keepfood, snail1, snail2;
    private String randomname;
    private JFrame frame;
    private RandomList randomList;
    private DefaultListModel defmodel;
    private JPanel keepfoodPanel, lbuttonPanel, snailPanel;
    private JButton keep,delete;
    private Dialogbox dialogbox;
    
    public Keepbox(String randomname, RandomList randomList, DefaultListModel defmodel, JFrame frame){
        this.randomname = randomname;
        this.randomList = randomList;
        this.defmodel = defmodel;
        this.frame = frame;
        Initial();
        setComponent();
        setComponentLocation();
        Finally();
        
        
    }

    private void Initial(){
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    private void setComponent(){

        keepfood = new JLabel(randomname);
        keepfood.setFont(new Font("Tahoma", Font.BOLD, 50));
        keepfood.setForeground(Color.decode("#98623C"));
        
        keep = new JButton("KEEP");
        keep.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
        keep.setBackground(Color.decode("#98FB98"));
        keep.setBorder(BorderFactory.createLineBorder(Color.decode("#4CBB17"), 6));
        keep.setPreferredSize(new Dimension(130, 80));
        keep.addActionListener(this);

        delete = new JButton("DELETE");
        delete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
        delete.setBackground(Color.decode("#FF4040"));
        delete.setBorder(BorderFactory.createLineBorder(Color.decode("#8B0000"), 4));
        delete.setPreferredSize(new Dimension(130, 80));
        delete.addActionListener(this);

        snail1 = new JLabel(new ImageIcon(new ImageIcon("UI/image/snail.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        snail1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        snail2 = new JLabel(new ImageIcon(new ImageIcon("UI/image/snail2.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        snail2.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

    }
    private void setComponentLocation(){

        keepfoodPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 35));
        keepfoodPanel.setMaximumSize(new Dimension(600, 80));
        keepfoodPanel.add(keepfood);
        this.add(keepfoodPanel);
        keepfoodPanel.setOpaque(false);

        snailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 110, 0));
        snailPanel.setMaximumSize(new Dimension(600,120));
        snailPanel.add(snail1);
        snailPanel.add(snail2);
        this.add(snailPanel);
        snailPanel.setOpaque(false);

        lbuttonPanel = new JPanel();
        lbuttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        lbuttonPanel.setMaximumSize(new Dimension(600, 200));
        lbuttonPanel.add(keep);
        lbuttonPanel.add(delete); 
        this.add(lbuttonPanel);
        lbuttonPanel.setOpaque(false);

    }
    private void Finally(){
        this.setSize(600,400);
        this.getContentPane().setBackground(Color.decode("#FAE5C7"));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == keep){
            
            this.dispose();
            new Dialogbox(randomList, defmodel, frame).setVisible(true);
        }

        if(e.getSource() == delete){

            for(int i = 0; i < randomList.getListLength(); i++){
                if(randomList.getName(i).equals(randomname)){
                    randomList.removeFormList(i);
                    defmodel.removeElementAt(i);
                }
            }
            if(!randomList.isEmpty()){
                
                this.dispose();
                new Dialogbox(randomList, defmodel, frame).setVisible(true);
                
            }
            else{
                this.setModalityType(JDialog.ModalityType.MODELESS);
                this.dispose();
                new Farewell(frame).setVisible(true);
                
            }
            this.dispose();
    
            
        }

        
    }
    
}
