package co.uk.smudge.demo.roman_numbers_app.model;

public class RomanNumber {

    private final int arabicNumber;
    private final String romanNumber;

    public RomanNumber(int arabicNumber, String romanNumber) {
        this.arabicNumber = arabicNumber;
        this.romanNumber = romanNumber;
    }

    public int getArabicNumber() {
        return arabicNumber;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

}
