package atm;

import java.util.TreeMap;

public class Withdrawal {

    private TreeMap<Integer, Integer> withdrawal = new TreeMap<>();

    public int getAmountOf(Notes note) {
        if (withdrawal.containsKey(note.getValue())) {
            return withdrawal.get(note.getValue());
        }

        return 0;
    }

    public void addNotes(Notes value, Integer amount) {
        withdrawal.put(value.getValue(), amount);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Notes");

        if (withdrawal.size() == 0) {
            sb.append(" - NONE");
        } else {
            for (Integer value : withdrawal.descendingKeySet()) {
                sb.append(" - ").append(value).append(": ").append(withdrawal.get(value));
            }
        }

        return sb.toString();
    }
}
