package CALab;

import mvc.*;

public class GridFactory implements AppFactory {

    // create and return instance of grid model
    @Override
    public Model makeModel() {
        return null;
    }

    // create and return instance of grid model view
    @Override
    public View makeView(Model m) {
        return null;
    }

    // title of CALab
    @Override
    public String getTitle() {
        return null;
    }

    // help instructions
    @Override
    public String[] getHelp() {
        return new String[0];
    }

    // provide information about the application
    @Override
    public String about() {
        return null;
    }

    // return array of edit commands
    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    // create and return appropriate edit commands
    @Override
    public Command makeEditCommand(Model model, String name, Object object) {
        return null;
    }
}
