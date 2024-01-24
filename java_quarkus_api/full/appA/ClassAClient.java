import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
public interface ClassAClient {

    @POST
    @Path("/api/a/postFromB")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    String postFromBToA(String data);
}

