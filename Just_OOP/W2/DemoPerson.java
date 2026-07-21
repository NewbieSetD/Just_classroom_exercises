class DemoPerson
{
    public static void main(String[]opi){
            //System.out.println("JIK");
            //dome, ken, ploy, may, ann, fon
            Person dome = new Person("dome");
            dome.name = "Dome";
            dome.gender = 'M';
            dome.telno = "080-000-0000";
            Person ploy = new Person("ploy");
            ploy.name = "Ploy";
            ploy.gender = 'F';
            ploy.telno = "085-555-5555";
            Person ken = new Person("Ken", 'M', "081-111-1111");
            Person may = new Person("May", 'F', "082-222-2222");
            Person ann = new Person("Ann", 'F', "083-333-3333");
            Person fon = new Person("Fon", 'F', "084-444-4444");
            // System.out.println(dome.getPhoneNumber(ken));
            // System.out.println(dome.getPhoneNumber(ploy));
            // System.out.println(dome.isHaveFan(ploy));
            dome.setFan(ploy);

            // System.out.println(dome.toString());
            //dome.setFan(ann);
            // System.out.println(dome.getFan(may));
            // System.out.println(dome.getFan(ploy));
            dome.setGig(may);
            dome.setGig(ken);
            dome.setGig(fon);
            //System.out.println(dome.getPersonInfo());
            System.out.println(dome.getGig(ploy));
            System.out.println(dome.getGig(ken));
            dome.removeGig();
            System.out.println(dome.getGig(ken));
            //System.out.println(dome.getPersonInfo());
        }
        
}
