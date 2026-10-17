package src;
//Tank inherits from Vehicle.
//It is designed to aim at and target other Vehicle types.

public class Tank extends Vehicle implements HumanDrivable{
    //attributes - members - fields - variables//
    private int shellCount;
    private Personnel gunner;
    private float aimSpeed;
    private Vehicle target;
    private boolean isLocked;
    private boolean isLoaded;

    //constructors
    public Tank()
    { //default
        super();
        shellCount = 3;
        gunner = null;
        aimSpeed = 5;
        target = null;
        isLocked = false;
        isLoaded = false;
    }

    public Tank(float topSpeed, float acceleration, int shellCount, float aimSpeed) 
    { //intended default
        super(topSpeed, acceleration);
        this.shellCount = shellCount;
        this.aimSpeed = aimSpeed;
        gunner = null;
        target = null;
        isLocked = false;
        isLoaded = false;
    }

    //getters
    public int getShellCount() 
    {
        return shellCount;
    }
    public Personnel getGunner() 
    {
        return gunner;
    }
    public float getAimSpeed()
    {
        return aimSpeed;
    }
    public Vehicle getTarget()
    {
        return target;
    }
    public boolean isLocked() 
    {
        return isLocked;
    }
    public boolean isLoaded()
    {
        return isLoaded;
    }
    //setters
    public void setShellCount(int shellCount) 
    {
        this.shellCount = shellCount;
    }
    public void setGunner(Personnel gunner)
    {
        this.gunner = gunner;
    }
    public void setAimSpeed(float aimSpeed)
    {
        this.aimSpeed = aimSpeed;
    }
    public void setTarget(Vehicle target) 
    {
        this.target = target;
    }
    public void setIsLocked(boolean isLocked) 
    {
        this.isLocked = isLocked;
    }
    public void setIsLoaded(boolean isLoaded)
    {
        this.isLoaded = isLoaded;
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
        System.out.println("rolling");
    }
    public double checkFuel()
    {
        return 20.5;
    }
    public void fuelUp()
    {
        System.out.println("The tank is now fully fueled");
    }
    public void startEngine()
    {
        System.out.println("Starting engine, tank is powered on");
    }

    public boolean fireAtTarget()
    {
        if (!isLocked || !isLoaded || target == null || shellCount <= 0)
            return false;

        shellCount--;
        isLoaded = false;
        target.stop();
        return true;
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
        gunner = null;
        occupants = null;
    }

    //TODO: specialized functions for Tank
}
