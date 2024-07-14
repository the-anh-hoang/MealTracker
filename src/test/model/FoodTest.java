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
}
