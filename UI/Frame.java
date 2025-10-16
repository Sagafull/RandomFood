package UI;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    Container cp;
    StartUI startUI;
    RandomMenuUI randomMenuUI;
    // paintFrame paintframe;

    public Frame() {
        // setUpLookAndFeel();
        Initial();
        setComponent();
        Finally();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
        
    }

    public void setComponent() {
        this.setContentPane(new StartUI(this));// แสดง JPanel แรก และ ส่งค่า Frame หลัก ไปที่ JPanel แรก
        // paintframe = new paintFrame();
    }

    public void Finally() {
        this.setSize(600, 800);
        this.setBackground(Color.decode("#FAE5C7"));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    

    // private void setUpLookAndFeel() {
    //     try {
    //         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 UIManager.put("control", new Color(250, 245, 240)); // สีพื้นหลังโดยรวม
    //                 UIManager.put("nimbusBlueGrey", new Color(200, 200, 200)); // สีเทาพื้นฐาน
    //                 UIManager.put("nimbusLightBackground", new Color(255, 255, 255)); // สีพื้นของ textfield/panel
                    
    //                 UIManager.put("nimbusBorder", Color.decode("#E9B32C")); // เปลี่ยนสีกรอบหลัก
    //                 UIManager.put("TextField.border", BorderFactory.createLineBorder(Color.decode("#E9B32C"), 2));
    //                 UIManager.put("Button.border", BorderFactory.createLineBorder(Color.decode("#E9B32C"), 2));
    //                 UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (Exception ex) {
    //         java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    // }
}
// class paintFrame extends JPanel{

//     protected void paintComponent(Graphics grphcs) {
//         super.paintComponents(grphcs);
//         grphcs.setColor(Color.WHITE);
//         grphcs.fillRoundRect(2, 2, 10, 10, 360, 360);
//     }
// }