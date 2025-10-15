package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Farewell extends JDialog implements ActionListener {
    private JLabel farewell;
    private JButton ok;
    private JFrame frame;
    private JPanel wellPanel, okbuttonPanel;
    
    public Farewell(JFrame frame){
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
        farewell = new JLabel("Enjoy Eating !!!", SwingConstants.CENTER);
        farewell.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
        farewell.setForeground(Color.decode("#98623C"));

        ok = new JButton(">");
        ok.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        ok.setPreferredSize(new Dimension(50, 50));
        ok.setBackground(Color.decode("#FFE49D"));
        ok.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 4));
        ok.addActionListener(this);
    }

    private void setComponentLocation(){
        wellPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 140));
        wellPanel.setPreferredSize(new Dimension(600, 200));
        wellPanel.add(farewell);
        wellPanel.setOpaque(false);
        this.add(wellPanel);

        okbuttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        okbuttonPanel.setPreferredSize(new Dimension(600, 200));
        okbuttonPanel.add(ok);
        okbuttonPanel.setOpaque(false);
        this.add(okbuttonPanel);
    }

    private void Finally(){
        this.setSize(600, 400);
        this.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        this.getContentPane().setBackground(Color.decode("#FAE5C7"));
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

