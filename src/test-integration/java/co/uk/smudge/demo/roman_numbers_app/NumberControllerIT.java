package co.uk.smudge.demo.roman_numbers_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerIT {

    @Autowired
    MockMvcTester mockMvcTester;

    @Test
    void getRomanNumberSuccessful() {
        assertThat(mockMvcTester.get().uri("/roman/123")).hasStatusOk();
    }

    @Test
    void getRomanNumberZero() {
        assertThat(mockMvcTester.get().uri("/roman/0"))
                .hasFailed()
                .failure()
                .hasMessageContaining("Number must be between 1 and 9999");
    }

    @Test
    void getRomanNumberTooLarge() {
        assertThat(mockMvcTester.get().uri("/roman/10985"))
                .hasFailed()
                .failure()
                .hasMessageContaining("Number must be between 1 and 9999");
    }

    @Test
    void getRomanNumberBadRequest() {
        String badArg = "abc";
        assertThat(mockMvcTester.get().uri("/roman/" + badArg))
                .hasFailed()
                .failure()
                .hasMessageContaining(badArg);
    }
}
