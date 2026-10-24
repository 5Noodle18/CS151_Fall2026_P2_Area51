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
    public UFO() throws ObjectLimitException
    { //default
        super();
        altitudeRate = 100;
        currentAltitude = 0;
        isStealthed = false;
    }

    public UFO(float topSpeed, float acceleration, float altitudeRate) throws ObjectLimitException
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
    public void drive() throws IllegalPilotException
    {
        if(this.getDriver() == null){
            throw new IllegalPilotException("UFO Driver Needed!");
        }
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
        if (getDriver() != null)
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

        setCurrentSpeed(getCurrentSpeed() + (getAcceleration() * seconds));
        if (getCurrentSpeed() > getTopSpeed())
            setCurrentSpeed(getTopSpeed());
        distance = getCurrentSpeed() * seconds;
        return distance;
    }

    @Override
    public void stop() 
    {
        setCurrentSpeed(0);
    }

    @Override
    public void destroy()
    {
        setCurrentSpeed(0);
        setDriver(null);
        setOccupants(null);
        currentAltitude = 0;
    }

    //TODO: specialized functions for UFO
}
