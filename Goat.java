
/**
 * A class for creating a Goat (cheese) object to be added 
 * to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Goat extends Cheese
{
    private static final String DESCRIPTION = "Goat";
    private static final Money COST = new Money(1.50);
    private static final int CALORIES = 45;
    
    /**
     * A constructor for creating a Goat Object
     */
    public Goat()
    {
        super(DESCRIPTION, COST, CALORIES);
    }
}
