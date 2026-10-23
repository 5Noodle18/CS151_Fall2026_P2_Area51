package src;
public class Soldier extends Personnel
{
    private boolean expendable;
    //Array keeps track of all the ranks. RankNum stores the corresponding number 
    private static String[] ranks =
    {
        "Airman Basic",             //rankNum = 0
        "Airman",                   //rankNum = 1
        "Senior Airman",            //rankNum = 2
        "Staff Sergeant",           //rankNum = 3
        "Technical Sergeant",       //rankNum = 4
        "Master Sergeant",          //rankNum = 5
        "Chief Master Sergeant",    //rankNum = 6
        "Second Lieutenant",        //rankNum = 7
        "First Lieutenant",         //rankNum = 8
        "Captain",                  //rankNum = 9
        "Major",                    //rankNum = 10
        "Colonel",                  //rankNum = 11
        "General"                   //rankNum = 12
    };

    public Soldier(String name, int rankNum, double salary, boolean expendable) throws ObjectLimitException
    {
        super(name, rankNum, salary);
        this.expendable = expendable;
        this.setRanks(ranks);
    }

    public void promote()
    {
        if (getRankNum() < ranks.length - 1)
        {
            incrementRankNum();
            addSalary(15000);
        }
    }

    public void demote()
    {
        if (this.getRankNum() > 0)
        {
            decrementRankNum();
            addSalary(-15000);
        }
    }
    
    public void setExpendable(boolean val){
        this.expendable = val;
    }

    //getter methods:

    public String getRank()
    {
        return ranks[getRankNum()];
    }

    public boolean getExpendable()
    {
        return this.expendable;
    }
}
