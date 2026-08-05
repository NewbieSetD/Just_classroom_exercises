import javax.swing.*;
import java.awt.*;
import javax.swing.*;
public class GUI_OOP_ASS1 extends JFrame {
    public int Wginter = 1000,Hginter = 1000;
    public GUI_OOP_ASS1() {
        SetUp_gui();
        setup_Layout();
        setup_Tables();
        // setup_TextArea();
        // JButton btn = new JButton("Click Me");
        // add(btn);
    }
    public static void main(String[] args) {
        new GUI_OOP_ASS1();
    }
    private void SetUp_gui(){
        setTitle("OOP_ASS1");
        setSize(Wginter, Hginter);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void setup_Tables() {
        JTable table = new JTable(40, 20);
        // table.setPreferredSize(new Dimension(500, 1000));
        table.setRowHeight(50); 
        table.setShowGrid(true);
        table.setGridColor(Color.GRAY); 
        table.setPreferredSize(new Dimension(Wginter, Hginter/2));
        add(table);
    } 
    private void setup_Layout() {
        setLayout(new FlowLayout());
    } 
    private void setup_TextArea() {
        for(int i = 0; i < 10; i++) {
            JTextArea textArea = new JTextArea("Text Area " + (i + 1));
            add(textArea);

        }
    }  
}
