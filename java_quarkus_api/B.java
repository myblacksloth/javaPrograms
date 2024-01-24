import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/api/b")
public class ClassBController {

    @Inject
    ClassAService classAService;

    @POST
    @Path("/callA")
    @Consumes(MediaType.TEXT_PLAIN)
    public String callClassA(String request) {
        // Chiamare il servizio della Classe A
        return "Response from Class A: " + classAService.callClassB(request);
    }

    @POST
    @Path("/postMethod")
    @Consumes(MediaType.TEXT_PLAIN)
    public String postMethod(String data) {
        return "Class B received POST request with data: " + data;
    }
}

