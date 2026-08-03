import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Lab3App extends Frame implements WindowListener {
    Lab3App(){
        Random Rnd = new Random();
        setTitle("My Appl");
          setLocation(200, 100);
          setLayout(null);
          int x=0,y=0;
          for(byte i=1;i<=20;i++){
            Button btn = new Button("Button "+i);
            x = Rnd.nextInt(750); y = Rnd.nextInt(550);
            Color Linec = new Color(Rnd.nextInt(256),Rnd.nextInt(256),Rnd.nextInt(256));
            btn.setBounds(x,y,80,30);
            btn.setBackground(Linec);
            add(btn);

          }
        setSize(800,600);
        addWindowListener(this);
        setVisible(true);
    }
    @Override public void windowClosing(WindowEvent e) {System.exit(0);}
    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    public static void main(String HUj[]){
        new Lab3App();
        // System.out.println("HI");
    }
}