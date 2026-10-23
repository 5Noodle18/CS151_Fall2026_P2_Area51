package src;
public class Scientist extends Personnel
{
    private String degree;
    //Array keeps track of all the ranks. RankNum stores the corresponding number 
    private final static String[] ranks =
    {
        "College Intern",                       //rankNum 0
        "Laboratory Assistant",
        "Research Technician",
        "Junior Scientist",
        "Research Scientist",
        "Senior Scientist",
        "Principal Scientist",
        "Project Director",
        "Chief Scientist",
        "Director of Research",
        "Head of Illuminati Science Division"   //rankNum 10
    };

    public Scientist(String name, int rankNum, double salary, String degree) throws ObjectLimitException
    {
        super(name, rankNum, salary);
        this.degree = degree;
        this.setRanks(ranks);
    }

    public void promote()
    {
        if (getRankNum() < ranks.length - 1)
        {
            incrementRankNum();
            addSalary(15000);
        }
        else
        {
            System.out.println("This Scientist has reached the maximum rank!");
        }
    }

    public void demote(){
        if (getRankNum() > 0)
        {
            decrementRankNum();
            addSalary(-15000);
        }
    }

    //getter methods:
    public String getRank()
    {
        return ranks[getRankNum()];
    }

    public String getDegree()
    {
        return this.degree;
    }
}
