import atm.Notes;
import atm.Withdrawal;
import org.junit.Test;
import static org.junit.Assert.*;

public class WithdrawalTest {

    // get amount of some note

    @Test
    public void shouldReturn0ForNotesNotDelivered() {
        // given
        Withdrawal withdrawal = new Withdrawal();

        // when
        int amount = withdrawal.getAmountOf(Notes.TEN);

        // then
        assertEquals(0, amount);
    }

    @Test
    public void shouldReturn2NotesOfTwenty() {
        // given
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.addNotes(Notes.TWENTY, 2);

        // when
        int amount = withdrawal.getAmountOf(Notes.TWENTY);

        // then
        assertEquals(2, amount);
    }

    @Test
    public void shouldPrintItselfAsSumaryWhenHasNotes() {
        // given
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.addNotes(Notes.HUNDRED, 1);
        withdrawal.addNotes(Notes.TWENTY, 2);
        withdrawal.addNotes(Notes.TEN, 3);

        // when
        String sumary = withdrawal.toString();

        // then
        assertEquals("Notes - 100: 1 - 20: 2 - 10: 3", sumary);
    }

    @Test
    public void shouldPrintItselfAsSumaryWhenIsEmpty() {
        // given
        Withdrawal withdrawal = new Withdrawal();

        // when
        String sumary = withdrawal.toString();

        // then
        assertEquals("Notes - NONE", sumary);
    }
}
