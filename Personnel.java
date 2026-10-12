abstract class Personnel {
    public static long peopleCount = 0;
    public String name;
    public String rank;
    public float HP = 100;
    public double salary;
    public long badgeNum;

    public Personnel(String name, String rank, double salary){
        this.name = name;
        this.rank = rank;
        this.salary = salary;
        this.HP = 100;
        peopleCount++;
        this.badgeNum = peopleCount;
        System.out.println ("A new Member has joined our base. Glory to the Lizard People running America's government!");
    }

    public void promote(){

    }

    public void demote(){

    }

    public void takeDamage(){

    }

    public void heal(){

    }

}
