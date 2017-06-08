import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by rvillules on 08/06/17.
 */
public class DatabaseObject {

    public long lastUpdate;

    public int petAge;
    public String petName;
    public int hunger;
    public int thirst;


    public static long currentTimeSeconds(){
        long timeMillis = System.currentTimeMillis();
        return TimeUnit.MILLISECONDS.toSeconds(timeMillis);
    }


    public DatabaseObject(){

    }

    public DatabaseObject(Pet pet){
        update(pet);
        lastUpdate = currentTimeSeconds();
    }

    public void update(Pet pet){
        this.petAge = pet.age;
        this.petName = pet.name;
        this.hunger = pet.hunger;
        this.thirst = pet.thirst;
    }


    public Pet getPet(){
        Pet pet =new Pet();
        pet.age = petAge;
        pet.name = petName;
        pet.hunger = hunger;
        pet.thirst = thirst;
        return pet;
    }

}
