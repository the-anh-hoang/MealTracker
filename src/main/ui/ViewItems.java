package ui;

import java.awt.Component;
import javax.swing.*;
import model.Food;
import model.Meal;

public abstract class ViewItems extends JDialog {

    protected JPanel mainPanel;
    protected JFrame parentObj;

    // EFFECTS: initialize a panel for viewing items in a list
    public ViewItems(JFrame parentObj, String title) {
        super(parentObj, title, true);
        this.parentObj = parentObj;
        mainPanel = new JPanel();
        setUpMainPanel();

    }

    private void setUpMainPanel() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        setSize(500, 300);
        // setUpScrollPanel();
        add(mainPanel);
    }

    protected abstract void setUpButtonPanel();

    // MODIFIES: this
    // EFFECTS: adding a scroll pane for long lists
    protected abstract void setUpScrollPanel();

    // Render class for formating different items in html
    protected class ItemListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Food) {
                Food food = (Food) value;
                setText(String.format(
                        "<html><b>%s</b>: <br> Calories: %.1f, Protein: %.1f g, Carbs: %.1f g, Fat: %.1f g</html>",
                        food.getName(), food.getCalories(), food.getProtein(), food.getCarbs(), food.getFat()));
            } else if (value instanceof Meal) {
                Meal meal = (Meal) value;
                setText(String.format(
                        "<html><b>%s</b>: <br> "
                                + "Total Calories: %.1f, Total Protein: %.1f g, Total Carbs: %.1f g, Fat: %.1f g</html>",
                        meal.getName(), meal.getTotalCalories(), meal.getTotalProtein(), meal.getTotalCarbs(),
                        meal.getTotalFat()));
            }
            this.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
            return this;
        }
    }
}
