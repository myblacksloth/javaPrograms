import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/api/a")
public class ClassAController {

    @Inject
    ClassBService classBService;

    @POST
    @Path("/callB")
    @Consumes(MediaType.TEXT_PLAIN)
    public String callClassB(String request) {
        // Chiamare il servizio della Classe B
        return "Response from Class B: " + classBService.callClassA(request);
    }

    @POST
    @Path("/postMethod")
    @Consumes(MediaType.TEXT_PLAIN)
    public String postMethod(String data) {
        return "Class A received POST request with data: " + data;
    }
}

