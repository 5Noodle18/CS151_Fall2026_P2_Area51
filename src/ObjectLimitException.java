package src;

public class ObjectLimitException extends Exception {
    /*THE IDEA:
    Each class supports a maximum of x instances.
    When the x+1 object is instantiated, we have to throw this exception
    */

    public ObjectLimitException(String message) {
        super(message);
    }
}
