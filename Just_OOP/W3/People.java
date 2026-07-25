class People{
    public String name;
    public char gender=' ';
    private String workplace;
    People(String name, char gender){
        this.name=name;
        this.gender=gender; 
    }
    People(String name, char gender, String workplace){
        this(name,gender);
        this.workplace=workplace;
    }
    @Override
    public String toString(){
        String Body="";
        if(gender=='M'){
            Body="(Male)";

        }
        else{
            Body="(Female)";
        }
        return "People [name="+name+", gender="+Body+"";
    }
    public String getWorkplace(){
        return workplace;
    }
}