package krd.bootcamp.kilid.municipality;

import krd.bootcamp.kilid.city.City;
import krd.bootcamp.kilid.image.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipalityRepository extends PagingAndSortingRepository<Municipality,Long> {

  Page<Municipality> findAllByCity_Id(Pageable pageable,Long houseId);
  Page<Municipality> findAll(Pageable pageable);


}
