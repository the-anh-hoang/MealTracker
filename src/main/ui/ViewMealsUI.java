package ui;

import model.User;
import model.Meal;
import javax.swing.*;
import java.awt.*;

public class ViewMealsUI extends ViewItems {

    private User user;
    private DefaultListModel<Meal> mealListModel;
    private JList<Meal> mealJList;

    // EFFECTS: initialize the view meals panel
    public ViewMealsUI(JFrame parentObj, User user) {
        super(parentObj, "Saved Meals");
        this.user = user;
        mealListModel = new DefaultListModel<>();
        mealJList = new JList<>(mealListModel);
        setUpScrollPanel();
        setUpButtonPanel();
    }

    // EFFECTS: set up the scroll panel displaying all the meals
    @Override
    protected void setUpScrollPanel() {
        user.getMeals().forEach(mealListModel::addElement);
        mealJList.setCellRenderer(new ItemListCellRenderer());
        mealJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(mealJList);
        mainPanel.add(scrollPane);
    }

    // EFFECTS: set up the buttons and their function in the button panel
    @Override
    protected void setUpButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Meal");
        addButton.setVisible(true);
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove Meal");
        removeButton.setVisible(true);

        JButton evaluateButton = new JButton("Evaluate Meal");
        evaluateButton.setVisible(true);

        buttonPanel.add(removeButton);
        mainPanel.add(buttonPanel);
    }
}
