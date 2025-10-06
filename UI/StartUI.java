package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class StartUI extends JPanel implements ActionListener{
    
    private JLabel welcomemsg;
    private JButton start;
    private JLabel choose;
    private JPanel startPanel;
    JFrame frame;
    
    
    public StartUI(JFrame frame){
        Initial();
        setComponent();
        setComponentLocation();
        Finally();
        this.frame = frame;

    }

    private void Initial(){
        this.setLayout(new BorderLayout());
     }
     
    private void setComponent(){
        welcomemsg = new JLabel("Random Food", SwingConstants.CENTER);
        welcomemsg.setFont(new Font("Tahoma", Font.PLAIN, 70));
        welcomemsg.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));

        start = new JButton("START");
        start.setFont(new Font("Tahoma", Font.PLAIN, 40));
        start.setPreferredSize(new Dimension(180, 80));
        start.addActionListener(this);

        choose = new JLabel("Your Food Let's us Choose it for YOU !!", SwingConstants.CENTER);
        choose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        choose.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));
    }

    private void setComponentLocation(){
        this.add(welcomemsg, BorderLayout.NORTH);

        startPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startPanel.add(start);
        startPanel.setBorder(BorderFactory.createEmptyBorder(300, 0, 300, 0));
        this.add(startPanel, BorderLayout.CENTER);

        this.add(choose, BorderLayout.SOUTH);
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
