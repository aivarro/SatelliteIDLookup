package eu.spaceit.satelliteidlookup.satellite;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class SatelliteService {

    public Satellite getSatellite(String internationalDesignator) {
        Satellite satellite = Satellite.findById(internationalDesignator);
        if (satellite != null) {
            return satellite;
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void createSatellite(Satellite satellite) {
        Satellite.persist(satellite);
    }

    @Transactional
    public void updateSatellite(Satellite satellite) {
        if (Satellite.findById(satellite.internationalDesignator) != null) {
        Satellite.update("name = ?1, orbitType = ?2, yearOfLaunch = ?3",
                satellite.name, satellite.orbitType, satellite.yearOfLaunch);
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void deleteSatellite(String internationalDesignator) {
        Satellite satellite = Satellite.findById(internationalDesignator);
        if (satellite != null) {
            Satellite.deleteById(internationalDesignator);
        } else {
            throw new NotFoundException();
        }
    }
}
