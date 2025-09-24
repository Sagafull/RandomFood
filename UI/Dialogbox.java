package UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Dialogbox extends JDialog implements ActionListener {

    private JLabel randomfood;
    private JButton confirm,tryagain;
    private String randomname;
    
    public Dialogbox(String randomname){
        this.randomname = randomname;
        Initial();
        setComponent();
        setComponentLocation();
        Finally();
        
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
        this.add(confirm);

        tryagain = new JButton("Try Again");
        tryagain.setSize(100, 100);
        this.add(tryagain);
        
    }
    private void setComponentLocation(){
        randomfood.setBounds(150, 30, 200,100 );
        

        confirm.setBounds(100, 100, 100, 100);
        tryagain.setBounds(300, 100, 100, 100);

    }
    private void Finally(){
        this.setSize(560,360);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
