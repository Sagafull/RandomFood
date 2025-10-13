package UI;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    Container cp;
    StartUI startUI;
    RandomMenuUI randomMenuUI;
    paintFrame paintframe;

    public Frame() {
        setUpLookAndFeel();
        Initial();
        setComponent();
        Finally();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
        
    }

    public void setComponent() {
        this.setContentPane(new StartUI(this));// แสดง JPanel แรก และ ส่งค่า Frame หลัก ไปที่ JPanel แรก
        paintframe = new paintFrame();
    }

    public void Finally() {
        this.setSize(600, 800);
        cp.setBackground(Color.BLACK);
        this.setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

     private void setUpLookAndFeel() {
         try {
             for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (Exception ex) {
             java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
     }
}
class paintFrame extends JPanel{

    protected void paintComponent(Graphics grphcs) {
        super.paintComponents(grphcs);
        grphcs.setColor(Color.WHITE);
        grphcs.fillRoundRect(2, 2, 10, 10, 360, 360);
    }
}