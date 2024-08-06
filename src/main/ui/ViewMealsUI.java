package ui;

import model.User;
import model.Meal;
import javax.swing.*;
import java.util.List;

public class ViewMealsUI extends ViewItems {
    
    private User user;

    // EFFECTS: initialize the view meals panel
    public ViewMealsUI(JFrame parentObj, User user) {
        super(parentObj, "Saved Meals");  
        this.user = user;
        itemDisplay();
    }

    // EFFECTS: display the meals stored in user using html
    @Override
    public void itemDisplay() {
        List<Meal> listOfMeals = user.getMeals();
        for (int i = 0; i < listOfMeals.size(); i++) {
            Meal meal = listOfMeals.get(i);
            String formattedText = String.format(
                    "<html>%d. <b>%s</b>:<br>"
                            + "&nbsp;&nbsp;&nbsp;Total Calories: %.1f<br>"
                            + "&nbsp;&nbsp;&nbsp;Total Protein: %.1f g<br>"
                            + "&nbsp;&nbsp;&nbsp;Total Carbs: %.1f g<br>"
                            + "&nbsp;&nbsp;&nbsp;Total Fat: %.1f g</html>",
                    i + 1,
                    meal.getName(),
                    meal.getTotalCalories(),
                    meal.getTotalProtein(),
                    meal.getTotalCarbs(),
                    meal.getTotalFat());
            JLabel itemLabel = new JLabel(formattedText);
            itemLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); 
            contentPanel.add(itemLabel);
        }
    }
}
