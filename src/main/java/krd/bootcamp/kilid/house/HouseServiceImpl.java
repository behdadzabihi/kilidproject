package krd.bootcamp.kilid.house;

import krd.bootcamp.kilid.common.exception.NotFoundException;
import krd.bootcamp.kilid.housing_agency.HouseAgencyService;
import krd.bootcamp.kilid.housing_agency.HousingAgency;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HouseServiceImpl implements HouseService{

    private final HouseAgencyService houseAgencyService;

    private final HouseRepository repository;
    @Override
    public House save(House house) {
        Long haId=house.getHousingAgency().getId();
        HousingAgency housingAgency= houseAgencyService.findById(haId);
        house.setHousingAgency(housingAgency);
        return repository.save(house);
    }

    @Override
    public House update(House house) {
       House lastHouse=findById(house.getId());
       lastHouse.setHouseState(house.getHouseState());
       lastHouse.setAddress(house.getAddress());
       lastHouse.setHouseType(house.getHouseType());
       lastHouse.setArea(house.getArea());
       lastHouse.setBalcony(house.getBalcony());
       lastHouse.setCountOfRoom(house.getCountOfRoom());
       lastHouse.setDeposit(house.getDeposit());
       lastHouse.setFloor(house.getFloor());
       lastHouse.setLocation(house.getLocation());
       lastHouse.setPriceByMeter(house.getPriceByMeter());
       lastHouse.setRentPrice(house.getRentPrice());
       lastHouse.setSalePrice(house.getSalePrice());
       lastHouse.setSaleType(house.getSaleType());
       lastHouse.setTitle(house.getTitle());
       lastHouse.setWarehouse(house.getWarehouse());
       lastHouse.setElevator(house.getElevator());
       lastHouse.setYearOfConstruction(house.getYearOfConstruction());
       lastHouse.setDescription(house.getDescription());
       lastHouse.setSuitableFor(house.getSuitableFor());
       lastHouse.setUnit(house.getUnit());
       lastHouse.setNumberOfFloor(house.getNumberOfFloor());
       lastHouse.setNumberOfUnitPerFloor(house.getNumberOfUnitPerFloor());
       lastHouse.setHasCoolingDevice(house.getHasCoolingDevice());
       lastHouse.setHasCoolingDeviceType(house.getHasCoolingDeviceType());
       lastHouse.setHasHeatingDevice(house.getHasHeatingDevice());
       lastHouse.setHasHeatingDeviceType(house.getHasHeatingDeviceType());
       lastHouse.setParking(house.getParking());
       lastHouse.setCodeAdvertise(house.getCodeAdvertise());
        return repository.save(lastHouse);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<House> getAll(Integer page,Integer size) {
        return  repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public House findById(Long id) {
        Optional<House> houseOptional=repository.findById(id);
        if(!houseOptional.isPresent()){
            throw new NotFoundException("NOT FOUND HOUSE");
        }
        return houseOptional.get();
    }

    @Override
    public Page<House> getByHousingAgency(Integer page, Integer size, Long hosingAgencyId) {
        return repository.findAllByHousingAgency_Id(PageRequest.of(page,size),hosingAgencyId);
    }

}
