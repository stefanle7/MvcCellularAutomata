package midterm;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class RollCommand extends Command {
    public RollCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Casino m = (Casino) model;
        int val1 = Utilities.rng.nextInt(6) + 1; // Adding 1 to ensure the range is 1 to 6
        int val2 = Utilities.rng.nextInt(6) + 1; // Adding 1 to ensure the range is 1 to 6
        m.roll(val1, val2);
    }
}
