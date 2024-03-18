package CALab.life;

import CALab.Cell;

import java.awt.*;
import java.util.Random;

public class Agent extends Cell {

    private int status = 0;
    private int ambience = 8;


    public Agent(int status) {
        this.status = status;
    }

    @Override
    public void observe() {
        // Initialize a counter to keep track of the number of living neighbors
        ambience = 0;

        // Iterate over the neighbors of the cell
        for (Cell neighbor : neighbors) {
            if (neighbor instanceof Agent) {
                // Check if the neighbor is alive
                if (((Agent) neighbor).status == 1) {
                    // Increment the counter if the neighbor is alive
                    ambience++;
                }
            }
        }
    }

    @Override
    public void interact() {
        // No interaction phase
    }

    @Override
    public void update() {
        // Update the status based on the number of living neighbors and the current status
        if (this.status == 1 && (this.ambience < 2 || this.ambience > 3)) {
            // If the cell is alive and has fewer than 2 or more than 3 living neighbors, it dies
            status = 0;
        } else if (this.status == 0 && ambience == 3) {
            // If the cell is dead and has exactly 3 living neighbors, it becomes alive
            status = 1;
        }
    }

    @Override
    public void nextState() {
        status = (status + 1) % 2;
    }

    @Override
    public void reset(boolean randomly) {
        if (randomly) {
            status = new Random().nextInt(2); // Generates either 0 or 1 randomly
        } else {
            status = 0; // Sets the status to dead (0)
        }
    }

    @Override
    public int getStatus() {
        return status; // Simply return the status value
    }

}
