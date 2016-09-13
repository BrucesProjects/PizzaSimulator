
/**
 * A class for creating an Alfredo object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Alfredo extends Base
{ 
    private static final String DESCRIPTION = "Alfredo";
    private static final Money COST = new Money(0.75);
    private static final int CALORIES = 135;

    /**
     * A constructor for creating an Alfredo Object
     */
    public Alfredo()
    {
        super(DESCRIPTION, COST, CALORIES);
    }
}
