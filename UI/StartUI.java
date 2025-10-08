package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class StartUI extends JPanel implements ActionListener{
    
    private JLabel welcomemsg, choose;
    private CustomeButton start;
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
        welcomemsg.setForeground(Color.WHITE);
        
        start = new CustomeButton("START");
        start.setFont(new Font("Tahoma", Font.BOLD, 40));
        start.setPreferredSize(new Dimension(220, 120));
        start.setRadius(365);
        start.setColor(Color.YELLOW);
        start.setColorOver(Color.CYAN);
        start.addActionListener(this);
        
        choose = new JLabel("Your Food Let's us Choose it for YOU !!", SwingConstants.CENTER);
        choose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        choose.setForeground(Color.WHITE);
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
        welcomePanel.setOpaque(false);
        startPanel.setOpaque(false);
        choosePanel.setOpaque(false);
        UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
          frame.setContentPane(new RandomMenuUI(frame));//ส่งค่า frame หลักไป panel2 แล้ว new panel2
        }
    }

}
