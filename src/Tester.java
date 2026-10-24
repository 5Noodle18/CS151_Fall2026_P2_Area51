package src;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

public class Tester {
    @Test
    public void hundredPersonnelTest()
    {
        Personnel[] personnelList = new Personnel[101];
        Random random = new Random();

        // fill the array with 100 Personnel from 0 to 100
        assertThrows(ObjectLimitException.class, () ->
        {
            Personnel nextPersonnel;
            for (int i = 0; i <= 101; i++)
            {
                switch (random.nextInt(3))
                {
                    case 0:
                        nextPersonnel = new Soldier("Soldier " + (i), random.nextInt(13), 50000 + random.nextInt(50000), random.nextBoolean());
                        break;
                    case 1:
                        nextPersonnel = new Scientist("Scientist " + (i), random.nextInt(11), 60000 + random.nextInt(50000), "Degree " + (i + 1));
                        break;
                    default: // case: 2
                        nextPersonnel = new Alien("Alien " + (i), random.nextInt(12), 30000 + random.nextInt(50000), "Planet " + (i + 1));
                        break;
                }   
                personnelList[i] = nextPersonnel;
            }
        });
    }

    @Test
    public void hundredVehicleTest()
    {
        Vehicle[] vehicleList = new Vehicle[101];
        Random random = new Random();

        // fill the array with 100 Personnel from 0 to 100
        assertThrows(ObjectLimitException.class, () ->
        {
            Vehicle nextVehicle;
            for (int i = 0; i <= 101; i++)
            {
                switch (random.nextInt(3))
                {
                    case 0:
                        nextVehicle = new Tank(random.nextInt(100),random.nextInt(10),random.nextInt(5),random.nextFloat(30));
                        break;
                    case 1:
                        nextVehicle = new UFO(random.nextFloat(1000),random.nextFloat(15),random.nextFloat(15));
                        break;
                    default: // case: 2
                        nextVehicle = new Airplane(random.nextFloat(500),random.nextFloat(50),random.nextFloat(200),random.nextFloat(100),random.nextFloat(50));
                        break;
                }
                vehicleList[i] = nextVehicle;
            }
        });
    }

    @Test
    public void duplicatePersonnelTest()
    {
        assertThrows(IllegalArgumentException.class, () ->
            {
                Alien alien1 = new Alien("Gleebop", 10, 60000, "Forbulon-3");
                Alien alien2 = new Alien("Gleebop", 10, 60000, "Forbulon-3");
            });
    }

    @Test
    public void duplicateVehicleTest()
    {
        assertThrows(IllegalArgumentException.class, () ->
            {
                UFO ufo1 = new UFO(1000, 100, 100);
                UFO ufo2 = new UFO(1000, 100, 100);
            });
    }

    @Test
    public void expectedBehaviorTest()
    {
        Alien alien;
        Scientist scientist;
        Soldier soldier;
        UFO ufo;
        Airplane airplane;
        Tank tank;
        try
        {
            alien = new Alien("Glippo Snarblebarp", 2, 60000, "Strongulon 6");
            scientist = new Scientist("Brian Sage", 10, 100000, "Advanced Xenogastronomy");
            soldier = new Soldier("Chet Gunn", 7, 80000, true);
            ufo = new UFO(2000, 100,100);
            airplane = new Airplane(1000, 50, 100, 100, 25);
            tank = new Tank(100,10,5,30);
        }
        catch (ObjectLimitException e)
        {
            return;
        }

        assertEquals(alien.getName(), "Glippo Snarblebarp");
        assertEquals(alien.getRank(), "Glob Glob Assistant");
        alien.promote();
        assertEquals(alien.getSalary(), 75000,1);
        assertEquals(alien.getRank(), "Glob Glob");

        assertEquals(ufo.getTopSpeed(), 2000,1);
        assertEquals(ufo.getAcceleration(), 100,1);
        ufo.abduct(scientist);
        assertEquals(ufo.getHoldingBay(), scientist);
        assertEquals(ufo.drive(1), 100,1);
        assertEquals(ufo.getCurrentSpeed(), 100,1);
    }

    @Test
    public void illegalPilotTest()
    {
        Alien alien;
        Tank tank;
        try
        {
            alien = new Alien("Glippo Snarblebarp", 2, 60000, "Strongulon 6");
            tank = new Tank(100,10,5,30);
        }
        catch (ObjectLimitException e)
        {
            return;
        }

        assertThrows(IllegalPilotException.class, () ->
        {
            tank.setDriver(alien);
            tank.drive();
        });
    }

    @Test
    public void polymorphismTest()
    {
        Personnel[] personnelArray = new Personnel[3];
        Vehicle[] vehicleArray = new Vehicle[3];

        try
        {
            personnelArray[0] = new Alien("Glippo Snarblebarp", 2, 60000, "Strongulon 6");
            personnelArray[1] = new Scientist("Brian Sage", 10, 100000, "Advanced Xenogastronomy");
            personnelArray[2] = new Soldier("Chet Gunn", 7, 80000, true);
            vehicleArray[0] = new UFO(2000, 100,100);
            vehicleArray[1] = new Airplane(1000, 50, 100, 100, 25);
            vehicleArray[2] = new Tank(100,10,5,30);
        }
        catch (ObjectLimitException e) {}

        try
        {
            for(int i = 0; i < personnelArray.length; i++)
            {
                personnelArray[i].promote();
                personnelArray[i].demote();

                vehicleArray[i].setDriver(personnelArray[i]);
                try
                {
                    vehicleArray[i].drive();
                }
                catch (IllegalPilotException e) {}
                vehicleArray[i].getDriver();
            }
        }
        catch (ClassCastException e) {}

        
    }
}