import java.awt.*;
/**
 * *****************************************************************************
 * This class is used to create a Cirle. 
 * 
 * @author Bruce Harr
 * @version 12.13.2015
 */
public class Circle extends Shape implements Cloneable
{
    private int radius;
    public static final double PI = Math.PI;
    public static final String shape = "Circle";

    /**
     * Default no args Constructor
     */
    public Circle()
    {
        super(0,0);
        super.setShape(this.shape);
        this.radius = 20;
    }

    /**
     * Constructor with args
     * 
     * @param inX: the x value for the new circle
     * @param inY: the y value for the new circle
     * @param inRadius: the radius of the new circle
     */
    public Circle(int inX, int inY, int inRadius)
    {
        super(inX, inY);
        super.setShape(this.shape);
        this.radius = inRadius;
    }
    
    /**
     * A constructor that uses an existing circle as a template
     * 
     * @Param copy - the circle being copied.
     */
    public Circle(Circle copy)
    {
        super(copy.getX(), copy.getY());
        super.setShape(copy.shape);
        this.radius = copy.getRadius();
    }

    /**
     * Setter method for radius
     * 
     * @Param inRadius: the value to be set as the new radius
     */
    public void setRadius(int inRadius)
    {
        this.radius = inRadius;
    }

    /**
     * Getter method for radius
     * 
     * @return: the radius of this.circle
     */
    public int getRadius()
    {
        return this.radius;
    }
    
    /**
     * Getter method for shape description
     * 
     * @return String: the description of the shape ("circle")
     */
    public String getShapeDescription()
    {
        return this.shape;
    }

    /**
     * calculates circle area with the formula PI r^2
     * 
     * @return double: the area of the circle
     */
    public double getArea()
    {
        return PI * radius * radius;
    }

    /**
     * draws a black circle
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillOval(getX(), getY(), radius * 2, radius * 2);
    }

    /**
     * Returns all circle properties as a String
     * 
     * @return String - a detailed description of the circle
     */
    public String toString()
    {
        return super.toString() + ", Width: " + this.getRadius() 
                            + ", Area: " + this.getArea();
    }
    
    /**
     * Creates and returns a clone of this.Circle
     * 
     * @return Shape: a clone of this.Circle
     */
    @Override
    public Shape clone() {
        return new Circle(this);
    }
}
