import java.awt.*;
import java.awt.event.*;
public class Lab2App extends Frame implements WindowListener {
    Lab2App(){
        setTitle("My Appl");
          setLocation(200, 100);
          setLayout(new GridLayout(10, 4));
          for(byte i=1;i<=20;i++){
            add(new Button("Button "+i));
             add(new TextArea("TextArea " + i, 2, 10));
          }
        setSize(700,600);
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
        new Lab2App();
        // System.out.println("HI");
    }
}