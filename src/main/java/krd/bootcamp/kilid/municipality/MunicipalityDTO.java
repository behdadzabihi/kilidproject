package krd.bootcamp.kilid.municipality;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.kilid.city.City;
import krd.bootcamp.kilid.city.CityDTO;
import krd.bootcamp.kilid.common.BaseDTO;
import krd.bootcamp.kilid.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
public class MunicipalityDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Integer region;

    @ApiModelProperty(required = true,hidden = false)
    private CityDTO city;
}
