package eu.spaceit.satelliteidlookup.satellite;

import eu.spaceit.satelliteidlookup.misson.Mission;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table
@Entity(name = "satellite")
public class Satellite extends PanacheEntityBase {

    @Id
    @NotBlank(message = "internationalDesignator cannot be null or empty")
    public String internationalDesignator;
    @NotBlank(message = "name cannot be null or empty")
    public String name;
    @NotNull(message = "yearOfLaunch cannot be null")
    public Integer yearOfLaunch;
    @NotNull(message = "orbitType cannot be null")
    @Enumerated(EnumType.STRING)
    public OrbitType orbitType;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mission_name", nullable = false)
    public Mission mission;

}
