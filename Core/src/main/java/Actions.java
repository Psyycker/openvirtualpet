/**
 * Created by rvillules on 09/06/17.
 */
public enum Actions {

    EAT("EAT"),
    DRINK("DRINK");



    private String value;

    Actions(String eat) {
        value = eat;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Actions getAction(String action){
        action = action.toUpperCase();
        switch (action){
            case "EAT":
                return EAT;
            case "DRINK":
                return DRINK;
            default:
                return null;
        }
    }
}
