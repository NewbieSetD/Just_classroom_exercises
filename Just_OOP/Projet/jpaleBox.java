import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// Class สำหรับสร้างบล็อกข้อมูลที่รองรับการอัปเดตค่า
class jpaleBox extends JPanel {
    private JLabel titleLabel;
    private JTextArea dataArea;

    public jpaleBox(String titleName, String initialValue) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 1. ส่วนหัวข้อ
        titleLabel = new JLabel(titleName);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 2. แถบแสดงข้อมูล
        dataArea = new JTextArea();
        dataArea.setPreferredSize(new Dimension(250, 35));
        dataArea.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        dataArea.setOpaque(true);
        dataArea.setBackground(new Color(240, 240, 240));
        dataArea.setAlignmentX(Component.LEFT_ALIGNMENT);

        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        dataArea.setBorder(BorderFactory.createCompoundBorder(border, 
                            BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        add(titleLabel);
        add(Box.createVerticalStrut(5)); 
        add(dataArea);
    }
    // =======================================================
    // เมธอดสำหรับรับค่าจากการคำนวณมาอัปเดตข้อความบนแถบ
    public void setValue(String newValue) {
        dataArea.setText(newValue);
    }
    public void setDataOutput(String d){
        dataArea.setText("");
        dataArea.append(d);
    }

}