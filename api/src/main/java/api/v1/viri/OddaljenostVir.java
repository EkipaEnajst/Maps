package api.v1.viri;


import org.ekipaenajst.beans.ParkiriscaZrno;
import org.ekipaenajst.entitete.Oddaljenost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("oddaljenosti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class OddaljenostVir {
    @Inject
    private ParkiriscaZrno parkiriscaZrno;

    @GET
    @Path("/query")
    public Response getOddaljenosti(@QueryParam("lokacija") String lokacija) {
        Oddaljenost[] oddaljenosti = parkiriscaZrno.getOddaljenosti(lokacija);

        return Response.status(javax.ws.rs.core.Response.Status.OK).entity(oddaljenosti).build();
        //return parkiriscaZrno.getOddaljenosti(lokacija);
    }

}
