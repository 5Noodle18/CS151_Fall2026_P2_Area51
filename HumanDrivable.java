public interface HumanDrivable extends Drivable
{
    /* check the fuel level fo the vehicle */
    double checkFuel();

    /* fills the vehicle with fuel */
    void fuelUp();

    /* starts the combustion engine */
    void startEngine();
    
}
