package krd.bootcamp.kilid.housing_agency;

import krd.bootcamp.kilid.house.LocationDTO;
import krd.bootcamp.kilid.municipality.MunicipalityMapper;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",uses = {MunicipalityMapper.class})
public interface HousingAgencyMapper {

    @Mappings({
            @Mapping(source = "locationDTO", target = "location", qualifiedByName = "locationDtoToLocation")})
    HousingAgency toHousingAgency(HousingAgencyDTO housingAgencyDTO);

    @Mappings({
            @Mapping(source = "location", target = "locationDTO", qualifiedByName = "locationToLocationDTO")})
    HousingAgencyDTO toHousingAgencyDTO(HousingAgency housingAgency);

    List<HousingAgency> toHousingAgencies(List<HousingAgencyDTO> housingAgencyDTOS);

    List<HousingAgencyDTO> toHousingAgencyDTOs(List<HousingAgency> housingAgencies);


    @Named("locationDtoToLocation")
    default Point<G2D> convertLocationDtoToLocation(LocationDTO locationDTO) {
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()), CoordinateReferenceSystems.WGS84);
        return  candidPoint;
    }

    @Named("locationToLocationDTO")
    default  LocationDTO  convertlLocationToLocationDTO(Point<G2D> point) {
        G2D g2D=   point.getPosition();
        LocationDTO locationDTO=new LocationDTO();
        locationDTO.setLat(g2D.getLat());
        locationDTO.setLng(g2D.getLon());
        return  locationDTO;
    }
}
