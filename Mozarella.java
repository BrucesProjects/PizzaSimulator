
/**
 * A class for creating a Mozarella object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Mozarella extends Cheese
{
    private static final String DESCRIPTION = "Mozarella";
    private static final Money COST = new Money(1.25);
    private static final int CALORIES = 65;
    
    /**
     * A constructor for creating a Mozarella Object
     */
    public Mozarella()
    {
        super(DESCRIPTION, COST, CALORIES);
    }
}
