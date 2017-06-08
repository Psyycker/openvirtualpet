import java.util.Calendar;

/**
 * Created by rvillules on 08/06/17.
 */
public class DatabaseObject {

    public long lastUpdate;

    public int petAge;
    public String petName;



    public DatabaseObject(){

    }

    public DatabaseObject(Pet pet){
        update(pet);
        lastUpdate = System.currentTimeMillis();
    }

    public void update(Pet pet){
        this.petAge = pet.age;
        this.petName = pet.name;
    }


    public Pet getPet(){
        Pet pet =new Pet();
        pet.age = petAge;
        pet.name = petName;
        return pet;
    }

}
