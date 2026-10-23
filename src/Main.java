package src;

import java.util.*;

public class Main {

//keep the scanner like this so all the methods can use it too:
private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException, WrongOrderException {
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
                scanner.nextLine();
                
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
        try {
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
        catch (ObjectLimitException e) {
            System.out.println("Error: " + e.getMessage());
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
        try {
            alien = (Alien) Personnel.characterCreator(alien, scanner);
            Personnel.generateStub(alien);
        } catch (ObjectLimitException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        
        System.out.println("\n" + alien.getName() + ", while the guards were rotating shifts, escapes from his holding room.");

        //Alien needs to Choose a vehicle:
        System.out.println("Choose a vehicle for " + alien.getName() + " to steal.");

        int choice3 = -6767;
        choice3 = readChoice(scanner, "Tank (Enter: 1), Airplane (Enter: 2), Unidentified Flying Object *UFO* (Enter: 3)", 1, 3);

            switch(choice3){
                case 1:
                    try{
                        Tank tank = new Tank(67,67,67,67);
                        tank.setDriver(alien);
                        tank.drive();
                    }
                    catch(IllegalPilotException e){
                        System.out.println(e.getMessage());
                    }
                    finally{
                        for(int i = 10; i>=0; i--){
                        System.out.print(i + "...");
                        Thread.sleep(170);
                    }
                    System.out.println("BOOM!!!");
                    Thread.sleep(170);
                    System.out.println("\nThe Alien has perished. GAME OVER!");
                    }
                    return;
                case 2:
                    try{
                        Airplane plane = new Airplane(300, 25, 150, 80, 30);
                        plane.setDriver(alien);
                        plane.drive();
                    }
                    catch(IllegalPilotException e){
                        System.out.println(e.getMessage());
                    }
                    finally{
                        for(int i = 10; i>=0; i--){
                        System.out.print(i + "...");
                        Thread.sleep(170);
                    }
                    System.out.println("BOOM!!!");
                    Thread.sleep(170);
                    System.out.println("\nThe Alien has perished. GAME OVER!");
                    }
                    return;                   
                case 3:
                    System.out.println();
                    break;
                default:
                    throw new IllegalStateException("How did this happen? Unexpected personnel selection: " + choice3);
            }

        System.out.println("The UFO has a security system that only a Scientist can disable. What will " + alien.getName() + " do?");
            Scientist bill = new Scientist("Dr. Bill", 7, 60000, "UFO electrical engineering");

        boolean skinsuited = false;
        while(!skinsuited){
            System.out.println("\nChoose an action:");
            System.out.println("    1. Kill person and wear their skin as a disguise");
            System.out.println("    2. Subdue a scientist");
            System.out.println("    3. Comandeer a UFO");
            System.out.println("    4. Drive to new location");
            System.out.println("    5. Abduct Humans to serve your Alien overlords on " + alien.getHomePlanet());
            System.out.println("    6. Ascend towards the stars");

            int d1 = -6767;
            d1 = readChoice(scanner, "Select a number (1-6)", 1, 6);
            switch (d1) {
                    case 1:
                        System.out.println("Dr. Bill walks down the hallway as " + alien.getName() + " ambushes him.");
                        skinsuited = true;
                        break;
                    case 2:
                        System.out.println("\nDr. Kumar sees "+ alien.getName() +" in the hallway and alerts security!");
                        System.out.println( alien.getName() + " is shot and killed while attempting to run away from them.");
                        System.out.println("GAME OVER");
                        System.exit (0);
                        break;
                    case 3,4,5,6:
                        System.out.println("Impossible right now. Try Again:");
                        break;
                    default:
                        break;
            }
        }

        Scientist disguise = (Scientist) Alien.wearSkinSuit(alien, bill);
        try{
            Personnel.generateStub(alien);
        } catch(Exception e){
            System.out.println("Oops");
        }
        
        System.out.println(disguise.getName() + " approaches Dr. Kumar, who suspects nothing malicious at all.");

        boolean kidnap = false;
        while(!kidnap){
            System.out.println("\nChoose an action:");
            System.out.println("    1. ---");
            System.out.println("    2. Subdue a scientist");
            System.out.println("    3. Comandeer a UFO");
            System.out.println("    4. Drive to new location");
            System.out.println("    5. Abduct Humans to serve your Alien overlords on " + alien.getHomePlanet());
            System.out.println("    6. Ascend towards the stars");

            int d1 = -6767;
            d1 = readChoice(scanner, "Select a number (1-6)", 1, 6);
            switch (d1) {
                    case 2:
                        System.out.println(disguise.getName() + " chokes out Dr. Hundal and takes out his key to unlock the UFO");
                        kidnap = true;
                        break;
                    case 3:
                        System.out.println("\nDr. Hundal sees "+ disguise.getName() +" trying to hijack the UFO and kills him with his Glock!");
                        System.out.println( alien.getName() + " did not know that DR. Bill did not have access to UFO security systems and died cause of that...");
                        System.out.println("GAME OVER");
                        System.exit (0);
                        break;
                    case 1,4,5,6:
                        System.out.println("Impossible right now. Try Again:");
                        break;
                    default:
                        break;
            }
        }





        UFO ufo = new UFO(600, 150, 1000);
        ufo.setDriver(alien);
        ufo.startProtonDrive();

        if (!ufo.start()) {
            try{
                ufo.drive();
            } catch(IllegalPilotException e){
                System.out.println(e.getMessage());
            }                                                                    
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

    private static void runScientistScenario(Scientist scientist) throws WrongOrderException {
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
        try {
            scientist = (Scientist) Personnel.characterCreator(scientist, scanner);
            Personnel.generateStub(scientist);
        } catch (ObjectLimitException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("SCIENTIST SCENARIO: Emergency Research Flight");
        System.out.println(scientist.getName() + " must fly the research airplane and land safely.");


        Airplane airplane = new Airplane(300, 25, 150, 80, 30);
        generateStub(airplane);

        boolean isFueled = false;
        while (!isFueled) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Fuel Up");
            System.out.println("2. Board Passengers");
            System.out.println("3. Get in the Airplane");
            System.out.println("4. Start Engine");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");


            
        int choice = -6767;
        while (choice < 1 || choice > 6){
            System.out.print("Please enter an integer from 1 to 6: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                
                if (choice < 1 || choice > 3) {
                    System.out.println("TRY AGAIN!");
                } 
            } else {
                System.out.println("TRY AGAIN!");
                System.out.println();
                scanner.next();
            }
        }

            try {
                switch (choice) {
                    case 1:
                        airplane.fuelUp();
                        isFueled = true;
                        break;
                    case 2, 3, 4, 5, 6:
                        throw new WrongOrderException("You must fuel up before anything else.");
                    default:
                        throw new IllegalStateException("Unexpected choice: " + choice);
                }
            } catch (WrongOrderException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
        
        generateStub(airplane);

        boolean boarded = false;
        while (!boarded) {
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. Board Passengers");
            System.out.println("3. Get in the Airplane");
            System.out.println("4. Start Engine");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");

            int choice = readChoice(scanner, "Enter your choice (1-6): ", 1, 6);

            try {
                switch (choice) {
                    case 2:
                        boardPassengers(airplane, scanner);
                        boarded = true;
                        break;
                    case 1, 3, 4, 5, 6:
                        throw new WrongOrderException("You must board your passengers now.");
                    default:
                        throw new IllegalStateException("Unexpected choice: " + choice);
                }
            } catch (ObjectLimitException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (WrongOrderException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        generateStub(airplane);
        
        boolean pilotBoarded = false;
        while (!pilotBoarded) {
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. ---");
            System.out.println("3. Get in the Airplane");
            System.out.println("4. Start Engine");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");

            int choice = readChoice(scanner, "Enter your choice (1-6): ", 1, 6);

            try {
                switch (choice) {
                    case 3:
                        airplane.setDriver(scientist);
                        System.out.println(scientist.getName() + " has boarded the airplane.");
                        pilotBoarded = true;
                        break;
                    case 1, 2, 4, 5, 6:
                        throw new WrongOrderException("You must board yourself now.");
                    default:
                        throw new IllegalStateException("Unexpected choice: " + choice);
                }
            } catch (WrongOrderException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        generateStub(airplane);

        boolean engineStarted = false;
        while (!engineStarted) {
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. ---");
            System.out.println("3. ---");
            System.out.println("4. Start Engine");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");

            int choice = readChoice(scanner, "Enter your choice (1-6): ", 1, 6);

            try {
                switch (choice) {
                    case 4:
                        airplane.startEngine();
                        engineStarted = airplane.start();
                        break;
                    case 1, 2, 3, 5, 6:
                        throw new WrongOrderException("You must start the airplane.");
                    default:
                        throw new IllegalStateException("Unexpected choice: " + choice);
                }
            } catch (WrongOrderException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        generateStub(airplane);

        boolean driven = false;
        while (!driven) {
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. ---");
            System.out.println("3. ---");
            System.out.println("4. ---");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");

            int choice = readChoice(scanner, "Enter your choice (1-6): ", 1, 6);

            try {
                switch (choice) {
                    case 5:
                        flyControls(airplane, scanner);
                        driven = true;
                        break;
                    case 1, 2, 3, 4, 6:
                        throw new WrongOrderException("It's time to fly to Area 51!.");
                    default:
                        throw new IllegalStateException("Unexpected choice: " + choice);
                }
            } catch (WrongOrderException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
        
        generateStub(airplane);

        boolean stopped = false;
        while (!stopped) {
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. ---");
            System.out.println("3. ---");
            System.out.println("4. ---");
            System.out.println("5. ---");
            System.out.println("6. Stop Engine");

            int choice = readChoice(scanner, "Enter your choice (1-6): ", 1, 6);

            try {
                switch (choice) {
                    case 6:
                        airplane.stop();
                        stopped = true;
                        break;
                    case 1, 2, 3, 4, 5:
                        throw new WrongOrderException("You've landed! Time to stop the engine.");
                    default:
                        throw new IllegalStateException("Unexpected choice: " + choice);
                }
            } catch (WrongOrderException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.println("Congratulations! " + scientist.getName() + " has successfully completed the emergency research flight to Area 51.");
        System.out.println("Giving promotion based on the number of passengers: " + airplane.getOccupants().length + " passengers.");
        System.out.println("For every 25 passengers, you've earned a promotion!");
        int promotions = airplane.getOccupants().length / 25;

        System.out.println("\n Your original salary was: $" + scientist.getSalary() + "0");
        for (int i = 0; i < promotions; i++) {
            System.out.println("Promoting from rank " + scientist.getRank() + " to rank " + (scientist.getRank() + 1) + ".");
            scientist.promote();
        }
        System.out.println("Your new salary is: $" + scientist.getSalary() + "0");        
    }

    private static void runSoldierScenario(Scanner scanner, Soldier soldier)
    {
        // actors in this scenario
        Alien alien;
        Scientist scientist;
        UFO ufo = new UFO(600, 150, 1000);
        Tank tank = new Tank(80, 20, 3, 5);

        try
        {
            // create a soldier 
            soldier = (Soldier) Personnel.characterCreator(soldier, scanner);
            Personnel.generateStub(soldier);
            // create an alien for the soldier to fight
            alien = new Alien("Zeeblezorp Glurgnop", 3, 50000, "Zeta Reticuli");
            // create a scientist for the soldier to protect
            scientist = new Scientist("Horacio Smartinov", 7, 50000, "Xenogastronomy");
        }
        catch (ObjectLimitException e)
        {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        // list of options to choose from
        String[] options = new String[4];
        options[0] = "Do nothing";
        options[1] = "Chase";
        options[2] = "Shoot";
        options[3] = "Run to tank";

        
        int alienState = 1;
        int soldierState = 1;
        int endingState= 0;

        // place to put messages so that they can be printed at the proper times
        String statusMessage = "\n==== ==== ==== ==== ==== ==== ==== ROUND " + alienState + " ==== ==== ==== ==== ==== ==== ====\n";
        statusMessage += "SOLDIER OBJECTIVE: Stop the alien.\n";
        statusMessage += "You, " + soldier.getRank() + " " + soldier.getName() + ", must intercept the alien before they escape.\n";
        String actionMessage = "";

        while(endingState <= 0) 
        {
            // what the alien is doing, it progresses once per turn
            switch (alienState)
            {
                case 1: // alien running to the UFO
                    statusMessage += "The alien " + alien.getName() + " is currently running away from you... towards a UFO!\n";
                    break;
                case 2: // alien is at the UFO door
                    statusMessage += alien.getName() + " is now at the UFO's door and is about to get in.\n";
                    ufo.setDriver(alien);
                    break;
                case 3: // alien is starting UFO, it is still on the ground
                    ufo.drive();
                    statusMessage += alien.getName() + " is starting the UFO...\n";
                    break;
                case 4: // the UFO is now in the air
                    statusMessage += alien.getName() + " is flying around in the UFO looking for someone to abduct before getting away!\n";
                    if (tank.getDriver() == null)
                    {
                        statusMessage += "It is worth noting: you are in abducting range and are not in a safe tank right now\n";
                    }
                    ufo.start();
                    break;
                case 5: // alien is now flying around, out of range of the tank, and is looking for someone to abduct
                    if (tank.getDriver() == null) // the the player is not in a tank, they get abducted
                    {
                        statusMessage += alien.getName() + " is activating the abduction beam... ";
                        statusMessage += "Vwoosh! You have been abducted.\n";
                        ufo.abduct(soldier);
                        endingState = 5;
                    }
                    else // otherwise, some scientist gets abducted
                    {
                        statusMessage += alien.getName() + " is now abducting someone...\n";
                        statusMessage += "it looks like " + scientist.getName() + " from the science team.\n";
                        ufo.abduct(scientist);
                    }
                    break;
                case 6: // UFO is preparing to leave
                    statusMessage += alien.getName() + " is now getting ready to Jump away with " + ((Scientist)ufo.getHoldingBay()).getName() + " still inside.\n";
                    ufo.startProtonDrive();
                    break;
                case 7: // UFO is jumped away
                    statusMessage += ufo.getDriver().getName() + " got away. They are now probably on their way to " +  ((Alien)ufo.getDriver()).getHomePlanet() + ".\n";
                    endingState = 3;
                    break;
            }
            System.out.print(statusMessage);
            statusMessage = "";

            // ask the user for their input on what to do
            int choice = 0;
            if(endingState > 0)
            {
                soldierState = -1;
            }
            if(soldierState == 1) // the soldier is on foot
            {
                System.out.println("What will you do?\n");
                System.out.print("1. Do nothing\n");
                System.out.print("2. Chase\n");
                System.out.print("3. Shoot\n");
                System.out.print("4. Run to tank\n");
                choice = readChoice(scanner, "Choose between 1 and 4: ", 1, 4);
                switch (choice)
                {
                    case 1: // do nothing
                        actionMessage += "You do nothing...\n";
                        break;
                    case 2: // chase
                        actionMessage += "You sprint after the alien...";
                        if (alienState < 2)
                        {
                            actionMessage += " And tackle them!\n";
                            endingState = 1;
                        }
                        else
                        {
                            actionMessage += " And quickly realise that they are already in a UFO\n";
                        }
                        break;
                    case 3: // shoot
                        actionMessage += "You pull out your firearm and shoot at the alien... ";
                        if (alienState < 3)
                        {
                            actionMessage += "And hit them in the leg.\n";
                            endingState = 1;
                        }
                        else // alien already in a UFO
                        {
                            actionMessage += "But the bullet bounces off the UFO. If only you were in a tank.\n";
                        }
                        break;
                    case 4: // Run to tank
                        actionMessage += "You sprint towards the nearest tank and hop in it\n";
                        tank.setDriver(soldier);
                        tank.startEngine();
                        tank.setShellCount(2);
                        soldierState = 2;
                        break;
                }
            }
            else if (soldierState == 2)// the soldier is in a tank
            {
                System.out.println("What will you do?\n");
                System.out.print("1. Do nothing\n");
                System.out.print("2. Shoot\n");
                System.out.print("3. Load shell\n");
                System.out.print("4. Aim tank\n");
                choice = readChoice(scanner, "Choose between 1 and 4: ", 1, 4);
                switch(choice)
                {
                    case 1: // do nothing
                        actionMessage += "You do nothing...\n";
                        break;
                    case 2: // shoot
                        actionMessage += "You go to fire the tank at the UFO...";
                        if (tank.isLocked() && tank.isLoaded())
                        {
                            actionMessage += " BOOM!\n";
                            if(tank.fireAtTarget())
                            {
                                actionMessage += "A direct hit on the UFO!\n";
                                if(alienState < 5)
                                {
                                    endingState = 1;
                                }
                                else
                                {
                                    endingState = 6;
                                }
                            }
                            else
                            {
                                tank.setIsLoaded(false);
                                actionMessage += "You miss the UFO completely\n";
                            }
                        }
                        else
                        {
                            actionMessage += " Click. Nothing loaded.\n";
                        }
                        break;
                    case 3: // load shell
                        actionMessage += "You load a shell into the tank\n";
                        tank.setIsLocked(true);
                        tank.loadShell();
                        break;
                    case 4: // aim tank
                        actionMessage += "You aim the tank at the UFO\n";
                        tank.setTarget(ufo);

                }
            }

        alienState++;
        actionMessage = "\n==== ==== ==== ==== ==== ==== ==== ROUND " + alienState + " ==== ==== ==== ==== ==== ==== ====\n" + actionMessage;
        System.out.print(actionMessage);
        actionMessage = "";
        }



        // ending conditions
        String endingMessage = "";
        switch (endingState)
        {
            case 1:
                endingMessage += "\nAnd you didn't damage the UFO! You deserve two promotions!";
            case 2:
                endingMessage = "Congratulations! You stopped " + alien.getRank() + " " + alien.getName() + "! You deserve a promotion!" + endingMessage;
                break;

            case 3:
                endingMessage += "\nAnd they abducted " + ((Scientist)ufo.getHoldingBay()).getRank() + " " + ufo.getHoldingBay().getName() + "!";
            case 4:
                endingMessage = "Oh no! " + alien.getRank() + " " + alien.getName() + " got away!" + endingMessage;
                break;

            case 5:
                endingMessage = "Oh no! You got abducted! Good thing " + soldier.getName() + " was expendible...";
                break;
            
            case 6:
                endingMessage += "\nToo bad that " + ((Scientist)ufo.getHoldingBay()).getRank() + " " + ufo.getHoldingBay().getName() + " was aboard...";
            case 7:
                endingMessage = "Congratulations! You stopped " + alien.getRank() + " " + alien.getName() + "! You deserve a promotion!" + endingMessage;
                break;
        }
        System.out.println(endingMessage);
    }

    private static int readChoice(Scanner scanner, String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.equals("QUIT"))
                System.exit(0);
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

    private static void boardPassengers(Airplane airplane, Scanner scanner) throws ObjectLimitException {
        //Allow user to input # of passengers to board and create that many. Class itself handles too many objects exception.
        System.out.println("Time to board passengers. How many passengers would you like to board? Area 50 will assign you random personnel to take with you.");

        int numPassengers = readChoice(scanner, "Enter the number of passengers to board: ", 1, 1000); //perfect opportunity to test the MAXIMUM_OBJECTS=100 exception rule

        /*
        Random creation. Randomly choose 0 or 1. If 0, create a Soldier. If 1, create a Scientist. 
        Add them to the Airplane's occupants list when all are created.
        ALSO, perfect opportunity for polymorphism. The Airplane's occupants list is of type Personnel, but we can add both Soldiers and Scientists to it.
        Let's call abstract functions for polymorphic behavior. For example, we can call getRank() on each occupant and it will return the correct rank for that type of Personnel.
        NOTE: if ObjectLimitException is thrown, catch it and print a message to the user. The program should return to main with maximum occupancy.
         */

        Personnel[] passengers = new Personnel[numPassengers];
        Random random = new Random();

        try {
            for (int i = 0; i < numPassengers; i++) {
                Personnel nextPassenger;
                if (random.nextBoolean()) {
                    nextPassenger = new Soldier("Soldier " + (i + 1), random.nextInt(13), 50000 + random.nextInt(50000), random.nextBoolean());
                } else {
                    nextPassenger = new Scientist("Scientist " + (i + 1), random.nextInt(11), 60000 + random.nextInt(40000), "Degree " + (i + 1));
                }
                //polymophism in action!
                System.out.println("Currently boarding: " + nextPassenger.getName() + "\t Rank: " + nextPassenger.getRank()); // This will call the appropriate getRank() method for Soldier or Scientist

                passengers[i] = nextPassenger;
            }
        } catch (ObjectLimitException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Maximum number of Personnel instances reached. Boarding stopped.");
        } finally {
            //ensure we set occupants to the successfully created passengers, even if we hit the limit
            airplane.setOccupants(passengers);
        }
    }

    private static void flyControls(Airplane airplane, Scanner scanner) {
        System.out.println("You are now in control of the airplane. You can adjust speed and altitude.");
        System.out.println("Enter 'QUIT' at any time to exit the game.");
        float distanceTraveled = 0;

        while (true) {
            if (airplane.getDriver() == null) //plane was destroyed during loop)
            {
                System.out.println("GAME OVER: The airplane has been destroyed. You cannot continue.");
                System.exit(0);
            }
            System.out.println("\nCurrent Speed: " + airplane.getCurrentSpeed() + " units");
            System.out.println("Current Altitude: " + airplane.getAltitude() + " units");
            System.out.println("Takeoff Speed: " + airplane.getTakeOffSpeed() + " units, Landing Speed: " + airplane.getLandingSpeed() + " units");
            System.out.println("Distance to Area 51: " + (100000 - distanceTraveled) + " units");
            System.out.println("Choose an action:");
            System.out.println("1. " + ((airplane.getAltitude() > 0) ? "Fly" : "Drive"));
            System.out.println("2. Slow Down");
            System.out.println("3. Take Off");
            System.out.println("4. Land");

            int choice = readChoice(scanner, "Enter your choice (1-4): ", 1, 4);

            switch (choice) {
                case 1:
                    if (distanceTraveled >= 100000) {
                        System.out.println("You have reached Area 51! Prepare to land.");
                        break;
                    }
                    float flightTime = readChoice(scanner, "Enter flight time in seconds: ", 1, 10000);
                    float distance = airplane.drive(flightTime);
                    System.out.println("The airplane traveled " + distance + " units.");
                    distanceTraveled += distance;
                    if (distanceTraveled >= 100000) {
                        System.out.println("You are approaching Area 51! Prepare to land.");
                        distanceTraveled = 100000; // Cap the distance to Area 51
                    }
                    break;
                case 2:
                    float decelerationTime = readChoice(scanner, "Enter time to slow down in seconds: ", 1, 10000);
                    float distanceSlowed = airplane.slowDown(decelerationTime);
                    System.out.println("The airplane slowed down. Current speed: " + airplane.getCurrentSpeed() + " units.");
                    if (distanceTraveled < 100000) {
                        System.out.println("You still traveled " + distanceSlowed + " units during deceleration.");
                        distanceTraveled += distanceSlowed;
                    }
                    break;
                case 3:
                    airplane.takeOff();
                    break;
                case 4:
                    if (airplane.land()) {
                        System.out.println("You have successfully landed at Area 51!");
                        return;
                    } else {
                        System.out.println("You cannot land yet. Ensure your speed is below the landing speed and you are at a safe altitude.");
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected choice: " + choice);
            }
        }
    }

        public static void generateStub(Vehicle vehicle){
        if (vehicle == null) {
            System.out.println("Null vehicles not allowed.");
            return;
        }

        String role = vehicle.getClass().getSimpleName();
        System.out.println("\n[" + role + " Stats:]");

        if(vehicle instanceof Airplane){
            Airplane v = (Airplane) vehicle;
            System.out.println("    Takeoff Speed: " + v.getTakeOffSpeed() + " units, Landing Speed: " + v.getLandingSpeed() + " units");
            System.out.println("    Altitude Rate: " + v.getAltitudeRate() + " units/sec, Current Altitude: " + v.getAltitude() + " units");
            System.out.println("    Fuel Level: " + v.checkFuel() + "%");
        } else if(vehicle instanceof Tank){
            Tank v = (Tank) vehicle;
            System.out.println("    Shell Count: " + v.getShellCount() + "shells, Aim Speed: " + v.getAimSpeed());
            System.out.println("Locked on Target: " + v.isLocked() + ", Cannon Loaded: " + v.isLoaded());

        }else{
            UFO v = (UFO) vehicle;
            System.out.println("    Altitude Rate: " + v.getAltitudeRate() + " units/sec, Current Altitude: " + v.getAltitude() + " units");
            System.out.print  ("    Is Stealthed: " + v.isStealthed() + ", Victim: ");
            if(v.getHoldingBay() == null){
                System.out.println("none right now");
            } else{
                System.out.println(v.getHoldingBay());
            }
        }
        
        System.out.println("    Top Speed: " + vehicle.getTopSpeed() + " units, Acceleration: " + vehicle.getAcceleration() + " units/sec^2");
        System.out.println("    Current Speed: " + vehicle.getCurrentSpeed() + " units");

        if(!(vehicle.getDriver() == null)){
            System.out.println("    Driver: " + vehicle.getDriver().getName());
        } else{
            System.out.println("    Driver: n/a");
        }

        if(vehicle instanceof Airplane){
            if(!(vehicle.getOccupants() == null)){
                System.out.println("    Occupants: " + vehicle.getOccupants().length + " passengers");
            } else{
            System.out.println("    Occupants: n/a");
            }
        }     
    }
}
