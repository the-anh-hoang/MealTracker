package model;

import java.util.List;

public class MealGenerator {
    private List<Food> savedFoods;
    // EFFECTS: create a new meal generator that has 
    // user saved foods
    public MealGenerator(List<Food> savedFoods) {
        
    }

    // REQUIRES: amount <= availableFoods.length()
    // EFFECTS: randomly pick items from availableFoods to create a meal
    // with the amount of items specified by customer
    public Meal generateRandomMeal(int amount) {
        return null; 
    }

    // REQUIRES: goal must be one of "WL"(weight loss) / "MG" (muscle gain)
    // and amount <= availableFoods.length()
    // EFFECT: generate a meal based on saved foods where:
    // If goal if "WL": 
    // generate a meal with specified amount of foods 
    // that contains lowest calories
    // If goal is "MG":
    // generate a meal with specified amount of foods
    // that contains highest protein 
    public Meal generateSuggestedMeal(String goal, int amount) {
        return null;
    }    

    public List<Food> getSavedFoods() {
        return savedFoods;
    }

    
}
