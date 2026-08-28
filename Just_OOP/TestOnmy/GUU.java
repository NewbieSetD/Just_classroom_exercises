import java.awt.*;
import java.awt.event.*;
public class GUU extends Frame {
    GUU(){
        setTitle("MyTestsome");
        setSize(500,500);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                System.exit(0);
                }
        });
        setLayout(new BorderLayout());
        setBackground(Color.RED);
        //add(new JButton("Nuga"));
        Panel Ddi = new Panel();
        Ddi.setBackground(Color.BLUE);
        add(new TextArea(),BorderLayout.NORTH);
    }
    
    public static void main(String[] args) {
        new GUU().setVisible(true);
    }


}
