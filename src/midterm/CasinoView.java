package midterm;

import mvc.*;

import javax.swing.*;
import java.awt.*;

public class CasinoView extends View {
    JTextField die1Field = new JTextField("1", 5); // displays 1 in 5 columns
    JTextField die2Field = new JTextField("1", 5);
    JTextField scoreField = new JTextField("1", 5);
    // etc.


    public CasinoView(Model newModel) {
        super(newModel);
        // Create a JPanel to hold components
        JPanel panel = new JPanel();

        // Set layout to GridLayout with 3 rows and 2 columns
        panel.setLayout(new GridLayout(3, 2, 5, 5)); // 5 pixels of horizontal and vertical gap between components

        // Create and add JLabels and JTextFields
        JLabel label1 = new JLabel("Die 1:");
        panel.add(label1);
        panel.add(die1Field);

        JLabel label2 = new JLabel("Die 2:");
        panel.add(label2);
        panel.add(die2Field);

        JLabel label3 = new JLabel("Score:");
        panel.add(label3);
        panel.add(scoreField);

        // Add the panel to the frame
        add(panel);

        // Set the size of the frame
        setSize(300, 200); // Adjust the size as needed

        // Make the frame visible
        setVisible(true);
    }


    @Override
    public void update() {
        super.update();
        Casino casino = (Casino) model;
        die1Field.setText(String.valueOf(casino.die1));
        die2Field.setText(String.valueOf(casino.die2));
        scoreField.setText(String.valueOf(casino.score));
    }

}
