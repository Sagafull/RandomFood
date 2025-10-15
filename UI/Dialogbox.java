package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Class.RandomList;

public class Dialogbox extends JDialog implements ActionListener {

    private JLabel randomfood, snail1, snail2;
    private JButton confirm,tryagain;
    private String randomname;
    private JFrame frame;
    private RandomList randomList;
    private DefaultListModel defmodel;
    private JPanel gbuttonPanel, frandomPanel, snailPanel;
    
    public Dialogbox(RandomList randomList, DefaultListModel defmodel, JFrame frame){
        this.randomList = randomList;
        randomname = randomList.getRandom();
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
        randomfood = new JLabel(randomname, SwingConstants.CENTER);
        randomfood.setFont(new Font("TH Sarabun New" ,Font.BOLD, 50));
        randomfood.setForeground(Color.decode("#98623C"));

        confirm = new JButton("Confrim");
        confirm.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        confirm.setBackground(Color.decode("#98FB98"));
        confirm.setBorder(BorderFactory.createLineBorder(Color.decode("#4CBB17"), 6));
        confirm.setPreferredSize(new Dimension(130,80));
        confirm.addActionListener(this);

        tryagain = new JButton("Try Again");
        tryagain.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        tryagain.setBackground(Color.decode("#FF4040"));
        tryagain.setBorder(BorderFactory.createLineBorder(Color.decode("#8B0000"), 6));
        tryagain.setPreferredSize(new Dimension(130, 80));
        tryagain.addActionListener(this);

        snail1 = new JLabel(new ImageIcon(new ImageIcon("UI/image/snail.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        snail1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        snail2 = new JLabel(new ImageIcon(new ImageIcon("UI/image/snail2.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        snail2.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    }
    private void setComponentLocation(){

        frandomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 35));
        frandomPanel.setMaximumSize(new Dimension(600, 80));
        frandomPanel.add(randomfood);
        this.add(frandomPanel);
        frandomPanel.setOpaque(false);

        snailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 110, 0));
        snailPanel.setMaximumSize(new Dimension(600,120));
        snailPanel.add(snail1);
        snailPanel.add(snail2);
        this.add(snailPanel);
        snailPanel.setOpaque(false);
       
        gbuttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 0));
        gbuttonPanel.setMaximumSize(new Dimension(600, 200));
        gbuttonPanel.add(confirm);
        gbuttonPanel.add(tryagain); 
        this.add(gbuttonPanel);
        gbuttonPanel.setOpaque(false);


    }
    private void Finally(){
        
        this.setSize(600,400);
        this.getContentPane().setBackground(Color.decode("#FAE5C7"));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == confirm){
            
            this.dispose();
            new Farewell(frame);
            //frame.setContentPane(new StartUI(frame));
            
        }
       
        if(e.getSource() == tryagain){
            
            this.dispose();
            new Keepbox(randomname, randomList, defmodel, frame).setVisible(true);    
        }


    }
    
}
