package StopLight;
//heyooo testtest test testtttt
//teeeesttttt

import mvc.*;

public class ChangeCommand extends Command {
    public ChangeCommand(Model model) {
        super(model);
    }

    public void execute() {
        Stoplight light = (Stoplight) model;
        light.change();
    }

}