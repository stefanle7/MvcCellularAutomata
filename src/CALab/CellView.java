package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mvc.*;

public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
        update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState(); // Call nextState() method of the Cell when the button is clicked
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setText(String.valueOf(myCell.getStatus()));
    }

    // called by notifySubscribers and GridView.update
    @Override
    public void update() {
        System.out.println("CellView updating...");
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getStatus());
    }
}