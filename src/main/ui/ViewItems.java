package ui;

import javax.swing.*;
import java.awt.Dimension;
import java.util.List; 
import model.User;


public abstract class ViewItems extends JDialog {

    protected JPanel contentPanel;
    private JFrame parentObj;

    public ViewItems(JFrame parentObj, String title) {
        super(parentObj, title, true);
        this.parentObj = parentObj;
        contentPanel = new JPanel();
        setSize(300, 400);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        addScrollPane();

    }

    public abstract void itemDisplay();

    public void addScrollPane() {
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(380, 280));
        add(scrollPane);
    }

    public void addCloseButton() {
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        contentPanel.add(closeButton);
        setLocationRelativeTo(parentObj);
    }
    
}
