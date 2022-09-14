package krd.bootcamp.kilid.city;

import krd.bootcamp.kilid.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService{

    private CityRepository repository;

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public City update(City city) {
      City lastCity=findById(city.getId());
      lastCity.setName(city.getName());
        return repository.save(lastCity);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<City> getAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public City findById(Long id) {
        Optional<City> cityOptional=repository.findById(id);
        if(!cityOptional.isPresent()){
            throw new NotFoundException("NOT FOUND CITY");
        }
        return cityOptional.get();
    }
}
