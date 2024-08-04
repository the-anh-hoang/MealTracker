package ui;

import model.User;
import model.Food;
import javax.swing.*;
import java.util.List;

public class ViewFoodsUI extends ViewItems {

    private User user;

    public ViewFoodsUI(JFrame parentObj, User user) {
        super(parentObj, "Saved Foods");
        this.user = user;
        itemDisplay();
    }

    @Override
    public void itemDisplay() {
        List<Food> listOfFoods = user.getFoods();
        for (int i = 0; i < listOfFoods.size(); i++) {
            Food food = listOfFoods.get(i);
            String formattedText = String.format(
                    "<html>%d. <b>%s</b>:<br>"
                            + "&nbsp;&nbsp;&nbsp;Calories: %.1f<br>"
                            + "&nbsp;&nbsp;&nbsp;Protein: %.1f g<br>"
                            + "&nbsp;&nbsp;&nbsp;Carbs: %.1f g<br>"
                            + "&nbsp;&nbsp;&nbsp;Fat: %.1f g</html>",
                    i + 1,
                    food.getName(),
                    food.getCalories(),
                    food.getProtein(),
                    food.getCarbs(),
                    food.getFat());
            JLabel itemLabel = new JLabel(formattedText);
            itemLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); 
            contentPanel.add(itemLabel);
        }
    }
}
