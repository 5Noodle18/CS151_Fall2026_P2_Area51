public class Soldier extends Personnel{
    
    //Array keeps track of all the ranks. RankNum stores the corresponding number 
    private static String[] ranks = {
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

    public Soldier(String name, int rankNum, double salary){
        super(name, rankNum, salary);
    }

    public void promote(){
        if (this.rankNum >= 0 && this.rankNum < 12 ){
            rankNum++;
        }

        this.salary = this.salary + 15000;
    }

    public void demote(){
        if (this.rankNum > 0 && this.rankNum <= 12 ){
            rankNum--;
        }

        if(this.salary > 15000){
            this.salary = this.salary - 15000;
        }
    }

    public void takeDamage(){

    }

    public void heal(){

    }

    public void fire(){
        System.out.println ("This individual will be \"disposed of\" accordingly");
        //figure out a way to delete a person. Still increment badge numbers as needed.
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

}
