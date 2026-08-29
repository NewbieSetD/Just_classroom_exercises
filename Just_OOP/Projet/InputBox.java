import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// Class สำหรับสร้างบล็อกข้อมูลที่รองรับการอัปเดตค่า
public class InputBox extends JPanel {
    private JLabel titleLabel;
    private JTextField DataInput; // เก็บ Reference ไว้เปลี่ยนค่า
    private JButton BtnInput; // เก็บ Reference ไว้เปลี่ยนค่า
    private JList<String> listBar;
    private Timer currentTimer ;
    public InputBox(String titleName,String BtnName) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 1. ส่วนหัวข้อ
        titleLabel = new JLabel(titleName);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 2. แถบแสดงข้อมูล
        DataInput = new JTextField();
        DataInput.setPreferredSize(new Dimension(250, 35));
        DataInput.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        DataInput.setAlignmentX(Component.LEFT_ALIGNMENT);

        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        DataInput.setBorder(BorderFactory.createCompoundBorder(border, 
                            BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        
        BtnInput = new JButton(BtnName);
        BtnInput.setPreferredSize(new Dimension(250, 35));
        BtnInput.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        BtnInput.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(titleLabel);
        add(Box.createVerticalStrut(5)); 
        add(DataInput);
        //add(Box.createVerticalStrut(5)); 
        add(BtnInput);
    }
    public InputBox(String [] DataList) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 1. ส่วนหัวข้อ
        listBar = new JList<>(DataList);
        listBar.setFont(new Font("Tahoma", Font.BOLD, 14));
        listBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        listBar.setFixedCellHeight(35);
        listBar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //listBar.setSelectedIndex(0);
        JScrollPane listScrollPane = new JScrollPane(listBar);
        listScrollPane.setPreferredSize(new Dimension(200, 300));
        
        BtnInput = new JButton("Start Rain");
        BtnInput.setPreferredSize(new Dimension(250, 35));
        BtnInput.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        BtnInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        add(listBar);
        add(Box.createVerticalStrut(5)); 
        //add(Box.createVerticalStrut(5)); 
        add(BtnInput);
    }

    // =======================================================
    // เมธอดสำหรับรับค่าจากการคำนวณมาอัปเดตข้อความบนแถบ
    public void showTemporaryText(String message) {
        if (currentTimer != null && currentTimer.isRunning()) {
        currentTimer.stop();
    }
        DataInput.setText(message);

        // สร้าง Timer นับถอยหลังตามเวลา delayMs
        Timer timer = new Timer(2500, e -> {
            DataInput.setText(""); // เมื่อครบกำหนดเวลา ให้ลบข้อความทิ้ง
        });

        timer.setRepeats(false); // 🟢 สำคัญ: ตั้งค่าให้ทำงานครั้งเดียวแล้วหยุด
        timer.start(); // เริ่มนับเวลา
    }
    public JButton getSubmitButton() {
        return BtnInput;
    }
    public void setButton_commd(String cmd){
        BtnInput.setActionCommand(cmd);
    }
    public void setOutError(String data,Color cor){
        DataInput.setForeground(cor);
        DataInput.setText(data);
    }
    public JTextField getTextField(){
        return DataInput;
    }
    public String getDataFromTextField(){
        return DataInput.getText().trim();
    }
    public JList getJList(){
        return listBar;
    }
}