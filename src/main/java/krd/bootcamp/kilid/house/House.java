package krd.bootcamp.kilid.house;

import krd.bootcamp.kilid.common.BaseEntity;
import krd.bootcamp.kilid.house.enum_house.HouseState;
import krd.bootcamp.kilid.house.enum_house.HouseType;
import krd.bootcamp.kilid.house.enum_house.SaleType;
import krd.bootcamp.kilid.house.enum_house.SuitableFor;
import krd.bootcamp.kilid.housing_agency.HousingAgency;
import krd.bootcamp.kilid.image.Photo;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_house")
@Data
@Audited
public class House extends BaseEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    private HouseType houseType;

    @Column(name = "house_location")
    private Point<G2D> location;


    @NotNull
    @Column(name = "area")
    private Double area;

    @NotNull
    @Column(name = "price_by_meter")
    private Long priceByMeter;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SaleType saleType;

    @NotNull
    @Column(name = "rent_price")
    private Long rentPrice;

    @NotNull
    @Column(name = "deposit")
    private Long deposit;

    @NotNull
    @Column(name ="sale_price")
    private Long salePrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SuitableFor suitableFor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private HouseState houseState;

    @NotNull
    @Column(name = "count_of_room")
    private Integer countOfRoom;

    @NotNull
    @Column(name = "year_construction")
    private Integer yearOfConstruction;

    @NotNull
    @Column(name = "floor")
    private Integer floor;

    @NotNull
    @Column(name = "number_floor")
    private Integer numberOfFloor;

    @NotNull
    @Column(name = "unit")
    private Integer unit;

    @NotNull
    @Column(name = "number_of_unit_per_floor")
    private Integer numberOfUnitPerFloor;

    @NotNull
    @Column(name = "balcony")
    private Boolean balcony;

    @NotNull
    @Column(name = "elevator")
    private Boolean elevator;

    @NotNull
    @Column(name = "warehouse")
    private Boolean warehouse;

    @NotNull
    @Column(name = "parking")
    private Boolean parking;

    @NotNull
    @Column(name = "cooling_device")
    private Boolean hasCoolingDevice;

    @NotNull
    @Column(name = "cooling_device_type")
    private String hasCoolingDeviceType;


    @NotNull
    @Column(name = "heating_device")
    private Boolean hasHeatingDevice;

    @NotNull
    @Column(name = "heating_device_type")
    private String hasHeatingDeviceType;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "codeAdvertise")
    private Integer codeAdvertise;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "house",cascade = CascadeType.ALL)
    private List<Photo> photos;

    @ManyToOne
    @JoinColumn(name = "housing_id")
    private HousingAgency housingAgency;

}
