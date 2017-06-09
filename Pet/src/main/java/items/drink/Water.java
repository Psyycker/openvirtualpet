package items.drink;

/**
 * Created by rvillules on 09/06/17.
 */
public class Water extends Drink {
    @Override
    public int getHungerRestore() {
        return 0;
    }

    @Override
    public int getThirstRestore() {
        return 2000000;
    }

    @Override
    public int getEnergyRestore() {
        return 0;
    }
}
