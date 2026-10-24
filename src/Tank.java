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
    public Tank() throws ObjectLimitException
    { //default
        super();
        shellCount = 3;
        gunner = null;
        aimSpeed = 5;
        target = null;
        isLocked = false;
        isLoaded = false;
    }

    public Tank(float topSpeed, float acceleration, int shellCount, float aimSpeed) throws ObjectLimitException
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
    public void drive() throws IllegalPilotException
    {
        if(this.getDriver() instanceof Alien){
            throw new IllegalPilotException("ALIEN DETECTED! Initiating Self Destruct Sequence:");
        }
        System.out.println("Tank is rolling");
    }
    public double checkFuel()
    {
        return 20.5;
    }
    public void fuelUp()
    {
        System.out.print("\nThe tank is now fully fueled");
    }
    public void startEngine()
    {
        System.out.print("\nStarting engine, tank is powered on.");
    }

    public boolean fireAtTarget()
    {
        boolean fired = true;
        String message = "\n";
        if (!isLocked || shellCount <= 0)
        {           
            message += "Not locked\n";
            fired = false;   
        }
        if (!isLoaded)
        {
            message += "Not loaded\n";
            fired = false;
        }
        if (target == null)
        {
            message += "No Target\n";
            fired = false;
        }
        if (shellCount < 1)
        {
            message += "No ammo\n";
            fired = false;
        }
        if (!fired)
        {
            System.out.print(message);
            return false;
        }
        shellCount--;
        isLoaded = false;
        target.stop();
        return true;
    }

    public void loadShell()
    {
        System.out.print("\nShell loaded");
        isLoaded = true;
    }

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
        gunner = null;
        setOccupants(null);
    }

    //TODO: specialized functions for Tank
}
