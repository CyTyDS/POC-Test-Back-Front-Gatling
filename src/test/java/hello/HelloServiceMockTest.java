package hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HelloServiceMockTest {

    @Mock
    private HelloRepository helloRepository = new HelloRepository();

    @InjectMocks // auto inject helloRepository
    private HelloService helloService = new HelloService();

    @BeforeEach
    void setMockOutput() {
        when(helloRepository.get()).thenReturn("Hello Mockito From Repository");
    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() {
        // GIVEN
        String expectedValue = "Hello Mockito From Repository";
        String incomeValue;
        // WHEN
        incomeValue = helloService.get();
        // THEN
        assertThat(incomeValue).isEqualTo(expectedValue);
    }
}
