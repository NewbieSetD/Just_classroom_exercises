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
    // ชุด Panel ต่างๆ
    private JPanel TopPanel,DataPanel,DataBar,DataUuser; 
    // ตัวแปรไฟล์
    private File selectedFile;
    // ตัวแปรตาราง
    private JTable table;
        //Dust levels || population(2) || number of healthy(3) || sick people(4) || percentage of sick people(5)
    private jpaleBox Box_crete,Box_crete2,Box_crete3,Box_crete4,Box_crete5,Box_AdrTable;
    // ตัวแปรสำหรับการส่งค่าและการทำงานของผู้ใช้
    private InputBox Input_crete1,Input_crete2,Input_crete3;
    // คลังข้อมูลจากไฟล์
    private ArrayList <Integer> NumData = new ArrayList<>();
    // อาเรย์สำหรับฝน
    private String [] Rain = {"Artificial rain", "natural rain"};
    private int[][]DustLv;//อาเรย์ 2D เก็บข้อมูล ฝุ่น
    private int[][]population;//อาเรย์ 2D เก็บข้อมูล ประชากร
    private int[][]healthy; //อาเรย์ 2D เก็บข้อมูล ประชากรที่สุขภาพดี
    private int[][]Speople; //อาเรย์ 2D เก็บข้อมูล ประชากรที่ป่วย
    private double[][] percentage_Speople; //อาเรย์ 2D เก็บข้อมูล ประชากรที่ป่วยแบบเปอร์เซ็นต์
    private Color[][] cellColors; //อาเรย์ 2D เก็บข้อมูลสีพื้นที่
    private boolean isFlie = false,isGetPel = false; //ตัวแปลการเช็คการทำงาน
    private int arr[] = new int[2];  //อาเรย์ เก็บเลขที่เอาไว้สุ่มประชากร
    private String stateInput; //ตัวแปลส่งข้อมูลสถานะในการทำงานของผู้ใช้
    public int Wginter = 1024,Hginter = 1024;
    private int perLowD; //ตัวแปลเลขที่เอาไว้คำนวณ ของฝนเทียม
    int Tcol = 40,Trow=20;
    gui_pm() {
        //==================================
        // เริ่ม GUI เค้าโครง
        SetUp_gui();
        setLayout(new GridLayout(2, 1));
        JPanel TopPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(setup_Tables());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        TopPanel.add(scrollPane, BorderLayout.CENTER);
        set_up_Number_Table();
        //=======================================
        // เริ่มใส่ menuBar เริ่มเพิ่ม Panel
        JMenuBar menuBar = new JMenuBar();
        JMenu DataPM = new JMenu("Data");
        JMenuItem modeItem = new JMenuItem("Reset All Data");
        modeItem.setActionCommand("RESTE");
        modeItem.addActionListener(this);
        DataPM.add(modeItem);
        menuBar.add(DataPM);
        TopPanel.add(menuBar,BorderLayout.NORTH);
        add(TopPanel);
        //===============================
        // เพิ่ม Panel เฉพาะการทำงานต่างๆ โดยแยก Panel อีกที่เพื่อแบ่งออก
        JPanel DataPanel = new JPanel(new GridLayout(1, 2));
        JPanel DataBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        DataBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JPanel DataUuser = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        DataUuser.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        //================================
        // ชุดการสร้าง com โดยใช้ class jpaleBox ในการอำนวย และเพิ่มเข้าไปที่ Panel
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
        //ปุ่มหลัก สร้างแยกเพราะว่าต้องการให้ปุ่มนี้แยกอออกมาเดียวๆและโดดจากชุดอื่นๆ
        //ปุ่มนี้ทำหน้าที่ import Flie ฝุ่น
        JButton ImporBTN = new JButton("Import Data");
        ImporBTN.setPreferredSize(new Dimension(250, 35));
        ImporBTN.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        ImporBTN.setAlignmentX(Component.LEFT_ALIGNMENT);
        ImporBTN.setActionCommand("IMPORT");
        ImporBTN.addActionListener(this);

        //================================
        //ปุ่มนี้ทำหน้าในการรีเฟดข้อมูลใหม่ กรณีที่ทำอะไรบ้างอย่างแล้วไม่มีการเปลี่ยนแปลง
        JButton DataCal = new JButton("Refresh");
        DataCal.setPreferredSize(new Dimension(250, 35));
        DataCal.setMaximumSize(new Dimension(Short.MAX_VALUE, 10));
        DataCal.setAlignmentX(Component.LEFT_ALIGNMENT);
        DataCal.setActionCommand("REFRESH");
        DataCal.addActionListener(this);

        //================================
        //ชุดสร้าง com สำหรับการทำงานของผู้ใช้ โดยมีกำหนดประชากร และ สุ่มแบบไม่ซ้ำ
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

        //================================
        add(DataPanel);
        
    }
    public static void main(String[] args) {
            new gui_pm().setVisible(true);
        // gui_pm fun = new gui_pm("My");
        // System.out.println(fun.isSamevalue(10));
    }
   // Method สำหรับในการเช็คว่าสามารถคำนวณค่าเลยได้ไหม ป้องกันการคำนวณที่ผิดพลาด เพราะข้อมูลไม่พร้อม 
    public void isCanbecolor(){
        if(isWork()){
                System.out.println("Is Done");
                setDataBar();
                //setTable();
                setColoerTable();
            }
    }
    //Method ในการถามว่า ตัวแปรนี้พร้อมหรือยังเพื่อดำเนินการกับ Method อื่นๆ 
    public boolean isWork(){
        return isFlie&isGetPel;
    }
    // Method นี้เป็นชุดรวม Method ของการทำงานของฝนเทียม
    private void toArtificial(int r,int c){
                    setNumDamgeDust(10);
                    Artificial_Rain(5,r,c);
                    setNumDamgeDust(25);
                    Artificial_Rain(3,r,c);
                    setNumDamgeDust(50);
                    setDustLow(r, c);
                    Calling_Met_Data();
                    table.repaint();
    }
    // Method นี้เป็นชุดรวม ในการคำนวณข้อมูลต่างๆ
    private void Calling_Met_Data(){
                setDataBar();
                //setTable();
                setColoerTable();
                table.repaint();
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
            String Det = Input_crete1.getDataFromTextField();
             int numData;
            int r = table.getSelectedRow();
            int c = table.getSelectedColumn();
            int cellNumber = (r * Tcol) + c + 1;
            String Output = String.format("User On cell %d or on Row:: %d and Col:: %d",cellNumber,r,c);
            System.out.println(Output);
            if(!((r != -1) && (c != -1))){
                stateInput = "The user did not select a grid box.";
                Input_crete1.showTemporaryText(stateInput);
            }       
            else if(isNumic(Det)){
                numData=getDataIntSclect(Det);
                setpopulation(r,c,numData);
                Input_crete1.showTemporaryText(stateInput);
                System.out.println(" Human");
                sendDatatoBar(r,c,Box_crete2,population);
            }
            else{
                stateInput = "Please use only integers.";
                Input_crete1.showTemporaryText(stateInput);
                System.out.println("Not Human");
            }
            Det=null;
            
        }
        else if(e.getActionCommand().equals("RANDOM")){
            System.out.println(" random");
            String Det = Input_crete2.getDataFromTextField();
            setnumInput(Det);
            Arrays.sort(arr);
            if(isRigthRandom()){
                isGetPel=true; 
                setRandomHuman(arr[0],arr[1]);
                isCanbecolor();
                Input_crete2.showTemporaryText(stateInput);
                
            }
            else{Input_crete2.showTemporaryText(stateInput);}
        }
        else if(e.getActionCommand().equals("REFRESH")){
            System.out.println(" REFRESH");
            if(isWork()){
                System.out.println("Is Refresh");
                Calling_Met_Data();
            }
            else{
                System.out.println("None Data");
            }
        }
        else if(e.getActionCommand().equals("RAIN")){
            int r = table.getSelectedRow();
            int c = table.getSelectedColumn();
            int cellNumber = (r * Tcol) + c + 1;
            String Output = String.format("User On cell %d or on Row:: %d and Col:: %d",cellNumber,r,c);
            System.out.println(Output); 
            if(Input_crete3.getJList().getSelectedIndex()==0){
                System.out.println("Artificial rain");
                if(isWork()){
                   toArtificial(r,c);
                }
                else{System.out.println("None Data");}
            }
            else if(Input_crete3.getJList().getSelectedIndex()==1){
                System.out.println("natural rain");
                if(isWork()){
                    Natural_rain();
                    Calling_Met_Data();
                }
                else{System.out.println("None Data");}
            }
            else{System.out.println("User Not Select Any Rain");}
        }
        else if(e.getActionCommand().equals("RESTE")){
            System.out.println("Data Reset");
            if(isWork()){
                ResetDataArr(DustLv);
                ResetDataArr(population);
                ResetDataArr(healthy);
                ResetDataArr(Speople);
                ResetDataArr(cellColors);
                ResetDataArr(percentage_Speople);
                isFlie = !isFlie;isGetPel=!isGetPel;
                NumData.clear();
                table.repaint();
                System.out.println("Data Is Gone");
            }
            
        }
        else{
            System.out.println("None Button");
        }
    }
    // Method เริ่มต้น GUI แทบทุกอย่างเริ่มจากที่นี้
    private void SetUp_gui(){
        setTitle("OOP_ASS1");
        setSize(Wginter, Hginter);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // Method ชุดสร้างตาราง
    private JTable setup_Tables() {
        int numRows = 1;
        table = new JTable(Trow, Tcol ){
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
        
        table.setRowHeight(Tcol); 
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
    // Method ในการแสดงและใส่ลำดับในตาราง
    private void set_up_Number_Table(){
        int Adr=1;
        for (int r = 0; r < table.getRowCount(); r++) {
            for (int c = 0; c < table.getColumnCount(); c++) {
                table.setValueAt(Adr, r, c); 
                Adr++;
            }
        }
    }
    // Method สำหรับการเปิดไฟล์
    private void openFile() {
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

    //============================================
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
    //================================================

    //Method สำหรับในการแสดงตำแหน่งที่ผู้ใช้คลิกอยู่ว่าที่ช่องเท่าไหร่
    private void onCellSelected(int row, int col,jpaleBox Box) {
        int cellNumber = (row * Tcol) + col + 1;
        Box.setValue(Integer.toString(cellNumber));

    }
    // Method ในการส่งข้อมูลขึ้นอินเตอร์เฟคของ int
    private void sendDatatoBar(int row,int col,jpaleBox Box,int [][]Data){
        String data = String.format("%d",  Data[row][col]);
        Box.setValue(data);
    }
    // Method ในการส่งข้อมูลขึ้นอินเตอร์เฟคของ Double
    private void sendDatatoBar(int row,int col,jpaleBox Box,double [][]Data){
        
        String data = String.format("%.2f %%",  Data[row][col]);
        Box.setValue(data);
    }
    // Mehod ในการเช็คว่าตัวข้อความที่ผู้ใช้ Input เข้ามาว่าเป็นตัวเลขไหม
    private boolean isRigthRandom(){
        if(arr[0]<=0||arr[1]<=0){
            stateInput = "Numbers starting with 0 are not allowed.";
            return false;
        }
        else if((arr[1]-arr[0])<800){
            
            stateInput = "The sampling range is less than 800.";
            return false;
        }
        else{
            stateInput = "Data transmission is accessible.";
            return true;
        }
    }
    // Method ในการตัดและแยกข้อความออกและเก็บเฉพาะที่เป็นตัวเลขเท่านั้น
    private void setnumInput(String Data){
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
    // Method สำหรับการส่งค่าข้อมูลระดับฝุ่นในให้ตัวข้อมูลจากคลังข้อมูลที่อ่านไฟล์มาแล้ว
    private void setDustData(){
        int ioi=0;
        for (int r = 0; r < table.getRowCount(); r++) {
            for (int c = 0; c < table.getColumnCount(); c++) {
                DustLv[r][c] = NumData.get(ioi);
                ioi++;
            }
        }
        System.out.println("Data count::"+NumData.size());
    }
    // Method ในการสุ่มประชากร
    private void setRandomHuman(int min,int max){
        // บรรทัดที่ 1: สร้าง List เรียงลำดับ
        List<Integer> nums = IntStream.rangeClosed(min, max).boxed().collect(Collectors.toList());
        /*
        IntStream.rangeClosed(min, max)
        สร้าง Stream ของตัวเลขชนิด int (primitive) เรียงตามลำดับตั้งแต่ min ไปจนถึง max โดยรวมตัวสุดท้ายด้วย
        (ตัวอย่าง: ถ้า min = 1, max = 5 จะได้ลำดับ 1, 2, 3, 4, 5)
        .boxed()
        แปลงชนิดข้อมูลจาก primitive int ให้เป็น Object Integer (Wrapper Class) เนื่องจาก Collection ใน Java รองรับเฉพาะวัตถุ (Object) เท่านั้น */
        // บรรทัดที่ 2: สับเปลี่ยนลำดับแบบสุ่ม
        Collections.shuffle(nums);
        Random ranNum = new Random();
        int index=0;
        for (int r = 0; r < population.length; r++) {
            for (int c = 0; c < population[r].length ;c++) {
                population[r][c] = nums.get(index);index++;
            }
        }
    }
    // Method ในการคำนวณค่าข้อมูลต่างๆ
    private void setDataBar(){
        for (int r = 0; r < healthy.length; r++) {
            for (int c = 0; c < healthy[r].length ;c++) {
                percentage_Speople[r][c] = getPercent(DustLv[r][c]);

                Speople[r][c] = (int)Math.round((population[r][c]* percentage_Speople[r][c])/100);

                healthy[r][c] = population[r][c] - Speople[r][c];
            }
        }
    }
    // Method คำนวณ เปอร์เซ็นต์
    private double getPercent(int Dust){
        double   minPatients ,maxPatients,Drate,MaxP=0,MinP=0,Datamin=0,DataMax=0;
        if(Dust>=0&&Dust<=50){
            MaxP = 9;MinP=0;Datamin=0;DataMax=50;
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
        else{
            return 0;
        }
         minPatients = MinP;
         maxPatients = MaxP;
         Drate = (double)(Dust-Datamin)/(DataMax-Datamin);
         //System.out.println(Drate);
        return (minPatients + (Drate*(maxPatients-minPatients)));
    }
    // Method เอาสีเข้าคลังข้อมูลแล้วค่อยส่งลงตาราง
    private void setColoerTable(){
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
    // Method ดึงค่าตัวอักษณมาเป็นตัวเลข
    private int getDataIntSclect(String Data){
        int num=0;
        try {
            num = Integer.parseInt(Data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            stateInput = e.getMessage();
        }
        return num;
    }
    // Method เช็คว่าเป็นเลขจริงหรือไม่ (กันการส่ง  Exception หาผู้ใช้)
    private boolean isNumic(String Data){
        int num=0;
        try {
            num = Integer.parseInt(Data);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    // Method ส่งการขึ้นเตือนเกี่ยวกับ Input ของผู้ใช้
    private void setpopulation(int row,int col,int data){
        if(data<=0){
            stateInput = "Equal to or less than 0 or Text is not allowed.";
            return;
        }
        population[row][col] = data;
        stateInput = "Data entry completed.";
    }
    // Method ในการคำนวณ ผลกระทบของฝุ่นที่โดนฝนธรรมชาติ
    private void Natural_rain(){
        int Num=0;
        for(int r=0;r<DustLv.length;r++){
            for(int c=0;c<DustLv[r].length;c++){
                Num=DustLv[r][c];
                if(isZero(Num,50)){
                    DustLv[r][c]=DustLv[r][c]-50;
                }
                else{
                    DustLv[r][c]=0;
                }
            }
        }
    }
    // Method ที่เอาไว้คำนวณค่าว่าเป็น 0 หรือไม่ ป้องกันเลขติดลบ
    private boolean isZero(int x,int y){
        if((x-y)>0){
            return true;
        }
        else{
            return false;
        }
    }
    // Method สำหรับการลบค่าและคืนค่าเป็นหมือนเดิม int
    private void ResetDataArr(int[][]num){
        for(int i=0;i<num.length;i++){
            Arrays.fill(num[i], 0);
        }
    }
    // Method สำหรับการลบค่าและคืนค่าเป็นหมือนเดิม double
    private void ResetDataArr(double[][]num){
        for(int i=0;i<num.length;i++){
            Arrays.fill(num[i], 0);
        }
    }
    // Method สำหรับการลบค่าและคืนค่าเป็นหมือนเดิม Color
    private void ResetDataArr(Color[][]num){
        for(int i=0;i<num.length;i++){
            Arrays.fill(num[i], Color.WHITE);
        }
    }
    //  Method ในการคำนวณ ระยะในการส่งผลต่อผลของ ฝนเทียม
    private void Artificial_Rain(int range,int row,int col){
        int offset = (int)range/2;
        int minRow = Math.max(0, row - offset);
        int maxRow = Math.min(Trow - 1, row + offset);
        int minCol = Math.max(0, col - offset);
        int maxCol = Math.min(Tcol - 1, col + offset);
        SetDustForArtificial(maxRow,minRow,maxCol,minCol);

    }
    // Method ในการเปลี่ยนแปลงค่าของฝุ่น
    private void SetDustForArtificial(int Maxrow,int Minrow,int Maxcol,int Mincol){
        for(int r=Minrow;r<=Maxrow;r++){
            for(int c=Mincol;c<=Maxcol;c++){
                if(r==Minrow||c==Mincol||r==Maxrow||c==Maxcol){
                    setDustLow(r,c);
                }
            }
        }
    }
    // Method คำนวณค่าเปอร์เซ็นที่ควรลดและเช็คเพื่อป้องเลขติดลบ
    private void setDustLow(int r,int c){
        int getDelDust=DustLv[r][c]*perLowD/100;
        if((DustLv[r][c]-getDelDust)>0){
            DustLv[r][c]=DustLv[r][c]-getDelDust;
        }
        else{
            DustLv[r][c]=0;
        }
        
        //DustLv[r][c]=DustLv[r][c]-20;
    }
    // Method สำหรับในการเปลี่ยนค่าในการคำนวณเปอร์เซ็นต์
    public void setNumDamgeDust(int x){
        perLowD = x;
    }

}

