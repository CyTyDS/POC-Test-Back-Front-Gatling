package hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NumbersTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @DisplayName("Test Mock Numbers Status")
    @Test
    public void postNumber() throws Exception {
        int expectedStatus = 200;
        int responseStatus;
        URL url = new URL("http://localhost:" + port + "/number");
        responseStatus = restTemplate.postForEntity(url.toString(), int.class, String.class).getStatusCodeValue();
        assertThat(responseStatus).isEqualTo(expectedStatus);
    }

    @Mock
    private Numbers numbers = new Numbers();

    @BeforeEach
    void setMockOutput() {
        when(numbers.getRandomNumber()).thenReturn(118218);
    }

    @DisplayName("Test Mock Numbers")
    @Test
    void testGetRandomNumber() {
        // GIVEN
        int expectedValue = 118218;
        int incomeValue;
        // WHEN
        incomeValue = numbers.getRandomNumber();
        // THEN
        assertThat(incomeValue).isEqualTo(expectedValue);
    }

}
