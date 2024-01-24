import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/a")
public class ClassAController {

    @Inject
    ClassBClient classBClient;

    @GET
    @Path("/getFromB")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFromB() {
        // Chiamata GET a ClassB
        return "Response from ClassB: " + classBClient.getDataFromB();
    }

    @POST
    @Path("/postToB")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String postToB(String data) {
        // Chiamata POST a ClassB
        return "Response from ClassB: " + classBClient.postDataToB(data);
    }

    @POST
    @Path("/postFromB")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String postFromB(String data) {
        // Metodo POST chiamato da ClassB
        return "Received POST request from ClassB with data: " + data;
    }
}

