package ui;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.*;
import persistence.*;

class MealTrackerUI extends JFrame {
    
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public static final String DEST = "./data/users.json"; 
    private User user;


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

    public void loadUserData() { 
        JsonReader jsonReader = new JsonReader(DEST);
        try {
            user = jsonReader.read();
            System.out.println(user.getAge());
            System.out.println("Loaded user " + user.getName() + " from" + DEST);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + DEST);
        }
    }

    public void saveUser() {
        JsonWriter jsonWriter = new JsonWriter(DEST);
        try {
            jsonWriter.open();
            jsonWriter.write(user);
            jsonWriter.close();
            System.out.println("Saved " + user.getName() + " to " + DEST);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + DEST);
        }
    }



    public User getUser() {
        return user; 
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static void main(String[] args) {
        new MealTrackerUI();
    }
    


}
