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
    public void setTopSpeed(float speed) 
    {
        topSpeed = speed;
    }
    public void setAcceleration(float acceleration) 
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
