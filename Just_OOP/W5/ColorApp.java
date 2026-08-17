import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
public class ColorApp extends JFrame implements MouseMotionListener{
    Panel   panel;
    TextField   tfinfo;
    ColorApp(){
        setLocationRelativeTo(null);
        setSize(512,512);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        tfinfo = new TextField();
        tfinfo.setEditable(false);

        panel = new Panel();
        panel.setBackground(Color.GRAY);
        panel.         addMouseMotionListener(this);
        add(tfinfo, BorderLayout.NORTH);
        add(panel,  BorderLayout.CENTER);
    } 
    public static void main(String[] args) {
        new ColorApp().setVisible(true);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("Hi");

    }
    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int r = x / 2;
        int g = y / 2;
        int b = (x + y) / 4;

// ป้องกัน r, g, b เกิน 255 (อาจเกินได้ถ้า x หรือ y มากกว่า 510)
        r = Math.min(r, 255);
        g = Math.min(g, 255);
        b = Math.min(b, 255);

        panel.setBackground(new Color(r, g, b));
        tfinfo.setText("x=" + x + ", y=" + y + "   r=" + r + " g=" + g + " b=" + b);
    }
}
