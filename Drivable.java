public interface Drivable
{
    /* sets the driver of the vehicle */
    void setDriver(Personnel driver);

    /* returns the driver of the vehicle, null if none */
    Personnel getDriver();

    /* gets the vehicle going, but only if its power source is on */
    void move();

    /* stops the vehicle */
    void stop();

}
