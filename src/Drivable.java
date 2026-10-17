package src;
public interface Drivable
{
    /* sets the driver of the vehicle */
    void setDriver(Personnel driver);

    /* returns the driver of the vehicle, null if none */
    Personnel getDriver();

    void drive();

}
