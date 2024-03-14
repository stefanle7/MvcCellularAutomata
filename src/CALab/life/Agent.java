package CALab.life;

import CALab.Cell;

import java.awt.*;
import java.util.Random;

public class Agent extends Cell {

    private boolean alive;

    public Agent(boolean alive) {
        this.alive = alive;
    }

    int livingNeighborCount;


    @Override
    public void observe() {
        // Initialize a counter to keep track of the number of living neighbors
        livingNeighborCount = 0;

        // Iterate over the neighbors of the cell
        for (Cell neighbor : neighbors) {
            if (neighbor instanceof Agent) {
                // Check if the neighbor is alive
                if (((Agent) neighbor).alive) {
                    // Increment the counter if the neighbor is alive
                    livingNeighborCount++;
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
        if (alive && (livingNeighborCount < 2 || livingNeighborCount > 3)) {
            // If the cell is alive and has fewer than 2 or more than 3 living neighbors, it dies
            alive = false;
        } else if (!alive && livingNeighborCount == 3) {
            // If the cell is dead and has exactly 3 living neighbors, it becomes alive
            alive = true;
        }
    }

    @Override
    public void nextState() {
        alive = !alive;
    }

    @Override
    public void reset(boolean randomly) {
        if (randomly) {
            alive = new Random().nextBoolean();
        } else {
            alive = false;
        }
    }

    @Override
    public int getStatus() {
        if (alive) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Color getColor() {
        if (alive) {
            return Color.GREEN;
        } else {
            return Color.RED;
        }
    }
}
