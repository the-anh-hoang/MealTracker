package ui;

import javax.swing.*;
import java.awt.Dimension;


public abstract class ViewItems extends JDialog {

    protected JPanel contentPanel;
    protected JFrame parentObj;

    // EFFECTS: initialize a panel for viewing items in a list
    public ViewItems(JFrame parentObj, String title) {
        super(parentObj, title, true);
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        setSize(500, 700);
        this.parentObj = parentObj;
        addScrollPane();
        
    }


    public abstract void itemDisplay();
    
    public abstract void setUpButtons();

    // MODIFIES: this
    // EFFECTS: adding a scroll pane for long lists
    public void addScrollPane() {
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(380, 280));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);
    }

    // MODIFIES: this
    // EFFECTS: adding a close button to close the panel
    public void addCloseButton() {
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        contentPanel.add(closeButton);
        setLocationRelativeTo(parentObj);
    }
}
