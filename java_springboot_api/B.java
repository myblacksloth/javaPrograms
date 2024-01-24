import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/b")
public class ClassBController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/callA")
    public String callClassA(@RequestBody String request) {
        // Chiamare l'endpoint della Classe A tramite POST
        String responseFromA = restTemplate.postForObject("http://localhost:8080/api/a/callB", request, String.class);
        return "Response from Class A: " + responseFromA;
    }
}

