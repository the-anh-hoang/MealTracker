package ui;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import model.*;
import persistence.*;

class MealTrackerUI extends JFrame {
    
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public static final String DEST = "./data/users.json"; 
    private User user;

    // EFFECTS: kicks off the program by prompting the user with UserSeleciton panel
    public MealTrackerUI() {
        super("Meal Tracker");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new UserSelectionUI(this));
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                printEventLog();
                System.exit(0);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: switch to new panel
    public void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    // MODIFIES: this
    // EFFECTS: load the user data from users.json and parse into this
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

    // EFFECTS: save current user's data into users.json
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

    // EFFECTS: print the event log to console
    public void printEventLog() {
        EventLog log = EventLog.getInstance();
        for (Event event : log) {
            System.out.println(event);
        }
    }

    public static void main(String[] args) {
        new MealTrackerUI();
    }
    
    

}
