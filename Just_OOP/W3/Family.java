class Family{
    public static void main(String[] args) {
        People beckham  = new People
        ("Beckham",  'M', "Manchester United");
        People victoria = new People
        ("Victoria", 'F', "Spice Girls");
        Children brooklyn = new Children
        ("Brooklyn", 'M',beckham, victoria,"Beckham Academy");
        Children harper   = new Children
        ("Harper", 'F',beckham, victoria,"Harper's School");
        System.out.println(brooklyn.getFather()); 
        System.out.println(harper.getMother());
    }

}