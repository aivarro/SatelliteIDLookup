package eu.spaceit.satelliteidlookup.misson;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class MissionService {

    public Mission getMission(String name) {
        Mission mission = Mission.findById(name);
        if (mission != null) {
            return mission;
        } else {
            throw new NotFoundException();
        }
    }

    public void createMission(Mission mission) {
        Mission.persist(mission);
    }

    public void updateMission(Mission mission) {
        if (Mission.findById(mission.name) != null) {
            Mission.update("satellites = ?1", mission.satellites);
        } else {
            throw new NotFoundException();
        }
    }

    public void deleteMission(String name) {
        Mission mission = Mission.findById(name);
        if (mission != null) {
            Mission.deleteById(name);
        } else {
            throw new NotFoundException();
        }
    }
}
