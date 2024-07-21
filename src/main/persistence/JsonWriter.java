package persistence;

import java.io.*;
import org.json.JSONObject;

import model.User;

public class JsonWriter {

    // Represents a writer that writes JSON info representation of user to file
    private static final int TAB = 4;
    private PrintWriter writer;
    private String dest;

    // EFFECTS: construcs writer to write to specified destination
    public JsonWriter(String dest) {
        this.dest = dest; 
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file
    // cannot be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(dest));
    }
    
    // MODIFIES: this
    // EFFECTS: writes JSON representation of User to file
    public void write(User user) {
        JSONObject json = user.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json); 
    }
}
