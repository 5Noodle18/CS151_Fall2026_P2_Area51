package src;
public class Alien extends Personnel
{
    private String homePlanet;
    //Array keeps track of all the ranks. RankNum stores the corresponding number 
    private static String[] ranks = 
    {   "Junior Glipnorp",
        "Glipnorp",
        "Glob Glob Assistant",
        "Glob Glob",
        "Assistant Probing Technician",
        "Probing Technician",
        "Abduction Manager",
        "Snazwazzler",
        "UFO division Captain",
        "UFO division Commander",
        "UFO division Colonel",
        "UFO division General"          //rankNum 11
    };

    public Alien(String name, int rankNum, double salary, String homePlanet) throws ObjectLimitException
    {
        super(name, rankNum, salary);
        this.homePlanet = homePlanet;
        this.setRanks(ranks);
    }

    public void promote()
    {
        if (getRankNum() > 0 && (getRankNum() < ranks.length - 1 ) )
        {
            incrementRankNum();
            addSalary(15000);
        }
    }

    public void demote()
    {
        if (getRankNum() > 0)
        {
            decrementRankNum();
            addSalary(-15000);
        }
    }
    
    //setters
    public void setHomePlanet(String p){
        this.homePlanet = p;
    }

    //getter methods:

    public String getRank()
    {
        return ranks[getRankNum()];
    }

    public String getHomePlanet()
    {
        return this.homePlanet;
    }
    
    public static Personnel wearSkinSuit(Alien alien, Personnel person){
        if (person instanceof Alien){
            System.out.println("No attacking your fellow Alien comrades!");
            return alien;
        }
        else if(person instanceof Scientist || person instanceof Soldier){
            person.setName(alien.getName() + ", who is wearing " + person.getName() );
            return person;
        }
        else{
            return alien;
        }
    }

    public static void sabotageAndDisplay(Vehicle vehicle){
        vehicle.destroy();
        vehicle.setAcceleration(0);
        vehicle.setTopSpeed(0);
        System.out.println("Vehicle Capabilities Nullified");

        String role = vehicle.getClass().getSimpleName();
        System.out.println("\n[" + role + " Stats:]");

        if(vehicle instanceof Airplane){
            Airplane v = (Airplane) vehicle;

            v.setTakeOffSpeed(10000);
            v.setLandingSpeed(10000);

            System.out.println("    Takeoff Speed: " + v.getTakeOffSpeed() + " units, Landing Speed: " + v.getLandingSpeed() + " units");
            
        } else if(vehicle instanceof Tank){
            Tank v = (Tank) vehicle;

            v.setShellCount(0);
            v.setAimSpeed(0);
            v.setIsLoaded(false);

            System.out.println("    Shell Count: " + v.getShellCount() + " shells, Aim Speed: " + v.getAimSpeed());
            System.out.println("    Cannon Loaded: " + v.isLoaded());

        }else{
            UFO v = (UFO) vehicle;
            v.setAltitudeRate(0);
            System.out.println("    Altitude Rate: " + v.getAltitudeRate());
        }
        System.out.println("    Top Speed: " + vehicle.getTopSpeed() + " units, Acceleration: " + vehicle.getAcceleration() + " units/sec^2");
        System.out.println("    Current Speed: " + vehicle.getCurrentSpeed() + " units\n");
    }

    public void comsumeUpgrade(Personnel person){
        if(person.getRankNum() > this.getRankNum()){
            this.promote();
            System.out.println(this.getName() + " absorbs the person's DNA and levels up:");
        }
    }
    
}
