package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

// replaced extends Bean with extends Publisher
public abstract class Cell extends Publisher implements Serializable {

    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<Cell>();
    protected Grid myGrid = null;
    protected Cell partner = null;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // choose a random neighbor as a partner
    public void choosePartner() {
        if (partner == null && neighbors != null) {
			/*
			Set partner to null
			Convert neighbors set to a local array
			Starting at a random position in the array search for a neighbor without a partner
			Make the first such neighbor (if any) the partner and set its partner field to this
			*/
            if (partner == null && neighbors != null) {
                // Convert neighbors set to a local array
                Cell[] neighborsArray = neighbors.toArray(new Cell[0]);

                // Shuffle the array to start searching from a random position
                Collections.shuffle(Arrays.asList(neighborsArray));

                // Search for a neighbor without a partner
                for (Cell neighbor : neighborsArray) {
                    if (neighbor.partner == null) {
                        // Set partner to the current neighbor
                        partner = neighbor;
                        // Set the partner's partner field to this cell
                        neighbor.partner = this;
                        break; // Exit loop after finding the first partner
                    }
                }
            }
        }

    }

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }

    public Color getColor() {
        if (this.getStatus() == 1) {
            return Color.GREEN; // Alive cells are represented in green
        } else {
            return Color.RED; // Dead cells are represented in red
        }
    }

    // observer neighbors' states
    public abstract void observe();
    // interact with a random neighbor
    public abstract void interact();
    // update my state
    public abstract void update();
    // set status to status + 1 mod whatever
    public abstract void nextState();
    // set status to a random or initial value
    public abstract void reset(boolean randomly);
    // determines if the cell is dead or alive
    public abstract int getStatus();

}