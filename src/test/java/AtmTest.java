import atm.Atm;
import atm.Notes;
import atm.SafeBox;
import atm.Withdrawal;
import org.junit.Test;
import static org.junit.Assert.*;

public class AtmTest {

    // basic operation

    @Test public void shouldMakeAWithdrawalWithOne20AndOne10() {
        // given
        Notes[] availableNotes = { Notes.HUNDRED, Notes.FIFTY, Notes.TWENTY, Notes.TEN };
        SafeBox safeBox = new SafeBox(availableNotes);
        Atm atm = new Atm(safeBox);

        // when
        Withdrawal withdrawal = atm.makeWithdrawal(30);

        // then
        assertEquals(0, withdrawal.getAmountOf(Notes.HUNDRED));
        assertEquals(0, withdrawal.getAmountOf(Notes.FIFTY));
        assertEquals(1, withdrawal.getAmountOf(Notes.TWENTY));
        assertEquals(1, withdrawal.getAmountOf(Notes.TEN));
    }

    @Test public void shouldMakeAWithdrawalWithOne50One20AndOne10() {
        // given
        Notes[] availableNotes = { Notes.HUNDRED, Notes.FIFTY, Notes.TWENTY, Notes.TEN };
        SafeBox safeBox = new SafeBox(availableNotes);
        Atm atm = new Atm(safeBox);

        // when
        Withdrawal withdrawal = atm.makeWithdrawal(80);

        // then
        assertEquals(0, withdrawal.getAmountOf(Notes.HUNDRED));
        assertEquals(1, withdrawal.getAmountOf(Notes.FIFTY));
        assertEquals(1, withdrawal.getAmountOf(Notes.TWENTY));
        assertEquals(1, withdrawal.getAmountOf(Notes.TEN));
    }

    // should return the minimum amount of notes possible

    @Test public void shouldMakeAWithdrawalWithTwo100() {
        // given
        Notes[] availableNotes = { Notes.HUNDRED, Notes.FIFTY, Notes.TWENTY, Notes.TEN };
        SafeBox safeBox = new SafeBox(availableNotes);
        Atm atm = new Atm(safeBox);

        // when
        Withdrawal withdrawal = atm.makeWithdrawal(200);

        // then
        assertEquals(2, withdrawal.getAmountOf(Notes.HUNDRED));
        assertEquals(0, withdrawal.getAmountOf(Notes.FIFTY));
        assertEquals(0, withdrawal.getAmountOf(Notes.TWENTY));
        assertEquals(0, withdrawal.getAmountOf(Notes.TEN));
    }

    @Test public void shouldMakeAWithdrawalWithFour50() {
        // given
        Notes[] availableNotes = { Notes.FIFTY, Notes.TWENTY, Notes.TEN };
        SafeBox safeBox = new SafeBox(availableNotes);
        Atm atm = new Atm(safeBox);

        // when
        Withdrawal withdrawal = atm.makeWithdrawal(200);

        // then
        assertEquals(0, withdrawal.getAmountOf(Notes.HUNDRED));
        assertEquals(4, withdrawal.getAmountOf(Notes.FIFTY));
        assertEquals(0, withdrawal.getAmountOf(Notes.TWENTY));
        assertEquals(0, withdrawal.getAmountOf(Notes.TEN));
    }
}
