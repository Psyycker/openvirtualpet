import javax.swing.*;
import java.util.Scanner;

/**
 * Created by rvillules on 08/06/17.
 */
public class LibTest {


    public static class UpdateThread extends Thread{

        GameManager manager;

        public UpdateThread(GameManager manager){
            this.manager = manager;
        }

        @Override
        public void run() {



            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //FIRST STEP : Start the game;
        GameManager manager = new GameManager();
        if (!manager.gameExists()) {
            manager.newPet();
        }
        manager.launch();
        //new UpdateThread(manager).start();
        Scanner reader = new Scanner(System.in);
        manager.updatePet();
        while (manager.isPetAlive()){
            System.out.println("Enter an action");
            String actionStr = reader.nextLine();
            Actions action = Actions.getAction(actionStr);
            System.out.println("Enter an argument");
            String argument = reader.nextLine();
            manager.doAction(action, argument);
            manager.updatePet();
        }
    }

}
