package src;
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
