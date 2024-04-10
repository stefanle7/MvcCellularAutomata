package midterm;

import mvc.*;

public class Casino extends Model {
    public int die1 = 0;
    public int die2 = 0;
    public int score = 0;

    public void roll(int val1, int val2) {
        die1 = val1;
        die2 = val2;
        if (die1 + die2 == 7 || die1 + die2 == 11) {
            score++;
        } else if (die1 + die2 == 3 || die1 + die2 == 12) {
            score = 0;
        }
        changed();
    }
}
