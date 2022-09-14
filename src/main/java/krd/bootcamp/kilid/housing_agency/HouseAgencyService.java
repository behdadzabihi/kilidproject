package krd.bootcamp.kilid.housing_agency;

import org.springframework.data.domain.Page;

import java.util.List;

public interface HouseAgencyService {

    HousingAgency save(HousingAgency housingAgency);

    HousingAgency update(HousingAgency housingAgency);

    void delete(Long id);

    HousingAgency findById(Long id);

    Page<HousingAgency> getAll(Integer page,Integer size);
}
