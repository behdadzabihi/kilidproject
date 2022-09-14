package krd.bootcamp.kilid.image;

import krd.bootcamp.kilid.house.House;
import krd.bootcamp.kilid.municipality.Municipality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PhotoRepository extends PagingAndSortingRepository<Photo,Long> {

    Page<Photo> findAllByHouse_Id(Pageable pageable, Long cityId);
    Page<Photo> findAll(Pageable pageable);

}
