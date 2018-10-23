package interfaces;

import java.security.InvalidParameterException;

public class UserInterface implements ConsoleInterface {

    private String[] inputs;

    public UserInterface(String[] inputs) {
        this.inputs = inputs;
    }

    public int getIntAtPosition(int position) {
        if (inputs == null) {
            throw new IllegalArgumentException("Nenhuma entrada encontrada.");
        }

        if (position >= inputs.length) {
            throw new IllegalArgumentException("Entrada não encontrada.");
        }

        String input = inputs[position];

        int value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Valor inválido");
        }


        return value;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
