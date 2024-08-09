package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class User implements Writable {
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
        EventLog.getInstance().logEvent(new Event("User: " + this.name));
    }

    // MODIFIES: this
    // EFFECT: change goal from "WL" to "MG" or vice versa
    public void changeGoal() {
        if (goals == "WL") {
            goals = "MG";
        } else {
            goals = "WL";
        }
        EventLog.getInstance().logEvent(new Event("Changed goal to: " + this.goals));
    }

    // MODIFIES: this
    // EFFECTS: add food into user's list of foods
    public void addFood(Food food) {
        foods.add(food);
        EventLog.getInstance().logEvent(new Event("Added food: " + food.getName()));
    }

    // MODIFIES: this
    // EFFECTS: save meal into user's list of foods
    public void addMeal(Meal meal) {
        meals.add(meal);
        EventLog.getInstance().logEvent(new Event("Added meal: " + meal.getName()));
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
        if (goals == "WL") {
            return evaluateWeightLoss(mealIndex, mealsPerDay);
        } else {
            return evaluateMuscleGain(mealIndex, mealsPerDay);
        }
    }

    private List<String> evaluateWeightLoss(int mealIndex, int mealsPerDay) {
        List<String> listOfErr = new ArrayList<String>();
        Meal selectedMeal = meals.get(mealIndex - 1);
        if (sex == "male") {
            if (selectedMeal
                    .getTotalCalories() > ((1.3 * ((13.397 * weight) + (4.799 * height) - (5.677 * age) + 88.362)
                            - 200) / mealsPerDay)) {
                listOfErr.add("Too much calories");
            }
        }
        if (sex == "female") {
            if (selectedMeal
                    .getTotalCalories() > ((1.3 * ((9.247 * weight) + (3.098 * height) - (4.330 * age) + 447.593)
                            - 200) / mealsPerDay)) {
                listOfErr.add("Too much calories");
            }
        }
        return listOfErr;
    }

    private List<String> evaluateMuscleGain(int mealIndex, int mealsPerDay) {
        List<String> listOfErr = new ArrayList<String>();
        Meal selectedMeal = meals.get(mealIndex - 1);

        if (selectedMeal.getTotalProtein() < ((1.4 * weight) / mealsPerDay)) {
            listOfErr.add("Not enough protein");
        }
        float totalNutrition = selectedMeal.getTotalProtein() + selectedMeal.getTotalCarbs()
                + selectedMeal.getTotalFat();
        if (selectedMeal.getTotalCarbs() > ((0.6 * totalNutrition) / mealsPerDay)) {
            listOfErr.add("Carbs percentage is too high!");
        }

        if (selectedMeal.getTotalFat() > ((0.25 * totalNutrition) / mealsPerDay)) {
            listOfErr.add("Fat percentage is too high!");
        }
        return listOfErr;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("username", name);
        json.put("weight", weight);
        json.put("height", height);
        json.put("sex", sex);
        json.put("age", age);
        json.put("goal", goals);
        json.put("Saved foods", savedFoodsToJson());
        json.put("Saved meals", savedMealsToJson());
        EventLog.getInstance().logEvent(new Event("Saved user: " + this.name));
        return json;
    }

    // EFFECTS: returns list of foods in this user as a JSON array
    private JSONArray savedFoodsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Food f : foods) {
            jsonArray.put(f.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns list of meals in this user to a JSON array
    private JSONArray savedMealsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Meal m : meals) {
            jsonArray.put(m.toJson());
        }
        return jsonArray;
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

    public int getAge() {
        return this.age;
    }

    public String getSex() {
        return this.sex;
    }

    public String getGoals() {
        return this.goals;
    }

    public List<Meal> getMeals() {
        return this.meals;
    }

    public List<Food> getFoods() {
        return this.foods;
    }

    // EFFECTS: return the full goal for UI
    public String getGoalsForUI() {
        if (goals.equals("MG")) {
            return "Muscle Gain";
        } else {
            return "Weight Loss"; 
        }
    }
}