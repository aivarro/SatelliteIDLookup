package eu.spaceit.satelliteidlookup.misson;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/mission")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MissionResource {

    @Inject
    MissionService missionService;

    @Path("{name}")
    @GET
    public Mission get(@PathParam("name") String name) {
        return missionService.getMission(name);
    }

    @POST
    public void create(Mission mission) {
        missionService.createMission(mission);
    }

    @PUT
    public void update(Mission mission) {
        missionService.updateMission(mission);
    }

    @Path("{name}")
    @DELETE
    public void delete(@PathParam("name") String name) {
        missionService.deleteMission(name);
    }
}
