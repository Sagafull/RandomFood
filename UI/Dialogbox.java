package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import Class.RandomList;

public class Dialogbox extends JDialog implements ActionListener {

    private JLabel randomfood;
    private JButton confirm,tryagain;
    private String randomname;
    private JFrame frame;
    private RandomList randomList;
    private DefaultListModel defmodel;
    private JPanel gbuttonPanel, frandomPanel;
    
    public Dialogbox(RandomList randomList, DefaultListModel defmodel, JFrame frame){
        this.randomList = randomList;
        randomname = randomList.getRandom();
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

        confirm = new JButton("Confrim");
        confirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
        confirm.setPreferredSize(new Dimension(150, 60));
        confirm.addActionListener(this);

        tryagain = new JButton("Try Again");
        tryagain.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tryagain.setPreferredSize(new Dimension(150, 60));
        tryagain.addActionListener(this);
        
    }
    private void setComponentLocation(){

        frandomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 70));
        frandomPanel.setPreferredSize(new Dimension(600, 200));
        frandomPanel.add(randomfood);
        this.add(frandomPanel);

        gbuttonPanel = new JPanel();
        gbuttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        gbuttonPanel.setPreferredSize(new Dimension(600, 200));
        gbuttonPanel.add(confirm);
        gbuttonPanel.add(tryagain); 
        this.add(gbuttonPanel);

    }
    private void Finally(){
        this.setSize(600,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == confirm){
            new Farewell(frame).setVisible(true);
            this.setVisible(false);
        }
       
        if(e.getSource() == tryagain){
            new Keepbox(randomname, randomList, defmodel, frame).setVisible(true);
            this.setVisible(false);
        }

        
    }
    
}
