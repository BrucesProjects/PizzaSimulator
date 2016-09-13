
/**
 * A class for creating a Sausage object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Sausage extends Meat
{
    private static final String DESCRIPTION = "Sausage";
    private static final Money COST = new Money(1.50);
    private static final int CALORIES = 180;

    /**
     * A constructor for creating a Sausage Object
     */
    public Sausage()
    {
        super(DESCRIPTION, COST, CALORIES);
    }
}
