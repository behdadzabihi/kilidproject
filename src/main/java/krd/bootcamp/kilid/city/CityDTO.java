package krd.bootcamp.kilid.city;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.kilid.common.BaseDTO;
import lombok.Data;


@Data
public class CityDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;



}
