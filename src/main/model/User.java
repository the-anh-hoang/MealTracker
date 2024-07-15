package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private float weight;
    private float height;
    private String sex;
    private int age;
    private String goals;
    private List<Meal> meals;
    private List<Food> foods;

    // REQUIRES: goals must be either "WL" or "MG";
    // sex must be male or female
    // EFFECT: create a new user with name, weight, height, age, sex, goals
    // with an empty food and meal list.
    public User(String name, float weight, float height, int age, String sex, String goals) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.goals = goals;
        this.meals = new ArrayList<Meal>();
        this.foods = new ArrayList<Food>();
    }

    // MODIFIES: this
    // EFFECT: change goal from "WL" to "MG" or vice versa
    public void changeGoal() {
        if (goals == "WL") {
            goals = "MG";
        } else {
            goals = "WL";
        }
    }

    // MODIFIES: this
    // EFFECTS: add food into user's list of foods
    public void addFood(Food food) {
        foods.add(food);
    }

    // MODIFIES: this
    // EFFECTS: save meal into user's list of foods
    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    // REQUIRES: mealsPerDay > 0
    // EFFECTS: evaluate the meal based on user's information and output what needs
    // to be fixed in diet:
    // If goal is "WL":
    // If sex is male
    // calories <= (1.3 * ((13.397 * weigth) + (4.799 * height) - (5.677 * age) +
    // 88.362) - 200)/ mealsPerDay
    // If sex is female
    // calories <= (1.3 * ((9.247 * weight) + (3.098 * height) - (4.330 * age) +
    // 447.593) - 200)/ mealsPerDay
    // If goal is "MG":
    // protein >= (1.4 * weight) / mealsPerDay
    // fat <= 0.25 * total nutrition value / mealsPerDay
    // carbs <= 0.6 * total nutrition value / mealsPerDay

    public List<String> evaluateNutrition(int mealIndex, int mealsPerDay) {
        List<String> listOfErr = new ArrayList<String>();
        Meal selectedMeal = meals.get(mealIndex - 1);
        if (goals == "WL") {
            if (sex == "male") {
                if (selectedMeal.getTotalCalories() > 
                    ((1.3 * ((13.397 * weight) + (4.799 * height) - (5.677 * age) + 88.362) - 200) / mealsPerDay)) {
                    listOfErr.add("Too much calories");
                }
            }
            if (sex == "female") {
                if (selectedMeal.getTotalCalories() >
                    ((1.3 * ((9.247 * weight) + (3.098 * height) - (4.330 * age) + 447.593) - 200)/ mealsPerDay)) {
                    listOfErr.add("Too much calories");
                }
            }
        } else {
            if (selectedMeal.getTotalProtein() < ((1.4*weight)/mealsPerDay)) {
                listOfErr.add("Not enough protein");
            }
            float totalNutrition = selectedMeal.getTotalProtein() + selectedMeal.getTotalCarbs() + selectedMeal.getTotalFat();
            if (selectedMeal.getTotalCarbs() > ((0.6 * totalNutrition)/mealsPerDay)) {
                listOfErr.add("Too much carbs");
            }
            
            if (selectedMeal.getTotalFat() > ((0.25 * totalNutrition)/mealsPerDay)) {
                listOfErr.add("Too much fat");
            }
            
        }
        return listOfErr; 
    }

    public String getName() {
        return this.name;
    }

    public float getWeight() {
        return this.weight;
    }

    public float getHeight() {
        return this.height;
    }

    public String getSex() {
        return sex;
    }

    public String getGoals() {
        return goals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Food> getFoods() {
        return foods;
    }

}
