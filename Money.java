
/**
 ********************************************************************************
 * The Money class builds objects that store integer variables for dollars and
 * cents.
 * 
 * @author Bruce Harr 
 * @version 11.13.2015
 * @invariant 0 <= cents <=99
 * @invariant 0 <= dollars
 */
public class Money implements Comparable<Money>
{
    private int dollars; //stores dollars value
    private int cents; //stores cents value

    /**
     * Constructor that initializes dollars to the value of the input parameter
     * assuming input parameter passes check to validate class invariant. Cents
     * is initialized to 0.
     * 
     * @param - int d: integer to be stored as dollars for new money object
     */
    public Money(int d)
    {
        this.dollars = checkDollars(d);
    }

    /**
     * Constructor that initializes both dollars and cents to the values of
     * the input parameters assuming they pass checks to validate class
     * invariants. 
     * 
     * @param - int d: integer to be stored as dollars for new money object
     * @param - int c: integer to be stored as cents for new money object
     */
    public Money(int d, int c)
    {
        this.dollars = checkDollars(d);
        this.cents = checkCents(c);
    }

    /**
     * Constructor method that takes as input a double and converts it to 
     * Money. 
     * 
     * @param amount: the amount to be turned into a money object
     */
    public Money(double amount)
    {
        this.dollars = (int)amount;
        this.cents = (int)((amount - this.dollars)*100);
    }

    /**
     * Constructor that creates a copy of an existing Money object to create a
     * new Money object. Arguably the checkDollars() and checkCents() methods
     * may not be necessary for this method, however they have been included 
     * as a safety check. 
     * 
     * @param - Money other: 
     */
    public Money(Money other)
    {
        if(other == null) //not a real money object
        {
            System.out.println("Null money object used");
            System.exit(0);
        }

        this.dollars = checkDollars(other.dollars);
        this.cents = checkCents(other.cents);
    }

    /**
     * Getter method used to return the value of private variable dollars
     * 
     * @return - int retVal: the value stored as dollars of this money object
     */
    public int getDollars()
    {
        int retVal = this.dollars;
        return retVal;
    }

    /**
     * Getter method used to return the value of private variable cents
     * 
     * @return - int retVal: the value stored as cents of this money object
     */
    public int getCents()
    {
        int retVal = this.cents;
        return retVal;
    }

    /**
     * Getter that returns a Money object as a double (dollars.cents).
     * 
     * @return - double: dollars and cents combined as a double
     */
    public double getMoney()
    {
        return this.dollars + (double)this.cents/100;
    }

    /**
     * Setter method used to set the value of this.dollars. Value must be 
     * checked to ensure that it complies with class invariants before
     * it is allowed to be initialized. 
     * 
     * @param - int d: integer to be stored as dollars for this money object
     */
    public void setDollars(int d)
    {
        this.dollars = checkDollars(d);
    }

    /**
     * Setter method used to set the value of this.cents. Value must be 
     * checked to ensure that it complies with class invariants before
     * it is allowed to be initialized. 
     * 
     * @param - int c: integer to be soted as cents for this money object
     */
    public void setCents(int c)
    {
        this.cents = checkCents(c);
    }

    /**
     * Setter method usedto setthe value of both dollars and cents 
     * for this Money object. This method utilizes methods already
     * created for setting dollars and cents (setDolalrs & setCents).
     * 
     * @param - int d: integer to be stored as dollars for this money object
     * @param - int c: integer to be soted as cents for this money object
     */
    public void setMoney(int d, int c)
    {
        this.setDollars(d);
        this.setCents(c);
    }

    /**
     * This method takes as input some integer intended to be stored as 
     * cents, and verifies that it does not violate any class invariants.
     * If no excpetions are thrown, this class returns an integer that is 
     * save to use for cents. 
     * 
     * @param - int input: an integer intended to be stored as cent 
     * @return - int input: only those ints that don't throw exceptions
     */
    public int checkCents(int input)
    {
        if(input < 0)
        {
            System.out.println("Cannot have negative cents!");
            return 0;
        } else if (input > 99) {
            System.out.println("Cannot have more than 99 cents!");
            return 0;
        }

        return input;
    }

    /**
     * This method takes as input some integer intended to be stored as 
     * dollars, and verifies that it does not violate any class invariants.
     * If no excpetions are thrown, this class returns an integer that is 
     * save to use for dollars. 
     * 
     * @param - int input: an integer intended to be stored as dollar 
     * @return - int input: only those ints that don't throw exceptions
     */
    public int checkDollars(int input)
    {
        if(input < 0)
        {
            System.out.println("Cannot have negative Dollars!");
            return 0;
        }
        return input;
    }

    /**
     * This method takes as input a dollar amount and then adds
     * it to an existing instance of Money. This method allows for negative
     * adds, however it will throw an exception if the sum value of dollars
     * and the new input amount is not positive. 
     * 
     * @param - int d: the amount to be added to this.dollars
     */
    public void add(int d)
    {
        int newAmount = this.dollars + d;
        this.dollars = checkDollars(newAmount);
    }

    /**
     * This method takes as input an amount that represents dollars
     * and an amount that represents cents and then adds them both
     * to an existing instance of Money. 
     * 
     * @param - int d: the amount to be added to this.dollars
     * @param - int c: the amount to be added to this.cents
     */
    public void add(int d, int c)
    {
        int carryOver = carryOver(this.cents + checkCents(c));
        this.cents += checkCents(c) - carryOver*100;
        this.dollars += checkDollars(d) + carryOver;
    }

    /**
     * This method takes as input a Money Object and then adds it to
     * this money object, Using the carryOver() function to ensure that 
     * extra cents get converted to dollars and accounted for appropriately. 
     * 
     * @param - Money that: a money object to be added to this Money object
     */
    public void add(Money that)
    {
        int carryOver = carryOver(this.cents + that.cents);
        this.cents += that.cents - carryOver*100;
        this.dollars += that.dollars + carryOver;
    }

    /**
     * This method calculates the carry over value in terms of dollars from 
     * some cent value. The method returns the number of dollars derrivable from
     * some number of cents. (e.g: 364 cents -> returns 3).
     * 
     * @param int c - some cent value to be split into dollars and cents
     * @return int - The number of hundreds (dollars) in int c
     */
    public int carryOver(int c)
    {
        return c/100;
    }

    /**
     * This method compares two money objects and returns true if they are
     * the same and false if they are different. 
     * 
     * @param - Money that: the money object to be compared to this money object
     * @return - boolean: returns true if objects match and false if they don't
     */
    public boolean equals(Money that)
    {
        boolean retVal = false;

        if(this.dollars == that.dollars && this.cents == that.cents)
        {
            retVal = true;
        }

        return retVal;
    }

    /**
     * This method returns a money object as a string in the format of ($dd.cc)
     * 
     * @return - String: A Money object in String format ($dd.cc)
     */
    public String toString()
    {
        return "$" + this.dollars + "." + this.cents;
    }

    /**
     * a method for comparing two money objects. This method compares
     * money objects by dollars first and then by cnets
     * 
     * @param compare: the Money object to be compared
     * @param int: negative, 0, or positive depending on the comparison
     */
    public int compareTo(Money compare)
    {
        if(this.getDollars() > compare.getDollars()){
            return 1;
        } else if(this.getDollars() < compare.getDollars()){
            return -1;
        } else {
            if(this.getCents() > compare.getCents()){
                return 1;
            } else if(this.getCents() < compare.getCents()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
