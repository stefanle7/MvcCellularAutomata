package CALab.life;

import CALab.*;

public class LifeGrid extends Grid {
    public LifeGrid(int dim) {
        super(dim);
    }

    @Override
    public Cell makeCell(boolean uniform) {
        if (uniform) {
            return new LifeCell(false);                     // Sets all to dead
        } else {
            return new LifeCell(Math.random() < 0.5);       // Sets all randomly
        }
    }
}
