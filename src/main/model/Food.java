package model;

import java.util.Objects;

import org.json.JSONObject;
import persistence.Writable;

public class Food implements Writable {

    private String name;
    private float calories;
    private float protein;
    private float carbs;
    private float fat;

    // EFFECTS: creates a new instance of Food with given name, amount of calories
    // protein (g), carbohydrates (g), and fat (g)
    public Food(String name, float calories, float protein, float carbs, float fat) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public String getName() {
        return this.name;
    }

    public float getCalories() {
        return this.calories;
    }

    public float getCarbs() {
        return this.carbs;
    }

    public float getProtein() {
        return this.protein;
    }

    public float getFat() {
        return this.fat;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("calories", calories);
        json.put("protein", protein);
        json.put("carbs", carbs);
        json.put("fat", fat);
        return json;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return calories == food.calories &&
               protein == food.protein &&
               carbs == food.carbs &&
               fat == food.fat &&
               Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calories, protein, carbs, fat);
    }
}
