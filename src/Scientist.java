package src;

import java.util.Random;

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
    private final static String[] quips =
    {
        "Hey, I'm doing research ovah here!",
        "My research is of utmost importantance.",
        "Don't mind me, just playing scientist...",
        "This is a troubling development..."
    };

    public Scientist(String name, int rankNum, double salary, String degree) throws ObjectLimitException
    {
        super(name, rankNum, salary);
        this.degree = degree;
        this.setRanks(ranks);
    }

    //getter methods:
    public String getRank()
    {
        return ranks[getRankNum()];
    }
    public String getRank(int higher)  //overloaded
    {
        if ((getRankNum() + higher) > ranks.length)
            return ranks[ranks.length -1];
        else
            return ranks[getRankNum() + higher];
    }

    public String getDegree()
    {
        return this.degree;
    }

    //abstract methods
    @Override
    public void promote()
    {
        if (getRankNum() < ranks.length - 1)
        {
            incrementRankNum();
            addSalary(1500);
        }
        else
        {
            System.out.println("This Scientist has reached the maximum rank!");
        }
    }
    @Override
    public void demote()
    {
        if (getRankNum() > 0)
        {
            decrementRankNum();
            addSalary(-1500);
        }
        else 
        {
            System.out.println("This Scientist is already at the minimum rank!");
            fire();
        }
    }

    //unique methods
    public String speakRandomly() {
        Random random = new Random();
        int index = random.nextInt(quips.length);   //this is exclusive bound
        return quips[index];
    }

    public void calculateFlightPromotions(Airplane airplane) {
        //promote the Scientist based on the number of occupants / 25
        System.out.println("Giving promotion based on the number of passengers: " + airplane.getOccupants().length + " passengers.");
        System.out.println("For every 25 passengers, you've earned a promotion!");

        int promotions = airplane.getOccupants().length / 25;

        System.out.println("\n" + getName() + "'s original salary was: $" + getSalary() + "0");
        for (int i = 0; i < promotions; i++) {
            System.out.println("Promoting from rank " + getRank() + " to rank " + (getRank(1)) + ".");
            promote();
        }
        System.out.println("Your new salary is: $" + getSalary() + "0");        
    }
}
