package krd.bootcamp.kilid.municipality;

import krd.bootcamp.kilid.city.City;
import krd.bootcamp.kilid.common.BaseEntity;
import krd.bootcamp.kilid.housing_agency.HousingAgency;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_municipality")
@Data
@Audited
public class Municipality extends BaseEntity {

    @NotNull
    @Column(name = "region")
    private Integer region;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
