package items.food;

/**
 * Created by rvillules on 09/06/17.
 */
public enum FoodTypes {


    BURGER("burger");


    private String value;


    FoodTypes(String food){
        value = food;
    }


    @Override
    public String toString() {
        return value;
    }

    public static FoodTypes getFoodType(String type){
        type = type.toLowerCase();
        switch (type){
            case "burger":
                return BURGER;
            default:
                return null;
        }
    }
}
