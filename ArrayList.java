
/**
 * *****************************************************************************
 * This class constructs an arrayList which has two elements: 
 * 
 * 1. An array of objects
 * 2. an int for tracking the used size of the array
 * 
 * the nature of the arrayList allows users the highest level of freedom
 * in respect to adding and removing elements from the array. Elements can 
 * be inserted or removed in any order. ArrayList is not bound by FIFO / LIFO
 * requirements. 
 * 
 * 
 * @author Bruce Harr
 * @version 12.13.2015
 */
public class ArrayList<TBA>
{
    private Object[] data = new Object[10];
    public int index = 0;

    /**
     * This class is used to add an object to the Object list. 
     * 
     * Invariants: '-' is a reserved character used as a palceholder for null 
     * elements in the toString() function. As such, it cannot be added to 
     * the Object array. If a user attempts to use a hyphen char (-) with this
     * method, they will get a reserved character error message.
     * 
     * @param Object insert: the object to be inserted into the array
     * @param int input: the index at which the object will be inserted
     * @return void
     */
    public void insert(TBA insert)
    {
        if(index < 0)
        {
            System.out.println("ERROR: index out of bounds.");
            return;
        }

        //if input index is larger than the slots available in the array, 
        //expand the array
        if(index >= this.data.length)
        {
            this.expand();
        }

        data[index] = insert;
        index++;
    }
    
    /**
     * This class is used to add an object to the Object list. 
     * 
     * Invariants: '-' is a reserved character used as a palceholder for null 
     * elements in the toString() function. As such, it cannot be added to 
     * the Object array. If a user attempts to use a hyphen char (-) with this
     * method, they will get a reserved character error message.
     * 
     * @param Object insert: the object to be inserted into the array
     * @param int input: the index at which the object will be inserted
     * @return void
     */
    public void insert(Object insert, int input)
    {
        if(input < 0)
        {
            System.out.println("ERROR: index out of bounds.");
            return;
        }

        if(insert.toString().charAt(0) == '-')
        {
            System.out.println("You have chosen a reserved character (-).");
            System.out.println("Please use a different character");
        } else {

            //if input index is larger than the slots available in the array, 
            //expand the array
            if(input >= this.data.length)
            {
                this.expand();
            }
            /*
            The index behavior is different depending on where the 
            object is added to the array. For Example:

            1. Object is added @index -> index++
            2. Object is added before index -> index remains the same
            3. Object is added after index -> index = input

            No matter where the object is added, index will always be
            the index of the last object in the array. So for any case,
            findNextIndex() works for setting the index and is less
            complicated than trying to set index on a case by case basis.
             */

            data[input] = insert;
            index = findNextIndex();
        }
    }

    /**
     * This method returns the object index used as a pointer in the array
     * 
     * @return int: object index variable
     */
    public int getIndex(){
        return this.index;
    }

    /**
     *  This method is used to remove objects from the array. The 
     *  removed object is returned, all subsequent objects are 
     *  shifted one place to the left in the array, and this.index
     *  is updated to reflect the new index (index--).
     *  
     * @param int input: the index of the object to be removed
     * @return Object: The object that was found and removed
     */
    public TBA remove(int input)
    {
        Object retVal = null; //Object to be removed and returned

        if(input >= this.findNextIndex() || input < 0)
        {
            System.out.println("ERROR: Index out of bounds.");
            return (TBA)retVal;
        } else {
            retVal = data[input];
            //Loop used to shift all subsequent items to the left
            for(int i = input; i < index; i++)
            {
                data[i] = data[i + 1];
            }
        }
        index = findNextIndex(); //index is updated to reflect the new value
        return (TBA)retVal;
    }

    /**
     * This method returns the current size of the array.
     * 
     * @return int: the size of the array measured by the last used
     * index of the array
     */
    public int size()
    {
        return this.findNextIndex();
    }

    /**
     * This method converts the array objects to a String and then 
     * returns the String
     * 
     * @return String: A concatonation of the ArrayList objects in
     * the form of a String
     */
    public String toString()
    {
        String retVal = "[";

        for(int i = 0; i < index; i++)
        {
            if(data[i] != null)
            {
                retVal += data[i] + " ";
            }
        }

        retVal = retVal.substring(0, retVal.length() - 1);
        return retVal + "]";
    }

    /**
     * This method checks to see if an arrayList has any elements in it. 
     * If the array is populated, isEmpty() will return false, if not
     * it returns true.
     * 
     * @return boolean: The determination (true/false) of whether or not
     * ArrayList has been populated
     */
    public boolean isEmpty()
    {
        boolean retVal = false;

        if(index == 0 && data[index] == null)
        {
            retVal = true;
        }

        return retVal;
    }

    /**
     * This method returns the index (if found) of a target object
     * in data[].
     * 
     * @param Object: The Object to match while searching data[]
     * @return int: The index of the Object (if found) that matches
     *  up with the input Object. If no matching object is found, 
     *  returns -1
     */
    public int indexOf(TBA search)
    {
        //if not found return -1
        int retVal = -1;

        for(int i = 0; i < index; i++)
        {
            if(data[i] == search)
            {
                retVal = i;
            }
        }

        return retVal;
    }

    /**
     * This method compares two ArrayLists for congruency and returns
     * true or false depending on whether or not they have matching
     * properties.
     * 
     * @param ArrayList: the ArrayList (that) to match against
     * @return boolean: the determination (true/false) of whether
     * this ArrayList matched that ArrayList. True if the two match, 
     * false if no.
     */
    public boolean equals(ArrayList that)
    {
        boolean retVal = true;

        if(this.index != that.index)
        {
            retVal  = false;
            return retVal;
        }

        for(int i = 0; i < findNextIndex(); i++)
        {
            if(this.data[i] != that.data[i])
            {
                retVal = false;
            }
        }
        return retVal;
    }

    /**
     * This method returns the Object found at an index parameter 
     * (input)
     * 
     * @param int: The target index
     * @return Object: The object at the index provided
     */
    public TBA get(int input)
    {
        Object retVal = data[input];
        return (TBA)retVal;
    }

    /**
     * This method returns next available unused index, or in the case of
     * a full array, the next index to be used after a the array is 
     * expanded.
     * 
     * @return int: the next unused index in an array
     */
    public int findNextIndex()
    {
        int retVal = 0;
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] != null)
            {
                retVal = i + 1;
            }
        }

        return retVal;
    }

    /**
     * This method increases the size of an array by double when it
     * reaches its maxiumum capacity.
     */
    public void expand()
    {
        //new expanded temporary Object array
        Object[] expanded = new Object[this.data.length * 2];

        //copy all of the objects from this.data to expanded
        for(int i = 0; i < this.findNextIndex(); i ++)
        {
            expanded[i] = data[i];
        }

        //set this.data = expanded
        this.data = expanded;
    }

    /**
     * returns the size of an array, including any trailing nulls
     * 
     * @return int: the current size capacity of the array [data]
     */
    public int getArraySize()
    {
        return data.length;
    }

    /**
     * Swaps two elements in an arrayList using specified indices
     * 
     * @Param indx1: the index of the first element to swap
     * @Param indx2: the index of the second element to swap
     */
    public void swap(int indx1, int indx2)
    {
        
        //hold element one temporarily so it isn't overwritten
        Object temp = get(indx1); 
        //move the element at indx2 to indx1
        this.insert(get(indx2), indx1);
        //move the element at indx1 to indx2
        this.insert(temp, indx2);
        
    }
}
