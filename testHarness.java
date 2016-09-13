import java.awt.Color;
/**
 * Write a description of class testHarness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testHarness
{

    public static void main(String[] args) throws CloneNotSupportedException
    {
        //testIngredient();
        //testFractions();
        //testSubIngredients();
        testArrayList();
        //testShape();
        //testPizza();
        //testMathRandom();
    }

    public static void testMathRandom(){
        for(int i = 0; i < 50; i++)
        {
            if(Math.random() > .5) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
            
        }
    }
    
    public static void testPizza()throws CloneNotSupportedException
    {
        //testPizzaConstructors();
        //testPizzaEatSomePizza();
        //testPizzaGetSize();
        testPizzaCompare();
    }

    public static void testPizzaConstructors() throws CloneNotSupportedException
    {
        Pizza a = new Pizza();

        Ingredient a1 = new Mozarella();
        Ingredient a2 = new Sausage();
        Ingredient a3 = new Alfredo();

        a.addIngredient(a1);
        a.addIngredient(a2);
        a.addIngredient(a3);

        //a.addIngredient("a");
        //a.addIngredient("b");
        //a.addIngredient("c");

        System.out.println(a.toString());
        /*
        System.out.println(a.ingredients.get(0));
        System.out.println(a.ingredients.get(1));
        System.out.println(a.ingredients.get(2));
         */
    }

    public static void testPizzaGetSize()throws CloneNotSupportedException
    {
        Pizza a = new Pizza();
        System.out.println(a.getRemainingArea());
        try{
            a.eatSomePizza(new Fraction("1/8"));
        } catch (PizzaException e) {
            System.out.println(e.toString());
        }
        System.out.println(a.getRemaining().toString());
        System.out.println(a.getRemainingArea());

        try{
            a.eatSomePizza(new Fraction("3/8"));
        } catch (PizzaException e) {
            System.out.println(e.toString());
        }
        System.out.println(a.getRemaining().toString());
        System.out.println(a.getRemainingArea());
    }

    public static void testPizzaEatSomePizza()throws CloneNotSupportedException
    {
        Pizza a = new Pizza();
        a.addIngredient(new Mozarella());
        System.out.println(a.toString());

        try{
            a.eatSomePizza(new Fraction("1/8"));
        } catch (PizzaException e) {
            System.out.println(e.toString());
        }
        System.out.println(a.toString());

        try{
            a.eatSomePizza(new Fraction("1/2"));
        } catch (PizzaException e) {
            System.out.println(e.toString());
        }
        System.out.println(a.toString());

        try{
            a.eatSomePizza(new Fraction("2/8"));
        } catch (PizzaException e) {
            System.out.println(e.toString());
        }
        System.out.println(a.toString());

        try{
            a.eatSomePizza(new Fraction("1/8"));
        } catch (PizzaException e) {
            System.out.println(e.toString());
        }
        System.out.println(a.toString());

        try{
            a.eatSomePizza(new Fraction("3/8"));
        } catch (PizzaException e) {
            System.out.println(e.toString());
        }
    }

    public static void testPizzaCompare()throws CloneNotSupportedException
    {
        Pizza a = new Pizza();
        Pizza b = new Pizza();
        
        a.addIngredient(new Mozarella());
        b.addIngredient(new Mozarella());
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        
        System.out.println(a.compareTo(b));
        System.out.println(a.compareToBySize(b));
        System.out.println(a.compareToByCalories(b));
        
        b.addIngredient(new Sausage());
        try{
            a.eatSomePizza(new Fraction("1/8"));
        } catch (PizzaException e) {
            System.out.println(e.toString());
        }
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        
        System.out.println(a.compareTo(b));
        System.out.println(a.compareToBySize(b));
        System.out.println(a.compareToByCalories(b));
        
        a.addIngredient(new Sausage());
        a.addIngredient(new Pepper(Color.GREEN));
        try{
            b.eatSomePizza(new Fraction("3/8"));
        } catch (PizzaException e) {
            System.out.println(e.toString());
        }
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        
        System.out.println(a.compareTo(b));
        System.out.println(a.compareToBySize(b));
        System.out.println(a.compareToByCalories(b));
        
    }

    public static void testArrayList()
    {
        ArrayList a = new ArrayList();

        a.insert("Bat");
        a.insert("Dog");
        a.insert("Rat");
        System.out.println(a.toString());
        System.out.println("Removed: " + a.remove(2));
        System.out.println(a.toString());
        System.out.println("Removed: " + a.remove(0));
        System.out.println(a.toString());
        System.out.println("Removed: " + a.remove(0));
        System.out.println(a.toString());
        System.out.println(a.isEmpty());
        System.out.println(a.index);
    }

    public static void testShape() throws CloneNotSupportedException
    {
        Shape circle = new Circle(50,100,9);
        Shape circle2 = circle.clone();

        System.out.println(circle.toString());
        System.out.println(circle2.toString());

        Shape Square = new Square(50,100,9);
        Shape Square2 = Square.clone();

        System.out.println(Square.toString());
        System.out.println(Square2.toString());
        
        Pizza a = new Pizza();
        Pizza b = new Pizza();
        Pizza c = new Pizza();
        Pizza d = new Pizza();
        Pizza e = new Pizza();
        Pizza f = new Pizza();
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());
        System.out.println(f.toString());
    }

    public static void testSubIngredients()
    {
        testSubIngredientsConstructors();
        testSubIngredientsGetters();
        testSubIngredientsEquals();
        testSubIngredientsCompareTo();
    }

    public static void testSubIngredientsConstructors()
    {
        Cheese Mozarella = new Mozarella();
        System.out.println(Mozarella.toString());
        Cheese Goat = new Goat();
        System.out.println(Goat.toString());

        Meat Pepperoni = new Pepperoni();
        System.out.println(Pepperoni.toString());
        Meat Sausage = new Sausage();
        System.out.println(Sausage.toString());

        Base Marinara = new Marinara();
        System.out.println(Marinara.toString());
        Base Alfredo = new Alfredo();
        System.out.println(Alfredo.toString());

        Vegetable Pepper = new Pepper(Color.GREEN);
        System.out.println(Pepper.toString());
        Vegetable Olive = new Olive(Color.BLACK);
        System.out.println(Olive.toString());
    }

    public static void testSubIngredientsGetters(){
        Cheese Mozarella = new Mozarella();
        Cheese Goat = new Goat();
        Meat Pepperoni = new Pepperoni();
        Meat Sausage = new Sausage();
        Base Marinara = new Marinara();
        Base Alfredo = new Alfredo();
        Vegetable Pepper = new Pepper(Color.GREEN);
        Vegetable Olive = new Olive(Color.BLACK);

        System.out.println(Mozarella.getDescription() + " " + Mozarella.getCost() + " " + Mozarella.getCalories());
        System.out.println(Goat.getDescription() + " " + Goat.getCost() + " " + Goat.getCalories());
        System.out.println(Pepperoni.getDescription() + " " + Pepperoni.getCost() + " " + Pepperoni.getCalories());
        System.out.println(Sausage.getDescription() + " " + Sausage.getCost() + " " + Sausage.getCalories());
        System.out.println(Marinara.getDescription() + " " + Marinara.getCost() + " " + Marinara.getCalories());
        System.out.println(Alfredo.getDescription() + " " + Alfredo.getCost() + " " + Alfredo.getCalories());
        System.out.println(Pepper.getDescription() + " " + Pepper.getCost() + " " + Pepper.getCalories() + " " + Pepper.getColor());
        System.out.println(Olive.getDescription() + " " + Olive.getCost() + " " + Olive.getCalories() + " " + Olive.getColor());
    }

    public static void testSubIngredientsEquals(){
        Cheese Mozarella = new Mozarella();
        Cheese Goat = new Goat();
        Cheese Mozarella2 = new Mozarella();
        System.out.println(Mozarella.equals(Goat));
        System.out.println(Mozarella.equals(Mozarella2));

        Meat Pepperoni = new Pepperoni();
        Meat Sausage = new Sausage();
        Meat Pepperoni2 = new Pepperoni();
        System.out.println(Pepperoni.equals(Sausage));
        System.out.println(Pepperoni.equals(Pepperoni2));

        Base Marinara = new Marinara();
        Base Alfredo = new Alfredo();
        Base Marinara2 = new Marinara();
        System.out.println(Marinara.equals(Goat));
        System.out.println(Marinara.equals(Marinara2));

        Vegetable Pepper = new Pepper(Color.GREEN);
        Vegetable Olive = new Olive(Color.BLACK);
        Vegetable Pepper2 = new Pepper(Color.GREEN);
        System.out.println(Pepper.equals(Olive));
        System.out.println(Pepper.equals(Pepper2));
    }

    public static void testSubIngredientsCompareTo(){
        Cheese Mozarella = new Mozarella();
        Cheese Goat = new Goat();
        Meat Pepperoni = new Pepperoni();
        Meat Sausage = new Sausage();
        Base Marinara = new Marinara();
        Base Alfredo = new Alfredo();
        Vegetable Pepper = new Pepper(Color.GREEN);
        Vegetable Olive = new Olive(Color.BLACK);

        System.out.println(Mozarella.compareTo(Goat));
        System.out.println(Mozarella.compareTo(Pepperoni));
        System.out.println(Mozarella.compareTo(Sausage));
        System.out.println(Mozarella.compareTo(Marinara));
        System.out.println(Mozarella.compareTo(Alfredo));
        System.out.println(Mozarella.compareTo(Pepper));
        System.out.println(Mozarella.compareTo(Olive));

        System.out.println(Pepper.compareTo(Olive));
    }

    public static void testFractions()
    {
        testFractionConstructors();
        testFractionGetters(); //no setters for this class
        testFractionSubtract();
        testFractionEquals();
    }

    public static void testFractionConstructors()
    {
        Fraction a = new Fraction(1,2);
        Fraction b = new Fraction("3/4");
        Fraction c = new Fraction(b);
        Fraction d = new Fraction(3,12);
        Fraction e = new Fraction("12/9");
        Fraction f = new Fraction(200,250);

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());
        System.out.println(f.toString());
    }

    public static void testFractionGetters()
    {
        Fraction a = new Fraction(1,2);
        Fraction b = new Fraction("3/4");

        System.out.println(a.getNumerator());
        System.out.println(a.getDenominator());
        System.out.println(b.getNumerator());
        System.out.println(b.getDenominator());
    }

    public static void testFractionSubtract()
    {
        Fraction a = new Fraction(1,1);
        Fraction b = new Fraction(2,5);
        Fraction c = new Fraction(6,5);

        System.out.println(a.subtract(b).toString());
        System.out.println(a.subtract(c).toString());

    }
    public static void testFractionEquals()
    {
        Fraction a = new Fraction(1,2);
        Fraction b = new Fraction("3/4");
        Fraction c = new Fraction(b);
        Fraction d = new Fraction(3,12);
        Fraction e = new Fraction("12/9");
        Fraction f = new Fraction(200,250);

        System.out.println(b.equals(a));
        System.out.println(b.equals(b));
        System.out.println(b.equals(c));
        System.out.println(b.equals(d));
        System.out.println(b.equals(e));
        System.out.println(b.equals(f));
    }

    public static void testIngredient()
    {
        testIngredientConstructors();
        testSettersAndGetters();
        testIngredientBoolean();
        testIngredientCompareTo();
    }

    public static void testIngredientConstructors()
    {
        Ingredient a = new Ingredient("Cheese", new Money(1.25), 125);
        System.out.println(a.toString());

        Ingredient b = new Ingredient(a);
        System.out.println(b.toString());
    }

    public static void testSettersAndGetters()
    {
        Ingredient a = new Ingredient("Cheese", new Money(1.25), 125);
        System.out.println(a.toString());

        a.setDescription("Peps");
        System.out.println(a.toString());

        a.setCost(new Money(2.75));
        System.out.println(a.toString());

        a.setCalories(225);
        System.out.println(a.toString());

        System.out.println(a.getDescription());
        System.out.println(a.getCost());
        System.out.println(a.getCalories());
    }

    public static void testIngredientBoolean()
    {
        Ingredient a = new Ingredient("Cheese", new Money(1.25), 125);
        Ingredient b = new Ingredient(a);
        System.out.println(a.equals(b));

        b.setDescription("peps");
        System.out.println(a.equals(b));

        b.setDescription("Cheese");
        System.out.println(a.equals(b));

        b.setCost(new Money(2.25));
        System.out.println(a.equals(b));

        b.setCost(new Money(1.25));
        System.out.println(a.equals(b));

        b.setCalories(225);
        System.out.println(a.equals(b));

    }

    public static void testIngredientCompareTo()
    {
        Ingredient a = new Ingredient("Cheese", new Money(1.25), 125);
        Ingredient b = new Ingredient(a);
        System.out.println(a.compareTo(b));

        b.setDescription("peps");
        System.out.println(a.compareTo(b));

        b.setDescription("Cheese");
        System.out.println(a.compareTo(b));

        b.setCost(new Money(2.25));
        System.out.println(a.compareTo(b));

        b.setCost(new Money(1.25));
        System.out.println(a.compareTo(b));

        b.setCalories(225);
        System.out.println(a.compareTo(b));
    }
}
