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
        myCell.nextState();
        // No need to call update() here since the view will be updated via the Subscriber mechanism
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
        System.out.println("here");
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getStatus());
    }
}