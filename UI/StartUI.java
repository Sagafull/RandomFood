package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class StartUI extends JPanel implements ActionListener{
    
    private JLabel welcomemsg, choose;
    private JButton start;
    private JPanel startPanel, welcomePanel, choosePanel;
    JFrame frame;
    
    
    public StartUI(JFrame frame){
        Initial();
        setComponent();
        setComponentLocation();
        Finally();
        this.frame = frame;

    }

    private void Initial(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
     }
     
    private void setComponent(){
        welcomemsg = new JLabel("Random Food", SwingConstants.CENTER);
        welcomemsg.setFont(new Font("Tahoma", Font.PLAIN, 70));
        
        start = new JButton("START");
        start.setFont(new Font("Tahoma", Font.PLAIN, 40));
        start.setPreferredSize(new Dimension(160, 80));
        start.addActionListener(this);
        
        choose = new JLabel("Your Food Let's us Choose it for YOU !!", SwingConstants.CENTER);
        choose.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }
    
    private void setComponentLocation(){
        
        welcomePanel = new JPanel();
        welcomePanel.setPreferredSize(new Dimension(600, 500));
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        welcomePanel.add(welcomemsg);
        this.add(welcomePanel);
        
        startPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startPanel.setPreferredSize(new Dimension(600,200));
        startPanel.add(start);
        this.add(startPanel);

        choosePanel = new JPanel();
        choosePanel.setPreferredSize(new Dimension(600, 100));
        choosePanel.add(choose);
        this.add(choosePanel);
    }
    
    private void Finally(){
        this.setSize(600, 800);
        this.setOpaque(false);//พื้นหลังโปร่งใส่
        UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
          frame.setContentPane(new RandomMenuUI(frame));//ส่งค่า frame หลักไป panel2 แล้ว new panel2
        }
    }

}
