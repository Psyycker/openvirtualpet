package items.drink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rvillules on 09/06/17.
 */
public class DrinkRegistry {


    private static DrinkRegistry registry;

    private Map<String, Drink> drinkMap;


    private DrinkRegistry(){
        drinkMap = new HashMap<>();

        drinkMap.put("water", new Water());

        registry = this;
    }

    public static Drink getDrinkWithType(DrinkTypes type){
        if (registry == null){
            new DrinkRegistry();
        }
        return registry.drinkMap.get(type.toString());
    }

}
