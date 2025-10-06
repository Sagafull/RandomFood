package UI;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    Container cp;
    StartUI startUI;
    RandomMenuUI randomMenuUI;

    public Frame() {
        // setUpLookAndFeel();
        Initial();
        setComponent();
        Finally();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
    }

    public void setComponent() {
        this.setContentPane(new StartUI(this));// แสดง JPanel แรก และ ส่งค่า Frame หลัก ไปที่ JPanel แรก

    }

    public void Finally() {
        this.setSize(600, 800);
        cp.setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // private void setUpLookAndFeel() {
    //     try {
    //         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (Exception ex) {
    //         java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    // }

}
