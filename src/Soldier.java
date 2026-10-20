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

    public Soldier(String name, int rankNum, double salary, boolean expendable)
    {
        super(name, rankNum, salary);
        this.expendable = expendable;
    }

    public void promote()
    {
        if (this.rankNum < ranks.length - 1)
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

    //getter methods:
    public String[] getRanksArray(){
        return ranks;
    }

    public String getRank()
    {
        return ranks[this.rankNum];
    }

    public boolean getExpendable()
    {
        return this.expendable;
    }
}
