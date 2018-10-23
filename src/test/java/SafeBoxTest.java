import atm.Notes;
import atm.SafeBox;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class SafeBoxTest {

    @Test
    public void shouldSortValuesDescending() {
        // given
        Notes[] availableNotes = { Notes.FIFTY, Notes.HUNDRED, Notes.TEN };
        SafeBox safeBox = new SafeBox(availableNotes);

        // when
        ArrayList<Notes> safeboxNotes = safeBox.getAvailableNotes();

        // then
        assertEquals(Notes.HUNDRED, safeboxNotes.get(0));
        assertEquals(Notes.FIFTY, safeboxNotes.get(1));
        assertEquals(Notes.TEN, safeboxNotes.get(2));
    }

    @Test
    public void shouldNotAcceptNullNotes() {
        // given
        Notes[] availableNotes = null;

        // when
        boolean exception = false;
        try {
            new SafeBox(availableNotes);
        } catch (InvalidParameterException e) {
            exception = true;
        }

        // then
        assertTrue(exception);
    }

    @Test
    public void shouldAcceptEmptyNotes() {
        // given
        Notes[] availableNotes = {};

        // when
        boolean thrownException = false;
        try {
            new SafeBox(availableNotes);
        } catch (InvalidParameterException e) {
            thrownException = true;
        }

        // then
        assertFalse(thrownException);
    }

    // lower available note

    @Test
    public void shoulReturn10() {
        // given
        Notes[] availableNotes = { Notes.FIFTY, Notes.HUNDRED, Notes.TEN, Notes.TWENTY };
        SafeBox safeBox = new SafeBox(availableNotes);

        // when
        int noteValue = safeBox.getLowerAvailableNote().getValue();

        // then
        assertEquals(10, noteValue);
    }

    @Test
    public void shoulReturn20() {
        // given
        Notes[] availableNotes = { Notes.FIFTY, Notes.TWENTY, Notes.HUNDRED };
        SafeBox safeBox = new SafeBox(availableNotes);

        // when
        int noteValue = safeBox.getLowerAvailableNote().getValue();

        // then
        assertEquals(20, noteValue);
    }

    @Test
    public void shouldInformWhenSafeboxIsEmpty() {
        // given
        Notes[] availableNotes = {};
        SafeBox safeBox = new SafeBox(availableNotes);

        // when
        boolean thrownException = false;
        try {
            safeBox.getLowerAvailableNote();
        } catch (EmptyStackException e) {
            thrownException = true;
        }

        // then
        assertTrue(thrownException);
    }

    // can deliver value

    @Test
    public void shouldNotDeliverValue0() {
        // given
        Notes[] availableNotes = {};
        SafeBox safeBox = new SafeBox(availableNotes);

        int value = 0;

        // when
        boolean canDeliver = safeBox.canDeliverValue(value);

        // then
        assertFalse(canDeliver);
    }

    @Test
    public void shouldNotDeliverNegativeValues() {
        // given
        Notes[] availableNotes = {};
        SafeBox safeBox = new SafeBox(availableNotes);

        int value = -10;

        // when
        boolean canDeliver = safeBox.canDeliverValue(value);

        // then
        assertFalse(canDeliver);
    }

    @Test
    public void shouldDeliverWhenHaveNotesThatFullfilRequestedValue() {
        // given
        Notes[] availableNotes = { Notes.TWENTY, Notes.TEN };
        SafeBox safeBox = new SafeBox(availableNotes);

        int value = 50;

        // when
        boolean canDeliver = safeBox.canDeliverValue(value);

        // then
        assertTrue(canDeliver);
    }

    @Test
    public void shouldNotDeliverWhenAvailableNotesDontFullfilRequestedValue() {
        // given
        Notes[] availableNotes = { Notes.FIFTY, Notes.TWENTY };
        SafeBox safeBox = new SafeBox(availableNotes);

        int value = 30;

        // when
        boolean canDeliver = safeBox.canDeliverValue(value);

        // then
        assertFalse(canDeliver);
    }

    // get available notes values

    @Test
    public void shouldReturnTheValuesOfTheAvailableNotes() {
        // given
        Notes[] availableNotes = { Notes.FIFTY, Notes.TWENTY, Notes.TEN };
        SafeBox safeBox = new SafeBox(availableNotes);

        // when
        ArrayList<Integer> values = safeBox.getAvailableNoteValues();

        // then
        assertEquals(50, (int) values.get(0));
        assertEquals(20, (int) values.get(1));
        assertEquals(10, (int) values.get(2));
    }

    @Test
    public void shouldReturnEmptyWhenNoAvailableNotes() {
        // given
        Notes[] availableNotes = { };
        SafeBox safeBox = new SafeBox(availableNotes);

        // when
        ArrayList<Integer> values = safeBox.getAvailableNoteValues();

        // then
        assertEquals(0, values.size());
    }
}
