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
            System.out.println("No attacking your fellow Alien comrades. You must remain yourself");
            return alien;
        }
        else if(person instanceof Scientist || person instanceof Soldier){
            person.setName(alien.getName() + " is wearing " + person.getName());
            return person;
        }
        else{
            return alien;
        }
    }
}
