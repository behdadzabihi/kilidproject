package krd.bootcamp.kilid.municipality;

import krd.bootcamp.kilid.image.Photo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MunicipalityService {

    Municipality save(Municipality municipality);

    Municipality update(Municipality municipality);

    void delete(Long id);

    Page<Municipality> getAll(Integer page,Integer size);

    Municipality findById(Long id);

    Page<Municipality> findByCity(Integer page,Integer size,Long houseId);

}
