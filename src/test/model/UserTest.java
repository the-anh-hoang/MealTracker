package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

public class UserTest {
    private User testUser1;
    private User testUser2;
    private User testUser3;
    private Food food1;
    private Food food2;
    private Food food3;
    private Food food4;
    private Food food5;
    private Food food6;
    private Meal testMeal;
    private Meal testMeal2;

    @BeforeEach
    public void beforeEach() {
        testUser1 = new User("Harry", 50, 170, 18, "male", "MG");
        testUser2 = new User("Jasmine", 55, 160, 20, "female", "WL");
        testUser3 = new User("Trung Rua", 80, 165, 21, "male", "WL");
        food1 = new Food("Wings", 800, 20, 10, 10);
        food2 = new Food("Egg", 1000, 6, 1, 5);
        food3 = new Food("fish", 1000, 30, 2, 50);
        food4 = new Food("Salmon", 250, 18, 40, 10);
        food5 = new Food("Chicken", 170, 40, 80, 5);
        food6 = new Food("Milk", 60, 20, 50, 5);
        testMeal = new Meal("Meal 1");
        testMeal.addFood(food1);
        testMeal.addFood(food2);
        testMeal.addFood(food3);
        testMeal2 = new Meal("Meal 2");
        testMeal2.addFood(food4);
        testMeal2.addFood(food5);
        testMeal2.addFood(food6);
    }

    @Test
    public void testUser() {
        assertEquals("Harry", testUser1.getName());
        assertEquals(50, testUser1.getWeight());
        assertEquals(170, testUser1.getHeight());
        assertEquals("male", testUser1.getSex());
        assertEquals("MG", testUser1.getGoals());
        assertEquals(new ArrayList<Meal>(), testUser1.getMeals());
        assertEquals(new ArrayList<Food>(), testUser1.getFoods());
    }

    @Test
    public void testGetGoalsForUI() {
        assertEquals("Muscle Gain", testUser1.getGoalsForUI());
        testUser1.changeGoal();
        assertEquals("Weight Loss", testUser1.getGoalsForUI()); 
    }

    @Test
    public void testChangeGoal() {
        testUser1.changeGoal();
        assertEquals("WL", testUser1.getGoals());
        testUser1.changeGoal();
        assertEquals("MG", testUser1.getGoals());
    }

    @Test
    public void testAddFood() {
        List<Food> listOfFoods = new ArrayList<Food>();
        testUser1.addFood(food1);
        listOfFoods.add(food1);
        assertEquals(listOfFoods, testUser1.getFoods());
        testUser1.addFood(food2);
        listOfFoods.add(food2);
        assertEquals(listOfFoods, testUser1.getFoods());
    }

    @Test
    public void testAddMeal() {
        List<Meal> listOfMeals = new ArrayList<Meal>();
        listOfMeals.add(testMeal);
        testUser1.addMeal(testMeal);
        assertEquals(listOfMeals, testUser1.getMeals());
        listOfMeals.add(testMeal2);
        testUser1.addMeal(testMeal2);
        assertEquals(listOfMeals, testUser1.getMeals());
    }

    @Test
    public void testEvaluateNutrition() {
        testUser1.addMeal(testMeal);
        testUser1.addMeal(testMeal2);
        testUser2.addMeal(testMeal);
        testUser2.addMeal(testMeal2);
        testUser3.addMeal(testMeal);
        testUser3.addMeal(testMeal2);

        List<String> user1MealEvaluate = new ArrayList<String>();
        user1MealEvaluate.add("Not enough protein");
        user1MealEvaluate.add("Fat percentage is too high!");

        assertEquals(user1MealEvaluate, testUser1.evaluateNutrition(1, 1));

        List<String> user1Meal2Evaluate = new ArrayList<String>();
        user1Meal2Evaluate.add("Carbs percentage is too high!");
        List<String> listOfErr = testUser1.evaluateNutrition(2, 1);
        assertEquals(user1Meal2Evaluate, listOfErr);

        List<String> user2MealEvaluate = new ArrayList<String>();
        user2MealEvaluate.add("Too much calories");
        assertEquals(user2MealEvaluate, testUser2.evaluateNutrition(1, 1));

        List<String> user2Meal2Evaluate = new ArrayList<String>();
        assertEquals(user2Meal2Evaluate, testUser2.evaluateNutrition(2, 1));

        List<String> user3MealEvaluate = new ArrayList<String>();
        user3MealEvaluate.add("Too much calories");
        assertEquals(user3MealEvaluate, testUser3.evaluateNutrition(1, 1));

        List<String> user3Meal2Evaluate = new ArrayList<String>();
        assertEquals(user3Meal2Evaluate, testUser3.evaluateNutrition(2, 1));

    }
}
