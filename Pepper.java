import java.awt.Color;
/**
 * A class for creating a Pepper object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Pepper extends Vegetable
{
    private static final String DESCRIPTION = "Pepper";
    private static final Money COST = new Money(0.65);
    private static final int CALORIES = 25;

    /**
     * A constructor for creating a Pepper Object
     */
    public Pepper(Color inColor)
    {
        super(DESCRIPTION, COST, CALORIES, inColor);
    }
}
