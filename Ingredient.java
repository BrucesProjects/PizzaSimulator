
/**
 * *****************************************************************************

 * Ingredient is an abstract class for any ingredients that may go on a pizza. 
 * Ingredients all have a certain calory per serving value as well as a cost
 * to include on the pizza and description as a String
 * 
 * @author Bruce Harr
 * @version 12.13.2015
 */
public class Ingredient extends Object implements Comparable<Ingredient>
{
    private String description; //What is the ingredient called?
    private Money cost; //How much does it cost?
    private int calories; //How many calories per serving does it have?

    /**
     * A no args default constructor for making an ingredient object. 
     * by default the ingredient name is null and it has no calories
     */
    public Ingredient()
    {
        setDescription(null);
        setCalories(0);
    }

    /**
     * An ingredient constructor that takes arguments
     * 
     * @param name: the name of the ingredient
     * @param price: the price of the ingredient
     * @param calorieCount: number of calories per serving in the ingredient
     */
    public Ingredient(String name, Money price, int calorieCount)
    {
        setDescription(name);
        setCost(price);
        setCalories(calorieCount);
    }

    /**
     * A copy constructor
     * 
     * @param ing: the ingredient to be copied
     */
    public Ingredient(Ingredient ing)
    {
        setDescription(ing.getDescription());
        setCost(ing.getCost());
        setCalories(ing.getCalories());
    }

    /**
     * a setter method for the Description attribute
     * 
     * @param name: the name of the Ingredient
     */
    public void setDescription(String name)
    {
        this.description = name;
    }

    /**
     * A setter for the cost attribute
     * 
     * @param price: the price of the ingredient
     */
    public void setCost(Money price)
    {
        cost = new Money(price);
    }

    /**
     * a setter for the calories attribute
     * 
     * @param calorieCount: the number of calories per serving of an ingredient
     */
    public void setCalories(int calorieCount)
    {
        this.calories = calorieCount;
    }

    /**
     * A getter for the ingredient description
     * 
     * @return String: the name of the ingredient
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * A getter for the ingredient cost
     * 
     * @return Money: the cost of the ingredient
     */
    public Money getCost()
    {
        Money retVal = new Money(this.cost);
        return retVal;
    }

    /**
     * A getter for the ingredient caloires
     * 
     * @return int: the number of calories per serving of the ingredient
     */
    public int getCalories()
    {
        return this.calories;
    }

    /**
     * A method for converting an ingredient into a human readable String
     * 
     * @return String: the ingredient as a human readable String
     */
    public String toString()
    {
        String retVal = "Ingredient: ";
        retVal += this.getDescription();
        retVal += " \tCost: " + getCost().toString();
        retVal += " \tCalories: " + getCalories();

        return retVal;
    }

    /**
     * A method for checking whether two ingredients are the same. 
     * 
     * @return boolean: true if ingredients match, false if they do not
     */
    public boolean equals(Ingredient compare)
    {
        if(this.getDescription().equals(compare.getDescription())
        && this.getCost().equals(compare.getCost())
        && this.getCalories() == compare.getCalories())
            return true;
        else{
            return false;
        }
    }
    
    /**
     * A method for comparing two ingredients by price. 
     * 
     * @return int: negative, 0, or positive depending on the comparison
     */
    public int compareTo(Ingredient compare)
    {
        return this.cost.compareTo(compare.cost);
    }
}
