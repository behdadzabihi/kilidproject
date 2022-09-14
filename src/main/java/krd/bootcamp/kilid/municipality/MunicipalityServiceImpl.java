package krd.bootcamp.kilid.municipality;

import krd.bootcamp.kilid.city.City;
import krd.bootcamp.kilid.city.CityService;
import krd.bootcamp.kilid.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MunicipalityServiceImpl implements MunicipalityService {

    private final CityService cityService;
    private final MunicipalityRepository repository;

    @Override
    public Municipality save(Municipality municipality) {
        Long munId=municipality.getCity().getId();
        City city= cityService.findById(munId);
        municipality.setCity(city);
        return repository.save(municipality);
    }

    @Override
    public Municipality update(Municipality municipality) {
       Municipality lastMunicipality=findById(municipality.getId());
       lastMunicipality.setRegion(municipality.getRegion());
        return repository.save(lastMunicipality);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<Municipality> getAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Municipality findById(Long id) {
        Optional<Municipality> municipalityOptional=repository.findById(id);
        if(!municipalityOptional.isPresent()){
            throw new NotFoundException("NOT FOUND MUNICIPALITY");
        }
        return municipalityOptional.get();
    }

    @Override
    public Page<Municipality> findByCity(Integer page,Integer size,Long cityId) {
        return repository.findAllByCity_Id(PageRequest.of(page,size),cityId);
    }
}
