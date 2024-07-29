package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends JPanel {
    private static int WIDTH = MealTrackerUI.WIDTH;
    private static int HEIGHT = MealTrackerUI.HEIGHT;
    private static int LOW_BORDER = 100;
    private static int SPACE = 43;
    private static int LEFT_BORDER = 50;

    public MainMenuUI(MealTrackerUI parentObj) {
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        addButtons(parentObj);
    }

    private void addButtons(MealTrackerUI parentObj) {
        addButton("Add Food", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 6, parentObj);
        addButton("View Saved Foods", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 5, parentObj);
        addButton("View Saved Meals", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 4, parentObj);
        addButton("Create Meal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 3, parentObj);
        addButton("Evaluate Meal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 2, parentObj);
        addButton("Change Goal", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 1, parentObj);
        addButton("Save Data", LEFT_BORDER, HEIGHT - LOW_BORDER - SPACE * 0, parentObj);
        addUserInfo(parentObj); 
    }

    private void addButton(String text, int x, int y, MealTrackerUI parentObj) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(parentObj, text + " clicked");
            }
        });
        add(button);
    }
    
    private void addUserInfo(MealTrackerUI parentObj) {
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(null);
        userInfoPanel.setBounds(WIDTH/2, 0, WIDTH/2, HEIGHT);
        JLabel userInfoLabel = new JLabel();
        userInfoLabel.setVerticalAlignment(SwingConstants.TOP);
        userInfoLabel.setBounds(10, 10, WIDTH / 2 - 20, HEIGHT - 20);
        userInfoPanel.add(userInfoLabel);

        updateUserInfoLabel(userInfoLabel);

        add(userInfoPanel);
    }

    private void updateUserInfoLabel(JLabel userInfoLabel) {
       
            String userInfo = "<html>Name: " + "user.getName()" + "<br>" +
                              "Weight: " + "user.getWeight()" + "<br>" +
                              "Height: " + "user.getHeight()" + "<br>" +
                              "Sex: " + "user.getSex()" + "<br>" +
                              "Age: " + "user.getAge()" + "<br>" +
                              "Goal: " + "user.getGoal()" + "</html>";
            userInfoLabel.setText(userInfo);
      
    }
}
