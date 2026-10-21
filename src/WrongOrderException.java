package src;

public class WrongOrderException extends Exception {
    /*THE IDEA:
    This exception is thrown when the user executes the wrong order of operations to complete the task in Main.
    */
    public WrongOrderException(String message) {
        super(message);
    }
}
