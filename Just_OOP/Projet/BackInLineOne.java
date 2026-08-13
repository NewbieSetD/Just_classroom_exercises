import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackInLineOne implements ActionListener {
    private gui_pm mainGui;
    public BackinLIneOne (gui_pm mainGui) {
        this.mainGui = mainGui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "MAIN_BUTTON":
                // ทำงานเมื่อกดปุ่ม Class หลัก
                System.out.println("Controller: จัดการปุ่ม Class หลัก");
                break;
            case "SUB_BUTTON":
                // ทำงานเมื่อกดปุ่ม Class ย่อย
                System.out.println("Controller: จัดการปุ่ม Class ย่อย");
                break;
        }
    }
}

