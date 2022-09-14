package krd.bootcamp.kilid.house;

import krd.bootcamp.kilid.housing_agency.HousingAgency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HouseRepository extends PagingAndSortingRepository<House,Long> {

//    List<House> getByHousingAgency(HousingAgency housingAgency);

    Page<House> findAll(Pageable pageable);
    Page<House> findAllByHousingAgency_Id(Pageable pageable,Long housingAgencyId);


}
