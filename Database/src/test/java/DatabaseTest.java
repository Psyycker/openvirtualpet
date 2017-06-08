import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rvillules on 08/06/17.
 */
public class DatabaseTest {


    @Test
    public void testCreateAndLoadFile(){
        DatabaseObject obj = new DatabaseObject();
        obj.petName = "George";
        obj.petAge = 25;
        Database.getDatabase().saveSaveFile(obj);
        DatabaseObject obj2 = Database.getDatabase().loadSaveFile();
        assertNotEquals(obj2, null);
        assertEquals(obj2.petAge, 25);
        assertEquals(obj2.petName, "George");
    }

}