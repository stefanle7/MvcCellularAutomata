package stax;

import mvc.*;
import javax.swing.*;
public class StackPanel extends AppPanel {
    public StackPanel(AppFactory factory) {
        super(factory);
        JButton button = new JButton("Clear");
        controls.add(button);
        button.addActionListener(this);
        button = new JButton("Push");
        controls.add(button);
        button.addActionListener(this);
        button = new JButton("Pop");
        controls.add(button);
        button.addActionListener(this);
        button = new JButton("Add");
        controls.add(button);
        button.addActionListener(this);
        button = new JButton("Mul");
        controls.add(button);
        button.addActionListener(this);
    }

    public static void main(String[] args) {
        AppPanel panel = new StackPanel(new StackFacrtory());
        panel.display();
    }

}
