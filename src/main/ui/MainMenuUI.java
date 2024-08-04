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
    private User user; 

    public MainMenuUI(MealTrackerUI parentObj) {
        user = parentObj.getUser();
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        addButtons(parentObj);
    }

    private void addButtons(MealTrackerUI parentObj) {
        JButton addFoodButton = addButton("Add Food", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 7, parentObj);
        addFoodFunction(parentObj, addFoodButton); 
        JButton viewFoodsButton = addButton("View Saved Foods", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 6, parentObj);
        addViewFoodsFunction(parentObj, viewFoodsButton);
        JButton viewMealsButton = addButton("View Saved Meals", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 5, parentObj);
        JButton createManualMealButton = addButton("Create Meal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 4, parentObj);
        JButton generateMealButton = addButton("Auto Generated Meal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 3, parentObj); 
        JButton evaluateMealButton = addButton("Evaluate Meal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 2, parentObj);
        JButton changeGoalButton = addButton("Change Goal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 1, parentObj);
        JButton saveDataButton = addButton("Save Data", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 0, parentObj);
        addUserInfo(parentObj);
    }

    private void addFoodFunction(MealTrackerUI parentObj, JButton button) {
        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFoodUI addFoodUI = new AddFoodUI(parentObj, user);
                addFoodUI.setVisible(true); 
            }
        });
    } 

    private void addViewFoodsFunction(MealTrackerUI parentObj, JButton button) {
        button.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ViewFoodsUI viewFoodsUI = new ViewFoodsUI(parentObj, user);
                viewFoodsUI.setVisible(true); 
            }
        });
    }

    private JButton addButton(String text, int x, int y, MealTrackerUI parentObj) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 170, 35);
        add(button);
        return button; 
    }

    private void addUserInfo(MealTrackerUI parentObj) {
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(null);
        userInfoPanel.setBounds(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        JLabel userInfoLabel = new JLabel();
        userInfoLabel.setBounds(10, 0, WIDTH / 2 - 100, HEIGHT - 20);
        userInfoPanel.add(userInfoLabel);
        updateUserInfoLabel(userInfoLabel);
        add(userInfoPanel);
    }

    private void updateUserInfoLabel(JLabel userInfoLabel) {
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
    }

}
