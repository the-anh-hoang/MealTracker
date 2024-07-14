package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;

public class MealGeneratorTest {
    private Food food1;
    private Food food2;
    private Food food3;
    private MealGenerator testMGenerator;
    private List<Food> listOfFoods;

    @BeforeEach
    void beforeEach() {
        food1 = new Food("Wings", 300, 20, 10, 10);
        food2 = new Food( "Egg", 60, 6, 1, 5); 
        food3 = new Food("fish", 200, 30, 2, 50);
        listOfFoods = new ArrayList<Food>(); 
        listOfFoods.add(food1);
        listOfFoods.add(food2);
        listOfFoods.add(food3);
        testMGenerator = new MealGenerator(listOfFoods);
    }

    @Test
    void testMealGenerator() {
        assertEquals(listOfFoods, testMGenerator.getSavedFoods()); 
    }

    @Test
    void testGenerateRandomMeal() {
        
    }

    @Test
    void generateSuggestedMeal() {

    }
}
