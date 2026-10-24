package src;

import java.util.*;

public class Main {

//keep the scanner like this so all the methods can use it too:

// special scanner wrapper that ensures the user can always EXIT
private final static ScannerWrapper scannerWrapper = ScannerWrapper.getInstance();

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
        scannerWrapper.readString();

        System.out.println("Choose your personnel:");
        System.out.println("(1). Alien");
        System.out.println("(2). Scientist");
        System.out.println("(3). Soldier");
        
        //verify the input is between 1 and 3 in a polite, professional way befitting Area 51.
        int choice = scannerWrapper.readChoice("Please enter an integer from 1 to 3: \n", 1, 3);

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
                    runSoldierScenario(new Soldier("Captain Reyes", 5, 60000, false));
                    break;
                default:

                    throw new IllegalStateException("Unexpected personnel selection: " + choice);
            }
        }
        catch (ObjectLimitException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static void runAlienScenario(Alien alien) throws InterruptedException, ObjectLimitException {

        //refer to last method in personnel if you want to change character creator method:
        try {
            alien = (Alien) Personnel.characterCreator(alien, scannerWrapper);
            Personnel.generateStub(alien);
        } catch (ObjectLimitException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        
        System.out.println("\n" + alien.getName() + ", while the guards were rotating shifts, escapes from his holding room.\n");

        //Alien needs to Choose a vehicle:
        System.out.println("Choose a vehicle for " + alien.getName() + " to steal.");

        int choice3 = -6767;
        choice3 = scannerWrapper.readChoice("Tank (Enter: 1), Airplane (Enter: 2), Unidentified Flying Object *UFO* (Enter: 3) \n", 1, 3);

            switch(choice3){
                case 1:
                    Tank tank = new Tank(67,67,67,67);
                    int x = scannerWrapper.readChoice("Sabotage Tank (Enter: 1) or try to drive it? (Enter: 2)",1,2);

                        if(x==1){
                            Alien.sabotageAndDisplay(tank);
                            System.out.println("\nHaving sabotaged the tank, now it is time to steal a UFO.");
                            break;
                        }

                    try{
                        
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
                    System.exit(0);
                    }
                    break;
                case 2:
                    Airplane plane = new Airplane(300, 25, 150, 80, 30);
                    int x2 = scannerWrapper.readChoice("Sabotage Plane (Enter: 1) or try to drive it? (Enter: 2) \n",1,2);

                        if(x2==1){
                            Alien.sabotageAndDisplay(plane);
                            System.out.println("\nHaving sabotaged the plane, now it is time to steal a UFO.");
                            break;
                        }

                    try{
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
                    System.exit(0);
                    }
                    break;                   
                case 3:
                    System.out.println();
                    break;
                default:
                    throw new IllegalStateException("How did this happen? Unexpected personnel selection: " + choice3);
            }

        System.out.println("\nThe UFO has a security system that only a Scientist can disable. What will " + alien.getName() + " do?");
            Scientist bill = new Scientist("Dr. Yonemoto", 7, 60000, "Extraterrestrial Ethnic Studies");

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
            d1 = scannerWrapper.readChoice( "Select a number (1-6)\n", 1, 6);
            switch (d1) {
                    case 1:
                        System.out.println("\nDr. Yonemoto walks down the hallway as " + alien.getName() + " ambushes him.");
                        skinsuited = true;
                        break;
                    case 2:
                        System.out.println("\nDr. Yonemoto sees "+ alien.getName() +" in the hallway and alerts security!");
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
        
        Personnel.generateStub(disguise);

        Scientist hundal = new Scientist("Dr. Hundal", 9, 90000, "UFO computer science");
        System.out.println(disguise.getName() + ", approaches Dr. Hundal. They suspect nothing malicious at all.");

        boolean kidnap = false;
        while(!kidnap){
            System.out.println("\nChoose an action:");
            System.out.println("    1. ---");
            System.out.println("    2. Subdue a scientist");
            System.out.println("    3. Comandeer a UFO");
            System.out.println("    4. Drive to new location");
            System.out.println("    5. Abduct Humans to serve your Alien overlords on " + alien.getHomePlanet());
            System.out.println("    6. Ascend towards the stars");

            int d2 = -6767;
            d2 = scannerWrapper.readChoice("Select a number (1-6) \n", 1, 6);
            switch (d2) {
                    case 2:
                        System.out.println(disguise.getName() + ", chokes out Dr. Hundal and takes out his key to unlock the UFO");
                        kidnap = true;
                        break;
                    case 3:
                        System.out.println("\nDr. Hundal sees "+ disguise.getName() + " trying to hijack the UFO and kills him with his Glock!");
                        System.out.println( alien.getName() + " did not know that Dr. Hundal knows how to bust a cap.");
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

        UFO ufo = new UFO(600, 150, 100);

        boolean comandeer = false;
        while(comandeer ==  false){
            System.out.println("\nChoose an action:");
            System.out.println("    1. ---");
            System.out.println("    2. ---");
            System.out.println("    3. Comandeer a UFO");
            System.out.println("    4. Drive to new location");
            System.out.println("    5. Abduct Humans to serve your Alien overlords on " + alien.getHomePlanet());
            System.out.println("    6. Ascend towards the stars");

            int d3 = -6767;
            d3 = scannerWrapper.readChoice( "Select a number (1-6) \n", 1, 6);
            switch (d3) {
                    case 3:
                        comandeer = true;
                        ufo.setDriver(alien);
                        Thread.sleep(150);
                        ufo.startProtonDrive();

                        try{
                            ufo.drive();
                        } catch(IllegalPilotException e){
                            System.out.println(e.getMessage());
                        }
                        break;                                                                    
                    case 4,5,6,1,2:
                        System.out.println("Unable to do that right now.");
                        break;
                }
            }

        System.out.println("\n[UFO Stats]");
        System.out.println("    Top Speed: " + ufo.getTopSpeed() + " units, Acceleration: " + ufo.getAcceleration() + " units/s^2");
        System.out.println("    Altitude Rate: " + ufo.getAltitudeRate() + " units");

        boolean newloc = false;
        int count = 0;
        while(!newloc){
            System.out.println("\nChoose an action:");
            System.out.println("    1. ---");
            System.out.println("    2. ---");
            System.out.println("    3. ---");
            System.out.println("    4. Abduct Humans to serve your Alien overlords on " + alien.getHomePlanet());
            System.out.println("    5. Ascend towards the stars");

            int d4 = -6767;
            d4 = scannerWrapper.readChoice( "Select a number (1-5) \n", 1, 5);
            switch (d4) {
                    case 4:
                        if(count >= 1){
                            System.out.println("\nThis UFO model only has space to abduct one person.");
                            break;
                        }

                        count++;
                        System.out.println("The commotion has caused other people to wander into the hangar with the UFO. What will " + alien.getName() + " do?");
                        int d5 = scannerWrapper.readChoice("Choose an abductee: Dr. Hundal (Enter: 1) or a Random Soldier (Enter: 2) ",1,3);
                            if(d5 ==2){
                                System.out.println("\nThe handsome and muscular soldier breaks free of his restraints and blasts " + alien.getName() + " with an AR-15!");
                                System.out.println("He lands the UFO and flexes his ginormous muscles while holding up a dead alien.");
                                System.out.println("GAME OVER!");
                                System.exit(0);
                            }
                        System.out.println("A beam of light sucks the victim into the holding bay.");
                        ufo.abduct(hundal);
                        int eat = scannerWrapper.readChoice("Eat him? No (Enter 1), Yes (Enter 2).\n", 1,2);
                            if(eat == 2){
                                alien.comsumeUpgrade(hundal);
                                Personnel.generateStub(alien);
                                ufo.unAbduct();
                            }
                        break;
                    case 1,2,3:
                        System.out.println("\nUnable to do that right now.");
                        break;
                    case 5:
                        int flightTime = scannerWrapper.readChoice("\nEnter flight time: (0-1000). The choice is life or death.\n", 0, 1000);
                        float distance = ufo.drive(flightTime);
                        ufo.setCurrentAltitude(ufo.getAltitude() + ufo.getAltitudeRate() * flightTime);
                        System.out.println("The UFO traveled " + distance + " units and climbed to " + ufo.getAltitude() + " units.");

                        if (ufo.getAltitude() >= 2000) {
                            System.out.println("\n\nMission complete: " + alien.getName() + " has escaped into orbit!");
                            if(ufo.getHoldingBay() != null){
                                Thread.sleep(300);
                                System.out.println("\nUnfortunately, your superiors took a liking to the human and he has replaced your job.");
                                System.out.println(alien.getHomePlanet() + " has a bad economy right now.");
                                System.out.println(alien.getName() + " has been demoted");
                                alien.demote();
                                Personnel.generateStub(alien);
                                System.exit(0);
                            }
                        System.exit(0);

                        } else {
                            System.out.println("Mission failed: the UFO did not reach orbit.");
                            System.exit(0);
                        }
                        break;
                    default:
                        break;
            }
        }
         System.exit(0);   
    }

    //end of alien scenario


    private static void runScientistScenario(Scientist scientist) throws WrongOrderException {
  
        try {
            scientist = (Scientist) Personnel.characterCreator(scientist, scannerWrapper);
            Personnel.generateStub(scientist);
        } catch (ObjectLimitException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("SCIENTIST SCENARIO: Emergency Research Flight");
        System.out.println(scientist.getName() + " must fly the research airplane and land safely.");
        System.out.println(scientist.getName() + " speaks: " + scientist.speakRandomly());


        Airplane airplane;
        try
        {
            airplane = new Airplane(300, 25, 150, 80, 30);
        }
        catch (ObjectLimitException e)
        {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        System.out.println("\n[Airplane Stats:]");
        System.out.println("    Takeoff Speed: " + airplane.getTakeOffSpeed() + " units, Landing Speed: " + airplane.getLandingSpeed() + " units");
        System.out.println("    Altitude Rate: " + airplane.getAltitudeRate() + " units/sec, Current Altitude: " + airplane.getAltitude() + " units");
        System.out.println("    Fuel Level: " + airplane.checkFuel() + "%");
        System.out.println("    Top Speed: " + airplane.getTopSpeed() + " units, Acceleration: " + airplane.getAcceleration() + " units/sec^2");
        System.out.println("    Current Speed: " + airplane.getCurrentSpeed() + " units");
        System.out.println("    Driver: n/a");
        System.out.println("    Occupants: n/a");

        boolean isFueled = false;
        while (!isFueled) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Fuel Up");
            System.out.println("2. Board Passengers");
            System.out.println("3. Get in the Airplane");
            System.out.println("4. Start Engine");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");

            int choice = scannerWrapper.readChoice("Enter your choice (1-6): ", 1, 6);

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
        
        System.out.println("\n[Airplane Stats:]");
        System.out.println("    Takeoff Speed: " + airplane.getTakeOffSpeed() + " units, Landing Speed: " + airplane.getLandingSpeed() + " units");
        System.out.println("    Altitude Rate: " + airplane.getAltitudeRate() + " units/sec, Current Altitude: " + airplane.getAltitude() + " units");
        System.out.println("    Fuel Level: " + airplane.checkFuel() + "%");
        System.out.println("    Top Speed: " + airplane.getTopSpeed() + " units, Acceleration: " + airplane.getAcceleration() + " units/sec^2");
        System.out.println("    Current Speed: " + airplane.getCurrentSpeed() + " units");
        System.out.println("    Driver: n/a");
        System.out.println("    Occupants: n/a");

        boolean boarded = false;
        while (!boarded) {
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. Board Passengers");
            System.out.println("3. Get in the Airplane");
            System.out.println("4. Start Engine");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");

            int choice = scannerWrapper.readChoice("Enter your choice (1-6): ", 1, 6);

            try {
                switch (choice) {
                    case 2:
                        boardPassengers(airplane);
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

        System.out.println("\n[Airplane Stats:]");
        System.out.println("    Takeoff Speed: " + airplane.getTakeOffSpeed() + " units, Landing Speed: " + airplane.getLandingSpeed() + " units");
        System.out.println("    Altitude Rate: " + airplane.getAltitudeRate() + " units/sec, Current Altitude: " + airplane.getAltitude() + " units");
        System.out.println("    Fuel Level: " + airplane.checkFuel() + "%");
        System.out.println("    Top Speed: " + airplane.getTopSpeed() + " units, Acceleration: " + airplane.getAcceleration() + " units/sec^2");
        System.out.println("    Current Speed: " + airplane.getCurrentSpeed() + " units");
        System.out.println("    Driver: n/a");
        System.out.println("    Occupants: " + airplane.getOccupants().length + " passengers");
        
        boolean pilotBoarded = false;
        while (!pilotBoarded) {
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. ---");
            System.out.println("3. Get in the Airplane");
            System.out.println("4. Start Engine");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");

            int choice = scannerWrapper.readChoice("Enter your choice (1-6): ", 1, 6);

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

        System.out.println("\n[Airplane Stats:]");
        System.out.println("    Takeoff Speed: " + airplane.getTakeOffSpeed() + " units, Landing Speed: " + airplane.getLandingSpeed() + " units");
        System.out.println("    Altitude Rate: " + airplane.getAltitudeRate() + " units/sec, Current Altitude: " + airplane.getAltitude() + " units");
        System.out.println("    Fuel Level: " + airplane.checkFuel() + "%");
        System.out.println("    Top Speed: " + airplane.getTopSpeed() + " units, Acceleration: " + airplane.getAcceleration() + " units/sec^2");
        System.out.println("    Current Speed: " + airplane.getCurrentSpeed() + " units");
        System.out.println("    Driver: " + airplane.getDriver().getName());
        System.out.println("    Occupants: " + airplane.getOccupants().length + " passengers");

        boolean engineStarted = false;
        while (!engineStarted) {
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. ---");
            System.out.println("3. ---");
            System.out.println("4. Start Engine");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");

            int choice = scannerWrapper.readChoice("Enter your choice (1-6): ", 1, 6);

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

        System.out.println("\n[Airplane Stats:]");
        System.out.println("    Takeoff Speed: " + airplane.getTakeOffSpeed() + " units, Landing Speed: " + airplane.getLandingSpeed() + " units");
        System.out.println("    Altitude Rate: " + airplane.getAltitudeRate() + " units/sec, Current Altitude: " + airplane.getAltitude() + " units");
        System.out.println("    Fuel Level: " + airplane.checkFuel() + "%");
        System.out.println("    Top Speed: " + airplane.getTopSpeed() + " units, Acceleration: " + airplane.getAcceleration() + " units/sec^2");
        System.out.println("    Current Speed: " + airplane.getCurrentSpeed() + " units");
        System.out.println("    Driver: " + airplane.getDriver().getName());
        System.out.println("    Occupants: " + airplane.getOccupants().length + " passengers");

        boolean driven = false;
        while (!driven) {
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. ---");
            System.out.println("3. ---");
            System.out.println("4. ---");
            System.out.println("5. Drive");
            System.out.println("6. Stop Engine");

            int choice = scannerWrapper.readChoice("Enter your choice (1-6): ", 1, 6);

            try {
                switch (choice) {
                    case 5:
                        flyControls(airplane);
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
        
        System.out.println("\n[Airplane Stats:]");
        System.out.println("    Takeoff Speed: " + airplane.getTakeOffSpeed() + " units, Landing Speed: " + airplane.getLandingSpeed() + " units");
        System.out.println("    Altitude Rate: " + airplane.getAltitudeRate() + " units/sec, Current Altitude: " + airplane.getAltitude() + " units");
        System.out.println("    Fuel Level: " + airplane.checkFuel() + "%");
        System.out.println("    Top Speed: " + airplane.getTopSpeed() + " units, Acceleration: " + airplane.getAcceleration() + " units/sec^2");
        System.out.println("    Current Speed: " + airplane.getCurrentSpeed() + " units");
        System.out.println("    Driver: " + airplane.getDriver().getName());
        System.out.println("    Occupants: " + airplane.getOccupants().length + " passengers");

        boolean stopped = false;
        while (!stopped) {
            System.out.println(scientist.getName() + " speaks: " + scientist.speakRandomly());
            System.out.println("\nChoose an action:");
            System.out.println("1. ---");
            System.out.println("2. ---");
            System.out.println("3. ---");
            System.out.println("4. ---");
            System.out.println("5. ---");
            System.out.println("6. Stop Engine");

            int choice = scannerWrapper.readChoice("Enter your choice (1-6): ", 1, 6);

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
        scientist.calculateFlightPromotions(airplane);  
        System.out.println("Game Over. YOU WIN!!!");
    }

    private static void runSoldierScenario(Soldier soldier)
    {
        // actors in this scenario
        UFO ufo;
        Tank tank;
        Alien alien;
        Scientist scientist;
        try
        {
            ufo = new UFO(600, 150, 1000);
            tank = new Tank(80, 20, 3, 5);
            alien = new Alien("Zeeblezorp Glurgnop", 6, 50000, "Zeta Reticuli");
            scientist = new Scientist("Horacio Smartinov", 7, 50000, "Xenogastronomy");
            soldier = (Soldier) Personnel.characterCreator(soldier, scannerWrapper);
            Personnel.generateStub(soldier);
        }
        catch (ObjectLimitException e)
        {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        
        // states of the game
        int alienState = 1; // stages of the game, goes from 1 to 7
        int soldierState = 1; // 1 is on foot, 2 is in a tank
        int endingState= 0; // greater than 1 is an ending state

        // place to put messages so that they can be printed at the proper times
        String statusMessage = "\n==== ==== ==== ==== ==== ==== ==== ROUND " + alienState + " ==== ==== ==== ==== ==== ==== ====\n";
        statusMessage += "SOLDIER OBJECTIVE: Stop the alien.\n";
        statusMessage += "You, " + soldier.getRank() + " " + soldier.getName() + ", must intercept the alien before they escape.\n";
        String actionMessage = "";

        // as long as an ending state hasn't been reached or the game is over
        while(endingState <= 0 && alienState < 9)
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
                    try{
                        ufo.drive();
                    } catch(IllegalPilotException e){
                        System.out.println(e.getMessage());
                    }
                    statusMessage += alien.getName() + " is starting the UFO...\n";
                    break;
                case 4: // UFO is in the air and looking for an abductee
                    statusMessage += alien.getName() + " is flying around in the UFO looking for someone to abduct before getting away!\n";
                    break;
                case 5: // the UFO is about to abduct someone
                    statusMessage += "It looks like " + alien.getName() + " getting ready to fire the abduction beam.\n";
                    if (tank.getDriver() == null)
                    {
                        statusMessage += "It is worth noting: you are in abducting range and are not in a safe tank right now!\n";
                    }
                    ufo.start();
                    break;
                case 6: // alien is now flying around, and is looking for someone to abduct
                    if (tank.getDriver() == null) // if the the player is not in a tank, they get abducted
                    {
                        statusMessage += alien.getName() + " is activating the abduction beam... ";
                        statusMessage += "Vwoosh! You have been abducted.\n";
                        ufo.abduct(soldier);
                        endingState = 5;
                    }
                    else // otherwise, some scientist gets abducted
                    {
                        statusMessage += alien.getName() + " is now abducting someone... ";
                        statusMessage += "it looks like " + scientist.getName() + " from the science team.\n";
                        ufo.abduct(scientist);
                    }
                    break;
                case 7: // UFO is preparing to leave
                    statusMessage += alien.getName() + " is now getting ready to Jump away with " + ((Scientist)ufo.getHoldingBay()).getName() + " still inside.\n";
                    ufo.startProtonDrive();
                    break;
                case 8: // UFO is almost gone
                    statusMessage += "The UFO is really speeding up now, if you don't do something now they'll get away!\n";
                    ufo.setAcceleration(1000);
                    break;
                case 9: // UFO jumped away
                    statusMessage += ufo.getDriver().getName() + " got away. They are now probably on their way to " +  ((Alien)ufo.getDriver()).getHomePlanet() + ".\n";
                    endingState = 3;
                    break;
            }
            //print what the alien is doing
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
                System.out.print("4. Run to nearest tank\n");
                choice = scannerWrapper.readChoice("Choose between 1 and 4: ", 1, 4);
                switch (choice)
                {
                    case 1: // do nothing
                        actionMessage += "You do nothing...\n";
                        break;
                    case 2: // chase
                        actionMessage += "You sprint after the alien...";
                        if (alienState < 2)
                        {
                            actionMessage += soldier.doViolence(alien, "tackles") + ".\n";
                            endingState = 1;
                        }
                        else
                        {
                            actionMessage += " And quickly realise that they are already in a UFO.\n";
                        }
                        break;
                    case 3: // shoot
                        actionMessage += "You pull out your tazer and shoot at the alien... ";
                        if (alienState < 3)
                        {
                            actionMessage += soldier.doViolence(alien, "tazes") + " in the leg.\n";
                            endingState = 1;
                        }
                        else // alien already in a UFO
                        {
                            actionMessage += "But the projectile bounces off the UFO's shield. If only you were in a tank.\n";
                        }
                        break;
                    case 4: // Run to tank
                        actionMessage += soldier.rememberTraining(tank);
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
                choice = scannerWrapper.readChoice("Choose between 1 and 4: ", 1, 4);
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
                                if(alienState < 6)
                                {
                                    endingState = 7;
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
                        actionMessage += soldier.rememberTraining(tank);
                        break;
                    case 4: // aim tank
                        actionMessage += "You aim the tank at the UFO\n";
                        tank.setTarget(ufo);
                }
            }

        alienState++; // progress the round
        actionMessage = "\n==== ==== ==== ==== ==== ==== ==== ROUND " + alienState + " ==== ==== ==== ==== ==== ==== ====\n" + actionMessage;
        System.out.print(actionMessage); // print the round and what happened
        actionMessage = ""; // clear the message
        }



        // ending conditions
        String endingMessage = "";
        switch (endingState)
        {
            case 1: // you didn't damage the ufo
                endingMessage += "\nAnd you didn't damage the UFO! You deserve two promotions!";
                soldier.promote();
            case 2: // you stop the alien
                endingMessage = "Congratulations! You stopped " + alien.getRank() + " " + alien.getName() + "! You deserve a promotion!" + endingMessage;
                soldier.promote();
                break;

            case 3: // the alien got away with the scientist
                endingMessage += "\nAnd they abducted " + ((Scientist)ufo.getHoldingBay()).getRank() + " " + ufo.getHoldingBay().getName() + "!";
            case 4: // the alien got away
                endingMessage = "Oh no! " + alien.getRank() + " " + alien.getName() + " got away!" + endingMessage;
                break;

            case 5: // you get abducted
                endingMessage = "Oh no! " + alien.getRank() + " " + alien.getName() + " got away!\n";
                endingMessage += soldier.momentOfTruth("being sucked up by a flying saucer.");
                if (soldier.getExpendable())
                {
                    endingMessage += "Good thing " + soldier.getName() + " was expendible...\n";
                }
                else
                {
                    endingMessage += "As expected too! " + soldier.getName() + " is not expendable! Have a promotion for your hard work.\n";
                    soldier.promote();
                }
                break;
            
            case 6: // you shoot down the UFO with the scientist inside
                endingMessage += "\nToo bad that " + ((Scientist)ufo.getHoldingBay()).getRank() + " " + ufo.getHoldingBay().getName() + " was in the UFO...";
            case 7: // you shoot down the UFO
                endingMessage = "Congratulations! You stopped " + alien.getRank() + " " + alien.getName() + "! You deserve a promotion!" + endingMessage;
                soldier.promote();
                break;
        }
        System.out.println(endingMessage);
    }

    private static void boardPassengers(Airplane airplane) throws ObjectLimitException {
        //Allow user to input # of passengers to board and create that many. Class itself handles too many objects exception.
        System.out.println("Time to board passengers. How many passengers would you like to board? Area 50 will assign you random personnel to take with you.");

        int numPassengers = scannerWrapper.readChoice("Enter the number of passengers to board: ", 1, 1000); //perfect opportunity to test the MAXIMUM_OBJECTS=100 exception rule

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
            passengers = Arrays.copyOf(passengers, 100);
            airplane.setOccupants(passengers);
        }
    }

    private static void flyControls(Airplane airplane) {
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

            int choice = scannerWrapper.readChoice("Enter your choice (1-4): ", 1, 4);

            switch (choice) {
                case 1:
                    if (distanceTraveled >= 100000) {
                        System.out.println("You have reached Area 51! Prepare to land.");
                        break;
                    }
                    float flightTime = scannerWrapper.readChoice("Enter flight time in seconds: ", 1, 10000);
                    float distance = airplane.drive(flightTime);
                    System.out.println("The airplane traveled " + distance + " units.");
                    distanceTraveled += distance;
                    if (distanceTraveled >= 100000) {
                        System.out.println("You are approaching Area 51! Prepare to land.");
                        distanceTraveled = 100000; // Cap the distance to Area 51
                    }
                    break;
                case 2:
                    float decelerationTime = scannerWrapper.readChoice("Enter time to slow down in seconds: ", 1, 10000);
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
}
