package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

import javax.swing.*;
import javax.swing.border.Border;

public class Farewell extends JDialog implements ActionListener {
    private JLabel farewell, background, layered;
    private JButton ok;
    private JFrame frame;
    private JPanel wellPanel, okbuttonPanel;
    
    public Farewell(JFrame frame){
        this.frame = frame;
        Initial();
        setComponent();
        setComponentLocation();
        Finally();
        
    }

    private void Initial(){
        this.setLayout(new FlowLayout());
    }
    
    private void setComponent(){
        farewell = new JLabel("ENJOY EATING ~", SwingConstants.CENTER);
        farewell.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
        farewell.setForeground(Color.decode("#98623C"));

        ok = new JButton(">");
        ok.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        ok.setPreferredSize(new Dimension(50, 50));
        ok.setBackground(Color.decode("#FFE49D"));
        ok.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 4));
        ok.addActionListener(this);

        background = new JLabel(new ImageIcon(new ImageIcon("UI/image/pngwing.com.png").getImage().getScaledInstance(350, 346, Image.SCALE_SMOOTH)));

    }

    private void setComponentLocation(){
        wellPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        wellPanel.setMaximumSize(new Dimension(600, 340));
        wellPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        wellPanel.add(farewell);
        wellPanel.setOpaque(false);
        

        okbuttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        okbuttonPanel.setMaximumSize(new Dimension(600, 60));
        okbuttonPanel.add(ok);
        okbuttonPanel.setOpaque(false);
        
        background.setLayout(new BorderLayout());
        background.add(wellPanel, BorderLayout.CENTER);
        background.add(okbuttonPanel, BorderLayout.SOUTH);
        background.setOpaque(true);

    }
    
    private void Finally(){
        this.setContentPane(background);
        this.setSize(600, 400);
        this.getContentPane().setBackground(Color.decode("#FAE5C7"));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok){
            
            this.dispose();
            frame.setContentPane(new StartUI(frame));
            
        }
    }
}
