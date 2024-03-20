package CALab;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public abstract class GridFactory implements AppFactory {

    // create and return instance of grid model
    @Override
    public abstract Model makeModel();

    // create and return instance of grid model view
    @Override
    public abstract View makeView(Model m);

    // title of CALab
    @Override
    public String getTitle() {
        return "Cellular Automata Lab";
    }

    // help instructions
    @Override
    public String[] getHelp() {
        return new String[] {"[Run 1] simulates 1 generation",
                "[Run 50] simulates 50 generations",
                "[Populate] generates a random population of cells",
                "[Clear] resets the simulation to the empty state"};
    }

    // provide information about the application
    @Override
    public String about() {
        return "Cellular Automata Lab \nGroup 4";
    }

    // return array of edit commands
    @Override
    public String[] getEditCommands() {
        return new String[] {"Run 1", "Run 50", "Populate", "Clear"};
    }

    // create and return appropriate edit commands
    @Override
    public Command makeEditCommand(Model model, String name, Object object) {
        if (name.equals("Populate")) {
            return new PopulateCommand(model);
        } else if (name.equals("Run 1")) {
            return new RunCommand(model, 1);
        } else if (name.equals("Run 50")) {
            return new RunCommand(model, 50);
        } else if (name.equals("Clear")) {
            return new ClearCommand(model);
        }
        return null;
    }
}
