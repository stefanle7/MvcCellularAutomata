package CALab.life;

import CALab.Cell;

import java.util.Random;

public class LifeCell extends Cell {

    private boolean alive;

    public LifeCell(boolean alive) {
        this.alive = alive;
    }

    private int countLivingNeighbors() {
        int livingNeighbors = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor instanceof LifeCell && ((LifeCell) neighbor).isAlive()) {
                livingNeighbors++;
            }
        }
        return livingNeighbors;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void observe() {
        // In this method, we observe the states of neighboring cells.
        // This could involve inspecting the state of each neighbor.
        for (Cell neighbor : neighbors) {
            if (neighbor instanceof LifeCell) {
                boolean neighborState = ((LifeCell) neighbor).isAlive();
                // Perform any observation logic here
            }
        }
    }

    @Override
    public void interact() {
        int livingNeighbors = countLivingNeighbors();

        if (alive && (livingNeighbors < 2 || livingNeighbors > 3)) {
            alive = false;
        } else if (!alive && livingNeighbors == 3) {
            alive = true;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void nextState() {

    }

    @Override
    public void reset(boolean randomly) {
        if (randomly) {
            alive = new Random().nextBoolean();
        } else {
            alive = false;
        }
    }
}
