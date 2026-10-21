package src;
public class Scientist extends Personnel
{
    private String degree;
    //Array keeps track of all the ranks. RankNum stores the corresponding number 
    private static String[] ranks =
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
    }

    public void promote()
    {
        if (this.rankNum < ranks.length - 1)
        {
            rankNum++;
            this.salary += 15000;
        }
    }

    public void demote(){
        if (this.rankNum > 0)
        {
            rankNum--;
            this.salary -= 15000;
        }
    }

    //setters
    public void setRankNum(int num){
        if (this.rankNum > 0 && (this.rankNum < ranks.length - 1 ) ){
            this.rankNum = num;
        }
        else{
            this.rankNum = num%(ranks.length);
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

    public String getDegree()
    {
        return this.degree;
    }
}
