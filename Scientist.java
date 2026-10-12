
public class Scientist extends Personnel {
    private String degree;
    private static String[] ranks = {
        "College Intern",
        "Laboratory Assistant",
        "Research Technician",
        "Junior Scientist",
        "Research Scientist",
        "Senior Scientist",
        "Principal Scientist",
        "Project Director",
        "Chief Scientist",
        "Director of Research",
        "Head of Illuminati Science Division"
    };

    public Scientist(String name, int rankNum, double salary, String degree){
        super(name, rankNum, salary);
        this.degree = degree;
    }

    public void promote(){
        if (this.rankNum >= 0 && this.rankNum < 10){
            rankNum++;
        }

        this.salary = this.salary + 15000;
    }

    public void demote(){
        if (this.rankNum > 0 && this.rankNum <= 10){
            rankNum--;
        }

        if(this.salary > 15000){
            this.salary = this.salary - 15000;
        }
    }



    //getter methods:
    public String getName(){
        return super.getName();
    }

    public String getRank(){
        return ranks[this.rankNum];
    }

    public double getSalary(){
        return super.getSalary();
    }

    public float getHP(){
        return super.getHP();
    }

    public long getBadgeNum(){
        return super.getBadgeNum();
    }

    public String getDegree(){
        return this.degree;
    }
}
