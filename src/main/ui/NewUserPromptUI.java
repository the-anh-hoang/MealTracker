package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import model.User; 

public class NewUserPromptUI extends JPanel {
    private MealTrackerUI parentObj; 
    private JTextField nameField;
    private JTextField weightField;
    private JTextField heightField;
    private JTextField ageField;
    private JComboBox<String> sexField;
    private JComboBox<String> goalField;
    private static final int FIELD_WIDTH = 150;
    private static final int FIELD_HEIGHT = 30;
    private static final int XCOR = 100;
    private static final int HEIGHT_START = 40;
    private static final int SPACING = 50;

    public NewUserPromptUI(MealTrackerUI parentObj) {
        this.parentObj = parentObj; 
        setLayout(null);
        setUpLabel("Name: ", HEIGHT_START);
        nameField = setUpField(HEIGHT_START);

        setUpLabel("Weight (kg): ", HEIGHT_START + SPACING);
        weightField = setUpField(HEIGHT_START + SPACING);

        setUpLabel("Height (cm): ", HEIGHT_START + SPACING * 2);
        heightField = setUpField(HEIGHT_START + SPACING * 2);

        setUpLabel("Age: ", HEIGHT_START + SPACING * 3);
        ageField = setUpField(HEIGHT_START + SPACING * 3);

        setUpLabel("Sex: ", HEIGHT_START + SPACING * 4);
        Vector<String> sexChoices = new Vector<>(Arrays.asList("Male", "Female"));
        sexField = setUpComboChoice(sexChoices, HEIGHT_START + SPACING * 4);

        setUpLabel("Goal: ", HEIGHT_START + SPACING * 5);
        Vector<String> goalChoices = new Vector<>(Arrays.asList("Muscle Gain", "Weight Loss"));
        goalField = setUpComboChoice(goalChoices, HEIGHT_START + SPACING * 5);

        setUpSubmitButton();
    }

    private void setUpLabel(String labelName, int ycor) {
        JLabel label = new JLabel(labelName);
        label.setBounds(XCOR, ycor, FIELD_WIDTH, FIELD_HEIGHT);
        add(label);
    }

    private JTextField setUpField(int ycor) {
        JTextField textField = new JTextField(20);
        textField.setBounds(XCOR + 100, ycor, FIELD_WIDTH, FIELD_HEIGHT);
        add(textField);
        return textField;
    }

    private JComboBox<String> setUpComboChoice(Vector<String> choices, int ycor) {
        JComboBox<String> combo = new JComboBox<>(choices);
        combo.setBounds(XCOR + 100, ycor, FIELD_WIDTH, FIELD_HEIGHT);
        add(combo);
        return combo;
    }

    private void setUpSubmitButton() { 
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(400, MealTrackerUI.HEIGHT/2 - 75, 150, 100);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                float weight = Float.parseFloat(weightField.getText());
                float height = Float.parseFloat(heightField.getText());
                int age = Integer.parseInt(ageField.getText());
                String sex = (String) sexField.getSelectedItem();
                String goal = (String) goalField.getSelectedItem();
                if (goal.equals("Muscle Gain")) {
                    goal = "MG";
                } else {
                    goal = "WL";
                }

                User newUser = new User(name, weight, height, age, sex, goal);
                parentObj.setUser(newUser); 
                parentObj.switchPanel(new MainMenuUI(parentObj));
            }
        });
    }

}
