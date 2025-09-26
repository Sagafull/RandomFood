package UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import Class.RandomList;

public class Dialogbox extends JDialog implements ActionListener {

    private JLabel randomfood;
    private JButton confirm,tryagain;
    private String randomname;
    private JFrame frame;
    private RandomList randomList;
    private DefaultListModel defmodel;

    private JLabel keepfood;
    private JButton keep,delete;
    
    public Dialogbox(RandomList randomList,DefaultListModel defmodel, JFrame frame){
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
        this.setLayout(null);
    }

    private void setComponent(){
        randomfood = new JLabel(randomname);
        randomfood.setFont(new Font("Verdana" ,Font.PLAIN, 20));
        this.add(randomfood);

        confirm = new JButton("Confrim");
        confirm.setSize(100, 100);
        confirm.addActionListener(this);
        this.add(confirm);

        tryagain = new JButton("Try Again");
        tryagain.setSize(100, 100);
        tryagain.addActionListener(this);
        this.add(tryagain);

        keepfood = new JLabel("Keep: " + randomname +" ?");
        keepfood.setVisible(false);
        this.add(keepfood);
        
        
        keep = new JButton("KEEP");
        keep.setVisible(false);
        keep.addActionListener(this);
        this.add(keep);
        
        

        delete = new JButton("DELETE");
        delete.addActionListener(this);
        delete.setVisible(false);
        this.add(delete);
    }
    private void setComponentLocation(){
        randomfood.setBounds(210, 30, 200,100 );
        

        confirm.setBounds(100, 150, 100, 50);
        
        tryagain.setBounds(300, 150, 100, 50);

        keepfood.setBounds(210, 30, 150, 50);
        
        keep.setBounds(100, 150, 100, 50);

        delete.setBounds(300, 150, 100, 50);

    }
    private void Finally(){
        this.setSize(560,360);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == confirm){
            new Farewell(frame).setVisible(true);
            this.setVisible(false);
        }
       
        if(e.getSource() == tryagain){
            keepfood.setVisible(true);
            keep.setVisible(true);
            delete.setVisible(true);

            randomfood.setVisible(false);
            tryagain.setVisible(false);
            confirm.setVisible(false);
        }

        if(e.getSource() == keep){
            keepfood.setVisible(false);
            keep.setVisible(false);
            delete.setVisible(false);

            randomname = randomList.getRandom();
            randomfood.setText(randomname);
            keepfood.setText("Keep: "+randomname+"?");

            randomfood.setVisible(true);
            tryagain.setVisible(true);
            confirm.setVisible(true);
        }

        if(e.getSource() == delete){
            keepfood.setVisible(false);
            keep.setVisible(false);
            delete.setVisible(false);

            for(int i = 0; i < randomList.getListLength(); i++){
                if(randomList.getName(i).equals(randomname)){
                    randomList.removeFormList(i);
                    defmodel.removeElementAt(i);
                }
            }

            randomname = randomList.getRandom();
            randomfood.setText(randomname);
            keepfood.setText("Keep: "+randomname+"?");

            randomfood.setVisible(true);
            tryagain.setVisible(true);
            confirm.setVisible(true);
        }

        
    }
    
}
