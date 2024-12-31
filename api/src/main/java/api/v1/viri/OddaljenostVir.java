package api.v1.viri;


import org.ekipaenajst.beans.ParkiriscaZrno;
import org.ekipaenajst.entitete.Oddaljenost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("oddaljenosti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class OddaljenostVir {
    @Inject
    private ParkiriscaZrno parkiriscaZrno;

    @GET
    public Oddaljenost[] getOddaljenosti(String lokacija) {
        return parkiriscaZrno.getOddaljenosti(lokacija);
    }

}
