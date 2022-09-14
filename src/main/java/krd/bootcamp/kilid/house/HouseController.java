package krd.bootcamp.kilid.house;

import io.micrometer.core.annotation.Timed;
import krd.bootcamp.kilid.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/house/")
@AllArgsConstructor
public class HouseController {

    private final HouseService service;

    private final HouseMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity<HouseDTO> save(@RequestBody HouseDTO houseDTO){
        House house=mapper.toHouse(houseDTO);
        service.save(house);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<HouseDTO> update(@RequestBody HouseDTO houseDTO){
        House house=mapper.toHouse(houseDTO);
        service.update(house);
        return ResponseEntity.ok(houseDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Timed("houses.getAll")
    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<HouseDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<House> housePage=service.getAll(page,size);
       Integer totalPage=housePage.getTotalPages();
        List<House> houses=housePage.getContent();
        List<HouseDTO> houseDTOS=mapper.toHouseDTOs(houses);
        PagingData<HouseDTO> houseDTOPagingData=new PagingData<>(totalPage,page,houseDTOS);
        return ResponseEntity.ok(houseDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<HouseDTO> getById(@PathVariable Long id){
        House house=service.findById(id);
        HouseDTO houseDTO=mapper.toHouseDTO(house);
        return ResponseEntity.ok(houseDTO);
    }

    @GetMapping("/v1/filter-by-housing-agency/{page}/{size}/{id}")
    public ResponseEntity<PagingData<HouseDTO>> filterByHousingAgency(@PathVariable Integer page, @PathVariable Integer size, @PathVariable Long id){
        Page<House> housePage=service.getByHousingAgency(page,size,id);
        int total=housePage.getTotalPages();
        List<House> houses=housePage.getContent();
        List<HouseDTO> houseDTOS=mapper.toHouseDTOs(houses);
        PagingData<HouseDTO> houseDTOPagingData=new PagingData<>(total,page,houseDTOS);
        return ResponseEntity.ok(houseDTOPagingData);
    }

}
