package atm;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EmptyStackException;

public class SafeBox {

    private ArrayList<Notes> availableNotes = new ArrayList<>();

    public SafeBox(Notes[] availableNotes) {
        if (availableNotes == null) {
            throw new InvalidParameterException();
        }

        Collections.addAll(this.availableNotes, availableNotes);

        this.availableNotes.sort(Collections.reverseOrder(Comparator.comparing(Notes::getValue)));
    }

    public ArrayList<Notes> getAvailableNotes() {
        return new ArrayList<>(availableNotes);
    }

    public ArrayList<Integer> getAvailableNoteValues() {
        ArrayList<Integer> availableValues = new ArrayList<>();
        for (Notes note : availableNotes) {
            availableValues.add(note.getValue());
        }
        return availableValues;
    }

    public Notes getLowerAvailableNote() {
        if (availableNotes.size() == 0) {
            throw new EmptyStackException();
        }

        return availableNotes.get(availableNotes.size() - 1);
    }

    public boolean canDeliverValue(int amount) {
        return amount > 0 && (amount % getLowerAvailableNote().getValue()) == 0;
    }
}
