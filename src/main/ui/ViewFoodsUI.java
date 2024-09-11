package ui;

import model.User;
import model.Food;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFoodsUI extends ViewItems {

    private User user;
    private DefaultListModel<Food> foodListModel;
    private JList<Food> foodJList;

    // EFFECTS: initialize the view foods panel
    public ViewFoodsUI(JFrame parentObj, User user) {
        super(parentObj, "Saved Foods");
        this.user = user;
        itemDisplay();
        setUpButtons();
    }

    // EFFECTS: display the foods stored in user using html
    @Override
    protected void itemDisplay() {
        foodListModel = new DefaultListModel<>();
        user.getFoods().forEach(foodListModel::addElement);
        foodJList = new JList<>(foodListModel);
        foodJList.setCellRenderer(new FoodListCellRenderer());
        foodJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(foodJList);
        contentPanel.add(scrollPane);

    }

    protected void setUpButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Food");
        setAddButtonFunction(addButton);
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove Selected Food");
        setRemoveButtonFunction(removeButton);
        buttonPanel.add(removeButton);

        contentPanel.add(buttonPanel);
    }

    private void setAddButtonFunction(JButton addButton) {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFoodUI addFoodUI = new AddFoodUI(parentObj, user);
                addFoodUI.setVisible(true);
                foodListModel.clear();
                user.getFoods().forEach(foodListModel::addElement);
            }
        });

    }

    private void setRemoveButtonFunction(JButton removeButton) {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Food> selectedFoods = foodJList.getSelectedValuesList();
                for (Food f : selectedFoods) {
                    user.removeFood(f);
                    foodListModel.removeElement(f);
                }
                foodJList.repaint();
            }
        });
    }

    private class FoodListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Food) {
                Food food = (Food) value;
                setText(String.format(
                        "<html><b>%s</b>: Calories: %.1f, Protein: %.1f g, Carbs: %.1f g, Fat: %.1f g</html>",
                        food.getName(), food.getCalories(), food.getProtein(), food.getCarbs(), food.getFat()));
            }

            return this;
        }
    }
}
