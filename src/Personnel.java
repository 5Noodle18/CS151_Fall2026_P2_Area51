package src;

import java.util.Set;
import java.util.HashSet;

abstract class Personnel
{
    private static Set<Personnel> registry = new HashSet<>(); //used to prevent duplicates and enforce maximum number of instances
    private String name;
    private int rankNum;
    private String[] ranks;
    private double salary;
    
    public Personnel(String name, int rankNum, double salary) throws ObjectLimitException
    {
        // object limit check
        if (registry.size() > ObjectLimitException.MAX_INSTANCES) {
            throw new ObjectLimitException("Maximum number of Personnel instances reached: " + ObjectLimitException.MAX_INSTANCES);
        }
        this.name = name;
        this.rankNum = rankNum;
        this.salary = salary;
        // duplicate check, must happen after this... is set
        if (registry.contains(this)) {
            throw new IllegalArgumentException("Duplicate Personnel instance detected: " + name);
        }
        else {
            registry.add(this);
        }
    }

    public void promote(){ }

    public void demote(){ }

    public void fire()
    {
        System.out.println ("The person: " + name + ", will be \"disposed of\" accordingly");
        //figure out a way to delete a person. Still increment badge numbers as needed.
    }

    //setter methods:
    public void setName(String nombre){
        this.name = nombre;
    }
    public void setSalary(double s){
        this.salary = s;
    }
    public void setRankNum(int n){
        if (n >= ranks.length) {    // cap to max
            this.rankNum = ranks.length - 1;
        } else if (n < 0) {
            this.rankNum = 0; // cap to min
        } else {
            this.rankNum = n;
        }
    }
    public void setRanks(String[] r){
        this.ranks = r;
    }
    public void addSalary(double s){
        this.salary += s;
    }

    //getter methods:
    public String getName()
    {
        return this.name;
    }
    public String[] getRanksArray(){
        return this.ranks;
    }
    public String getRank()
    {
        return "Some Rank";
    }
    public double getSalary()
    {
        return this.salary;
    }
    public static int getPeopleCount() 
    {
        return registry.size();
    }
    public int getRankNum()
    {
        return this.rankNum;
    }
    public int incrementRankNum()
    {
        return ++this.rankNum;
    }
    public int decrementRankNum()
    {
        return --this.rankNum;
    }

    //putting character creator into personnel helps keep it clean when running the scenarios in main.
    public static Personnel characterCreator(Personnel person, ScannerWrapper scannerWrapper) throws ObjectLimitException {
        String role = person.getClass().getSimpleName();
        System.out.println(role + " Scenario Selected");
        System.out.println();
        System.out.println("Are you a default " + role + " (Enter: 1)... or a custom " + role + " (Enter: 2)?");

        int choice2 = scannerWrapper.readChoice("",1,2);

        String theName = "";
        int theRank = -676767;
        String extraField = "";
        Boolean expendable = false;

        if(choice2 == 1){
            return person;         
        } 
        else {

        System.out.print("Please enter the "+ role + "'s Name (Be Creative Please): ");
        while (theName.isEmpty()) {

            //I changed this code block to use a try catch block
            try{
                theName = scannerWrapper.readString().trim();
                if(theName.length() == 0){
                    throw new Exception();
                }
                break;
            }
            catch(Exception e){
                System.out.println ("TRY AGAIN! Enter Name Here:");
            }
        }

            int maxNum = person.getRanksArray().length-1;

            theRank = scannerWrapper.readChoice("Please enter the " + role + "'s Rank Number (0-"+ maxNum +"): ", 0, maxNum);
            
            //pick extra field for person and alien because those extra fields are strings
            
            if(!(person instanceof Soldier)){
                while (extraField.isEmpty())
                {
                    System.out.print("Please enter the " + role + "'s ");
                    if( person instanceof Alien ){
                        System.out.println ("Home Planet:");              
                    } else{
                        System.out.println ("Degree:");
                    }
                extraField = scannerWrapper.readString().trim();
    
                    if (extraField.isEmpty()) {
                        System.out.println("TRY AGAIN!");
                    }
                }
            } 
            // soldier is a separate scenario because it is a boolean instead
            else {
                int choosing = scannerWrapper.readChoice("Is your soldier expendable? Yes (1) or no (2): ", 1, 2);
                expendable = false;
                if(choosing == 1){
                    expendable = true;
                }
    
            }
            if (person instanceof Alien){
                return new Alien(theName, theRank, 50000, extraField);
            }
            else if(person instanceof Scientist){
                return new Scientist(theName, theRank, 80000, extraField);
            }
            else{
                return new Soldier(theName, theRank, 60000, expendable);
            }
        
    }
    }

    //Prints out a stub that shows the stats of the character you just created
    public static void generateStub(Personnel person){
        String role = person.getClass().getSimpleName().toUpperCase();

        StringBuilder str = new StringBuilder("==============================================================\n");
        str.append("[" + role + " STATS:]\n");
        str.append("    NAME: " + person.getName() + ", RANK: " + person.getRank() + "\n");
        str.append("    SALARY: $" + person.getSalary() + "0, ");

            if (person instanceof Alien){
                Alien a = (Alien) person;
                str.append("HOME PLANET: "+ a.getHomePlanet() +"\n");
            } else if(person instanceof Scientist){
                Scientist b = (Scientist) person;
                str.append("DEGREE TYPE: " + b.getDegree() + "\n");
            } else{
                Soldier c = (Soldier) person;
                str.append("EXPENDABLENESS: " + c.getExpendable() +  "\n");
            }
        str.append("==============================================================");

        System.out.println (str.toString());
    }


}
