package src;
//Airplane inherits from Vehicle
//It is designed specifically around taking off & landing correctly, and carrying many occupants.

public class Airplane extends Vehicle implements HumanDrivable{
    //attributes - members - fields - variables//
    private float takeOffSpeed; //min speed needed to takeoff
    private float landingSpeed; //max speed needed to land safely
    private float altitudeRate;
    private float currentAltitude;
    private double fuelLevel;

    public final static int MAX_ALTITUDE = 15000; //max altitude the airplane can reach

    //constructors
    public Airplane()
    { //default
        super();
        takeOffSpeed = 150;
        landingSpeed = 100;
        altitudeRate = 100;
        currentAltitude = 0;
        fuelLevel = 20;
    }

    public Airplane(float topSpeed, float acceleration, float takeOffSpeed, float landingSpeed, float altitudeRate) 
    { //intended default
        super(topSpeed, acceleration);
        this.takeOffSpeed = takeOffSpeed;
        this.landingSpeed = landingSpeed;
        this.altitudeRate = altitudeRate;
        currentAltitude = 0;
        fuelLevel = 20;
    }

    //getters
    public float getTakeOffSpeed() 
    {
        return takeOffSpeed;
    }
    public float getLandingSpeed()
    {
        return landingSpeed;
    }
    public float getAltitudeRate() 
    {
        return altitudeRate;
    }
    public float getAltitude()
    {
        return currentAltitude;
    }
    public double checkFuel()
    {
        return fuelLevel;
    }
    //setters
    public void setTakeOffSpeed(float takeOffSpeed)
    {
        this.takeOffSpeed = takeOffSpeed;
    }
    public void setLandingSpeed(float landingSpeed)
    {
        this.landingSpeed = landingSpeed;
    }
    public void setAltitudeRate(float altitudeRate) 
    {
        this.altitudeRate = altitudeRate;
    }
    public void setCurrentAltitude(float altitude) 
    {
        currentAltitude = Math.min(altitude, MAX_ALTITUDE);
    }

    // interface methods
    public void setDriver(Personnel driver)
    {
        this.driver = driver;
    }
    public Personnel getDriver()
    {
        return this.driver;
    }
    public void drive()
    {
        System.out.println("The plane flew.");
    }
    public void fuelUp()
    {
        System.out.println("The plane is now fully fueled.");
        fuelLevel = 100;
    }
    public void startEngine()
    {
        System.out.println("Starting turbines, plane is powered on");
    }


    //TODO: true implementations
    //abstract extensions
    @Override 
    public boolean start() 
    {
        if (driver != null) 
            return true;
        else
            return false;
    }

    @Override
    public float drive(float seconds) 
    {
        float distance = 0;
        currentSpeed = currentSpeed + (acceleration * seconds);
        if (currentSpeed > topSpeed)
            currentSpeed = topSpeed;
        distance = currentSpeed * seconds;
        if (currentSpeed > takeOffSpeed) {
            currentAltitude = Math.min(currentAltitude + (altitudeRate * seconds), MAX_ALTITUDE);
        }
        return distance;
    }

    @Override
    public void stop() 
    {
        currentSpeed = 0;
        if (currentAltitude > 10) //wasn't close enough to the ground!
            System.out.println("The airplane is still in the air! You stalled and crashed!");
            destroy();
    }

    @Override
    public void destroy()
    {
        System.out.println("The airplane has been destroyed.");
        currentSpeed = 0;
        driver = null;
        occupants = null;
        currentAltitude = 0;
    }

    //TODO: specialized functions for Airplane

    public boolean takeOff() {
        if (currentSpeed >= takeOffSpeed) {
            currentAltitude = Math.min(currentAltitude + altitudeRate, MAX_ALTITUDE);
            System.out.println("The airplane has taken off and is now at an altitude of " + currentAltitude + " units.");
            return true;
        } else {
            System.out.println("You need to reach the takeoff speed of " + takeOffSpeed + " units before taking off.");
            return false;
        }
    }

    public boolean land() {
        if (currentAltitude > 0 && currentSpeed <= landingSpeed) {
            currentAltitude = 0;
            System.out.println("The airplane has landed safely.");
            return true;
        } else if (currentAltitude > 0 && currentSpeed > landingSpeed) {
            System.out.println("You need to be at or below the landing speed of " + landingSpeed + " units to land.");
            return false;
        } else if (currentAltitude == 0) {
            System.out.println("The airplane is already on the ground.");
            return false;
        }
        return false;
    }

    public float slowDown(float seconds) 
    {
        float distance = 0;
        currentSpeed = currentSpeed - (acceleration * seconds);
        if (currentSpeed < 0)
            stop();
        else if (currentSpeed < landingSpeed && currentAltitude > 0) {
            currentAltitude = currentAltitude - (altitudeRate * seconds); //you're falling!
        }
        distance = currentSpeed * seconds;
        return distance;
    }
}
