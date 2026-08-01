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
        System.out.println(brooklyn.name);
        System.out.println(harper.name);

        // ข้อ 4.3
        System.out.println("#4.3#");
        System.out.println(brooklyn);
        System.out.println(harper);

        // ข้อ 5.2
        System.out.println("#5.2#");
        System.out.println(brooklyn.getFather());
        System.out.println(brooklyn.getMother());

        // ข้อ 6
        System.out.println("#6#");
        System.out.println(beckham.getWorkplace());
        System.out.println(brooklyn.getWorkplace());

        // ข้อ 7
        System.out.println("#7#");
        harper.equals(victoria);
        harper.equals(beckham);

        // ข้อ 8.2
        System.out.println("#8.2#");
        System.out.println(brooklyn.respectTo(beckham));
        System.out.println(brooklyn.respectTo(victoria));
        System.out.println(harper.respectTo(victoria));
        System.out.println(harper.respectTo(beckham));
    }

}