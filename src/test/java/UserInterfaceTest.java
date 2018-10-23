import interfaces.UserInterface;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class UserInterfaceTest {

    // get int input by position

    @Test public void shouldInformWhenNoInputFound() {
        // given
        String[] inputs = null;
        UserInterface userInterface = new UserInterface(inputs);

        // when
        boolean thrownException = false;
        try {
            userInterface.getIntAtPosition(0);
        } catch (IllegalArgumentException e) {
            thrownException = true;
        }

        // then
        assertTrue(thrownException);
    }

    @Test public void shouldInformWhenNoInputFoundAtPosition() {
        // given
        String[] inputs = { "10" };
        UserInterface userInterface = new UserInterface(inputs);

        // when
        boolean thrownException = false;
        try {
            userInterface.getIntAtPosition(1);
        } catch (IllegalArgumentException e) {
            thrownException = true;
        }

        // then
        assertTrue(thrownException);
    }

    @Test public void shouldInformWhenInputIsInvalid() {
        // given
        String[] inputs = { "abc" };
        UserInterface userInterface = new UserInterface(inputs);

        // when
        boolean thrownException = false;
        try {
            userInterface.getIntAtPosition(0);
        } catch (InvalidParameterException e) {
            thrownException = true;
        }

        // then
        assertTrue(thrownException);
    }

    @Test public void shouldReturnValueForRequestedPosition() {
        // given
        String[] inputs = { "10", "20" };
        UserInterface userInterface = new UserInterface(inputs);

        // when
        int value = userInterface.getIntAtPosition(1);

        // then
        assertEquals(20, value);
    }
}
