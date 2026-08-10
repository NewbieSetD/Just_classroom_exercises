import javax.swing.*;
import java.awt.*;
import java.util.EventObject;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
public class gui_pm extends JFrame {
    private JPanel TopPanel;
    private JPanel DataPanel;
    private JPanel DataBar;
    private JPanel DataUuser;
    public int Wginter = 1024,Hginter = 1024;
    String[] Rain={"Artificial rain", "natural rain"};
    String[] Data={"pm2.5_69.txt"};
    public gui_pm() {
        SetUp_gui();
        setLayout(new GridLayout(2, 1));

        JPanel TopPanel = new JPanel(new BorderLayout());
        //JPanel TopPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        //TopPanel.setPreferredSize(new Dimension(1000, 800));
        JScrollPane scrollPane = new JScrollPane(setup_Tables());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        TopPanel.add(scrollPane, BorderLayout.CENTER);
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
        JButton ImporBTN = new JButton("Import Data");
        ImporBTN.setPreferredSize(new Dimension(250, 35));
        ImporBTN.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        ImporBTN.setAlignmentX(Component.LEFT_ALIGNMENT);
        DataUuser.add(ImporBTN);
        InputBox Input_crete1 = new InputBox("Determine the population.","Submit");
        InputBox Input_crete2 = new InputBox("Population sampling schedule.","Submit");
        DataUuser.add(Input_crete1);
        DataUuser.add(Input_crete2);
        InputBox Input_crete3 = new InputBox(Rain);
        //openFile(); 
        DataUuser.add(Input_crete3);
        DataPanel.add(DataBar);
        DataPanel.add(DataUuser);
        add(DataPanel);
    }

    public static void main(String[] args) {
        new gui_pm().setVisible(true);;
    }
    private void SetUp_gui(){
        setTitle("OOP_ASS1");
        setSize(Wginter, Hginter);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    private JTable setup_Tables() {
        
        int numRows = 1;
        JTable table = new JTable(40, 20){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        // for (int r = 0; r < table.getRowCount(); r++) {
        //     for (int c = 0; c < table.getColumnCount(); c++) {
        //         table.setValueAt(numRows++, r, c); // ใส่ค่าตัวเลขลงในพิกัด (r, c)
        //     }
        // }
        table.setRowHeight(40); 
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK); 
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        return table;  
    } 
    public void setUpdateData(jpaleBox box, String newValue) {
        box.setValue(newValue);

    }
    public void openFile() {
    // 1. สร้าง JFileChooser
    JFileChooser fileChooser = new JFileChooser();

    // 2. (ตัวเลือก) กำหนดโฟลเดอร์เริ่มต้นที่ต้องการให้เปิด
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

    // 3. กรองประเภทไฟล์ ให้เลือกได้เฉพาะ .csv และ .txt
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text & CSV Files (*.txt, *.csv)", "txt", "csv");
    fileChooser.setFileFilter(filter);

    // 4. เปิดหน้าต่าง Pop-up ให้ผู้ใช้เลือกไฟล์
    int result = fileChooser.showOpenDialog(this); // 'this' คือ Component แม่ เช่น JFrame

    // 5. ตรวจสอบว่าผู้ใช้กดปุ่ม "Open" หรือไม่
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        System.out.println("ไฟล์ที่เลือก: " + selectedFile.getAbsolutePath());

        // 6. นำไฟล์ไปอ่านข้อมูล
    }
}
}
