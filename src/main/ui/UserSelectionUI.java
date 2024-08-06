package ui;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserSelectionUI extends ImagePanel {

    private MealTrackerUI parentObj;

    // EFFECTS: setup the user selection panel
    public UserSelectionUI(MealTrackerUI parentObj) {
        super("./background.jpg"); 
        this.parentObj = parentObj;
        setLayout(null);
        setUpLoadDataButton();
        setUpNewUserButton(); 
    }

    // MODIFIES: this
    // EFFECTS: set up the load user button
    private void setUpLoadDataButton() {
        JButton loadDataButton = new JButton("Load Data");
        loadDataButton.setBounds(MealTrackerUI.WIDTH / 2 - 150, MealTrackerUI.HEIGHT / 2 - 30, 300, 80);
        add(loadDataButton);
        setLoadDataAction(loadDataButton, parentObj);
    }

    // MODIFIES: this    
    // EFFECTS: set up the new user button
    private void setUpNewUserButton() {
        JButton newUserButton = new JButton("New User");
        newUserButton.setBounds(MealTrackerUI.WIDTH / 2 - 150, MealTrackerUI.HEIGHT / 2 - 120, 300, 80);
        add(newUserButton);
        setNewUserAction(newUserButton, parentObj);
    }

    // MODIFIES: this
    // EFFECTS: set up the function for the load data button
    private void setLoadDataAction(JButton button, MealTrackerUI parentObj) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentObj.loadUserData();
                MainMenuUI mainMenu = new MainMenuUI(parentObj);
                parentObj.switchPanel(mainMenu);
            }
        });
    }  

    // MODIFIES: this
    // EFFECTS: set up the function for the new user button
    private void setNewUserAction(JButton button, MealTrackerUI parentObj) {
        button.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                //parentObj.createNewUser();
                NewUserPromptUI mainMenu = new NewUserPromptUI(parentObj);
                parentObj.switchPanel(mainMenu); 
            }
        });
    }
}
