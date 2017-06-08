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
    }

    public void update(Pet pet){
        this.petAge = pet.age;
        this.petName = pet.name;
    }

}
