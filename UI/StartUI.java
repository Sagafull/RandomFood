package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class StartUI extends JPanel implements ActionListener{
    
    private JLabel welcomemsg, choose, image;
    private JButton start;
    private JPanel startPanel, welcomePanel, choosePanel, imagePanel;
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
        welcomemsg.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 70));
        welcomemsg.setForeground(Color.decode("#98623C"));
        
        image = new JLabel();
        image.setIcon(new ImageIcon(new ImageIcon("UI/image/hungryCat.png").getImage().getScaledInstance(400, 295, Image.SCALE_SMOOTH)));

        
        start = new JButton("START");
        start.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        start.setPreferredSize(new Dimension(220, 120));
        start.setBackground(Color.decode("#FFE49D"));
        start.setBorder(BorderFactory.createLineBorder(Color.decode("#D0915A"), 8));
        start.addActionListener(this);
        
        choose = new JLabel("Your Food Let's us Choose it for YOU !!", SwingConstants.CENTER);
        choose.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        choose.setForeground(Color.decode("#98623C"));
    }
    
    private void setComponentLocation(){
        
        welcomePanel = new JPanel();
        welcomePanel.setPreferredSize(new Dimension(600, 150));
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        welcomePanel.add(welcomemsg);
        this.add(welcomePanel);

        imagePanel = new JPanel();
        imagePanel.setPreferredSize(new Dimension(600, 350));
        imagePanel.add(image);
        this.add(imagePanel);
        
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
        imagePanel.setOpaque(false);
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
