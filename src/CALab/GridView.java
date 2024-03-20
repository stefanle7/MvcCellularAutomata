package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        super(model); // Call the constructor of the superclass View with the provided Model object
        Grid grid = (Grid) model;
        int size = grid.getDim();
        cellViews = new CellView[size][size];
        this.setLayout((new GridLayout(size,size)));

        // creating a spot in the grid for every cell
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Cell myCell = grid.getCell(r,c);
                myCell.row = r;
                myCell.col = c;
                cellViews[r][c] = new CellView(myCell);
                this.add(cellViews[r][c]);
            }
        }
    }


    public void update() { // I'm not sure if params are needed
        // Call update method of each CellView
        for (int i = 0; i < cellViews.length; i++) {
            for (int j = 0; j < cellViews[i].length; j++) {
                cellViews[i][j].update();
            }
        }
    }
}