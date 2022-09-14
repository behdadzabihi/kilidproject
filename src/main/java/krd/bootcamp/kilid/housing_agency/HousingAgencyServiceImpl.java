package krd.bootcamp.kilid.housing_agency;

import krd.bootcamp.kilid.city.City;
import krd.bootcamp.kilid.city.CityService;
import krd.bootcamp.kilid.common.exception.NotFoundException;
import krd.bootcamp.kilid.municipality.Municipality;
import krd.bootcamp.kilid.municipality.MunicipalityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HousingAgencyServiceImpl implements HouseAgencyService{

    private final HouseAgencyRepository repository;



    @Override
    public HousingAgency save(HousingAgency housingAgency) {
        return repository.save(housingAgency);
    }

    @Override
    public HousingAgency update(HousingAgency housingAgency) {
        HousingAgency lastHousingAgency=findById(housingAgency.getId());
        lastHousingAgency.setAddress(housingAgency.getAddress());
        lastHousingAgency.setName(housingAgency.getName());
        lastHousingAgency.setPhoneNumber(housingAgency.getPhoneNumber());
        lastHousingAgency.setLogoId(housingAgency.getLogoId());
        return repository.save(lastHousingAgency);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public HousingAgency findById(Long id) {
        Optional<HousingAgency> housingAgencyOptional=repository.findById(id);
        if(!housingAgencyOptional.isPresent()){
         throw  new NotFoundException("NOT FOUND HOUSING AGENCY");
        }
        return housingAgencyOptional.get();
    }

    @Override
    public Page<HousingAgency> getAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

}
