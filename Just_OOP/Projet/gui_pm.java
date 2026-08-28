import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.*;
import java.util.List;
import java.awt.event.*;
public class gui_pm extends JFrame implements ActionListener,MouseListener{
    private JPanel TopPanel,DataPanel,DataBar,DataUuser;
    private File selectedFile;
    private JTable table;
        //Dust levels || population(2) || number of healthy(3) || sick people(4) || percentage of sick people(5)
    private jpaleBox Box_crete,Box_crete2,Box_crete3,Box_crete4,Box_crete5,Box_AdrTable;
    private InputBox Input_crete1,Input_crete2,Input_crete3;
    private ArrayList <Integer> NumData = new ArrayList<>();
    private String [] Rain = {"Artificial rain", "natural rain"};
    private int[][]DustLv;
    private int[][]population;
    private int[][]healthy;
    private int[][]Speople;
    private double[][] percentage_Speople;
    private Color[][] cellColors;
    private boolean isFlie = false,isGetPel = false;
    private int arr[] = new int[2]; 
    private String stateInput;
    public int Wginter = 1024,Hginter = 1024;
    gui_pm() {
        SetUp_gui();
        setLayout(new GridLayout(2, 1));

        JPanel TopPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(setup_Tables());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        TopPanel.add(scrollPane, BorderLayout.CENTER);
        add(TopPanel);
        JPanel DataPanel = new JPanel(new GridLayout(1, 2));
        JPanel DataBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        DataBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JPanel DataUuser = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        DataUuser.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        Box_AdrTable = new jpaleBox("Table On", "None Select");
         Box_crete =  new jpaleBox("Dust levels", "None Data Output");
         Box_crete2 = new jpaleBox("population", "None Data Output");
         Box_crete3 = new jpaleBox("number of healthy", "None Data Output");
         Box_crete4 = new jpaleBox("sick people", "None Data Output");
         Box_crete5 = new jpaleBox("percentage of sick people", "None Data Output");
        DataBar.add(Box_AdrTable); 
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
        ImporBTN.setActionCommand("IMPORT");
        ImporBTN.addActionListener(this);
        JButton DataCal = new JButton("Refresh");
        DataCal.setPreferredSize(new Dimension(250, 35));
        DataCal.setMaximumSize(new Dimension(Short.MAX_VALUE, 10));
        DataCal.setAlignmentX(Component.LEFT_ALIGNMENT);
        DataCal.setActionCommand("REFRESH");
        DataCal.addActionListener(this);
        DataUuser.add(ImporBTN);
        DataUuser.add(DataCal);
        Input_crete1 = new InputBox("Determine the population.","Submit population");
        Input_crete2 = new InputBox("Population sampling schedule(Number-Number).","Submit Random");
        DataUuser.add(Input_crete1);
        DataUuser.add(Input_crete2);
        Input_crete3 = new InputBox(Rain);
        Input_crete1.setButton_commd("POPULATION");
        Input_crete2.setButton_commd("RANDOM");
        Input_crete3.setButton_commd("RAIN");
        Input_crete1.getSubmitButton().addActionListener(this);
        Input_crete2.getSubmitButton().addActionListener(this);
        Input_crete3.getSubmitButton().addActionListener(this);
        DataUuser.add(Input_crete3);
        DataPanel.add(DataBar);
        DataPanel.add(DataUuser);
        add(DataPanel);
        
    }
    public static void main(String[] args) {
            new gui_pm().setVisible(true);
        // gui_pm fun = new gui_pm("My");
        // System.out.println(fun.isSamevalue(10));
    }
    public void isCanbecolor(){
        if(isFlie&isGetPel){
                System.out.println("Is Done");
                setDataBar();
                //setTable();
                setColoerTable();
            }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("IMPORT")){
            openFile(); 
            setDustData();
            isFlie=true;
            isCanbecolor();
            System.out.println(" flie");
        }
        else if (e.getActionCommand().equals("POPULATION")){
            System.out.println(" Human");
        }
        else if(e.getActionCommand().equals("RANDOM")){
            System.out.println(" random");
            String Det = Input_crete2.getDataFromTextField();
            setnumInput(Det);
            Arrays.sort(arr);
            if(isRigthRandom()){
                isGetPel=true; 
                isCanbecolor();
                Input_crete2.showTemporaryText(stateInput);
                setRandomHuman(arr[0],arr[1]);
            }
            else{Input_crete2.showTemporaryText(stateInput);}
        }
        else if(e.getActionCommand().equals("REFRESH")){
            System.out.println(" REFRESH");
            if(isFlie&&isGetPel){
                System.out.println("Is Refresh");
                setDataBar();
                //setTable();
                setColoerTable();
                table.repaint();
            }
            else{
                System.out.println("None Data");
            }
        }
        else if(e.getActionCommand().equals("RAIN")){
            System.out.println(" rain");
        }
        else{
            System.out.println("None Button");
        }
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
        table = new JTable(40, 20){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);

                // ถ้าช่องนั้นไม่ได้ถูกคลิกเลือก และมีสีใน 2D Array ให้เปลี่ยนสีพื้นหลัง
            if (cellColors[row][column] != null) {
                c.setBackground(cellColors[row][column]);
            }
        
                return c;
            }
        };
        
        table.setRowHeight(40); 
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK); 
        table.setIntercellSpacing(new Dimension(1, 1));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        DustLv = new int[table.getRowCount()][table.getColumnCount()];
        population = new int[table.getRowCount()][table.getColumnCount()];
        healthy = new int[table.getRowCount()][table.getColumnCount()];
        Speople = new int[table.getRowCount()][table.getColumnCount()];
        percentage_Speople = new double [table.getRowCount()][table.getColumnCount()];
        cellColors = new Color[table.getRowCount()][table.getColumnCount()];
        table.addMouseListener(this);
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(true);
        //table.setFocusable(false);
        return table;  
    } 
    public void setTable(){
        int Adr=0;
        for (int r = 0; r < table.getRowCount(); r++) {
            for (int c = 0; c < table.getColumnCount(); c++) {
                table.setValueAt(Adr, r, c); 
                Adr++;
            }
        }
    }
    public String getData(InputBox Input){
        return Input.getDataFromTextField();
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
            selectedFile = fileChooser.getSelectedFile();
            System.out.println();
                String huhu="";
            try{
            Scanner Rening = new Scanner(selectedFile);
                while(Rening.hasNext()){
                    huhu=Rening.next();
                // System.out.println(huhu);
                    NumData.add(Integer.parseInt(huhu));
                }
                Rening.close();
            }
        
            catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("User didn't open");
        }
    }
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                
                if (row != -1 && col != -1) {
                    onCellSelected(row,col,Box_AdrTable);
                    sendDatatoBar(row,col,Box_crete,DustLv);
                    sendDatatoBar(row,col,Box_crete2,population);
                    sendDatatoBar(row,col,Box_crete3,healthy);
                    sendDatatoBar(row,col,Box_crete4,Speople);
                    sendDatatoBar(row,col,Box_crete5,percentage_Speople);
                }
    }
    private void onCellSelected(int row, int col,jpaleBox Box) {
        int cellNumber = (row * 20) + col + 1;
        //System.out.println("User Select::" + cellNumber);
        // System.out.println("Adrss::"+row+" "+col);
        Box.setValue(Integer.toString(cellNumber));

    }
    private void sendDatatoBar(int row,int col,jpaleBox Box,int [][]Data){
        String data = String.format("%d",  Data[row][col]);
        Box.setValue(data);
    }
    //Double
    private void sendDatatoBar(int row,int col,jpaleBox Box,double [][]Data){
        
        String data = String.format("%.2f %%",  Data[row][col]);
        Box.setValue(data);
    }
    public boolean isRigthRandom(){
        if((arr[1]-arr[0])<800){
            stateInput = "The sampling range is less than 800.";
            return false;
        }
        else if(arr[0]<=0){
            stateInput = "Numbers starting with 0 are not allowed.";
            return false;
        }
        else{
            stateInput = "Data transmission is accessible.";
            return true;
        }
    }
    public void setnumInput(String Data){
        String [] DInput = Data.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        int oio=0;
        try{
          for(short i=0;i<DInput.length;i++){
               if(DInput[i].matches("\\d+")){
                    arr[oio] = Integer.parseInt(DInput[i]);
                    oio++;
               }
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
    public void setDustData(){
        int ioi=0;
        for (int r = 0; r < table.getRowCount(); r++) {
            for (int c = 0; c < table.getColumnCount(); c++) {
                table.setValueAt(ioi+1, r, c); 
                DustLv[r][c] = NumData.get(ioi);
                ioi++;
            }
        }
        System.out.println("Data count::"+NumData.size());
    }
    public void setRandomHuman(int min,int max){
        List<Integer> nums = IntStream.rangeClosed(min, max).boxed().collect(Collectors.toList());
        Collections.shuffle(nums);
        Random ranNum = new Random();
        int index=0;
        for (int r = 0; r < population.length; r++) {
            for (int c = 0; c < population[r].length ;c++) {
                population[r][c] = nums.get(index);index++;
            }
        }
    }
    public void setDataBar(){
        for (int r = 0; r < healthy.length; r++) {
            for (int c = 0; c < healthy[r].length ;c++) {
                percentage_Speople[r][c] = getPercent(DustLv[r][c]);
                Speople[r][c] = (int)(population[r][c]* percentage_Speople[r][c])/100;
                healthy[r][c] = population[r][c] - Speople[r][c];
            }
        }
    }
    public double getPercent(int Dust){
        double   minPatients ,maxPatients,Drate,MaxP=0,MinP=0,Datamin=0,DataMax=0;
        if(Dust>=0&&Dust<=50){
            MaxP = 9;MinP=0;Datamin=0;DataMax=9;
        }
        else if(Dust>50&&Dust<=100){
            MaxP = 19;MinP=10;Datamin=51;DataMax=100;
        }
        else if(Dust>100&&Dust<=150){
            MaxP = 29;MinP=20;Datamin=101;DataMax=150;
        }
        else if(Dust>150){
            MaxP = 50;MinP=30;Datamin=151;DataMax=250;
        }
         minPatients = (MinP / 100);
         maxPatients = (MaxP / 100);
         Drate = (Dust-Datamin)/(DataMax-Datamin);
         //System.out.println(Drate);
        return (minPatients + (Drate*(maxPatients-minPatients)))*100;
    }
    public void setColoerTable(){
        for (int r = 0; r < table.getRowCount(); r++) {
            for (int c = 0; c < table.getColumnCount(); c++) {
                if(percentage_Speople[r][c]<=9){cellColors[r][c] = Color.GREEN;}
                else if(percentage_Speople[r][c]<=19){cellColors[r][c] = Color.YELLOW;}
                else if(percentage_Speople[r][c]<=29){cellColors[r][c] = Color.ORANGE;}
                else if(percentage_Speople[r][c]>29){cellColors[r][c] = Color.RED;}
            }
        }
        table.repaint();
    }
    
    
}
