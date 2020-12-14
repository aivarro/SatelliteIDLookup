package eu.spaceit.satelliteidlookup;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Mission {

    public Mission() {
    }

    public Mission(String name, Integer satellites) {
        this.name = name;
        this.satellites = satellites;
    }

    @Id
    private String name;
    private Integer satellites;
}
