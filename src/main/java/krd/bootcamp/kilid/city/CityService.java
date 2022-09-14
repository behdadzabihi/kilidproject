package krd.bootcamp.kilid.city;

import krd.bootcamp.kilid.image.Photo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CityService {

    City save(City city);

    City update(City city);

    void delete(Long id);

    Page<City> getAll(Integer page,Integer size);

    City findById(Long id);
}
