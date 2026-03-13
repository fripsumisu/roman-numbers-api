package co.uk.smudge.demo.roman_numbers_app.service;

import co.uk.smudge.demo.roman_numbers_app.model.RomanNumber;
import org.springframework.stereotype.Service;

@Service
public class RomanNumberService {

    public RomanNumber toRoman(int number) {
        if (number < 1 || number > 9999) {
            throw new IllegalArgumentException("Number must be between 1 and 9999");
        } else {

            //return new RomanNumber(2026, "MMXXVI");
            return new RomanNumber(number, convertToRoman(number));
        }
    }

    protected String convertToRoman(int num) {
        String romanThousands = null;
        String romanHundreds = null;
        String romanTens = null;
        String romanUnits = null;
        int thousands = num / 1000;
        int thouRemaining = num % 1000;
        int hundreds = thouRemaining / 100;
        int hunRemaining = thouRemaining % 100;
        int tens = hunRemaining / 10;
        int tensRemaining = hunRemaining % 10;

        romanThousands = getThousands(thousands);
        romanHundreds = getHundreds(hundreds);
        romanTens = getTens(tens);
        romanUnits = getUnits(tensRemaining);
        return romanThousands + romanHundreds + romanTens + romanUnits;
    }

    protected String getUnits(int num) {
        switch (num) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            default:
                return "";
        }
    }

    protected String getTens(int num) {
        switch (num) {
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
            default:
                return "";
        }
    }

    protected String getHundreds(int num) {
        switch (num) {
            case 1:
                return "C";
            case 2:
                return "CC";
            case 3:
                return "CCC";
            case 4:
                return "CD";
            case 5:
                return "D";
            case 6:
                return "DC";
            case 7:
                return "DCC";
            case 8:
                return "DCCC";
            case 9:
                return "CM";
            default:
                return "";
        }
    }

    protected String getThousands(int num) {
        switch (num) {
            case 1:
                return "M";
            case 2:
                return "MM";
            case 3:
                return "MMM";
            case 4:
                return "MMMM";
            case 5:
                return "MMMMM";
            case 6:
                return "MMMMMM";
            default:
                return "";
        }

    }
}
