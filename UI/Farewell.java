package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Farewell extends JDialog implements ActionListener {
    private JLabel farewell, background;
    private JButton ok;
    private JFrame frame;
    private JPanel wellPanel, okbuttonPanel;
    private JLayeredPane layeredPane;
    
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
        farewell = new JLabel("Enjoy Eating ~", SwingConstants.CENTER);
        farewell.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
        farewell.setForeground(Color.decode("#FFFFFF"));

        ok = new JButton(">");
        ok.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        ok.setPreferredSize(new Dimension(50, 50));
        ok.setBackground(Color.decode("#FFE49D"));
        ok.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 4));
        ok.addActionListener(this);

        background = new JLabel(new ImageIcon(new ImageIcon("UI/image/small.jpg").getImage().getScaledInstance(370, 370, Image.SCALE_SMOOTH)));
    }

    private void setComponentLocation(){
        wellPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 110));
        wellPanel.setMaximumSize(new Dimension(600, 340));
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
        this.getContentPane().setBackground(Color.decode("#0F1207"));
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
