package ui;

import javax.swing.*;
import java.awt.Dimension;


public abstract class ViewItems extends JDialog {

    protected JPanel contentPanel;
    private JFrame parentObj;

    public ViewItems(JFrame parentObj, String title) {
        super(parentObj, title, true);
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        setSize(300, 400);
        this.parentObj = parentObj;
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
