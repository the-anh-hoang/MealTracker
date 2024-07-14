package model;

import java.util.List;

public class Meal {
    private String name;
    private List<Food> foods;

    // EFFECTS: instantiates an empty meal with a given name, no food added,
    // and no nutrition values. 
    public Meal(String name) {

    }
    
    // MODIFIES: this
    // EFFECTS: add a food item to the meal
    public void addFood(Food food) {

    }

    // MODIFIES: this
    // EFFECTS: remove a food item from based on it's index (from 1) in the meal
    public void removeFood(int index) {

    }

    // EFFECTS: return the sum of calories of all food items in this
    public float getTotalCalories() {
        return 0;    
    }

    // EFFECTS: return the sum of protein of all food items in this
    public float getTotalProtein() {
        return 0;
    }

    // EFFECTS: return the sum of carbs of all food items in this
    public float getTotalCarbs() {
        return 0;
    }

    // EFFECTS: return the sum of fat of all food items in this
    public float getTotalFat() {
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public List<Food> getFoods() {
        return this.foods;
    }

}
