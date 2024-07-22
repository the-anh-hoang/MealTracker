package persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import model.Food;
import model.Meal;
import model.User;

// Represents a reader that reas user from JSON data stor
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonValidFileUser() {
        JsonReader reader = new JsonReader("imSoTiredWithThis!!!.json");
        try {
            User user = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    void testReaderEmptyUser() {
        JsonReader reader = new JsonReader("./data/testReaderEmpty.json");
        try {
            User user = reader.read();
            checkUser("Harry", 65, 175, 19, "male", "MG", new ArrayList<Food>(), new ArrayList<Meal>(), user);
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }
    }

    @Test
    void testReaderGeneralUser() {
        JsonReader reader = new JsonReader("./data/testReaderGeneral.json");
        try {
            User user = reader.read();
            checkUser("Harry", 65, 175, 19, "male", "MG", foodList, mealList, user);
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }
    }

}
