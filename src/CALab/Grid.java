package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
        // 1. use makeCell to fill in cells
        // 2. Use getNeighbors to set the neighbors field of each cell
        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells[r].length; c++) {
                cells[r][c] = makeCell(true);
                cells[r][c].neighbors = getNeighbors(cells[r][c],1);
            }
        }
        updateLoop(1);
        changed();
    }

    public void repopulate(boolean randomly) {
        if (randomly) {
            // randomly set the status of each cell
            Random random = new Random();
            for (int r = 0; r < cells.length; r++) {
                for (int c = 0; c < cells[r].length; c++) {
                    cells[r][c].reset(random.nextBoolean());
                }
            }
        } else {
            // set the status of each cell to 0 (dead)
            for (int r = 0; r < cells.length; r++) {
                for (int c = 0; c < cells[r].length; c++) {
                    cells[r][c].reset(false);
                }
            }
        }
        updateLoop(1);
        changed();
    }

    public void clear() {
        // set the status of each cell to 0 (dead)
        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells[r].length; c++) {
                cells[r][c].reset(false);
            }
        }
        updateLoop(1);
        //changed();
        setUnsavedChanges(false);
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /* return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself. */
        Set<Cell> neighbors = new HashSet<>();
        int row = asker.getRow();
        int col = asker.getCol();

        for (int r = -radius; r < (radius+1); r++) {
            for (int c = -radius; c < (radius+1); c++) {
                int ar = (row + r + dim) % dim;
                int ac = (col + c + dim) % dim;
                neighbors.add(cells[ar][ac]);
            } neighbors.remove(asker); //delete asker from calculation
        }
        return neighbors;
    }

    // cell phases:
    public void observe() {
        // call each cell's observe method and notify subscribers
        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells[r].length; c++) {
                cells[r][c].neighbors = getNeighbors(cells[r][c],1);
                cells[r][c].observe();
            }
        }
        changed();
    }

    public void interact() {
        // Call each cell's interact method
        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells[r].length; c++) {
                cells[r][c].interact();
            }
        }
        changed();
    }

    public void update() {
        // Call each cell's update method
        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells[r].length; c++) {
                cells[r][c].update();
            }
        }
        changed();
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}