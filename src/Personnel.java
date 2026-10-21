package src;

import java.util.Scanner;

abstract class Personnel
{
    public static long peopleCount = 0;
    public String name;
    public int rankNum;
    public float HP = 100;
    public double salary;
    public long badgeNum;

    public Personnel(String name, int rankNum, double salary)
    {
        this.name = name;
        this.rankNum = rankNum;
        this.salary = salary;
        this.HP = 100;
        //Badge number keeps track of people who have joined our base and gives us a way to pull up records of people based on a security badge code.
        //It increments for every new Person or Alien who starts working for our base or eveyr new alien who is born.
        peopleCount++;
        this.badgeNum = peopleCount;
    }

    public void promote(){ }

    public void demote(){ }

    public void fire()
    {
        System.out.println ("This individual will be \"disposed of\" accordingly");
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
        this.rankNum = n;
    }

    //getter methods:
    public String getName()
    {
        return this.name;
    }

    public String[] getRanksArray(){
        String[] stuff  = {
            "rank1",
            "rank2"
        };
        return stuff;
    }

    public String getRank()
    {
        return "Some Rank";
    }

    public double getSalary()
    {
        return this.salary;
    }

    public long getBadgeNum()
    {
        return this.badgeNum;
    }

    //putting character creator into personnel helps keep it clean when running the scenarios in main.
    public static Personnel characterCreator(Personnel person, Scanner scanner){
        String role = person.getClass().getSimpleName();
        System.out.println(role + " Scenario Selected");
        System.out.println();
        System.out.println("Are you a default " + role + " (Enter: 1)... or a custom " + role + " (Enter: 2)?");

        int choice2 = 676767;
            while (choice2 < 1 || choice2> 2){
            System.out.print("Please enter an integer from 1 to 2: ");
            
            if (scanner.hasNextInt()) {
                choice2 = scanner.nextInt();
                
                if (choice2 < 1 || choice2 > 2) {
                    System.out.println("TRY AGAIN!");
                } 
            } else {
                System.out.println("TRY AGAIN!");
                scanner.next();
            }
        }

        String theName = "";
        int theRank = -676767;
        String extraField = "";
        Boolean expendable = false;

        if(choice2 == 1){
            if (person instanceof Alien){
                return (Alien) person;
            }
            else if(person instanceof Scientist){
                return (Scientist) person;
            }
            else{
                return (Soldier) person;
            }            
        } 
        else {
        scanner.nextLine();

        System.out.print("Please enter the "+ role + "'s Name (Be Creative Please): ");
        while (scanner.hasNextLine()) {
            theName = scanner.nextLine().trim();

            if (!theName.isEmpty()) { 
                break;
            }
            System.out.print("Name cannot be empty. Please enter a valid name: ");
        }

            int maxNum = person.getRanksArray().length-1;
            
                while (theRank < 0 || theRank > maxNum){
                System.out.print("Please enter the " + role + "'s Rank Number (0-"+ maxNum +"):");
                    if (scanner.hasNextInt()) {
                        theRank = scanner.nextInt();

                        if (theRank < 1 || theRank > person.getRanksArray().length) {
                            System.out.println("TRY AGAIN!");
                        } 
                    } else {
                        System.out.println("TRY AGAIN!");
                        scanner.next();
                    }
                }
            scanner.nextLine();
            
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
                extraField = scanner.nextLine().trim();
    
                    if (extraField.isEmpty()) {
                        System.out.println("TRY AGAIN!");
                    }
                }
            } 
            // soldier is a separate scenario because it is a boolean instead
            else {
                int choosing = -676767;
                while (choosing < 1 || choosing> 2)
                {
                    System.out.print("Is your Soldier Expendable? Yes (Enter 1) or No (Enter 2)?");
            
                    if (scanner.hasNextInt()) {
                    choosing = scanner.nextInt();
                
                        if (choosing < 1 || choosing > 2) {
                            System.out.println("TRY AGAIN!");
                        } 
                    } else {
                        System.out.println("TRY AGAIN!");
                        scanner.next();
                    }
                }

                if(choosing == 1){
                    expendable = false;
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


}
