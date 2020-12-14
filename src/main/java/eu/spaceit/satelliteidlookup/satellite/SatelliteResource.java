package eu.spaceit.satelliteidlookup.satellite;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/satellite")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SatelliteResource {

    @Inject
    SatelliteService satelliteService;

    @Path("{id}")
    @GET
    public Satellite getSatellite(@PathParam("id") String internationalDesignator) {
        return satelliteService.getSatellite(internationalDesignator);
    }

    @POST
    public void create(Satellite satellite) {
        satelliteService.createSatellite(satellite);
    }

    @PUT
    public void update(Satellite satellite) {
        satelliteService.updateSatellite(satellite);
    }

    @Path("{id}")
    @DELETE
    public void delete(@PathParam("id") String internationalDesignator) {
        satelliteService.deleteSatellite(internationalDesignator);
    }
}
