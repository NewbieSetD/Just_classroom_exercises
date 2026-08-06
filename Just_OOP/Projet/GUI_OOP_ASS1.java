import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
public class GUI_OOP_ASS1 extends JFrame {
    public int Wginter = 1000,Hginter = 1000;;
    public GUI_OOP_ASS1() {
        SetUp_gui();
        Setuo_GridLayout();
        setup_Layout();
        setup_Tables();
        jpaleBox Box_crete = new jpaleBox("Dust levels", "None Data Output");
        jpaleBox Box_crete2 = new jpaleBox("population", "None Data Output");
        jpaleBox Box_crete3 = new jpaleBox("number of healthy", "None Data Output");
        jpaleBox Box_crete4 = new jpaleBox("sick people", "None Data Output");
        jpaleBox Box_crete5 = new jpaleBox("percentage of sick people", "None Data Output");
        add(Box_crete);
        add(Box_crete2);
        add(Box_crete3);
        add(Box_crete4);
        add(Box_crete5);
        setUpdateData(Box_crete5, "Dust levels: 50");
        
        // setup_TextArea();
        // JButton btn = new JButton("Click Me");
        // add(btn);
    }
    //  DefaultTableModel model = new DefaultTableModel() {
    //         @Override
    //         public boolean isCellEditable(int row, int column) {
    //             return false; // ห้ามแก้ไขข้อมูลทุกช่อง
    //         }
    // };
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
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createTitledBorder("PM2.5 Data Management Program"));
        JTable table = new JTable(40, 20);
        table.setRowHeight(50); 
        table.setShowGrid(true);
        table.setGridColor(Color.GRAY); 
        table.setPreferredSize(new Dimension(Wginter, Hginter/2));
        add(table,BorderLayout.CENTER);
    } 
    private void setup_Layout() {
        setLayout(new FlowLayout());
    } 
    private void Setuo_GridLayout() {
        setLayout(new GridLayout(2, 1));
    }
    public void setUpdateData(jpaleBox box, String newValue) {
        box.setValue(newValue);

    }
}
