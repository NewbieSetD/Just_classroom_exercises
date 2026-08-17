import javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
public class MultiTableApp extends JFrame implements ActionListener{
    JButton btn;
    JTextField  tf;
    JTextArea   ta;
    MultiTableApp(){
        setTitle("Multitable");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JLabel txJLabel =   new JLabel("Multitable::");
        tf  =  new JTextField();
        tf.setPreferredSize(new Dimension(250,35));
        btn =   new JButton("Do it");
        btn.addActionListener(this);
        btn.setActionCommand("MuI");
        ta  =   new JTextArea(12,30);
        ta.setEditable(false);
        add(txJLabel);add(tf);add(btn);add(ta);
    }
    public static void main(String[] args) {
        new MultiTableApp().setVisible(true);
    }
    public  void actionPerformed(ActionEvent ex){
        int Num=0;
        String DataN="",DataC="",DataI="";
       if(ex.getActionCommand().equals("MuI")){
            String data = tf.getText();
            //System.out.print("kkk");
            try {
                ta.setText("");
                int GetD = Integer.parseInt(data);
                for(byte i=1;i<=12;i++){
                    Num = GetD*i;
                    ta.append(String.format("%d * %d = %d\n",GetD,i,Num));
                }
            } catch (Exception e) {
                ta.setText("Error");
            }
       }
    }
}
