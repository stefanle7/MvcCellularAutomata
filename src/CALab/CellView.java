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

    public CellView() { this(null); }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState(); // Call nextState() method of the Cell when the button is clicked
        update(); // Update the view after changing the cell state
    }

    // called by notifySubscribers and GridView.update

    /* Im not sure if the parameters are needed */
//    @Override
//    public void update(String msg, Object oldState, Object newState) {
//        setBackground(myCell.getColor());
//        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
//        setText("" + myCell.getStatus());
//    }

    @Override
    public void update() {
        System.out.println("CellView updating...");
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getStatus());
    }
}