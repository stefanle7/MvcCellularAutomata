package CALab;

import javax.swing.*;
import java.awt.*;

import CALab.GridFactory;
import mvc.*;

public class GridPanel extends AppPanel {
    private JButton run1Button;
    private JButton run50Button;
    private JButton populateButton;
    private JButton clearButton;
    private JPanel gridPanel;

    public GridPanel(AppFactory af) {
        super(af);

        // Create buttons
        run1Button = new JButton("Run1");
        run50Button = new JButton("Run50");
        populateButton = new JButton("Populate");
        clearButton = new JButton("Clear");

        // Add action listeners
        run1Button.addActionListener(this);
        run50Button.addActionListener(this);
        populateButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add buttons to the control panel
        controlPanel.add(run1Button);
        controlPanel.add(run50Button);
        controlPanel.add(populateButton);
        controlPanel.add(clearButton);

        // Create grid panel (right side)
        gridPanel = new JPanel();
        // You would need to implement the display of the grid of cells within this panel
        // Add the grid panel to the main panel
        add(gridPanel);
    }

    // You may need to implement actionPerformed to handle button clicks

    public static void main(String[] args) {
        AppFactory factory = new GridFactory(); // Assuming you have a GridFactory
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }
}