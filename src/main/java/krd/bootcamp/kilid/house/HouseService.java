package krd.bootcamp.kilid.house;

import org.springframework.data.domain.Page;

import java.util.List;

public interface HouseService {

    House save(House house);

    House update(House house);

    void delete(Long id);

    Page<House> getAll(Integer page,Integer size);

    House findById(Long id);

    Page<House> getByHousingAgency(Integer page, Integer size, Long hosingAgencyId);


}
