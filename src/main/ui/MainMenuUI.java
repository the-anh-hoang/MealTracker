package ui;

import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class MainMenuUI extends JPanel {
    private static int WIDTH = MealTrackerUI.WIDTH;
    private static int HEIGHT = MealTrackerUI.HEIGHT;
    private static int LOW_BORDER = 110;
    private static int SPACE = 43;
    private static int LEFT_BORDER = 60;
    private User user; 

    public MainMenuUI(MealTrackerUI parentObj) {
        user = parentObj.getUser();
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
        button.setBounds(x, y, 150, 35);
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
        userInfoPanel.setBounds(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        JLabel userInfoLabel = new JLabel();
        userInfoLabel.setBounds(10, 0, WIDTH / 2 - 100, HEIGHT - 20);
        userInfoPanel.add(userInfoLabel);
        updateUserInfoLabel(userInfoLabel);

        add(userInfoPanel);
    }

    private void updateUserInfoLabel(JLabel userInfoLabel) {
        String userInfo = "<html>"
        + "<div style='text-align: left; font-size: 10px;'>"
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
