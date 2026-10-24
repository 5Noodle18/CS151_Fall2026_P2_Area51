package src;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
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
                        nextVehicle = new UFO(random.nextInt(1000),random.nextInt(15),random.nextInt(15));
                        break;
                    default: // case: 2
                        nextVehicle = new Airplane(random.nextInt(500),random.nextInt(50),random.nextInt(200),random.nextInt(100),random.nextInt(50));
                        break;
                }
                vehicleList[i] = nextVehicle;
            }
        });
    }

    @Test
    public void expectedBehavior()
    {
        
    }
}