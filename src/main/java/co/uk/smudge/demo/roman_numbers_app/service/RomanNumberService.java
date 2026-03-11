package co.uk.smudge.demo.roman_numbers_app.service;

import co.uk.smudge.demo.roman_numbers_app.model.RomanNumber;
import org.springframework.stereotype.Service;

@Service
public class RomanNumberService {

    public RomanNumber toRoman(int number) {
         if (number < 1 || number > 9999) {
             throw new IllegalArgumentException("Number must be between 1 and 9999");
         }
         else {

             return new RomanNumber(2026, "MMXXVI");
         }
    }
}
