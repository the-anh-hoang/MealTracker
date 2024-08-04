package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONObject;
import persistence.Writable;

public class Meal implements Writable {
    private String name;
    private List<Food> foods;

    // EFFECTS: instantiates an empty meal with a given name, no food added,
    // and no nutrition values.
    public Meal(String name) {
        this.name = name;
        foods = new ArrayList<Food>();
    }

    // EFFECTS instantiates a meal with name and consists of given foods.
    // For testing purposes. 
    public Meal(String name, List<Food> listOfFoods) {
        this.name = name;
        foods = listOfFoods; 
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
        foods.remove(index - 1);
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("foods", foods);
        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Meal meal = (Meal) o;
        return Objects.equals(name, meal.name)
                && Objects.equals(foods, meal.foods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, foods);
    }
}
