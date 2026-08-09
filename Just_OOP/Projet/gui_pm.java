import javax.swing.*;
import java.awt.*;
import java.util.EventObject;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
public class gui_pm extends JFrame {
    private JPanel TopPanel;
    private JPanel DataPanel;
    private JPanel DataBar;
    private JPanel DataUuser;
    public int Wginter = 1000,Hginter = 1000;;
    public gui_pm() {
        SetUp_gui();
        setLayout(new GridLayout(2, 1));

        JPanel TopPanel = new JPanel(new FlowLayout());
        setup_Tables(TopPanel);
        add(TopPanel);
        
        JPanel DataPanel = new JPanel(new GridLayout(1, 2));
        JPanel DataBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        DataBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JPanel DataUuser = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        DataUuser.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jpaleBox Box_crete = new jpaleBox("Dust levels", "None Data Output");
        jpaleBox Box_crete2 = new jpaleBox("population", "None Data Output");
        jpaleBox Box_crete3 = new jpaleBox("number of healthy", "None Data Output");
        jpaleBox Box_crete4 = new jpaleBox("sick people", "None Data Output");
        jpaleBox Box_crete5 = new jpaleBox("percentage of sick people", "None Data Output");
        DataBar.add(Box_crete);
        DataBar.add(Box_crete2);
        DataBar.add(Box_crete3);
        DataBar.add(Box_crete4);
        DataBar.add(Box_crete5);
        
        //================================
        InputBox Input_crete1 = new InputBox("Determine the population.","Submit");
        InputBox Input_crete2 = new InputBox("Population sampling schedule.","Submit");
        DataUuser.add(Input_crete1);
        DataUuser.add(Input_crete2);
        DataPanel.add(DataBar);
        DataPanel.add(DataUuser);
        add(DataPanel);
    }

    public static void main(String[] args) {
        new gui_pm();
    }
    private void SetUp_gui(){
        setTitle("OOP_ASS1");
        setSize(Wginter, Hginter);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    private void setup_Tables(JPanel panel) {
        JPanel topPanel = new JPanel(new BorderLayout());
        JTable table = new JTable(40, 20){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        table.setRowHeight(40); 
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK); 
        table.setPreferredSize(new Dimension(Wginter, Hginter/2));
        panel.add(table);
    } 
    public void setUpdateData(jpaleBox box, String newValue) {
        box.setValue(newValue);

    }
}
