package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;

public class MealTest {
    private Meal testMeal;
    private Food food1;
    private Food food2;
    private Food food3;

    @BeforeEach
    void beforeEach() {
        food1 = new Food("Wings", 300, 20, 10, 10);
        food2 = new Food("Egg", 60, 6, 1, 5);
        food3 = new Food("fish", 200, 30, 2, 50);
        testMeal = new Meal("Meal 1");
        testMeal.addFood(food1);
        testMeal.addFood(food2);
        testMeal.addFood(food3);
    }

    @Test
    void testMeal() {
        assertEquals(testMeal, testMeal.getName());
        assertEquals(new ArrayList<Food>(), testMeal.getFoods());
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

}
