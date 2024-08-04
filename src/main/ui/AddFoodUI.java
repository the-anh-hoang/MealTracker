package ui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Food;
import model.User;

public class AddFoodUI extends JDialog {
    private static final int COLS = 10; 
    private JTextField nameField;
    private JTextField caloriesField;
    private JTextField proteinField;
    private JTextField carbsField;
    private JTextField fatField;
    private JButton submitButton;
    private User user;
    private JFrame parentObj; 

    public AddFoodUI(JFrame parentObj, User user) {
        super(parentObj, "Add Food", true); 
        this.parentObj = parentObj;
        this.user = user;
        setSize(300, 300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        panelSetup();
    }

    private void panelSetup() {
        nameField = new JTextField(COLS);
        addField("Food Name: ", nameField);
        caloriesField = new JTextField(COLS);
        addField("Calories: ", caloriesField);
        proteinField = new JTextField(COLS);
        addField("Protein: ", proteinField);
        carbsField = new JTextField(COLS);
        addField("Carbs: ", carbsField);
        fatField = new JTextField(COLS);
        addField("Fat: ", fatField);
        submitButton = new JButton("Add");
        submitButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitFood(); 
            }
        }));
        add(submitButton);
        setLocationRelativeTo(parentObj);
    }

    private void submitFood() {
        String name = nameField.getText();
        int calories = Integer.parseInt(caloriesField.getText());
        float protein = Float.parseFloat(proteinField.getText());
        float carbs = Float.parseFloat(carbsField.getText());
        float fat = Float.parseFloat(fatField.getText());

        Food food = new Food(name, calories, protein, carbs, fat);
        user.addFood(food);
        dispose();
    }

    private void addField(String prompt, JTextField field) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(prompt));
        panel.add(field);
        add(panel); 
        panel.setBorder(BorderFactory.createEmptyBorder(8, 10, 2, 10));  // Reduced padding
        add(panel);
    }
}
