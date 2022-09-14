package krd.bootcamp.kilid.city;

import krd.bootcamp.kilid.image.Photo;
import krd.bootcamp.kilid.image.PhotoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toCity(CityDTO cityDTO);

    CityDTO toCityDTO(City city);

    List<City> toCities(List<CityDTO> cityDTOS);

    List<CityDTO> toCityDTOs(List<City> cities);
}
