import atm.Atm;
import atm.Notes;
import atm.SafeBox;
import atm.Withdrawal;
import interfaces.UserInterface;

import java.security.InvalidParameterException;

public class App {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface(args);

        int value;
        try {
            value = userInterface.getIntAtPosition(0);
        } catch (InvalidParameterException e) {
            userInterface.showMessage("Informe um número válido para saque.");
            return;
        } catch (IllegalArgumentException e) {
            userInterface.showMessage("Informe um valor para saque.");
            return;
        }

        Notes[] availableNotes = { Notes.HUNDRED, Notes.FIFTY, Notes.TWENTY, Notes.TEN };
        SafeBox safeBox = new SafeBox(availableNotes);
        Atm atm = new Atm(safeBox);

        try {
            Withdrawal withdrawal = atm.makeWithdrawal(value);
            userInterface.showMessage(withdrawal.toString());
        } catch (InvalidParameterException e) {
            userInterface.showMessage("Não é possível sacar este valor. As notas disposíveis são "
                    + safeBox.getAvailableNoteValues());
        }
    }
}
