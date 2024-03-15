package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import CALab.GridFactory;
import mvc.*;

public class GridPanel extends AppPanel {

    // Constructor
    public GridPanel(AppFactory af) {
        super(af);
        addButtons();
    }

    // Add buttons to the control panel
    private void addButtons() {
        JButton run1Button = new JButton("Run1");
        JButton run50Button = new JButton("Run50");
        JButton populateButton = new JButton("Populate");
        JButton clearButton = new JButton("Clear");

        run1Button.addActionListener(this);
        run50Button.addActionListener(this);
        populateButton.addActionListener(this);
        clearButton.addActionListener(this);

        controlPanel.add(run1Button);
        controlPanel.add(run50Button);
        controlPanel.add(populateButton);
        controlPanel.add(clearButton);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); // Call the actionPerformed method of the superclass

        // Handle button-specific actions
        String command = e.getActionCommand();
        switch (command) {
            case "Run1":
                // Implement code to run one iteration
                break;
            case "Run50":
                // Implement code to run fifty iterations
                break;
            case "Populate":
                int choice = JOptionPane.showConfirmDialog(this, "Do you want to populate randomly?", "Populate Grid", JOptionPane.YES_NO_OPTION);
                boolean randomly = (choice == JOptionPane.YES_OPTION);

                // Populate the grid
                ((Grid) view.model).populate();
                break;
            case "Clear":
                // Implement code to clear the grid
                break;
            default:
                // Handle unrecognized command
                break;
        }
    }

    // main method for testing
    public static void main(String[] args) {
        AppFactory factory = new GridFactory(); // Assuming you have a GridFactory
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }
}