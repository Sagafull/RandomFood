package UI;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
    Container cp;
    StartUI startUI;
    RandomMenuUI randomMenuUI;
    
    public Frame(){
        Initial();
        setComponent();
        Finally();
    }

    public void Initial(){
        cp = this.getContentPane();
        cp.setLayout(null);
    }
    
    public void setComponent(){
       this.setContentPane(new StartUI(this));//แสดง JPanel แรก และ ส่งค่า Frame หลัก ไปที่ JPanel แรก

    }
    public void Finally(){
        cp.setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(600, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
