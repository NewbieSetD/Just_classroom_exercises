import java.awt.*;
import java.awt.event.*;
public class Lab4App extends Frame implements WindowListener {
    Lab4App(){
        int fWid = 400,fHei = 200,tfw = 200, tfH=30,Btnw=100,BtnH = 30;
        setTitle("My Appl");
        setLayout(null);
        
        TextField te =  new TextField(20);
        te.setBounds((fWid-tfw)/2,80,tfw,tfH);
        add(te);
        Button Btn = new Button("Touch");
        Btn.setBounds((fWid-Btnw)/2,130,Btnw,BtnH);
        add(Btn);
        setSize(fWid,fHei);
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
        new Lab4App();
        // System.out.println("HI");
    }
}