package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.MouseEvent;


import model.*;

class MealTrackerUI extends JFrame {
    
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;


    public MealTrackerUI() {
        super("Meal Tracker"); 
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new UserSelectionUI(this));
        setVisible(true);
    }

    public void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

  

    public static void main(String[] args) {
        new MealTrackerUI();
    }
    


}
