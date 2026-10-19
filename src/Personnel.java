package src;
abstract class Personnel
{
    public static long peopleCount = 0;
    public String name;
    public int rankNum;
    public float HP = 100;
    public double salary;
    public long badgeNum;

    public Personnel(String name, int rankNum, double salary)
    {
        this.name = name;
        this.rankNum = rankNum;
        this.salary = salary;
        this.HP = 100;
        //Badge number keeps track of people who have joined our base and gives us a way to pull up records of people based on a security badge code.
        //It increments for every new Person or Alien who starts working for our base or eveyr new alien who is born.
        peopleCount++;
        this.badgeNum = peopleCount;
        System.out.println ("A new Member has joined our base. Glory to the Lizard People running America's government!");
    }

    public void promote(){ }

    public void demote(){ }

    public void fire()
    {
        System.out.println ("This individual will be \"disposed of\" accordingly");
        //figure out a way to delete a person. Still increment badge numbers as needed.
    }

    //getter methods:
    public String getName()
    {
        return this.name;
    }

    public String getRank()
    {
        return "Some Rank";
    }

    public double getSalary()
    {
        return this.salary;
    }

    public long getBadgeNum()
    {
        return this.badgeNum;
    }


}
