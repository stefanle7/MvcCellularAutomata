package midterm;

import javax.swing.*;
import mvc.*;

public class CasinoPanel extends AppPanel {

    private JButton roll;
    public CasinoPanel(AppFactory factory) {
        super(factory);

        roll = new JButton("Roll");
        roll.addActionListener(this);
        controls.add(roll);
    }

    public static void main(String[] args) {
        AppFactory factory = new CasinoFactory();
        AppPanel panel = new CasinoPanel(factory);
        panel.display();
    }
}
