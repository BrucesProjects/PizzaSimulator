
/**
 * A class for creating a Marinara object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Marinara extends Base
{
    private static final String DESCRIPTION = "Marinara";
    private static final Money COST = new Money(0.75);
    private static final int CALORIES = 110;
    
    /**
     * A constructor for creating a Marinara Object
     */
    public Marinara()
    {
        super(DESCRIPTION, COST, CALORIES);
    }
}
