package CALab;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class GridPanel extends AppPanel {

    private JTextField dimField;

    public GridPanel(AppFactory factory) {
        super(factory);
        Grid grid = (Grid) view.model;
        grid.addPropertyChangeListener(this);
        controlPanel.setLayout(new FlowLayout()); // Use FlowLayout instead of GridLayout

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
        controlPanel.add(run1Button);
        controlPanel.add(run50Button);
        controlPanel.add(populateButton);
        controlPanel.add(clearButton);

        // Create grid panel (right side)
        JPanel gridPanel = new JPanel(new GridLayout(grid.getDim(), grid.getDim()));

        // Populate grid panel with cell views
        for (int i = 0; i < grid.getDim(); i++) {
            for (int j = 0; j < grid.getDim(); j++) {
                Cell cell = grid.getCell(i, j);
                CellView cellView = new CellView(cell);
                gridPanel.add(cellView);
            }
        }

        // Add grid panel to the main panel
        add(gridPanel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);
    }

    public static void main(String[] args) {
        AppFactory factory = new GridFactory();
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }
}