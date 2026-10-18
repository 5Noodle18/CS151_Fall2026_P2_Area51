abstract class Personnel {
    public static long peopleCount = 0;
    public String name;
    public int rankNum;
    public double salary;
    public long badgeNum;

    public Personnel(String name, int rankNum, double salary){
        this.name = name;
        this.rankNum = rankNum;
        this.salary = salary;
        //Badge number keeps track of people who have joined our base and gives us a way to pull up records of people based on a security badge code.
        //It increments for every new Person or Alien who starts working for our base or eveyr new alien who is born.
        peopleCount++;
        this.badgeNum = peopleCount;
        System.out.println ("A new Member has joined our base. Glory to the Lizard People running America's government!");
    }

    public void promote(){ }

    public void demote(){ }

<<<<<<< Updated upstream:Personnel.java
    public void takeDamage(){ }

    public void heal(){ }
=======
>>>>>>> Stashed changes:src/Personnel.java

    public void fire(){
        System.out.println ("This individual will be \"disposed of\" accordingly");
    }

    //getter methods:
    public String getName(){
        return this.name;
    }

    public String getRank(){
        return "Some Rank";
    }

    public double getSalary(){
        return this.salary;
    }

<<<<<<< Updated upstream:Personnel.java
    public float getHP(){
        return this.HP;
    }
=======
>>>>>>> Stashed changes:src/Personnel.java

    public long getBadgeNum(){
        return this.badgeNum;
    }


}
