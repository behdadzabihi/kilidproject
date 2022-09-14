package krd.bootcamp.kilid.housing_agency;

import krd.bootcamp.kilid.house.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseAgencyRepository extends PagingAndSortingRepository<HousingAgency,Long> {

    Page<HousingAgency> findAll(Pageable pageable);

}
