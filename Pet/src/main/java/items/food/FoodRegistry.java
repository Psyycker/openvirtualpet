package items.food;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rvillules on 09/06/17.
 */
public class FoodRegistry {

    private static FoodRegistry registry;
    private  Map<String, Food> foodRegistry;


    private FoodRegistry(){
        foodRegistry = new HashMap<>();

        foodRegistry.put(FoodTypes.BURGER.toString(), new Burger());
        registry = this;
    }

    public static Food getFoodFromType(FoodTypes type){
        if (registry == null){
            new FoodRegistry();
        }
        return registry.foodRegistry.get(type.toString());
    }


}
