package persistence;

import model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    private User user;

    @BeforeEach
    @Override
    void setUp() {
        super.setUp();
        user = new User("Harry", 65, 175, 19, "male", "MG");
    }

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\\0illegal:fileName.json");
            writer.open();
            fail("IOException expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    void testWriterEmptyUser() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterEmpty.json");
            writer.open();
            writer.write(user);
            writer.close();
            JsonReader reader = new JsonReader("./data/testWriterEmpty.json");
            user = reader.read();
            checkUser("Harry", 65, 175, 19, "male", "MG", new ArrayList<Food>(), new ArrayList<Meal>(), user);

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralUser() {
        try {

            user.addFood(food1);
            user.addFood(food2);
            user.addFood(food3);
            user.addMeal(meal1);
            user.addMeal(meal2);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneral.json");
            writer.open();
            writer.write(user);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneral.json");
            user = reader.read();

            checkUser("Harry", 65, 175, 19, "male", "MG", foodList, mealList, user);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

}
