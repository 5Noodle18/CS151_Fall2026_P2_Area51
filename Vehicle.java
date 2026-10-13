//Vehicle is meant to be conceptual superclass of Tank, UFO, and Airplane.
//Contains attributes meant for all Vehicle types, and generic methods.

public abstract class Vehicle {
    //attributes - members - fields - variables//
    protected float topSpeed;
    protected float acceleration;
    protected float currentSpeed;
    protected Personnel driver;
    protected Personnel[] occupants;

    //default constructor
    public Vehicle() 
    {
        topSpeed = 100;
        acceleration = 10;
        currentSpeed = 0;
        driver = null;
        occupants = null;
    }
    //intended constructor
    public Vehicle(float topSpeed, float acceleration) 
    {
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        currentSpeed = 0;
        driver = null;
        occupants = null;
    }
    
    //Getters
    protected float getTopSpeed() 
    { 
        return topSpeed; 
    }
    protected float getAcceleration() 
    { 
        return acceleration; 
    }
    protected float getCurrentSpeed() 
    { 
        return currentSpeed; 
    }
    protected Personnel getDriver() 
    { 
        return driver; 
    }
    protected Personnel[] getOccupants() 
    { 
        return occupants;
    }
    //Setters
    protected void setTopSpeed(float speed) 
    {
        topSpeed = speed;
    }
    protected void setAcceleration(float acceleration) 
    {
        this.acceleration = acceleration;
    }
    protected void setCurrentSpeed(float speed) 
    {
        currentSpeed = speed;
    }
    protected void setDriver(Personnel driver) 
    {
        this.driver = driver;
    }
    protected void setOccupants(Personnel[] occupants)
    {
        this.occupants = occupants;
    }

    //functions - methods//
    public abstract boolean start();

    public abstract float drive(float seconds);

    public abstract void stop();

    public abstract void destroy();
}
