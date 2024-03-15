package CALab;

import CALab.life.Society;
import StopLight.Stoplight;
import StopLight.StoplightView;
import mvc.*;

public class GridFactory implements AppFactory {

    // create and return instance of grid model
    @Override
    public Model makeModel() {
        return new Society();
    }

    // create and return instance of grid model view
    @Override
    public View makeView(Model m) {
        return new GridView((Grid) m);
    }

    // title of CALab
    @Override
    public String getTitle() {
        return "Cell Automata: Life";
    }

    // help instructions
    @Override
    public String[] getHelp() {
        return new String[] {"Click Run to update and view the status of cells as time passes",
                "Click Populate to create cells within the grid",
                "Click Clear to empty the grid"};
    }

    // provide information about the application
    @Override
    public String about() {
        return "Cellular Automata: Life Group 4";
    }

    // return array of edit commands
    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    // create and return appropriate edit commands
    @Override
    public Command makeEditCommand(Model model, String name, Object object) {
        switch (name) {
            case "Run1":
                return new Run1(); // Replace with actual command class for Command1
            case "Run50":
                return new Run50(); // Replace with actual command class for Command2
            case "Populate":
                return new Command3(); // Replace with actual command class for Command3
            case "Clear":
                return new Clear(); // Replace with actual command class for Command3
            default:
                return null;
        }
    }
}
