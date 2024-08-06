package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class MainMenuUI extends JPanel {
    private static int WIDTH = MealTrackerUI.WIDTH;
    private static int HEIGHT = MealTrackerUI.HEIGHT;
    private static int LOW_BORDER = 100;
    private static int SPACE = 40;
    private static int LEFT_BORDER = 60;
    private MealTrackerUI parentObj;
    private User user;
    private JLabel userInfoLabel;
    private JPanel userInfoPanel;

    // EFFECTS: initialize all the components in the main menu
    public MainMenuUI(MealTrackerUI parentObj) {
        this.parentObj = parentObj;
        user = parentObj.getUser();
        userInfoLabel = new JLabel();
        userInfoPanel = new JPanel();
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setupButtons(parentObj);
        setupUserInfoPanel();
    }

    // MODIFIES: this
    // EFFECTS: set up the user info panel on the right
    private void setupUserInfoPanel() {
        userInfoPanel = new JPanel();
        userInfoPanel.setLayout(null);
        userInfoPanel.setBounds(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        userInfoLabel = new JLabel();
        userInfoLabel.setBounds(10, 0, WIDTH / 2 - 100, HEIGHT - 20);
        userInfoPanel.add(userInfoLabel);
        add(userInfoPanel);
        updateUserInfoLabel();
    }

    // MODIFIES: this
    // EFFECTS: set up all the buttons and their functions on the left
    private void setupButtons(MealTrackerUI parentObj) {
        JButton addFoodButton = addButton("Add Food", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 7);
        addFoodFunction(addFoodButton);
        JButton viewFoodsButton = addButton("View Saved Foods", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 6);
        setViewFoodsFunction(viewFoodsButton);
        JButton viewMealsButton = addButton("View Saved Meals", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 5);
        setViewMealsFunction(viewMealsButton);
        JButton createManualMealButton = addButton("Create Meal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 4);
        setCreateManualMealFunction(createManualMealButton);
        JButton generateMealButton = addButton("Auto Generated Meal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 3);
        setGenerateMealFunction(generateMealButton);
        JButton evaluateMealButton = addButton("Evaluate Meal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 2);
        setEvaluateMealFunction(evaluateMealButton);
        JButton changeGoalButton = addButton("Change Goal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 1);
        setChangeGoalFunction(changeGoalButton);
        JButton saveDataButton = addButton("Save Data", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 0);
        setSaveDataFunction(saveDataButton);
    }

    // EFFECTS: open add food panel when button is pressed
    private void addFoodFunction(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFoodUI addFoodUI = new AddFoodUI(parentObj, user);
                addFoodUI.setVisible(true);
            }
        });
    }

    // EFFECTS: open view foods panel when button is pressed
    private void setViewFoodsFunction(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewFoodsUI viewFoodsUI = new ViewFoodsUI(parentObj, user);
                viewFoodsUI.setVisible(true);
            }
        });
    }

    // EFFECTS: open view meals panel when button is pressed
    private void setViewMealsFunction(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMealsUI viewMealsUI = new ViewMealsUI(parentObj, user);
                viewMealsUI.setVisible(true);
            }
        });
    }

    // EFFECTS: create new panel that prompt user to select the foods to add 
    private void setCreateManualMealFunction(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateMealUI createMealUI = new CreateMealUI(parentObj, user);
                createMealUI.setVisible(true);
            }
        });
    }

    // EFFECTS: generate a new meal and save to user based on goals
    private void setGenerateMealFunction(JButton button) {

    }

    // EFFECTS: evaluate the meal that the user select based on goals
    private void setEvaluateMealFunction(JButton button) {

    }

    // MODIFIES: this
    // EFFECTS: change the user's goals and update info label when button is pressed
    private void setChangeGoalFunction(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.changeGoal();
                updateUserInfoLabel();
            }
        });
    }

    // EFFECTS: save user's current data into users.json
    private void setSaveDataFunction(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentObj.saveUser();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: add a new button with text inside and set position. 
    private JButton addButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 170, 35);
        add(button);
        return button;
    }

    // MODIFIES: this
    // EFFECTS: update the new user info label and remove existing one
    private void updateUserInfoLabel() {
        String userInfo = "<html>"
                + "<div style='text-align: left; font-size: 13px;'>"
                + "<b>Name:</b> " + user.getName() + "<br><br>"
                + "<b>Weight:</b> " + user.getWeight() + " kg<br><br>"
                + "<b>Height:</b> " + user.getHeight() + " cm<br><br>"
                + "<b>Sex:</b> " + user.getSex() + "<br><br>"
                + "<b>Age:</b> " + user.getAge() + "<br><br>"
                + "<b>Goal:</b> " + user.getGoalsForUI()
                + "</div></html>";
        userInfoLabel.setText(userInfo);
        userInfoLabel.setVerticalAlignment(SwingConstants.CENTER);
        userInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userInfoPanel.revalidate();
        userInfoPanel.repaint();
    }

}
