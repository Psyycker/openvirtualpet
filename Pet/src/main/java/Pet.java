import items.food.Food;
import items.food.FoodRegistry;
import items.food.FoodTypes;

/**
 * Created by rvillules on 08/06/17.
 *
 *
 * WARNING : If adding a property to pet, go to Database/DatabaseObject to apply it. If not, property will ne bot saved.
 */
public class Pet {


    public int age;
    public String name;

    public static int BASE_HUNGER = 100000;
    public int hunger = BASE_HUNGER;

    public static int BASE_THIRST = 4000;
    public int thirst = BASE_THIRST;

    public static int BASE_TIRED = 4000;
    public int tired = BASE_TIRED;


    public void eat(FoodTypes type){
        if (type == null)
            return;

        System.out.println(name + " eated a " + type.toString());
        Food food = FoodRegistry.getFoodFromType(type);
        hunger += food.getHungerRestore();
        if (hunger > BASE_HUNGER)
            hunger = BASE_HUNGER;

        thirst += food.getThirstRestore();
        if (thirst > BASE_THIRST)
            thirst = BASE_THIRST;

        tired += food.getEnergyRestore();
        if (tired > BASE_TIRED)
            tired = BASE_TIRED;
    }

}
