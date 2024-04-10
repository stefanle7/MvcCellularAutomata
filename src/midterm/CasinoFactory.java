package midterm;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class CasinoFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new Casino(); /* <--- switch to whatever the model will be */
    }

    @Override
    public View makeView(Model m) {
        return new CasinoView((Casino) m);
    }

    @Override
    public String getTitle() {
        return "Casino";
    }

    @Override
    public String[] getHelp() {
        return new String[]{
                "Roll: Roll two die, if sum is 7 or 11, gain a point. If 3 or 12, lose a point"
        };
    }

    @Override
    public String about() {
        return "CS151 - Midterm: Rolling Dice, Jason Doria";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Roll"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object object) {
        switch(type) {
            case "Roll": return new RollCommand(model);
            default: return null;
        }
    }
}
