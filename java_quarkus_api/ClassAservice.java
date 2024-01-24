import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClassAService {

    public String callClassB(String request) {
        // Implementa la logica e chiamata dell'endpoint della Classe B
        return "Response from Class B Service: " + request;
    }

    public String postMethod(String data) {
        return "Class A Service received POST request with data: " + data;
    }
}

