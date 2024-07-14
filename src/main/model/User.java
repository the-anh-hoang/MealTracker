package model;

import java.util.List;

public class User {
    private String name; 
    private float weight;
    private float height;
    private String sex;
    private String goals; 
    private List<Meal> meals; 
    private List<Food> foods;
    

    // REQUIRES: goals must be either "WL" or "MG";
    // sex must be male or female
    // EFFECT: create a new user with name, weight, height, sex, goals
    // with an empty food and meal list.
    public User(String name, float weight, float height, String sex, String goals) {

    }

    // MODIFIES: this
    // EFFECT: change goal from "WL" to "MG" or vice versa,
    // and return the current goal
    public String changeGoal() {
        return null;
    }

    // MODIFIES: this
    // EFFECTS: save food into user's list of foods
    public void addFood(Food food) {
        
    }

    // MODIFIES: this
    // EFFECTS: save meal into user's list of foods
    public void addMeal(Meal meal) {

    }

    // EFFECTS: evaluate the meal based on user's information and output what needs
    // to be fixed in diet:
    // If goal is "WL":
    //   If sex is male
    //     calories <= (9.65 * weigth) + (573 * height) - (5.08 * age) - 240
    //     fat <= 0.3 * total nutrition value
    //     carbs <= 0.5 * total nutrition value
    //   If sex is female
    //     calories <= (7.38 * weight) + (607 * height) - (2.31 * age) - 457
    // If goal is "MG":
    //     protein >= (1.4 * weight)
    //     fat <= 0.25 * total nutrition value
    //     carbs <= 0.6 * total nutrition value

    public List<String> evaluateNutrition(Meal meal) {
        return null;
    }
}
