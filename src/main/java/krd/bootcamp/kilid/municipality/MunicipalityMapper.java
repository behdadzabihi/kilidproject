package krd.bootcamp.kilid.municipality;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MunicipalityMapper {

    Municipality toMunicipality(MunicipalityDTO municipalityDTO);

    MunicipalityDTO toMunicipalityDTO(Municipality municipality);

    List<Municipality> toMunicipalities(List<MunicipalityDTO> municipalityDTOS);

    List<MunicipalityDTO> toMunicipalityDTOs(List<Municipality> municipalities);

}
