package ui;

import model.User;
import model.Food;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFoodsUI extends ViewItems {

    private User user;
    private DefaultListModel<Food> foodListModel;
    private JList<Food> foodJList;

    // EFFECTS: initialize the view foods panel
    public ViewFoodsUI(JFrame parentObj, User user) {
        super(parentObj, "Saved Foods");
        this.user = user;
        foodListModel = new DefaultListModel<>();
        foodJList = new JList<>(foodListModel);
        setUpScrollPanel();
        setUpButtonPanel();
    }

    // EFFECTS: set up the scroll panel displaying the foods
    @Override
    protected void setUpScrollPanel() {
        user.getFoods().forEach(foodListModel::addElement);
        foodJList.setCellRenderer(new ItemListCellRenderer());
        foodJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(foodJList);
        mainPanel.add(scrollPane);
    }

    // EFFECTS: Setting up the buttons and their functions on the button panel
    @Override
    protected void setUpButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Food");
        setAddButtonFunction(addButton);
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove Selected Food");
        setRemoveButtonFunction(removeButton);
        buttonPanel.add(removeButton);

        mainPanel.add(buttonPanel);
    }

    // MODIFIES: user
    // EFFECTS: Setting the add food button
    private void setAddButtonFunction(JButton addButton) {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFoodUI addFoodUI = new AddFoodUI(parentObj, user);
                addFoodUI.setVisible(true);
                foodListModel.clear();
                user.getFoods().forEach(foodListModel::addElement);
            }
        });

    }

    // MODIFIES: user
    // EFFECTS: Setting the remove food button
    private void setRemoveButtonFunction(JButton removeButton) {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Food> selectedFoods = foodJList.getSelectedValuesList();
                for (Food f : selectedFoods) {
                    user.removeFood(f);
                    foodListModel.removeElement(f);
                }
                foodJList.repaint();
            }
        });
    }
}
