package hello;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Numbers {

    @GetMapping(value="/number")
    public String getRandomNumber() {
        Random random = new Random();
        int randomInt = random.nextInt();
        JSONObject json = new JSONObject();
        json.put("number", randomInt);
        return json.toString();
    }
}
