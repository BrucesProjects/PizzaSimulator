import java.util.Scanner;
import java.awt.Color;
/*  PizzaManager Skeleton File
 *  CSS 161, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Start by reading the documentation(comments), and then the code.  Find the 
 *  empty stub methods you are to fill in using a Top-Down approach (see the
 *  assignment for more information on this and Stepwise Refinement)
 * 
 *  Author: Rob Nash with minor edits by Johnny Lin
 */

public class PizzaManager {
    ArrayList<Pizza> PizzaList = new ArrayList<Pizza>();

    /* 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() throws CloneNotSupportedException, PizzaException{
        char selection='q';

        Scanner foo = new Scanner(System.in);

        while(true) {
            displayAllPizzas();
            displayInstructions();

            //foo.nextChar() doesn't exist, so now what?
            selection = foo.next().charAt(0);

            switch(selection) {
                case 'A':    
                case 'a':     System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                            addRandomPizza();
                                    break;
                case 'H':    
                case 'h':     System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                            //todo:
                            for(int i = 0; i < 100; i++){
                                addRandomPizza();
                            }
                            displayAllPizzas();
                            break;                    
                case 'E':    
                case 'e':     System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                            Scanner in = new Scanner(System.in);
                            eatSomePizza(in);// in = new Scanner(System.in))
                            break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                            sortByPrice();
                            break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                            sortBySize();
                            break;          
                case 'C':    
                case 'c':     System.out.println("Sorting pizzas by (C)alories");
                            sortByCalories();
                            break;
                case 'B':
                case 'b':     System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                            Scanner in2 = new Scanner(System.in);
                            int calorieSearch = in2.nextInt();
                            int index = binarySearchByCalories(calorieSearch);

                            if(index == -1) {
                                System.out.println("Pizza not found");
                            } else {
                                System.out.println("Congratulations!!! We found the following pizza for you: \n" + PizzaList.get(index) + "\n\n");
                            }
                            break;
                case 'Q':
                case 'q':     System.out.println("(Q)uitting!" );
                            System.exit(0);
                            //break;
                default:      System.out.println("Unrecognized input - try again");
            }
        }

    }

    /**
     * This method subtracts some fraction of a pizza taken from the
     * user from a pizza at an index taken from the user. 
     * 
     * @Exception throws PizzaException
     */
    private void eatSomePizza(Scanner keys)  throws PizzaException {
        String sFraction = keys.next();

        System.out.println("Which pizza do you want to eat? (please enter the Pizza's index(int))");
        int pIndex = keys.nextInt(); 
        //if the amount removed from the pizza results in the pizza being gone
        //or negative, this will catch the exception.
        try{
            PizzaList.get(pIndex).eatSomePizza(new Fraction(sFraction));
        }
        catch(PizzaException e)
        {
            System.out.println(e.toString());
            PizzaList.remove(pIndex);
        }
    }

    /**
     * this method creates a random pizza and adds it to the array list. 
     * It is assumed that each pizza will have exactly one base, one
     * cheese, one meat, and one veggie. The toppings are chosen randomly. 
     * 
     * @Exception throws CloneNotSupported Exception
     */
    private void addRandomPizza() throws CloneNotSupportedException {
        //create pizza
        Pizza newPizza = new Pizza();

        //declare ingredients
        Ingredient ing1;
        Ingredient ing2;
        Ingredient ing3;
        Ingredient ing4;

        //randomize Base
        if(Math.random() < .5){
            ing1 = new Marinara();
        } else {
            ing1 = new Alfredo();
        }

        //randomize Cheese
        if(Math.random() < .5){
            ing2 = new Mozarella();
        } else {
            ing2 = new Goat();
        }

        //randomize Meat
        if(Math.random() < .5){
            ing3 = new Pepperoni();
        } else {
            ing3 = new Sausage();
        }

        //randomize Vegetables
        if(Math.random() < .5){
            //randomize veggie colors
            if(Math.random() < .5){
                ing4 = new Pepper(Color.GREEN);
            } else {
                ing4 = new Pepper(Color.RED);
            }
        } else {
            //randomize veggie colors
            if(Math.random() < .5){
                ing4 = new Olive(Color.GREEN);
            } else {
                ing4 = new Olive(Color.BLACK);
            }
        }
        //add topings to the pizza
        newPizza.addIngredient(ing1);
        newPizza.addIngredient(ing2);
        newPizza.addIngredient(ing3);
        newPizza.addIngredient(ing4);
        //add to array list
        PizzaList.insert(newPizza);
    }

    /**
     * This function lists all of the pizzas in the arrayList in their
     * current order. 
     */
    private void displayAllPizzas() {
        //print out each pizza in the list
        for(int i = 0; i < PizzaList.findNextIndex(); i++){
            System.out.println(PizzaList.get(i).toString());
        }
    }

    /**
     * This method sorts pizzas from highest to lowest in terms of
     * price. this function uses a SELECTION sort. 
     */
    private void sortByPrice() throws CloneNotSupportedException {  
        ArrayList<Pizza> sortList = new ArrayList<Pizza>();
        Pizza toAdd = PizzaList.get(0);//the pizza to be added to the sorted list
        int toRemove = 0; //the of Pizza toAdd
        //find minimum first, add it to the new list
        while(!PizzaList.isEmpty()) {
            toAdd = PizzaList.get(0); //re initialize toAdd with each iteration
            for(int i = 0; i < PizzaList.findNextIndex(); i++)
            {
                //if toAdd is bigger than the element we are comparing, 
                if(toAdd.compareTo(PizzaList.get(i)) >= 0)
                {
                    //set toAdd equal to the new element
                    toAdd = PizzaList.get(i);
                    //and to remove euqal to its index
                    toRemove = i;
                }
            }
            sortList.insert(toAdd);//add the element to the sorted list
            PizzaList.remove(toRemove);//remove it fromt he unsorted list
        }
        //copy the sorted list elements back into PizzaList
        for(int i = 0; i < sortList.findNextIndex(); i++)
        {
            PizzaList.insert(sortList.get(i));
        }
        
    }

    /**
     * This method sorts pizzas from highest to lowest in terms of
     * size. this function uses a SELECTION sort. 
     */
    private void sortBySize() {
        ArrayList<Pizza> sortList = new ArrayList<Pizza>();
        Pizza toAdd = PizzaList.get(0);//the pizza to be added to the sorted list
        int toRemove = 0; //the of Pizza toAdd
        //find minimum first, add it to the new list
        while(!PizzaList.isEmpty()) {
            toAdd = PizzaList.get(0); //re initialize toAdd with each iteration
            for(int i = 0; i < PizzaList.findNextIndex(); i++)
            {
                //if toAdd is bigger than the element we are comparing, 
                if(toAdd.compareToBySize(PizzaList.get(i)) >= 0)
                {
                    //set toAdd equal to the new element
                    toAdd = PizzaList.get(i);
                    //and to remove euqal to its index
                    toRemove = i;
                }
            }
            sortList.insert(toAdd);//add the element to the sorted list
            PizzaList.remove(toRemove);//remove it fromt he unsorted list
        }
        //copy the sorted list elements back into PizzaList
        for(int i = 0; i < sortList.findNextIndex(); i++)
        {
            PizzaList.insert(sortList.get(i));
        }

    }

    /**
     * This method sorts pizzas from highest to lowest in terms of
     * calories. this function uses a SELECTION sort. 
     */
    private void sortByCalories() {
        ArrayList<Pizza> sortList = new ArrayList<Pizza>();
        Pizza toAdd = PizzaList.get(0);//the pizza to be added to the sorted list
        int toRemove = 0; //the of Pizza toAdd
        //find minimum first, add it to the new list
        while(!PizzaList.isEmpty()) {
            toAdd = PizzaList.get(0);//re initialize toAdd with each iteration
            for(int i = 0; i < PizzaList.findNextIndex(); i++)
            {
                //if toAdd is bigger than the element we are comparing, 
                if(toAdd.compareToByCalories(PizzaList.get(i)) >= 0)
                {
                    //set toAdd equal to the new element
                    toAdd = PizzaList.get(i);
                    //and to remove euqal to its index
                    toRemove = i;
                }
            }
            sortList.insert(toAdd);//add the element to the sorted list
            PizzaList.remove(toRemove); //remove it fromt he unsorted list
        }
        //copy the sorted list elements back into PizzaList
        for(int i = 0; i < sortList.findNextIndex(); i++)
        {
            PizzaList.insert(sortList.get(i));
        }
    }

    /**
     * This function performs a binary search on a sorted Pizza ArrayList
     */
    private int binarySearchByCalories(int cals) {
        //sort the list first
        sortByCalories();
        //the low marker for bisecting the search array
        int LowIndex = 0; 
        //the high marker for bisecting the search array
        int HighIndex = PizzaList.findNextIndex() - 1; 
        //declare midpoint variable
        int MidIndex;
        int count = 0;
        while(true)
        {
            //initialize midpoint with each iteration
            MidIndex = (LowIndex + HighIndex) / 2;
            
            //we've exhausted the list
            if(count > PizzaList.findNextIndex()) {
                return -1;
            }
            if(cals == PizzaList.get(MidIndex).getTotalCalories()) 
            //check if midpoint is a match to target
            {
                return MidIndex;
            } else if(cals < PizzaList.get(MidIndex).getTotalCalories()) 
            //target is found in the first half
            {
                HighIndex = MidIndex - 1;
                count++;
            } else if(cals > PizzaList.get(MidIndex).getTotalCalories()) 
            //target is found in the second half
            {
                LowIndex = MidIndex + 1;
                count++;
            }
        }

    }

    /*
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) throws CloneNotSupportedException, PizzaException {
        new PizzaManager().start();
    }
}
