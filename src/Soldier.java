package src;
public class Soldier extends Personnel
{
    private boolean expendable; // a soldier
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

    @Override
    public void promote()
    {
        if (getRankNum() < ranks.length - 1)
        {
            incrementRankNum();
            addSalary(15000);
        }
    }

    @Override
    public void demote()
    {
        if (this.getRankNum() > 0)
        {
            decrementRankNum();
            addSalary(-15000);
        }
    }

    /**
     * The moment that determines if this soldier dies gloriosly or survives
     * @param threat String. The thing that threatens the soldier.
     * They perished because of... OR were triumpant despite...
     * @return a string containing the fate of the soldier
     */
    public String momentOfTruth(String threat)
    {
        String message = this.getRank() + " " + this.getName();
        if (expendable)
        {
            message += " perished heroicly because of ";
        }
        else
        {
            message += " survived despite "; 
        }
        message += threat + "\n";
        return message;
    }

    /**
     * the soldier remembers their training and operates the tank
     * @param tank Tank. The tank that the soldier should occupy
     * @return a string showing what the soldier did
     */
    public String rememberTraining(Tank tank)
    {
        String message = this.getRank() + " " + this.getName();
        if (tank.getDriver() == null) // if no one is in the tank, get in and start it
        {
            message += " runs to the tank, gets in, and starts it.\n";
            tank.setDriver(this);
            tank.startEngine();
            tank.setShellCount(3);
        }
        else if (tank.getDriver().equals(this)) // if this soldier is in the tank, operate it
        {
            message += " goes to load a shell into the tank.\n";
            tank.setIsLocked(true);
            tank.loadShell();
            tank.setShellCount(tank.getShellCount() - 1);
        }

        return message;
        
    }

    /**
     * @param other Personnel. The victim of the violence
     * @param action String. The violence being done as a verb. ex: punches
     * @return a string depicting the violence this soldier does. ex: bob punches greg
     */
    public String doViolence(Personnel other, String action)
    {
        String message = "";
        message += "\n" + this.getRank() + " " + this.getName();
        message += " " +action + " ";
        message += other.getRank() + " " + other.getName();
        return message;
    }

    // setter methods
    public void setExpendable(boolean val)
    {
        this.expendable = val;
    }

    // getter methods:
    public String getRank()
    {
        return ranks[getRankNum()];
    }
    public boolean getExpendable()
    {
        return this.expendable;
    }
}
