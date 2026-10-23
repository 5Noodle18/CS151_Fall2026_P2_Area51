package src;

public class ObjectLimitException extends Exception {
    /*THE IDEA:
    Each class supports a maximum of x instances.
    When the x+1 object is instantiated, we have to throw this exception
    */

    private final static int MAX_INSTANCES = 100;

    public ObjectLimitException(String message) {
        super(message);
    }

    public static int getMaxInstances() {
        return MAX_INSTANCES;
    }
}
