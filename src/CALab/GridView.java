package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        super(model); // Call the constructor of the superclass View with the provided Model object
        initializeGrid();
    }

    private void initializeGrid() {
        Grid gridModel = (Grid) model; // Cast the model to Grid since we're expecting a Grid object
        int dim = gridModel.getDim();
        cellViews = new CellView[dim][dim];

        // Iterate over each cell in the grid model
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                // Get the cell reference
                Cell cell = gridModel.getCell(i, j);

                // Create a new CellView for each cell in the grid model
                CellView oneCellView = new CellView(cell);
                cellViews[i][j] = oneCellView;

                // Set the row and column properties of the cell view
                cell.row = i;
                cell.col = j;
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