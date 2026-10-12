public interface HumanDrivable extends Drivable
{
    /* sets the gunner of this vehicle */
    void setDriver(Personnel gunner);

    /* returns the gunner of the vehicle, null if none */
    Personnel getGunner();

    /* check the fuel level fo the vehicle */
    double checkFuel();

    /* fills the vehicle with fuel */
    void fuelUp();

    /* starts the combustion engine */
    void startEngine();
    
}
