
/**
 * *****************************************************************************
 * This class is used to create pizza objects. Pizza objects objects have a
 * variety of attributes, including ingredients, calories per serving, 
 * the cost of the pizza, the cost of the remaining portion of pizza and
 * the pizza shape (some pizzas are round some are square). Pizzas also have
 * a fraction attribute which determines how much of the pizza is left. 
 * this attribute is reduced when someone eats a peice of pizza.
 * 
 * @author Bruce harr
 * @version 12.13.2015
 * 
 * @invariant - Pizza must always have a remaining ratio of (0,1]
 * @invariant - Pizzas are either square or circle in shape
 * @invariant - When a pizza is fully eaten it is discarded(no longer useable)
 * @invariant - Pizzas have a positive cost and calorie attribute associated
 */
public class Pizza implements PizzaComparable
{
    private Fraction remaining;
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private int totalCalories;
    private Money totalCost;
    private Money currentCost;
    private Shape pizzaShape;

    /**
     * A pizza constructor class. 
     * 
     * @exception: throws CloneNoteSupportedException
     */
    public Pizza() throws CloneNotSupportedException
    {
        remaining = new Fraction(1,1);
        totalCalories = 0;
        totalCost = new Money(0,0);
        currentCost = new Money(totalCost);

        //the shape of the pizza is chosen at random
        if(Math.random() > .5){
            this.setShape(new Circle(30,30,12));
        } else {
            this.setShape(new Square(30,30,15));
        }

    }

    /**
     * sets the remaining amount of pizza by reduceing it by some fraction
     * amount
     * 
     * @param reduce: the amount by which the pizza should be reduced
     */
    public void setRemaining(Fraction reduce)
    {
        remaining = remaining.subtract(reduce);
    }
    
    /**
     * returns the remaining amount of pizza as a fraction
     * 
     * @return Fraction: the amount of pizza remaining
     */
    public Fraction getRemaining()
    {
        return new Fraction(remaining);
    }

    /**
     * returns the current cost of the remaining portion of pizza
     * 
     * @return Money: 
     */
    public Money getCurrentCost()
    {
        return new Money(currentCost);
    }

    /**
     * returns the calories per serving of the pizza
     * 
     * @return int: the number of calories per serving of the pizza
     */
    public int getCurrentCalories()
    {
        return totalCalories;
    }

    /**
     * calculates and returns the remaining area of the pizza. Remaining area
     * is calucated as a product of the total area of the pizzas default shape
     * and the remaining fraction of the pizza that has not yet been eaten. 
     * 
     * @return int: the remaining area of the pizza
     */
    public int getRemainingArea()
    {
        return (int)(pizzaShape.getArea() * ((remaining.toValue())));
    }

    /**
     * returns a list of ingredients currently on the pizza
     * 
     * @return String: a list of the ingredients currently on the pizza
     */
    public String getIngredients()
    {
        String retVal = "[";

        for(int i = 0; i < ingredients.getIndex(); i++)
        {
            retVal += ingredients.get(i).getDescription() + " ";
        }
        //trim the final comma and close the engredients with bracket
        retVal = retVal.substring(0,retVal.length()-1);
        return retVal + "]";
    }

    /**
     * returns the total calories per servign of the pizza
     * 
     * @return int: the total calories per serving of a pizza
     */
    public int getTotalCalories()
    {
        return totalCalories;
    }

    /**
     * returns the total cost of the pizza as a Money Object
     * 
     * @return Money: the cost of the pizza
     */
    public Money getTotalCost()
    {
        return new Money(totalCost);
    }

    /**
     * Can be used to set the shape of the pizza to either cirlc or square
     * 
     * @param s: the shape being set
     * @exception:throws CloneNotSupportedException
     */
    public void setShape(Shape s) throws CloneNotSupportedException
    {
        this.pizzaShape =(Shape)s.clone();
    }

    /**
     * returns the shape of the pizza
     * 
     * @return Shape: the shape of the pizza
     * @exception: throws CloneNotSuportedException
     */
    public Shape getShape() throws CloneNotSupportedException
    {
        return (Shape)pizzaShape.clone();
    }

    /**
     * this method is used to add an ingredient to a pizza. After the ingredient
     * is added the calorie per serving and cost of the pizza are updated. 
     * 
     * @param ingAdd: the ingredient to be added
     */
    public void addIngredient(Ingredient ingAdd)
    {
        ingredients.insert(ingAdd);
        this.totalCost.add(ingAdd.getCost());
        this.currentCost.add(ingAdd.getCost());
        this.totalCalories += ingAdd.getCalories();
    }

    /**
     * This method reduces a fraction of the pizza from the whole as 
     * determined by the input parameters. 
     * 
     * @param amt: a fraction of the pizza to be consumed
     * @exception: throws PizzaException
     */
    public void eatSomePizza(Fraction amt) throws PizzaException
    {
        remaining = new Fraction(remaining.subtract(amt));

        if(remaining.getNumerator() == 0){
            this.currentCost = new Money(0.0);
            this.remaining = new Fraction(0,0);
            throw new PizzaException("Pizza is gone");
        } else if(remaining.getNumerator() < 0 
        || remaining.getDenominator() < 0) {
            throw new PizzaException("Cannot have negative Pizza");
        } else {
            //convert totalCost into double
            double tDol = totalCost.getDollars();
            double tcent = (double)totalCost.getCents()/100;
            double tCost = tDol + tcent;
            
            //price to subtract is totalcost * reduction fraction
            Money pSub = new Money(amt.toValue() * tCost);
            
            //convert price to subtract to double
            double sDol = pSub.getDollars();
            double sCent = (double)pSub.getCents()/100;
            double sCost = sDol + sCent;
            
            //convert current cost into a double
            double cDol = currentCost.getDollars();
            double cCent = (double)currentCost.getCents()/100;
            double cCost = cDol + cCent;

            //set current cost
            currentCost = new Money(cCost - sCost);
        }
    }

    /**
     * This method compares one pizza to another in terms of the cost of the
     * remaining pizza.
     * 
     * @return int: negative, 0, or positive depending on pizza cost
     */
    @Override
    public int compareTo(Object o)
    {
        Pizza compare = (Pizza)o;//cast o as a pizza object
        return this.getCurrentCost().compareTo(compare.getCurrentCost());
    }

    /**
     * This method compares one pizza to another in terms of size remaining. 
     * All pizzas start out with a size of 1 times the area of the pizza. 
     * As peices of the pizza are eaten, the fraction that is consumed is 
     * subtracted from one, reducing the pizza size. 
     * 
     * @return int: negative, 0, or positive depending on pizza surface area
     */
    @Override
    public int compareToBySize(Object o)
    {
        Pizza compare = (Pizza)o;//cast o as a pizza object
        return (int)(this.getRemainingArea() - compare.getRemainingArea());
    }

    /**
     * This method compares one pizza to another in terms of calorie count
     * per serving. 
     * 
     * @return int: negative, 0, or positive depending on calorie comparison
     */
    @Override
    public int compareToByCalories(Object o)
    {
        Pizza compare = (Pizza)o;//cast o as a pizza object
        return this.getTotalCalories() - compare.getTotalCalories();
    }

    /**
     * this method outputs the pizza as a String. it countains all of the 
     * key data points of a pizza in a human readable format
     * 
     * @return String: the pizza description in HR format
     */
    @Override
    public String toString()
    {
        String retVal = "Amount remaining: ";
        retVal += this.getRemaining();
        retVal += " Remaining area: ";
        retVal += getRemainingArea();
        retVal += " Ingredients: ";
        retVal += this.getIngredients();
        retVal += " Calories: ";
        retVal += this.getCurrentCalories();
        retVal += " Total Cost: ";
        retVal += this.getCurrentCost();
        retVal += " Pizza Shape: ";
        retVal += this.pizzaShape.getShape();

        return retVal;
    }
}
