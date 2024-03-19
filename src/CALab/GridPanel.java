package CALab;

import mvc.*;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends AppPanel {

    public GridPanel(AppFactory factory) {
        super(factory);

        // Create buttons
        JButton run1Button = new JButton("Run1");
        JButton run50Button = new JButton("Run50");
        JButton populateButton = new JButton("Populate");
        JButton clearButton = new JButton("Clear");

        // Set preferred size for the buttons
        Dimension buttonSize = new Dimension(100, 30);
        run1Button.setPreferredSize(buttonSize);
        run50Button.setPreferredSize(buttonSize);
        populateButton.setPreferredSize(buttonSize);
        clearButton.setPreferredSize(buttonSize);

        // Add action listeners
        run1Button.addActionListener(this);
        run50Button.addActionListener(this);
        populateButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add buttons to the control panel
        controls.add(run1Button);
        controls.add(run50Button);
        controls.add(populateButton);
        controls.add(clearButton);
    }
}