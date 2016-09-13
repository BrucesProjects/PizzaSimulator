
/**
 * A class for creating a Meat object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Meat extends Ingredient
{
    /**
     * A constructor for creating a base Object
     * 
     * @param name: the name of the base
     * @param cost: the cost of the base
     * @param calories: the calories per serving of the base
     */
    public Meat(String name, Money cost, int calories)
    {
		super(name, cost, calories);
    }
}
