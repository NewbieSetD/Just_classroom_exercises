import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// Class สำหรับสร้างบล็อกข้อมูลที่รองรับการอัปเดตค่า
public class InputBox extends JPanel {
    private JLabel titleLabel;
    private JTextField DataInput; // เก็บ Reference ไว้เปลี่ยนค่า
    private JButton BtnInput; // เก็บ Reference ไว้เปลี่ยนค่า
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
        
        JButton BtnInput = new JButton(BtnName);
        BtnInput.setPreferredSize(new Dimension(250, 35));
        BtnInput.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        BtnInput.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(titleLabel);
        add(Box.createVerticalStrut(5)); 
        add(DataInput);
        //add(Box.createVerticalStrut(5)); 
        add(BtnInput);
    }
    public InputBox(String titleName,String BtnName,boolean isEditable) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 1. ส่วนหัวข้อ
        titleLabel = new JLabel(titleName);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JButton BtnInput = new JButton(BtnName);
        BtnInput.setPreferredSize(new Dimension(250, 35));
        BtnInput.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        BtnInput.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(titleLabel);
        add(Box.createVerticalStrut(5)); 
        //add(Box.createVerticalStrut(5)); 
        add(BtnInput);
    }

    // =======================================================
    // เมธอดสำหรับรับค่าจากการคำนวณมาอัปเดตข้อความบนแถบ
    public void getValue(JTextField DataInput) {
        DataInput.getText();
    }
}