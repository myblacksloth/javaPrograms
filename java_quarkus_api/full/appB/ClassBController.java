import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/b")
public class ClassBController {

    @Inject
    ClassAClient classAClient;

    @GET
    @Path("/getFromA")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFromA() {
        // Chiamata GET a ClassA
        return "Response from ClassA: " + classAClient.getDataFromA();
    }

    @POST
    @Path("/postToA")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String postToA(String data) {
        // Chiamata POST a ClassA
        return "Response from ClassA: " + classAClient.postDataToA(data);
    }

    @POST
    @Path("/postToAFromB")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String postToAFromB(String data) {
        // Chiamata POST a ClassA dal metodo di ClassB
        return "Response from ClassA: " + classAClient.postFromBToA(data);
    }
}

