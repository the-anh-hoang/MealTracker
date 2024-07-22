package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

import model.Food;
import model.Meal;
import model.User;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads user info from JSON file and returns it;
    // throws IOException if an error occurs while reading data
    public User read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseUser(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses user from JSON object and returns it
    private User parseUser(JSONObject jsonObject) {
        String name = jsonObject.getString("username");
        Float weight = jsonObject.getFloat("weight");
        Float height = jsonObject.getFloat("height");
        int age = jsonObject.getInt("age");
        String sex = jsonObject.getString("sex");
        String goals = jsonObject.getString("goal");

        User user = new User(name, weight, height, age, sex, goals);
        addFoods(user, jsonObject);
        addMeals(user, jsonObject);
        return user;
    }

    // MODIFIES: user
    // EFFECTS: parses saved foods from JSOn object and add to user
    private void addFoods(User user, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Saved foods");
        for (Object json : jsonArray) {
            JSONObject nextFood = (JSONObject) json;
            addFood(user, nextFood);
        }
    }

    // MODIFIES: user
    // EFFECTS: parses food from JSON object and add it to user
    private void addFood(User user, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Float calories = jsonObject.getFloat("calories");
        Float protein = jsonObject.getFloat("protein");
        Float fat = jsonObject.getFloat("fat");
        Float carbs = jsonObject.getFloat("carbs");
        Food tempFood = new Food(name, calories, protein, carbs, fat);
        user.addFood(tempFood);
    }

    // MODIFIES: user
    // EFFECTS: parses saved meals from JSON object and add to user
    private void addMeals(User user, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Saved meals");
        for (Object json : jsonArray) {
            JSONObject nextMeal = (JSONObject) json;
            addMeal(user, nextMeal);
        }
    }

    // MODIFIES: user
    // EFFECTS: parses meal from JSON object and add it to user
    private void addMeal(User user, JSONObject jsonObject) {
        JSONArray foodJsonArray = jsonObject.getJSONArray("foods");
        String name = jsonObject.getString("name");
        Meal meal = new Meal(name);
        for (Object foodJsonObject : foodJsonArray) {
            JSONObject food = (JSONObject) foodJsonObject;
            addFoodToMeal(meal, food);
        }
        user.addMeal(meal);
    }

    // MODIFIES: meal
    // EFFECTS: parses food from foodJsonObject and add it to meal
    private void addFoodToMeal(Meal meal, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Float calories = jsonObject.getFloat("calories");
        Float protein = jsonObject.getFloat("protein");
        Float fat = jsonObject.getFloat("fat");
        Float carbs = jsonObject.getFloat("carbs");
        Food tempFood = new Food(name, calories, protein, carbs, fat);
        meal.addFood(tempFood);
    }
}
