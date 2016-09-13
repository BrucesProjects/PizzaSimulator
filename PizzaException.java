
/**
 * A simple exception class for Pizza Class
 * 
 * @author Bruce Harr 
 * @version 13.11.2015
 */
public class PizzaException extends Exception
{     
    /**
     * A no args exception that throws a default error message
     */
    public PizzaException()
    {
        super("Invalid Linked List Operation.");
    }

    /**
     * A modifiable exception that throws an input String as an 
     * error message
     * 
     * @param String error - the message to be thrown
     */
    public PizzaException(String error)
    {
        super(error);
    }
}

