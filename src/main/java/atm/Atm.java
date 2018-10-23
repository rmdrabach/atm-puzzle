package atm;

import java.security.InvalidParameterException;
import java.util.*;

public class Atm {

    private SafeBox safeBox;

    public Atm(SafeBox safeBox) {
        this.safeBox = safeBox;
    }

    public Withdrawal makeWithdrawal(int value) {
        ArrayList<Notes> availableNotes = safeBox.getAvailableNotes();

        if (!safeBox.canDeliverValue(value)) {
            throw new InvalidParameterException(
                    "Invalid withdrawal. Available notes are: " + availableNotes);
        }

        Withdrawal withdrawal = new Withdrawal();
        for (Notes note : availableNotes) {
            int amount = value / note.getValue();

            if (amount > 0) {
                withdrawal.addNotes(note, amount);
            }

            value = value % note.getValue();
        }

        return withdrawal;
    }
}
