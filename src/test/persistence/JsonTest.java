package persistence;

import static org.junit.jupiter.api.Assertions.*;

import model.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

public class JsonTest {
    protected Food food1;
    protected Food food2;
    protected Food food3;
    protected Meal meal1;
    protected Meal meal2;
    protected List<Food> foodList;
    protected List<Meal> mealList;

    @BeforeEach
    void setUp() {
        food1 = new Food("Chicken", 200, 25, 2, 5);
        food2 = new Food("Salmon", 300, 25, 3, 12);
        food3 = new Food("Egg", 20, 6, 2, 5);

        meal1 = new Meal("meal1");
        meal1.addFood(food1);
        meal1.addFood(food2);
        meal2 = new Meal("meal2");
        meal2.addFood(food2);
        meal2.addFood(food3);

        foodList = new ArrayList<Food>();
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        mealList = new ArrayList<Meal>();
        mealList.add(meal1);
        mealList.add(meal2);
    }

    protected void checkUser(String name, float weight, float height, float age, String sex, String goals,
            List<Food> foods, List<Meal> meals, User user) {
        assertEquals(name, user.getName());
        assertEquals(weight, user.getWeight());
        assertEquals(height, user.getHeight());
        assertEquals(age, user.getAge());
        assertEquals(sex, user.getSex());
        assertEquals(goals, user.getGoals());
        assertTrue(foods.equals(user.getFoods()));
        assertTrue(meals.equals(user.getMeals()));
    }
}
