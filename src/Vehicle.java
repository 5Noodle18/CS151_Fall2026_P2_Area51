package src;
//Vehicle is meant to be conceptual superclass of Tank, UFO, and Airplane.
//Contains attributes meant for all Vehicle types, and generic methods.

import java.util.Set;
import java.util.HashSet;

public abstract class Vehicle implements Drivable {
    //attributes - members - fields - variables//
    private static Set<Vehicle> registry = new HashSet<>();
    private float topSpeed;
    private float acceleration;
    private float currentSpeed;
    private Personnel driver;
    private Personnel[] occupants;

    //default constructor
    public Vehicle() throws ObjectLimitException
    {
        if (registry.size() > ObjectLimitException.MAX_INSTANCES) {
            throw new ObjectLimitException("Maximum number of Vehicle instances reached: " + ObjectLimitException.MAX_INSTANCES);
        }
        topSpeed = 100;
        acceleration = 10;
        currentSpeed = 0;
        driver = null;
        occupants = null;
        if (registry.contains(this)) {
            throw new IllegalArgumentException("Duplicate Personnel instance detected");
        }
        else {
            registry.add(this);
        }
    }
    //intended constructor
    public Vehicle(float topSpeed, float acceleration) throws ObjectLimitException
    {
        if (registry.size() >= ObjectLimitException.MAX_INSTANCES) {
            throw new ObjectLimitException("Maximum number of Personnel instances reached: " + ObjectLimitException.MAX_INSTANCES);
        }
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        currentSpeed = 0;
        driver = null;
        occupants = null;
        if (registry.contains(this)) {
            throw new IllegalArgumentException("Duplicate Personnel instance detected");
        }
        else {
            registry.add(this);
        }
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
    public Personnel getDriver() 
    { 
        return driver; 
    }
    protected Personnel[] getOccupants() 
    { 
        return occupants;
    }
    public int getVehicleCount()
    {
        return registry.size();
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
    public void setDriver(Personnel driver) 
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
