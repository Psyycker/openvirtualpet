import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by rvillules on 08/06/17.
 *
 * We're using a property system and not a database because of compatibility with android.
 */
public class Database {

    private static String PETFILE = "pet.properties";

    DatabaseObject object;
    OutputStream output = null;


    private static Database database;

    public static Database getDatabase(){
        if (database == null){
           database =  new Database();
        }
        return database;
    }



}
