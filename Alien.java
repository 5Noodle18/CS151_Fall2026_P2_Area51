public class Alien extends Personnel{

    String[] ranks = {
        "Egg",
        "Larval Stage",
        "Cocoon Stage",
        "Junior Glipnorp",
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
        "UFO division General"
    };

    public Alien(String name, int rankNum, double salary){
        super(name, rankNum, salary);
    }


    //getter methods:
    public String getName(){
        return this.name;
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
