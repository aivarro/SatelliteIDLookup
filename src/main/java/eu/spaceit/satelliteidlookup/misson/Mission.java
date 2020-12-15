package eu.spaceit.satelliteidlookup.misson;

import eu.spaceit.satelliteidlookup.satellite.Satellite;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity(name = "mission")
public class Mission extends PanacheEntityBase {

    @Id
    @Column(name = "mission_name")
    public String name;
    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Satellite> satellites;
}
