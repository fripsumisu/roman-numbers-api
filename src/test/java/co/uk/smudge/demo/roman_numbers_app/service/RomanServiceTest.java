package co.uk.smudge.demo.roman_numbers_app.service;

import co.uk.smudge.demo.roman_numbers_app.model.RomanNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanServiceTest {

    private final RomanNumberService service = new RomanNumberService();

    @Nested
    @DisplayName("Valid conversions")
    class ValidCases {

        @ParameterizedTest(name = "{0} -> {1}")
        @CsvSource({
                // Basics
                "1, I",
                "2, II",
                "3, III",
                "4, IV",
                "5, V",
                "6, VI",
                "7, VII",
                "8, VIII",
                "9, IX",
                "10, X",

                // Tens
                "14, XIV",
                "19, XIX",
                "20, XX",
                "40, XL",
                "44, XLIV",
                "49, XLIX",
                "58, LVIII",
                "90, XC",
                "94, XCIV",
                "99, XCIX",

                // Hundreds
                "100, C",
                "400, CD",
                "444, CDXLIV",
                "500, D",
                "900, CM",
                "944, CMXLIV",

                // Thousands & edges
                "1000, M",
                "1984, MCMLXXXIV",
                "1994, MCMXCIV",
                "2023, MMXXIII",
                "2421, MMCDXXI",
                "3999, MMMCMXCIX"
        })
        void convertsIntToRoman(int input, String expectedRoman) {
            RomanNumber result = service.toRoman(input);
            assertEquals(input, result.getArabicNumber(), "Arabic number should echo input");
            assertEquals(expectedRoman, result.getRomanNumber(), "Roman number should match expected");
        }
    }

    @Nested
    @DisplayName("Invalid inputs")
    class InvalidCases {
        @ParameterizedTest
        @ValueSource(ints = {-10, -1, 0, 4000, 5000})
        void throwsForOutOfRange(int bad) {
            IllegalArgumentException ex =
                    assertThrows(IllegalArgumentException.class, () -> service.toRoman(bad));
            assertTrue(ex.getMessage().contains("between 1 and 3999"));
        }
    }

    @Test
    @DisplayName("Immutability check: RomanResult fields reflect original number")
    void resultContainsOriginalNumber() {
        RomanNumber result = service.toRoman(1987);
        assertEquals(1987, result.getRomanNumber());
        assertEquals("MCMLXXXVII", result.getRomanNumber());
    }
}
