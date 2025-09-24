package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartUI extends JPanel implements ActionListener{
    
    private JLabel welcomemsg;
    private JButton start;
    private JLabel choose;
    JFrame frame;
    
    
    public StartUI(JFrame frame){
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
        welcomemsg = new JLabel("Random Food");
        welcomemsg.setFont(new Font("Verdana", Font.PLAIN, 40));
        this.add(welcomemsg);

        start = new JButton("START");
        start.setFont(new Font("Verdana", Font.PLAIN, 40));
        this.add(start);
        start.addActionListener(this);

        choose = new JLabel("Your Food Let's us Choose it for YOU");
        choose.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.add(choose);
    }

    private void setComponentLocation(){
        welcomemsg.setBounds(140, 50, 300, 50);
        start.setBounds(200, 300, 200, 100);
        choose.setBounds(120, 450, 400, 50);

    }
    
    private void Finally(){
        this.setSize(600, 800);
        this.setOpaque(false);//พื้นหลังโปร่งใส่
     }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
          frame.setContentPane(new RandomMenuUI(frame));//ส่งค่า frame หลักไป panel2 แล้ว new panel2
        }
    }

}
