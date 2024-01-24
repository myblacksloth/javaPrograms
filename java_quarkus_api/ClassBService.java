import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClassBService {

    public String callClassA(String request) {
        // Implementa la logica e chiamata dell'endpoint della Classe A
        return "Response from Class A Service: " + request;
    }

    public String postMethod(String data) {
        return "Class B Service received POST request with data: " + data;
    }
}

