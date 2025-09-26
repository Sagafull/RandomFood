package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Farewell extends JDialog implements ActionListener {
    private JLabel farewell;
    private JButton ok;
    private JFrame frame;
    
    public Farewell(JFrame frame){
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
        farewell = new JLabel("Goodluck");
        this.add(farewell);

        ok = new JButton("OK");
        ok.addActionListener(this);
        this.add(ok);
    }

    private void setComponentLocation(){
        farewell.setBounds(150, 30, 200, 50);
        ok.setBounds(20, 100, 50, 50);
    }

    private void Finally(){
        this.setSize(570, 370);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok){
            frame.setContentPane(new StartUI(frame));
            this.setVisible(false);
        }
    }
}
