package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MealGenerator {
    
    private List<Food> savedFoods;

    // EFFECTS: create a new meal generator that has 
    // user saved foods
    public MealGenerator(List<Food> savedFoods) {
        this.savedFoods = savedFoods;
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
        Meal suggestedMeal;
        if (goal.equals("WL")) {
            suggestedMeal = new Meal("Recommended For Weight Loss");
            savedFoods.sort(Comparator.comparingDouble(Food::getCalories));
        } else {
            suggestedMeal = new Meal("Recommended For Muscle Gain");
            savedFoods.sort((f1, f2) -> Float.compare(f2.getProtein(), f1.getProtein()));
        }
        for (int i = 0; i < amount; i++) {
            suggestedMeal.addFood(savedFoods.get(i));
        }
        return suggestedMeal;
    }    

    public List<Food> getSavedFoods() {
        return savedFoods;
    }

}
