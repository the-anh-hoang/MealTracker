package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class FoodTest {

    private Food testFood;
    
    @BeforeEach
    void beforeEach() {
        testFood = new Food("Wings", 300, 20, 2, 10);
    }

    @Test
    void testFood() {
        assertEquals("Wings", testFood.getName());
        assertEquals(300, testFood.getCalories());
        assertEquals(20, testFood.getProtein()); 
        assertEquals(2, testFood.getCarbs());
        assertEquals(10, testFood.getFat());
    }


    @Test
    public void testEqualsReflexive() {
        Food food = new Food("Wings", 300, 20, 2, 10);
        assertTrue(food.equals(food));
    }


    @Test
    public void testEqualsNull() {
        assertFalse(testFood.equals(null));
    }

    @Test
    public void testEqualsDifferentClass() {
        String notFood = "Not a Food";
        assertFalse(testFood.equals(notFood));
    }

    @Test
    public void testEqualsDifferentName() {
        Food food1 = new Food("Apple", 300, 20, 2, 10);
        assertFalse(testFood.equals(food1));
    }

    @Test
    public void testEqualsDifferentCalo() {
        Food food1 = new Food("Wings", 301, 20, 2, 10);
        assertFalse(testFood.equals(food1));
    }

    @Test
    public void testEqualsDifferentProtein() {
        Food food1 = new Food("Wings", 300, 21, 2, 10);
        assertFalse(testFood.equals(food1));
    }

    @Test
    public void testEqualsDifferentCarbs() {
        Food food1 = new Food("Wings", 300, 20, 1, 10);
        assertFalse(testFood.equals(food1));
    }

    @Test
    public void testEqualsDifferentFat() {
        Food food1 = new Food("Wings", 300, 20, 2, 11);
        assertFalse(testFood.equals(food1));
    }

    @Test
    public void testHashCodeConsistency() {
        Food food = new Food("Wings", 300, 20, 2, 10);
        int initialHashCode = food.hashCode();
        assertEquals(initialHashCode, food.hashCode());
    }

}
