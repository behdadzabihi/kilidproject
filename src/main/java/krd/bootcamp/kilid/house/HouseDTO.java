package krd.bootcamp.kilid.house;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.kilid.common.BaseDTO;
import krd.bootcamp.kilid.house.enum_house.HouseState;
import krd.bootcamp.kilid.house.enum_house.HouseType;
import krd.bootcamp.kilid.house.enum_house.SaleType;
import krd.bootcamp.kilid.house.enum_house.SuitableFor;
import krd.bootcamp.kilid.housing_agency.HousingAgencyDTO;
import lombok.Data;


@Data
public class HouseDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private HouseType houseType;

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true,hidden = false)
    private Double area;

    @ApiModelProperty(required = false,hidden = false)
    private Long priceByMeter;

    @ApiModelProperty(required = true,hidden = false)
    private SaleType saleType;

    @ApiModelProperty(required = false,hidden = false)
    private Long rentPrice;

    @ApiModelProperty(required = false,hidden = false)
    private Long deposit;

    @ApiModelProperty(required = false,hidden = false)
    private Long salePrice;

    @ApiModelProperty(required = false,hidden = false)
    private SuitableFor suitableFor;

    @ApiModelProperty(required = true,hidden = false)
    private HouseState houseState;

    @ApiModelProperty(required = true,hidden = false)
    private Integer countOfRoom;

    @ApiModelProperty(required = true,hidden = false)
    private Integer yearOfConstruction;

    @ApiModelProperty(required = true,hidden = false)
    private Integer floor;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean balcony;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean elevator;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean warehouse;

    @ApiModelProperty(required = true,hidden = false)
    private String description;

    @ApiModelProperty(required = true,hidden = false)
    private String title;

    @ApiModelProperty(required = true,hidden = false)
    private String address;

    @ApiModelProperty(required = false,hidden = false)
    private Integer numberOfFloor;

    @ApiModelProperty(required = false,hidden = false)
    private Integer unit;

    @ApiModelProperty(required = false,hidden = false)
    private Integer numberOfUnitPerFloor;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean parking;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean hasCoolingDevice;

    @ApiModelProperty(required = false,hidden = false)
    private String hasCoolingDeviceType;


    @ApiModelProperty(required = false,hidden = false)
    private Boolean hasHeatingDevice;

    @ApiModelProperty(required = false,hidden = false)
    private String hasHeatingDeviceType;

    @ApiModelProperty(required = true,hidden = false)
    private Integer codeAdvertise;

    @ApiModelProperty(required = true,hidden = false)
    private HousingAgencyDTO housingAgency;

}
