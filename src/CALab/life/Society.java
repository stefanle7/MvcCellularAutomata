package CALab.life;

import CALab.*;

public class Society extends Grid {
    public Society(int dim) {
        super(dim);
    }

    @Override
    public Cell makeCell(boolean uniform) {
        if (uniform) {
            return new Agent(false);                     // Sets all to dead
        } else {
            return new Agent(Math.random() < 0.5);       // Sets all randomly
        }
    }
}