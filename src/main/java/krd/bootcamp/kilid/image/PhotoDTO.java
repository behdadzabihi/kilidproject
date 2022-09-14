package krd.bootcamp.kilid.image;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.kilid.common.BaseDTO;
import krd.bootcamp.kilid.house.HouseDTO;
import lombok.Data;

@Data
public class PhotoDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String image;

    @ApiModelProperty(required = true,hidden = false)
    private HouseDTO house;
}
