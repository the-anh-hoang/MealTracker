package ui;

import javax.swing.*;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSelectionUI extends JPanel{
    public UserSelectionUI(MealTrackerUI parentObj) {
        setLayout(null);

        JButton loadDataButton = new JButton("Load Data");
        loadDataButton.setBounds(MealTrackerUI.WIDTH/2 - 150, MealTrackerUI.HEIGHT/2-30, 300, 80);
        add(loadDataButton);  
        setLoadDataAction(loadDataButton, parentObj); 
        JButton newUserButton = new JButton("New User");
        newUserButton.setBounds(MealTrackerUI.WIDTH/2 - 150, MealTrackerUI.HEIGHT/2 - 120, 300, 80); 
        add(newUserButton);
        
    }

    private void setLoadDataAction(JButton button, MealTrackerUI parentObj) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // function for loading data. 
                parentObj.switchPanel(new MainMenuUI(parentObj)); 
            }
        });
    }


    
}
