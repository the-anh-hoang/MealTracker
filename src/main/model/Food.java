package model;

public class Food {
    
    private String name;
    private float calories;
    private float protein;
    private float carbs;
    private float fat;
    // EFFECTS: creates a new instance of Food with given name, amount of calories
    // protein (g), carbohydrates (g), and fat (g) 
    public Food(String name, float calories,float protein, float carbs, float fat) {
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
}
