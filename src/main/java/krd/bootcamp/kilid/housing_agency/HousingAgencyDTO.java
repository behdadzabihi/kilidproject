package krd.bootcamp.kilid.housing_agency;


import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.kilid.common.BaseDTO;
import krd.bootcamp.kilid.house.LocationDTO;
import krd.bootcamp.kilid.municipality.MunicipalityDTO;
import lombok.Data;

@Data
public class HousingAgencyDTO extends BaseDTO {


    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = true,hidden = false)
    private String phoneNumber;

    @ApiModelProperty(required = true,hidden = false)
    private String address;


    @ApiModelProperty(required = true,hidden = false)
    private String logoId;

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;




}
