package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class MealTest {
    private Meal testMeal;
    private Food food1;
    private Food food2;
    private Food food3;
    private Meal meal1;
    private Meal meal2;
    private Meal meal3;

    @BeforeEach
    void setUp() {
        food1 = new Food("Wings", 300, 20, 10, 10);
        food2 = new Food("Egg", 60, 6, 1, 5);
        food3 = new Food("fish", 200, 30, 2, 50);
        testMeal = new Meal("Meal 1");
        testMeal.addFood(food1);
        testMeal.addFood(food2);
        testMeal.addFood(food3);

        meal1 = new Meal("Meal 1");
        meal1.addFood(food1);
        meal2 = new Meal("Meal 1");
        meal2.addFood(food1);
        meal3 = new Meal("Meal 1");
        meal3.addFood(food2);
    }

    @Test
    void testMeal() {
        Meal testMeal2 = new Meal("Meal 2");
        assertEquals("Meal 2", testMeal2.getName());
        assertEquals(new ArrayList<Food>(), testMeal2.getFoods());
    }

    @Test
    void testAddFood() {
        assertEquals(food1, (testMeal.getFoods()).get(0));
        assertEquals(food2, (testMeal.getFoods()).get(1));
        assertEquals(food3, (testMeal.getFoods()).get(2));
    }

    @Test
    void testRemoveFood() {
        testMeal.removeFood(1);
        assertEquals(food2, (testMeal.getFoods()).get(0));
        testMeal.addFood(food1);
        testMeal.removeFood(2);
        assertEquals(food1, (testMeal.getFoods()).get(1));
    }



    @Test 
    void testGetTotalCalories() {
        assertEquals(560, testMeal.getTotalCalories());
    }

    @Test 
    void testGetTotalProtein() {
        assertEquals(56, testMeal.getTotalProtein());
    }

    @Test
    void testGetTotalCarbs() {
        assertEquals(13, testMeal.getTotalCarbs());
    }

    @Test
    void testGetTotalFat() {
        assertEquals(65, testMeal.getTotalFat());
    }

    @Test
    public void testEquals_Reflexivity() {
        assertTrue(meal1.equals(meal1));
    }

    @Test
    public void testEquals_Symmetry() {
        assertTrue(meal1.equals(meal2) && meal2.equals(meal1));
    }

    @Test
    public void testEquals_Transitivity() {
        Meal meal4 = new Meal("Meal 1", meal1.getFoods());
        assertTrue(meal1.equals(meal2) && meal2.equals(meal4) && meal1.equals(meal4));
    }

    @Test
    public void testEquals_Null() {
        assertFalse(meal1.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        Object differentClassObject = new String("Not a Meal");
        assertFalse(meal1.equals(differentClassObject));
    }

    @Test
    public void testEquals_DifferentName() {
        Meal mealWithDifferentName = new Meal("Meal 2", meal1.getFoods());
        assertFalse(meal1.equals(mealWithDifferentName));
    }

    @Test
    public void testEquals_DifferentFoods() {
        assertFalse(meal1.equals(meal3));
    }

    @Test
    public void testHashCode_Consistency() {
        int hashCode1 = meal1.hashCode();
        assertEquals(hashCode1, meal1.hashCode());
    }

    @Test
    public void testHashCode_Equality() {
        assertEquals(meal1.hashCode(), meal2.hashCode());
    }
}


