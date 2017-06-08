/**
 * Created by rvillulles on 08/06/17.
 *
 * Game manager is made to update the pet.
 */
public class GameManager {

    Pet pet;
    long lastModif;

    /**
     * Make a new pet and write it
     *
     * //TODO : Generate a pet randomly
     */
    public void newPet(/*Add parameters to make new pet here*/){
        pet = new Pet();
        pet.name = "George";
        pet.age = 25;
        Database.getDatabase().saveSaveFile(new DatabaseObject(pet));
        lastModif = System.currentTimeMillis();
    }

    /**
     * Launch the game, THIS IS NOT A NEW GAME.
     * Load database content and regenerate the pet.
     * Make calculs based on time
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

    }

    public boolean gameExists(){
        return Database.getDatabase().gameExists();
    }

}
