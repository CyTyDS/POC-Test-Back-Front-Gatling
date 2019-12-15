package hello;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Numbers {

    @PostMapping(value="/number")
    public int getRandomNumber() {
        Random random = new Random();
        int randomInt = random.nextInt();
        return randomInt;
    }
}
