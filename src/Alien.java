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
        "UFO division General"          //rankNum 14
    };

    public Alien(String name, int rankNum, double salary, String homePlanet) throws ObjectLimitException
    {
        super(name, rankNum, salary);
        this.homePlanet = homePlanet;
        this.setRanks(ranks);
    }

    public void promote()
    {
        if (this.rankNum > 0 && (this.rankNum < ranks.length - 1 ) )
        {
            rankNum++;
            this.salary += 15000;
        }
    }

    public void demote()
    {
        if (this.rankNum > 0)
        {
            rankNum--;
            this.salary -= 15000;
        }
    }
    
    //setters
    public void setHomePlanet(String p){
        this.homePlanet = p;
    }

    public void setRankNum(int num){
        if (this.rankNum > 0 && (this.rankNum < ranks.length - 1 ) ){
            this.rankNum = num;
        }
    }

    //getter methods:

    public String getRank()
    {
        return ranks[this.rankNum];
    }

    public String getHomePlanet()
    {
        return this.homePlanet;
    }
    
}
