package api.v1.viri;

import org.ekipaenajst.beans.ParkiriscaZrno;
import org.ekipaenajst.entitete.Oddaljenost;
import org.ekipaenajst.entitete.Parkirisce;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("parkirisca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ParkirisceVir {

    @Inject
    private ParkiriscaZrno parkiriscaZrno;

    @GET
    @Path("/query")
    public Response getParkirisca(@QueryParam("lokacija") String lokacija) {
        Parkirisce[] parkirisca = parkiriscaZrno.getParkirisca(lokacija);

        return Response.status(javax.ws.rs.core.Response.Status.OK).entity(parkirisca).build();
        //return parkiriscaZrno.getOddaljenosti(lokacija);
    }
}
