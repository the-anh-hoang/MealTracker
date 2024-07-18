package ui;

import java.util.List;
import java.util.Scanner;

import model.Food;
import model.Meal;
import model.MealGenerator;
import model.User;

public class Terminal {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------- Welcome to my Diet Planner --------");
        User user = createNewUser(scanner);
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            System.out.println("\n");
            switch (choice) {
                case 1:
                    addFood(user, scanner);
                    break;
                case 2:
                    viewSavedFoods(user.getFoods());
                    break;
                case 3:
                    viewSavedMeals(user.getMeals());
                    break;
                case 4:
                    createMealManual(user, scanner);
                    break;
                case 5:
                    generateMeal(user, scanner);
                    break;
                case 6:
                    evaluate(user, scanner);
                    break;
                case 7:
                    changeCurrentGoal(user);
                    break;
                case 8:
                    System.out.println("Thank you for using calories tracker!");
                    return;
                default:
                    System.out.println("Invalid, please enter single digits from 1-7!");
                    break;
            }
            System.out.println();
        }
    }

    private void changeCurrentGoal(User user) {
        user.changeGoal();
        if (("MG").equals(user.getGoals())) {
            System.out.println("Your goal is now set to gain muscle");
        } else {
            System.out.println("Your goal is now set to lost weight");
        }
    }

    private User createNewUser(Scanner scanner) {
        System.out.println(
                "First, please enter your name, weight, height, age, sex, and goals so we can best assist you!");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Weight (kg): ");
        Float weight = scanner.nextFloat();
        System.out.print("Height (cm): ");
        Float height = scanner.nextFloat();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Sex (male or female): ");
        String sex = scanner.next();
        System.out.print("Goals (\"WL\" for Weight Loss or \"MG\" for Muscle Gain): ");
        String goals = scanner.next();
        User user = new User(name, weight, height, age, sex, goals);
        System.out.println("\n");
        System.out.println("Thank you, the app is tailored to your specific characteristics!");
        System.out.println("Please choose from the options provided below by typing 1-8");
        return user;
    }

    private void printMenu() {
        System.out.println("---------------- Menu ---------------");
        System.out.println("1. Add new food");
        System.out.println("2. View saved foods");
        System.out.println("3. View saved meals");
        System.out.println("4. Create new meal (manual)");
        System.out.println("5. Generate a meal based on your goals");
        System.out.println("6. Evaluate your meal");
        System.out.println("7. Change goals");
        System.out.println("8. Exit");
        System.out.print("Choice: ");
    }

    // EFFECTS: ask for attributes of foods and save them to user's list
    private void addFood(User user, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Food name: ");
        String foodName = scanner.nextLine();
        System.out.print("Calories: ");
        Float calories = scanner.nextFloat();
        System.out.print("Protein (g): ");
        Float protein = scanner.nextFloat();
        System.out.print("Carbs (g): ");
        Float carbs = scanner.nextFloat();
        System.out.print("Fat (g): ");
        Float fat = scanner.nextFloat();
        user.addFood(new Food(foodName, calories, protein, carbs, fat));
        System.out.println("New food successfully added!");
    }

    private void viewSavedFoods(List<Food> userFoods) {
        if (userFoods.isEmpty()) {
            System.out.println("No foods saved.");
        } else {
            System.out.println("Here's your saved foods:");
            Food currentFood;
            for (int i = 0; i < userFoods.size(); i++) {
                currentFood = userFoods.get(i);
                System.out.println((i + 1) + ". " + currentFood.getName());
                System.out.println("    Calories: " + currentFood.getCalories());
                System.out.println("    Protein: " + currentFood.getProtein());
                System.out.println("    Carbs: " + currentFood.getCarbs());
                System.out.println("    Fat: " + currentFood.getFat());
            }
        }
    }

    private void viewSavedMeals(List<Meal> userMeals) {
        if (userMeals.isEmpty()) {
            System.out.println("No meals saved.");
        } else {
            Meal currentMeal;
            for (int i = 0; i < userMeals.size(); i++) {
                currentMeal = userMeals.get(i);
                System.out.println((i + 1) + ". " + currentMeal.getName());
                System.out.println("     Total Calories: " + currentMeal.getTotalCalories());
                System.out.println("     Total Protein: " + currentMeal.getTotalProtein());
                System.out.println("     Total Carbs: " + currentMeal.getTotalCarbs());
                System.out.println("     Total Fat: " + currentMeal.getTotalFat());
            }
        }
    }

    private void createMealManual(User user, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Meal's name: ");
        String name = scanner.nextLine();
        System.out.print("How much food would you like to add?: ");
        int amount = scanner.nextInt();
        List<Food> userFoods = user.getFoods();
        viewSavedFoods(userFoods);
        int selection;
        Meal newMeal = new Meal(name);
        for (int i = 0; i < amount; i++) {
            System.out.print("Please select the food you'd like to add (1-" + userFoods.size() + ")");
            selection = scanner.nextInt();
            newMeal.addFood(userFoods.get(selection - 1));
            System.out.println("Food added to meal successfully!");
            System.out.println();
        }
        user.addMeal(newMeal);
        System.out.println("Meal saved successfully!");
    }

    private void generateMeal(User user, Scanner scanner) {
        System.out.print("How much food would you like your meal to be? (maximum "
                + (user.getFoods()).size() + " items): ");
        int amount = scanner.nextInt();
        MealGenerator mealGenerator = new MealGenerator(user.getFoods());
        Meal newMeal = mealGenerator.generateSuggestedMeal(user.getGoals(), amount);
        System.out.println("Name: " + newMeal.getName());
        System.out.println("    Total Calories: " + newMeal.getTotalCalories());
        System.out.println("    Total Protein: " + newMeal.getTotalProtein());
        System.out.println("    Total Carbs: " + newMeal.getTotalCarbs());
        System.out.println("    Total Fat: " + newMeal.getTotalFat());
        user.addMeal(newMeal);
        System.out.println("Meal generated and added succesfully!");
    }

    private void evaluate(User user, Scanner scanner) {
        List<Meal> userMeals = user.getMeals();
        viewSavedMeals(userMeals);
        if (!userMeals.isEmpty()) {
            System.out.print("How meals would you be eating per day?: ");
            int mealsPerDay = scanner.nextInt();
            System.out.print("Select meal by index to evaluate: ");
            int selection = scanner.nextInt();
            List<String> listOfErr = user.evaluateNutrition(selection, mealsPerDay);
            if (listOfErr.isEmpty()) {
                System.out.println();
                System.out.println("--> This meals meets your goals and characteristics");
            } else {
                System.out.println();
                System.out.println("Problems !!");
                for (String str : listOfErr) {
                    System.out.println("  -> " + str);
                }
            }
        } else {
            return;
        }
    }

}
