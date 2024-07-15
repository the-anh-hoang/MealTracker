package model;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String name;
    private List<Food> foods;

    // EFFECTS: instantiates an empty meal with a given name, no food added,
    // and no nutrition values. 
    public Meal(String name) {
        this.name = name;
        foods = new ArrayList<Food>();
    }
    
    // MODIFIES: this
    // EFFECTS: add a food item to the meal
    public void addFood(Food food) {
        foods.add(food);
    }

    // REQUIRES: 1 <= index <= foods.length() 
    // MODIFIES: this
    // EFFECTS: remove a food item from based on it's index (from 1) in the meal
    public void removeFood(int index) {
        foods.remove(index-1);
    }

    // EFFECTS: return the sum of calories of all food items in this
    public float getTotalCalories() {
        float totalCalories = 0;
        for (Food f : foods) {
            totalCalories += f.getCalories();
        }    
        return totalCalories;
    }

    // EFFECTS: return the sum of protein of all food items in this
    public float getTotalProtein() {
        float totalProtein = 0;
        for (Food f : foods) {
            totalProtein += f.getProtein();
        }    
        return totalProtein;
    }

    // EFFECTS: return the sum of carbs of all food items in this
    public float getTotalCarbs() {
        float totalCarbs = 0;
        for (Food f : foods) {
            totalCarbs += f.getCarbs();
        }    
        return totalCarbs;
    }

    // EFFECTS: return the sum of fat of all food items in this
    public float getTotalFat() {
        float totalFat = 0;
        for (Food f : foods) {
            totalFat += f.getFat();
        }    
        return totalFat;
    }

    public String getName() {
        return this.name;
    }

    public List<Food> getFoods() {
        return this.foods;
    }
}
