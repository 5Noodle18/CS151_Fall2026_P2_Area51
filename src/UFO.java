package src;
//UFO inherits from Vehicle.
//It is designed to try and escape the atmosphere with an alien pilot.

public class UFO extends Vehicle implements AlienDrivable{
    //attributes - members - fields - variables//
    private float altitudeRate;
    private float currentAltitude;
    private boolean isStealthed;
    private Personnel holdingBay;

    //constructors
    public UFO()
    { //default
        super();
        altitudeRate = 100;
        currentAltitude = 0;
        isStealthed = false;
    }

    public UFO(float topSpeed, float acceleration, float altitudeRate) 
    { //intended default
        super(topSpeed, acceleration);
        this.altitudeRate = altitudeRate;
        currentAltitude = 0;
        isStealthed = false;
        holdingBay = null;
    }

    //getters
    public float getAltitudeRate() 
    {
        return altitudeRate;
    }
    public float getAltitude()
    {
        return currentAltitude;
    }
    public boolean isStealthed() 
    {
        return isStealthed;
    }
    //setters
    public void setAltitudeRate(float altitudeRate) 
    {
        this.altitudeRate = altitudeRate;
    }
    public void setCurrentAltitude(float altitude) 
    {
        currentAltitude = altitude;
    }
    public void setIsStealthed(boolean isStealthed)
    {
        this.isStealthed = isStealthed;
    }

    //interface methods
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
        System.out.print("UFO floating\n");
    }
    public void abduct(Personnel abductee)
    {
        this.holdingBay = abductee;
    }
    public Personnel getHoldingBay()
    {
        return this.holdingBay;
    }
    public Personnel unAbduct()
    {
        this.holdingBay = null;
        return this.holdingBay; // no need to make safe copy, it is meant to literally give you that person
    }
    public void startProtonDrive()
    {
        System.out.println("Proton drive spooled up");
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
        if (isStealthed)
            return 0; //can't drive if stealthed
        float distance = 0;
        currentSpeed = currentSpeed + (acceleration * seconds);
        if (currentSpeed > topSpeed)
            currentSpeed = topSpeed;
        distance = currentSpeed * seconds;
        return distance;
    }

    @Override
    public void stop() 
    {
        currentSpeed = 0;
    }

    @Override
    public void destroy()
    {
        currentSpeed = 0;
        driver = null;
        occupants = null;
        currentAltitude = 0;
    }

    //TODO: specialized functions for UFO
}
