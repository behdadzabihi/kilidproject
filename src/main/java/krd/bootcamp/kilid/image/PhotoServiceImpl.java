package krd.bootcamp.kilid.image;

import krd.bootcamp.kilid.common.exception.NotFoundException;
import krd.bootcamp.kilid.house.House;
import krd.bootcamp.kilid.house.HouseService;
import krd.bootcamp.kilid.municipality.Municipality;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final HouseService houseService;

    private final PhotoRepository repository;


    @Override
    public Photo save(Photo photo) {
        Long hId=photo.getHouse().getId();
        House house= houseService.findById(hId);
        photo.setHouse(house);
        return repository.save(photo);
    }

    @Override
    public Photo update(Photo photo) {
        Photo lastPhoto=findById(photo.getId());
        lastPhoto.setImage(photo.getImage());
        return repository.save(lastPhoto);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<Photo> getAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Photo findById(Long id) {
        Optional<Photo> photoOptional=repository.findById(id);
        if(!photoOptional.isPresent()){
            throw new NotFoundException("NOT FOUND PHOTO");
        }
        return photoOptional.get();
    }

    @Override
    public Page<Photo> findByHouse(Integer page, Integer size, Long houseId) {
        return repository.findAllByHouse_Id(PageRequest.of(page,size),houseId);
    }

}
