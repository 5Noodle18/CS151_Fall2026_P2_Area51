//Airplane inherits from Vehicle
//It is designed specifically around taking off & landing correctly, and carrying many occupants.

public class Airplane extends Vehicle{
    //attributes - members - fields - variables//
    private float takeOffSpeed; //min speed needed to takeoff
    private float landingSpeed; //max speed needed to land safely
    private float altitudeRate;
    private float currentAltitude;

    //constructors
    public Airplane()
    { //default
        super();
        takeOffSpeed = 150;
        landingSpeed = 100;
        altitudeRate = 100;
        currentAltitude = 0;
    }

    public Airplane(float topSpeed, float acceleration, float takeOffSpeed, float landingSpeed, float altitudeRate) 
    { //intended default
        super(topSpeed, acceleration);
        this.takeOffSpeed = takeOffSpeed;
        this.landingSpeed = landingSpeed;
        this.altitudeRate = altitudeRate;
        currentAltitude = 0;
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
        currentAltitude = altitude;
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
            currentAltitude = currentAltitude + (altitudeRate * seconds);
        }
        return distance;
    }

    @Override
    public void stop() 
    {
        currentSpeed = 0;
        if (currentAltitude > 10) //wasn't close enough to the ground!
            destroy();
    }

    @Override
    public void destroy()
    {
        currentSpeed = 0;
        driver = null;
        occupants = null;
        currentAltitude = 0;
    }

    //TODO: specialized functions for Airplane
}
