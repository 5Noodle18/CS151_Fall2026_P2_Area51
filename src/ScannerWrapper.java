package src;

import java.util.Scanner;

public class ScannerWrapper {
    private static final ScannerWrapper instance = new ScannerWrapper();
    private final Scanner scanner = new Scanner(System.in);
    private static boolean hasInt;

    public ScannerWrapper() {}

    public static ScannerWrapper getInstance()
    {
        return instance;
    }

    /**
     * Gets the user's input, helper function for other read functions
     * @return a String to be used by other functions
     */
    private String readInput()
    {
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("EXIT"))
        {
            System.out.print("\nExiting Program\n");
            System.exit(0);
        }
        return input;
    }

    /**
     * @return the users input as an int
     */
    public int readInt()
    {
        int input;
        try
        {
            input = Integer.parseInt(readInput());
            hasInt = true;
            return input;
        }
        catch (NumberFormatException e) {}

        hasInt = false;
        return -6767; // error code funy haha
    }

    /**
     * must have called readInt() before this, or it will be stale
     * @return if true if the last thing read was an int
     */
    public boolean hasInt()
    {
        return hasInt;
    }

    /**
     * @return the users input as a String
     */
    public String readString()
    {
        return readInput();
    }

    /**
     * 
     * @param prompt what to ask the user
     * @param min int ower limit
     * @param max int upper limit
     * @return a number representing user choice from min to max
     */
    public int readChoice(String prompt, int min, int max)
    {
        while(true)
        {
            System.out.print(prompt);
            String input = readInput().trim();
            try 
            {
                int choice = Integer.parseInt(input);
                if (min <= choice && choice <= max)
                {
                    return choice;
                }
            }
            catch (NumberFormatException ignored) {} // if the user inputs not a number
            // prompt user to try again
            System.out.print("\nIF THE CHOICE IS NOT FROM " + min + " TO " + max + ", YOU WILL BE NEUTRALIZED!\nTRY AGAIN: ");
        }
    }
}
