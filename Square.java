import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * This class is used to create a Square Object. 
 * 
 * @author Bruce Harr
 * @version 11.12.2015
 */

public class Square extends Shape implements Cloneable
{
    private int length;
    public static final String shape = "Square";

    /**
     * Default no args Constructor
     */    
    public Square()
    {
        super(0,0);
        super.setShape(this.shape);
        this.length = 40;
    }

    /**
     * Constructor with args
     * 
     * @param inX: the x value for the new square
     * @param inY: the y value for the new square
     * @param inLength: the length of the new square
     */
    public Square(int inX, int inY, int inLength)
    {
        super(inX, inY);
        super.setShape(this.shape);
        this.length = inLength;
    }
    
    /**
     * A constructor that uses an existing Square as a template
     * 
     * @Param copy - the Square being copied.
     */
    public Square(Square copy)
    {
        super(copy.getX(), copy.getY());
        super.setShape(copy.shape);
        this.length = copy.getLength();
    }

    /**
     * calcluates area of a square length * length
     * 
     * @return double: the area of the square
     */
    public double getArea()
    {
        return length * length;
    }

    /**
     * setter method for length
     * 
     * @param inLenght: the lenght of the square
     */
    public void setLength(int inLength)
    {
        this.length = inLength;
    }

    /**
     * getter method for length
     * 
     * @return int: the lenght of this.square
     */
    public int getLength()
    {
        return this.length;
    }
    
    /**
     * Getter method for shape description
     * 
     * @return String: the description of the shape ("Square")
     */
    public String getShapeDescription()
    {
        return this.shape;
    }

    /**
     * draws a Green Square
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(getX(), getY(), length, length);
    }

    /**
     * Returns all Square properties as a String
     * 
     * @return String: a detailed description of the Square
     */
    public String toString()
    {
        return super.toString() + ", Length: " + this.getLength() 
                                + ", Area: " + this.getArea();
    }
    
    /**
     * Creates and returns a clone of this.Square
     * 
     * @return Shape: a clone of this.Square
     */
    @Override
    public Shape clone() {
        return new Square(this);
    }
}
