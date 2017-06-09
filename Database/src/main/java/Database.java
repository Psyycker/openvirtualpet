import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 * Created by rvillules on 08/06/17.
 *
 * We're using a property system and not a database because of compatibility with android.
 */
public class Database {

    private static String PETFILE = "save.json";

    DatabaseObject object;
    OutputStream output = null;
    FileReader input = null;

    public static boolean bddUsed = false;

    private static Database database;

    public static Database getDatabase(){
        if (database == null){
           database =  new Database();
        }
        return database;
    }


    public DatabaseObject loadSaveFile(){
        try {
            input = new FileReader(PETFILE);
            BufferedReader rdr = new BufferedReader(input);
            String currentLine;
            String fullContent = "";
            while ((currentLine = rdr.readLine()) != null){
                fullContent += currentLine;
            }
            rdr.close();
            input.close();
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(fullContent, DatabaseObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean gameExists(){
        try {
            input = new FileReader(PETFILE);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public void saveSaveFile(DatabaseObject object){
        Gson gson = new GsonBuilder().create();
        String jsonobj = gson.toJson(object);
        try {
            output = new FileOutputStream(PETFILE);
            PrintWriter writer = new PrintWriter(PETFILE, "UTF-8");
            writer.println(jsonobj);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
