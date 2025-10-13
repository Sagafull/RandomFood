package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import Class.RandomList;

public class Dialogbox extends JDialog implements ActionListener {

    private JLabel randomfood;
    private CustomeButton confirm,tryagain;
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
        randomfood.setForeground(Color.WHITE);

        confirm = new CustomeButton("Confrim");
        confirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
        confirm.setRadius(365);
        confirm.setBackground(Color.GREEN);
        confirm.setPreferredSize(new Dimension(160,100));
        confirm.addActionListener(this);

        tryagain = new CustomeButton("Try Again");
        tryagain.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tryagain.setRadius(365);
        tryagain.setBackground(Color.RED);
        tryagain.setPreferredSize(new Dimension(160, 100));
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
        gbuttonPanel.setOpaque(false);
        frandomPanel.setOpaque(false);
        this.getContentPane().setBackground(Color.BLACK);;
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
