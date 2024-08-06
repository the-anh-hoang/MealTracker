package ui;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class ImagePanel extends JPanel {
    private Image backgroundImage;

    // EFFECTS: initialize the background image stored in path
    public ImagePanel(String path) {
        setLayout(null);
        try {
            URL imageURL = getClass().getResource(path);
            backgroundImage = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // MODIFIES: this
    // EFFECTS: paint the background image onto the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this); 
        }
    }
}
