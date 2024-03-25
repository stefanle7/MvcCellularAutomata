package stax;

import mvc.*;

public class Command extends mvc.Command {
    public Command(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Calculator calc = (Calculator) model;
        calc.add();
    }
}

