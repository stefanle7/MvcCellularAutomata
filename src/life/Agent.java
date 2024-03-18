package life;

import CALab.Cell;

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
        nextState();
        notifySubscribers();
    }

    @Override
    public void nextState() {
        if (status == 1 && status == 3) {
            status = 1;
        }
        else if (status == 1 && (ambience <= 1 || ambience >= 4)) {
            status = 0;
        }
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
