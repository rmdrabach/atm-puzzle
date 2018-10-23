package atm;

public enum Notes {
    HUNDRED(100), FIFTY(50), TWENTY(20), TEN(10);

    private final int value;

    Notes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}