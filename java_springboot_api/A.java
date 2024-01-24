import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/a")
public class ClassAController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/callB")
    public String callClassB(@RequestBody String request) {
        // Chiamare l'endpoint della Classe B tramite POST
        ResponseEntity<String> responseFromB = restTemplate.postForEntity("http://localhost:8080/api/b/callA", request, String.class);
        return "Response from Class B: " + responseFromB.getBody();
    }
}

