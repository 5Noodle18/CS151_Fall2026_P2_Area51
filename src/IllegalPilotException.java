package src;

public class IllegalPilotException extends Exception {
    /*THE IDEA:
    This exception is thrown when a pilot tries to drive a vehicle that they are not allowed to drive.
    Often thrown in blocks that try drive() which checks the interface Vehicle implements and the Personnel.
    */

    public IllegalPilotException(String message) {
        super(message);
    }

}
