package eu.spaceit.satelliteidlookup.satelliteidentifier;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class SatelliteIdentifier {

    @Id
    private String satelliteId;
    private String domain;
    private String satelliteIdInDomain;
}
