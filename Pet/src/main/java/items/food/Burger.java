package items.food;

/**
 * Created by rvillules on 09/06/17.
 */
public class Burger extends Food {
    @Override
    public int getHungerRestore() {
        return 30000;
    }

    @Override
    public int getThirstRestore() {
        return 10000;
    }

    @Override
    public int getEnergyRestore() {
        return 0;
    }
}
