import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// Class สำหรับสร้างบล็อกข้อมูลที่รองรับการอัปเดตค่า
class jpaleBox extends JPanel {
    private JLabel titleLabel;
    private JLabel dataLabel; // เก็บ Reference ไว้เปลี่ยนค่า

    public jpaleBox(String titleName, String initialValue) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 1. ส่วนหัวข้อ
        titleLabel = new JLabel(titleName);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 2. แถบแสดงข้อมูล
        dataLabel = new JLabel(initialValue);
        dataLabel.setPreferredSize(new Dimension(250, 35));
        dataLabel.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        dataLabel.setOpaque(true);
        dataLabel.setBackground(new Color(240, 240, 240));
        dataLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        dataLabel.setBorder(BorderFactory.createCompoundBorder(border, 
                            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        add(titleLabel);
        add(Box.createVerticalStrut(5)); 
        add(dataLabel);
    }

    // =======================================================
    // เมธอดสำหรับรับค่าจากการคำนวณมาอัปเดตข้อความบนแถบ
    // =======================================================
    public void setValue(String newValue) {
        dataLabel.setText(newValue);
    }

    // เมธอดสำหรับเปลี่ยนสีแถบ (เช่น เปลี่ยนสีตามผลลัพธ์)
    public void setBarColor(Color color) {
        dataLabel.setBackground(color);
    }
}