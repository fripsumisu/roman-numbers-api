package co.uk.smudge.demo.roman_numbers_app.controller;

import co.uk.smudge.demo.roman_numbers_app.model.RomanNumber;
import co.uk.smudge.demo.roman_numbers_app.service.RomanNumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roman")
public class NumberController {

    private final RomanNumberService romanNumberService;

    public NumberController(RomanNumberService romanNumberService) {

        this.romanNumberService = romanNumberService;
    }

    @GetMapping("/{number}")
    public RomanNumber toRoman(@PathVariable int number) {
        return romanNumberService.toRoman(number);

        // Quick local test to http://127.0.0.1:8080/roman/1234
    }


}
