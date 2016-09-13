import java.awt.Color;
/**
 * *****************************************************************************

 * A class for creating a Vegetable object to be added to a pizza.
 * 
 * @author Bruce Harr 
 * @version 12.13.2015
 */
public class Vegetable extends Ingredient
{
    Color myColor;

    /**
     * A constructor for creating a base Object
     * 
     * @param name: the name of the base
     * @param cost: the cost of the base
     * @param calories: the calories per serving of the base
     */
    public Vegetable(String name, Money cost, int calories)
    {
        super(name, cost, calories);
        myColor = new Color(0,0,0);
    }

    /**
     * A constructor that includes color in the input parameters
     * 
     * @param name: the name of the base
     * @param cost: the cost of the base
     * @param calories: the calories per serving of the base
     * @param Color: the color of the vegetable
     */
    public Vegetable(String name, Money cost, int calories, Color inColor)
    {
        super(name, cost, calories);
        myColor = inColor;
    }

    /**
     * A getter method for the vegetable color
     * 
     * @return Color: the color of the vegetable
     */
    public Color getColor()
    {
        int r = myColor.getRed();
        int g = myColor.getGreen();
        int b = myColor.getBlue();
        
        Color retVal = new Color(r, g, b);
        return retVal;
    }

    /**
     * A setter method for the vegetable color
     * 
     * @param inColor: the color of the vegetable
     */
    public void setColor(Color inColor){
        int r = inColor.getRed();
        int g = inColor.getGreen();
        int b = inColor.getBlue();
        
        myColor = new Color(r, g, b);
    }

    /**
     * Converts a vegetable to a human readable String by calling
     * the super class toString method and appending the vegetable
     * color
     * 
     * @return String: the vegetable in a HR string format
     */
    public String toString(){
        return super.toString() + " \t" + myColor.toString();
    }

    /**
     * an equals method that looks at two vegeatables to see if they 
     * are equal. Comparison is based on the super equals method call
     * and by comparing the vegetable color attribute. 
     * 
     * @return boolean: returns true if the colors match, false if not
     */
    public boolean equals(Vegetable compare) {
        return super.equals(compare) && this.myColor.equals(compare.myColor);
    }
}
