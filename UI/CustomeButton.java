package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;

import org.w3c.dom.events.MouseEvent;

public class CustomeButton extends JButton {
    private int radius = 0;
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color colorBorder;

    public CustomeButton(String text){
        this.setText(text);
        this.setContentAreaFilled(false);
        setColor(Color.WHITE);
        colorOver = new Color(179, 250, 160);
        colorClick = new Color(152, 184, 144);
        colorBorder = new Color(30, 136, 56);
        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOver);
                over = true;
            }
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                over = false;
            }
            public void mousePressed(MouseEvent me) {
                setBackground(colorClick);
            }
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }
        });
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public boolean isOver() {
        return over;
    }

    public void setColor(Color color){
        this.color = color;
        this.setBackground(color);
    }

    public Color getColor(){
        return color;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setBorderColor(Color borderColor) {
        this.colorBorder = borderColor;
    }

    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(colorBorder);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(this.getBackground());
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}
