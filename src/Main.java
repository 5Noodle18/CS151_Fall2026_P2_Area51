package src;

import java.util.*;

public class Main {

//keep the scanner like this so all the methods can use it too:
private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException{
        //cool starting screen text with a fake loading screen
        Thread.sleep(190);
        System.out.println("              Accessing Illuminati Database: Verifying top security clearance...\n");
        
        Thread.sleep(100);
        for (int i = 10; i<100; i+=10){
            System.out.print("              " + i + " percent complete");
            Thread.sleep(50);
            System.out.print(".");
            Thread.sleep(50);
            System.out.print(".");
            Thread.sleep(50);
            System.out.println(".");
            Thread.sleep(50);            
        }

        System.out.println("================================================================================\n");
        System.out.println("              CLASSIFIED U.S. GOVERNMENT SOFTWARE");
        System.out.println("              UNAUTHORIZED ACCESS CAN RESULT IN IMPRISONMENT OR DEATH\n");
        System.out.println("              FACILITY: ███████████████████████████");
        System.out.println("              LOCATION: GROOM LAKE, NEVADA");
        System.out.println("              DESIGNATION: AL██N RESEARCH FACILITY");
        System.out.println("              SECTOR:   51");
        System.out.println("              STATUS:   [ ACTIVE ]\n");
        System.out.println("              BIOLOGICAL CONTAINMENT.............. NOMINAL");
        System.out.println("              SECURITY SYSTEMS.................... ONLINE");
        System.out.println("              SURVEILLANCE NETWORK................ ONLINE");
        System.out.println("              SPECIMEN CONTAINMENT................ ███████");
        System.out.println("              PROJECT █████████................... CLASSIFIED\n");
        System.out.println("              PRESS ENTER TO CONTINUE:\n");
        System.out.println("================================================================================\n");
        scanner.nextLine();

        System.out.println("Choose your personnel:");
        System.out.println("(1). Alien");
        System.out.println("(2). Scientist");
        System.out.println("(3). Soldier");
        
        int choice = -6767;
        //verify the input is between 1 and 3 in a polite, professional way befitting Area 51.
        while (choice < 1 || choice > 3){
            System.out.print("Please enter an integer from 1 to 3: ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                
                if (choice < 1 || choice > 3) {
                    System.out.println("IF THE CHOICE IS NOT FROM 1:3, YOU WILL BE NEUTRALIZED. TRY AGAIN!");
                } 
            } else {
                System.out.println("ENTER AN INTEGER OR YOU WILL BE EXCECUTED IMMEDIATELY!");
                System.out.println();
                scanner.next();
            }
        }

        //this decides which one of 3 scenarios to play out:
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


    private static void runAlienScenario(Alien alien) throws InterruptedException {
        /* TODO:
        Code below is template. Comment below should be final outline:
        1. DONE
        2. DONE
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

        //refer to last method in personnel if you want to change character creator method:
        alien = (Alien) Personnel.characterCreator(alien, scanner);
        
        //TODO: add something like this after each character creator section for each scenario.
        System.out.println("\n==========================================================");
        System.out.println("[ALIEN STATS:]");
        System.out.println("    NAME: " + alien.getName() + ", RANK: " + alien.getRank());
        System.out.println("    SALARY: $" + alien.getSalary() + "0, PLANET OF ORIGIN: " + alien.getHomePlanet());
        System.out.println("==========================================================\n\n");
        
        //Alien needs to Choose a vehicle:
        System.out.println("Choose a vehicle for " + alien.getName() + " to steal.");
        System.out.println("Tank (Enter: 1), Airplane (Enter: 2), Unidentified Flying Object *UFO* (Enter: 3)");

        int choice3 = 676767;
        int counter = 0;
            while (choice3 < 1 || choice3> 3){
            System.out.println("Please enter an integer from 1 to 3: ");
            
            counter ++;
            if (scanner.hasNextInt()) {
                choice3 = scanner.nextInt();
                
                if (choice3 < 1 || choice3 > 3) {
                    if(counter > 3){
                        System.out.println("You must be a really stupid alien if you can't choose a vehicle correctly!");
                    }
                    else{
                        System.out.println("TRY AGAIN!");
                    }
                } 
                } else {
                System.out.println("TRY AGAIN!");
                scanner.next();
                }
            }

            //TODO: this needs to be fixed with try catch blocks:
            switch(choice3){
                case 1:
                    System.out.println("ALIEN DETECTED IN TANK! SELF DESTRUCT INITIATED!");
                    Thread.sleep(300);

                    for(int i = 10; i>=0; i--){
                        System.out.print(i + "...");
                        Thread.sleep(170);
                    }

                    System.out.println("BOOM!!!");
                    Thread.sleep(170);
                    System.out.println("\nThe Alien has perished. GAME OVER!");
                    return;
                case 2:
                    System.out.println("ALIEN DETECTED IN PLANE! SELF DESTRUCT INITIATED!");
                    Thread.sleep(300);

                    for(int i = 10; i>=0; i--){
                        System.out.print(i + "...");
                        Thread.sleep(170);                        
                    }

                    System.out.println("BOOM!!!");
                    Thread.sleep(170);
                    System.out.println("\nThe Alien has perished. GAME OVER!");                    
                    return;                    
                case 3:
                    System.out.println();
                    break;
                default:
                    throw new IllegalStateException("Unexpected personnel selection: " + choice3);
            }

        
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
        //end of alien scenario
    }

    private static void runScientistScenario(Scientist scientist) {
        /* TODO:
        Code below is template. Comment below should be final outline:
        1. THIS PART IS ALREADY DONE
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
        scientist = (Scientist) Personnel.characterCreator(scientist, scanner);

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
        1. THIS PART IS DONE
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
       soldier = (Soldier) Personnel.characterCreator(soldier, scanner);

        System.out.println("\nSOLDIER OBJECTIVE: Stop the UFO");
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
