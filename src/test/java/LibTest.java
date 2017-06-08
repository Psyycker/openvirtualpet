/**
 * Created by rvillules on 08/06/17.
 */
public class LibTest {


    public static void main(String[] args) throws InterruptedException {
        //FIRST STEP : Start the game;
        GameManager manager = new GameManager();
        if (!manager.gameExists())
            manager.newPet();
        manager.launch();
        while (manager.isPetAlive()){

            manager.updatePet();

            Thread.sleep(10000);
        }
    }

}
