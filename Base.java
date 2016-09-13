
/**
 * A class for creating a Base object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Base extends Ingredient
{
    /**
     * A constructor for creating a base Object
     * 
     * @param name: the name of the base
     * @param cost: the cost of the base
     * @param calories: the calories per serving of the base
     */
    public Base(String name, Money cost, int calories)
    {
        super(name, cost, calories);
    }
}
