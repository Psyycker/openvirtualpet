import items.food.FoodTypes;

import java.util.Objects;

/**
 * Created by rvillulles on 08/06/17.
 *
 * Game manager is made to update the pet.
 */
public class GameManager {

    Pet pet;
    long lastModif;


    private class UpdaterThread extends Thread{


        @Override
        public void run() {
            DatabaseObject obj = new DatabaseObject(pet);
            obj.lastUpdate = lastModif;
            synchronized (Database.getDatabase()) {
                Database.getDatabase().saveSaveFile(obj);
            }
        }
    }


    /**
     * Make a new pet and write it
     *
     * //TODO : Generate a pet randomly
     */
    public void newPet(/*Add parameters to make new pet here*/){
        pet = new Pet();
        pet.name = "George";
        pet.age = 25;
        lastModif = DatabaseObject.currentTimeSeconds();
        DatabaseObject obj = new DatabaseObject(pet);
        obj.lastUpdate = lastModif;
        Database.getDatabase().saveSaveFile(obj);
        System.out.println("New pet created");
    }


    /**
     * Launch the game, THIS IS NOT A NEW GAME.
     * Load database content and regenerate the pet.
     */
    public void launch(){
        DatabaseObject obj = Database.getDatabase().loadSaveFile();
        pet = obj.getPet();
        lastModif = obj.lastUpdate;
        updatePet();
    }

    /**
     * Update pet. Take current time and compare with lastmodif.
     * Do some calc
     */
    public void updatePet(){
        long time = DatabaseObject.currentTimeSeconds();

        time = time - lastModif;
        while (time != 0){
            updateOneSecond();
            time--;
        }
        lastModif = DatabaseObject.currentTimeSeconds();
        new UpdaterThread().start();
        System.out.println(pet.name + " : hunger : " + pet.hunger + ", thirst : " + pet.thirst + ", tired : " + pet.tired);
    }

    public void updateOneSecond(){
        pet.hunger -= 1;
        pet.thirst -= 1;
        pet.tired -= 1;
    }

    public boolean gameExists(){
        return Database.getDatabase().gameExists();
    }

    public boolean isPetAlive(){
        return pet.hunger > 0 && pet.thirst > 0;
    }

    public void doAction(Actions action, String argument){
        if (action == null)
            return;
        switch (action){
            case EAT:
                pet.eat(FoodTypes.getFoodType(argument));
                break;
        }
    }

}
