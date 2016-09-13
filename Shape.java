import java.awt.*;

/* Class Shape
 *
 * By Rob Nash
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)
public abstract class Shape extends Object implements Cloneable
{
    private int x = 0;
    private int y = 0;
    public String shape;

    public Shape(int a, int b) 
    {
        x=a;
        y=b;
    }

    public double getArea()
    { 
        return -1; 
    }
    
    public int getX() 
    {
        return x; 
    }

    public int getY() 
    { 
        return y; 
    }
    
    public void setX(int inX)
    {
        this.x = inX;
    }
    
    public void setY(int inY)
    {
        this.y = inY;
    }
    
    public void setShape(String shapeName)
    {
        this.shape = shapeName;
    }
    
    public String getShape()
    {
        return this.shape;
    }
    
    public String toString()
    {
        return "coordinates: (" + this.getX() + ", " + this.getY() + ")";
    }
    
    public boolean equals(Shape that)
    {
        return this.getX() == that.getX() && this.getY() == that.getY();
    }
    
    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape retVal = (Shape)super.clone();
        return retVal;
    }
}