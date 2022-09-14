package krd.bootcamp.kilid.housing_agency;


import krd.bootcamp.kilid.common.BaseEntity;
import krd.bootcamp.kilid.house.House;
import krd.bootcamp.kilid.municipality.Municipality;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_housing_agency")
@Data
@Audited
public class HousingAgency extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "username",unique = true)
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "phone_number",unique = true)
    private String phoneNumber;

    @NotNull
    @Column(name = "address")
    private String address;


    @NotNull
    @Column(name = "logo_id")
    private String logoId;

    @Column(name = "agency_location")
    private Point<G2D> location;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "housingAgency",cascade = CascadeType.ALL)
    private List<House> houses;


}
