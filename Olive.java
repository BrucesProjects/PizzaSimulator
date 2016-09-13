import java.awt.Color;
/**
 * A class for creating an Olive object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Olive extends Vegetable
{
    private static final String DESCRIPTION = "Olive";
    private static final Money COST = new Money(1.25);
    private static final int CALORIES = 65;
    
    /**
     * A constructor for creating an Olive Object
     */
    public Olive(Color inColor)
    {
        super(DESCRIPTION, COST, CALORIES, inColor);
    }
}
