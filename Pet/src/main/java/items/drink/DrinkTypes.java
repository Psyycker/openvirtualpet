package items.drink;

/**
 * Created by rvillulles on 09/06/17.
 */
public enum DrinkTypes {



    WATER("water");


    String value;

    DrinkTypes(String type) {
        this.value = type;
    }

    @Override
    public String toString() {
        return value;
    }


    public static DrinkTypes getDrinkType(String type){
        type = type.toLowerCase();
        switch (type){
            case "water" :
                return WATER;
            default:
                return null;
        }
    }

}
