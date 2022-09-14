package krd.bootcamp.kilid.image;

import org.springframework.data.domain.Page;

import java.util.List;

public interface PhotoService {

    Photo save(Photo photo);

    Photo update(Photo photo);

    void delete(Long id);

    Page<Photo> getAll(Integer page,Integer size);

    Photo findById(Long id);

    Page<Photo> findByHouse(Integer page,Integer size,Long houseId);

}
