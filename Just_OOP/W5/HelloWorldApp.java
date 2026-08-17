import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class HelloWorldApp extends JFrame implements ActionListener{
    JTextField tf;
    JButton btn;
    JLabel te ;
    HelloWorldApp(){
        setTitle("");
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        tf  =   new JTextField();
        tf.setPreferredSize(new Dimension(250,35));
        tf.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn =   new JButton("Here");
        btn.setActionCommand("pass");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(this);
        te  =   new JLabel();
    
        add(tf);add(btn);add(te);
    }

    public static void main(String[] args) {
        new HelloWorldApp().setVisible(true);
    }
    public  void actionPerformed(ActionEvent ex){
        if(ex.getActionCommand().equals("pass")){
            setTitle(tf.getText());
            te.setText(tf.getText());
            
        }
    }
}
