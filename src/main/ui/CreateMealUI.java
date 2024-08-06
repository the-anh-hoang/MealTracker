package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class CreateMealUI extends JDialog {
    private User user;
    private JList<String> foodList;
    private DefaultListModel<String> foodListModel;
    private JButton saveButton;
    private JTextField nameField;

    // EFFECTS: instantiate new create meal panel
    public CreateMealUI(JFrame parentObj, User user) {
        super(parentObj, "Create New Meal", true);
        this.user = user;
        setUpPanel(parentObj);
        setUpNameField();
        renderFoodList();
        addAndInitializeSaveButton();

    }

    // EFFECTS: add save button and initialize action
    private void addAndInitializeSaveButton() {
        saveButton = new JButton("Save Meal");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMeal();
            }
        });
        add(saveButton, BorderLayout.SOUTH);
    }

    // MODIFIES: user
    // EFFECTS: getting the food indicies selected and create a new meal
    // add the new meal to user.
    // If no foods are selected, meal will not be created
    private void saveMeal() {
        if (!foodList.getSelectedValue().isEmpty()) {
            List<Food> selectedFoods = new ArrayList<>();
            List<Food> userFoods = user.getFoods();
            for (int i : foodList.getSelectedIndices()) {
                selectedFoods.add(userFoods.get(i));
            }
            Meal newMeal = new Meal(nameField.getText());
            for (Food f : selectedFoods) {
                newMeal.addFood(f);
            }
            user.addMeal(newMeal);
            dispose();
        } else {
            dispose();
        }
    }

    // EFFECTS: render the food list by name
    private void renderFoodList() {
        foodListModel = new DefaultListModel<>();
        for (Food f : user.getFoods()) {
            foodListModel.addElement(f.getName());
        }
        foodList = new JList<>(foodListModel);
        add(new JScrollPane(foodList), BorderLayout.CENTER);
    }

    // EFFECTS: put both name field and label into a panel, put that panel on top
    private void setUpNameField() {
        JPanel namePanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("Meal's name: ");
        nameField = new JTextField();
        namePanel.add(nameLabel, BorderLayout.NORTH);
        namePanel.add(nameField, BorderLayout.CENTER);
        add(namePanel, BorderLayout.NORTH);
    }

    // EFFECTS: setup the new panel for user input
    private void setUpPanel(Frame parentObj) {
        setSize(300, 400);
        setLocationRelativeTo(parentObj);
        setLayout(new BorderLayout());
    }
}
