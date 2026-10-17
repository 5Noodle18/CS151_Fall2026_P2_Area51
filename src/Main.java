package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Area 51!");
            System.out.println("Choose your personnel:");
            System.out.println("1. Alien");
            System.out.println("2. Scientist");
            System.out.println("3. Soldier");

            int choice = readChoice(scanner, "Enter 1, 2, or 3: ", 1, 3);
            switch (choice) {
                case 1:
                    runAlienScenario(new Alien("Zorp", 3, 50000, "Zeta Reticuli"));
                    break;
                case 2:
                    runScientistScenario(new Scientist("Dr. Nova", 4, 80000, "Aeronautical Engineering"));
                    break;
                case 3:
                    runSoldierScenario(scanner, new Soldier("Captain Reyes", 5, 60000, false));
                    break;
                default:
                    throw new IllegalStateException("Unexpected personnel selection: " + choice);
            }
        }
    }

    private static void runAlienScenario(Alien alien) {
        /* TODO:
        Code below is template. Comment below should be final outline:
        1. Ask user if they want to use default Alien (1) or set custom parameters (2)
            --> use Alien setters to change values
        2. Print scenario -- {{Alien.getName}} is escaping!! Quick, what UFO will they choose to make their escape! They must escape with an abducted scientist.
        3. Construct some Vehicles and print their stats to the user. They choose which one.
            --> if !UFO, throw custom exception IllegalPilotException
        4. Set UFO's driver as {{Alien}}
        5. Present list of options: stop(), start(), drive(), abduct(), etc....
            --> each method throws custom exception WrongOrderException unless done in THIS order:
            start() --> setIsStealthed(true) --> drive(t)
        6. Every time drive(t) is used, the Alien enters a new area full of Personnel they can abduct
            a) Instantiate new Personnels
            b) abduct() takes Personnel if choice
                --> if !Scientist, the user must unabduct().
        7. Once Scientist abducted, the order for escape is: 
            --> startProtonDrive() --> warpDrive(t) --> they win!
            --> Alien gets promoted based on Scientist's rank
        */

        System.out.println("\nALIEN SCENARIO: Escape Area 51");
        System.out.println(alien.getName() + " must reach orbit in a UFO before security catches up.");

        UFO ufo = new UFO(600, 150, 1000);
        ufo.setDriver(alien);
        ufo.startProtonDrive();

        if (!ufo.start()) {
            System.out.println("The UFO cannot launch without a pilot.");   // TODO: throw custom exception here instead of printing message                                                                        
            return;
        }

        float flightTime = 2;
        float distance = ufo.drive(flightTime);
        ufo.setCurrentAltitude(ufo.getAltitude() + ufo.getAltitudeRate() * flightTime);
        System.out.println("The UFO traveled " + distance + " units and climbed to " + ufo.getAltitude() + " units.");

        if (ufo.getAltitude() >= 2000) {
            System.out.println("Mission complete: " + alien.getName() + " has escaped into orbit!");
        } else {
            System.out.println("Mission failed: the UFO did not reach orbit.");
        }
    }

    private static void runScientistScenario(Scientist scientist) {
        /* TODO:
        Code below is template. Comment below should be final outline:
        1. Ask user if they want to use default Scientist (1) or set custom parameters (2)
            --> use Scientist setters to change values
        2. Print scenario -- {{Scientist.getName}} has to take a research plane from Area 50 to Area 51 (100,000m)! They must succesfully take off and then land.
        3. Construct an Airplane and random assortment of human Personnel. 
        4. Set Airplane's driver as {{Scientist}} and occupants as these random Personnel.
            --> print every time someone boards (this is ideal time to check the MAXIMUM_OBJECTS=100 exception rule)
        5. Present list of options: stop(), start(), drive(), fuelUp(), etc....
            --> each method throws custom exception WrongOrderException unless done in THIS order:
            fuelUp() --> start() --> drive(t)
        6. Every time drive(t) is used, re-print the Airplane's speed, takeOffSpeed, and distance remaining landingSpeed so user knows when to takeOff and land.
            a) speed > takeOffSpeed in order to takeOff
            b) speed < landingSpeed in order to land 
        7. Once user lands the Airplane AND remaining_distance < 0, they win!
            --> Promote the scientist based on # of occupants!
        */

        System.out.println("\nSCIENTIST SCENARIO: Emergency Research Flight");
        System.out.println(scientist.getName() + " must fly the research airplane and land safely.");

        Airplane airplane = new Airplane(240, 50, 150, 80, 40);
        airplane.setDriver(scientist);
        airplane.fuelUp();
        airplane.startEngine();
        System.out.println("Fuel check: " + airplane.checkFuel());

        if (!airplane.start()) {
            System.out.println("The airplane cannot take off without a pilot.");
            return;
        }

        float distance = airplane.drive(4);
        System.out.println("The airplane traveled " + distance + " units and reached " + airplane.getAltitude() + " units altitude.");
        System.out.println("The research sample is delivered. The scientist begins the landing approach.");
        airplane.setCurrentAltitude(10);
        airplane.stop();

        if (airplane.getAltitude() <= 10) {
            System.out.println("Mission complete: the airplane landed safely.");
        } else {
            System.out.println("Mission failed: the airplane could not land safely.");
        }
    }

    private static void runSoldierScenario(Scanner scanner, Soldier soldier) {
        /* TODO:
        Code below is template. Comment below should be final outline:
        1. Ask user if they want to use default Soldier (1) or set custom parameters (2)
            --> use Soldier setters to change values
        2. Print scenario -- There's a containment breach! {{Soldier.getName}} has to blow up the Alien's UFO before they escape!
        3. Construct some Vehicles and print their stats to the user. They choose which one.
            --> if !Tank, throw custom exception IllegalPilotException
            --> if !Tank, !gunner, throw custom exception 
        4. Set Tank's driver as {{Soldier}}
        5. Present list of options: stop(), start(), drive(), fire(), etc....
            --> each method throws custom exception WrongOrderException unless done in THIS order:
            start() --> aim(Vehicle) --> lockOn() --> fire()
        6. Every time the method is chosen, re-print the UFO's altitude and speed. 
            --> If UFO.currentSpeed > Tank.topSpeed, lockOn fails!
            --> If UFO.isStealthed, aim fails!
            Either of these make it impossible for user to win. Game Over! 
            Soldier tries to do order in (5)
            Every other soldier turn, Alien does this in sequence:
                1. starts their UFO
                2. accelerates
                3. abducts random Personnel
                4. starts proton drive
                5. goes stealth and escapes! (Game Over!! - Bad End)
        7. Upon fire(), the UFO and alien is dead (also any Personnel if they abducted someone). They win!
            --> Soldier gets promoted if no human casualties!
        */

        System.out.println("\nSOLDIER SCENARIO: Stop the UFO");
        System.out.println(soldier.getName() + " must intercept the alien's UFO with a tank.");
        System.out.println("1. Intercept now");
        System.out.println("2. Wait for a clearer shot");
        int choice = readChoice(scanner, "Choose 1 or 2: ", 1, 2);

        Alien alien = new Alien("Zorp", 3, 50000, "Zeta Reticuli");
        UFO ufo = new UFO(600, 150, 1000);
        ufo.setDriver(alien);
        ufo.startProtonDrive();
        ufo.start();
        ufo.drive(1);

        if (choice == 2) {
            System.out.println("The UFO gets away while the soldier waits. Mission failed.");
            return;
        }

        Tank tank = new Tank(80, 20, 3, 5);
        tank.setDriver(soldier);
        tank.setTarget(ufo);
        tank.fuelUp();
        tank.startEngine();
        tank.start();
        tank.drive(2);
        tank.setIsLocked(true);
        tank.setIsLoaded(true);

        if (tank.fireAtTarget()) {
            System.out.println("The tank hit the UFO and stopped it. Mission complete: the alien cannot escape!");
        } else {
            System.out.println("The tank could not fire. Mission failed.");
        }
    }

    private static int readChoice(Scanner scanner, String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= minimum && choice <= maximum) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
                // Re-prompt below for non-numeric input.
            }
            System.out.println("Please enter a number from " + minimum + " to " + maximum + ".");
        }
    }
}
