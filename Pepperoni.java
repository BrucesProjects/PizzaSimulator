
/**
 * A class for creating a Pepperoni object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Pepperoni extends Meat
{
    private static final String DESCRIPTION = "Pepperoni";
    private static final Money COST = new Money(1.50);
    private static final int CALORIES = 160;
    
    /**
     * A constructor for creating a base Pepperoni
     */
    public Pepperoni()
    {
        super(DESCRIPTION, COST, CALORIES);
    }
}
