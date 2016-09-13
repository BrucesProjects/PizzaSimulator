
/**
 * The fraction class is used to build fraction objects. Fractions can be
 * created with two integers (numerator and denominator), no input, or
 * a properly formatted String ("[int]/[int]"). This class includes 
 * getters and setters as well as a method for reducing fractions using
 * euclidian algorithm, comparing fractions for equality, and a toString
 * method.  
 * 
 * @author Bruce Harr
 * @version 12/11/2015
 * *****************************************************************************
 */
public class Fraction implements Comparable<Fraction>
{
    private final int NUM; //the numerator value in a fraction
    private final int DEN; //the denominator value in a fraction

    /**
     * Constructor for building a fraction that can be rationalized with 
     * two integers. 
     * 
     * @param n: the fraction numerator
     * @param d: the fraction denominator
     */
    public Fraction(int n, int d)
    {
        //reduce the input num and den
        String fractionString = reduce(n, d);

        //split the return String into ints (num & den)
        String[] split = fractionString.split("/");
        int n1 = Integer.parseInt(split[0]);
        int d1 = Integer.parseInt(split[1]);

        //set the final NUM and DEN
        NUM = n1;
        DEN = d1;
    }

    /**
     * This method converts a properly formatted String into an Fraction object
     * 
     * The first part of the euclidian algorithm is to divide the lower of the 
     * two variables into the larger and then replace the larger number with
     * the remainder of the two. This process should repeat until the remainder
     * equals 0.
     * 
     * The second part to the Euclidian algorithm is the return the lowest 
     * reduced value (remainder) just before the final 0 remainder is found.
     * This number will be used to divide the original numerator and 
     * denominator and ultimately find the GCD.
     * 
     * @param String: the fraction to be created in String format
     */
    public Fraction(String fraction)
    {
        if(fraction.equals("1"))
        {
            NUM = 1;
            DEN = 1;
        } else if(fraction.equals("0")) {
            NUM = 0;
            DEN = 1;
        } else {
            //Split the input String so that num and den can be reduced
            String[] split = fraction.split("/");
            int n = Integer.parseInt(split[0]);
            int d = Integer.parseInt(split[1]);

            //reduce the num & den
            String fractionString = reduce(n, d);

            //split the return String into ints
            String[] split1 = fractionString.split("/");
            int n1 = Integer.parseInt(split1[0]);
            int d1 = Integer.parseInt(split1[1]);

            //set the final num and den
            NUM = n1;
            DEN = d1;
        }
    }

    /**
     * Copy Constructor for building a fraction that can be rationalized  
     * with two integers. 
     * 
     * @param: a fraction template for constructing a new Fraction
     */
    public Fraction(Fraction inFraction)
    {
        int n = inFraction.getNumerator();
        int d = inFraction.getDenominator();

        //reduce the num & den (just in case)
        String fractionString = reduce(n, d);

        //split the return String into ints (num & den)
        String[] split = fractionString.split("/");
        int n1 = Integer.parseInt(split[0]);
        int d1 = Integer.parseInt(split[1]);

        //set the final NUM and DEN
        NUM = n1;
        DEN = d1;
    }

    /**
     * This method reduces a fraction using Euclidian Algorithm
     * 
     * @param num: the fraction's numerators
     * @param den: The fraction's denominator
     * @return String: the reduced fraction as a String
     */
    public String reduce(int num, int den)
    {
        //if the numerator is 0, the fraction cannot be reduced
        if(num == 0)
        {
            return num + "/" + den; 
        }

        int num1 = Math.max(num, den);
        int num2 = Math.min(num, den);

        //Calculate the GCD 
        while (num2 != 0)
        {
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        //GCD is num1, reduce the original numerator and denomenator
        num /= num1;
        den /= num1;
        //returns the reduced fraction as a String
        return num + "/" + den;
    }

    /**
     * returns the num of a fraction
     * 
     * @return int: the numerator of this.fraction
     */
    public int getNumerator()
    {
        return NUM;
    }

    /**
     * returns the den of a fraction
     * 
     * @return int: the denominator of this.fraction
     */
    public int getDenominator()
    {
        return DEN;
    }

    /**
     * A method for subtracting one fraction from another
     * 
     * @return Fraction: the difference of two fractions
     */
    public Fraction subtract(Fraction subF)
    {
        //this handles subtracting from fractions with a zero in the num
        if(this.getNumerator() == 0)
        {
            //convert subF into 2 ints
            int subNum = subF.getNumerator()*-1;
            int subDen = subF.getDenominator();

            return new Fraction(subNum, subDen);
        }

        //Find the denominator of both fractions
        int int1 = this.getDenominator();
        int int2 = subF.getDenominator();

        //multiply the frist fraction by den/den of the second fraction
        int f1Num = this.getNumerator()*int2;
        int f1Den = this.getDenominator()*int2;

        //multiply the second fraction by den/den of the first fraction
        int f2Num = subF.getNumerator()*int1;
        int f2Den = subF.getDenominator()*int1;

        //once a common denomenator is established, the new fraction can be 
        //created
        Fraction f3 = new Fraction(f1Num - f2Num, f1Den);

        return new Fraction(f3);
    }

    /**
     * compares the denomenator and numerator of two fractions. If both 
     * elements match between the two fractions, this method will return true.
     * 
     * @return boolean: returns true if two fractions are equal, else false
     */
    public boolean equals(Fraction that)
    {
        boolean retVal = false;
        if(this.NUM == that.NUM && this.DEN == that.DEN)
        {
            retVal = true;
        }
        return retVal;
    }

    /**
     * a toString method designed specifically for a fraction class. this
     * method formats the fraction into human readable format and returns it
     * as a String.
     * 
     * @return String: the fraction as a String (num/den)
     */
    public String toString()
    {
        String retVal = NUM + "/" + DEN;
        return retVal;
    }

    /**
     * Converts a fraction into double format for the ease of mathmatical
     * operations. 
     * 
     * @return double: a rational expression of the fraction as a double
     */
    public double toValue() {
        return (double)this.getNumerator() / this.getDenominator();
    }

    /**
     * Compares two fractions based on their rational value
     * 
     * @return int: negative, 0, or positive
     */
    public int compareTo(Fraction compare)
    {
        if(this.toValue() > compare.toValue())
            return 1;
        else if(this.toValue() < compare.toValue())
            return -1;
        else 
            return 0;
    }
}
