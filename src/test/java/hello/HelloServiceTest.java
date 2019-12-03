package hello;

import hello.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HelloServiceTest {
    HelloService helloService = new HelloService();

    @Test
    void testGet() {
        // GIVEN
        String expectedValue = "Hello JUnit 5";
        String incomeValue;
        // WHEN
        incomeValue = helloService.get();
        // THEN
        assertThat(incomeValue).isEqualTo(expectedValue);
    }
}
