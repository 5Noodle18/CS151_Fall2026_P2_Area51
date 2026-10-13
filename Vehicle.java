//Vehicle is meant to be conceptual superclass of Tank, UFO, and Airplane.
//Contains attributes meant for all Vehicle types, and generic methods.

public abstract class Vehicle {
    //attributes - members - fields - variables//
    protected float topSpeed;
    protected float acceleration;
    protected float currentSpeed;
    protected Personnel driver;
    protected Personnel[] occupants;

    //Typically, getters/setters go here. We will allow subclasses to define the access level of variables.
    //This is the reason I used protected access modifier.

    //functions - methods//
    public abstract boolean start();

    public abstract float drive(float seconds);

    public abstract void stop();

    public abstract void destroy();
}
