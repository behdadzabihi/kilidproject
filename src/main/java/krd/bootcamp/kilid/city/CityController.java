package krd.bootcamp.kilid.city;

import io.micrometer.core.annotation.Timed;
import krd.bootcamp.kilid.common.PagingData;
import krd.bootcamp.kilid.image.Photo;
import krd.bootcamp.kilid.image.PhotoDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Sides;
import java.util.List;

@RestController
@RequestMapping(value = "/city/")
@AllArgsConstructor
public class CityController {

    private final CityService service;

    private final CityMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<CityDTO> save(@RequestBody CityDTO cityDTO){
        City city=mapper.toCity(cityDTO);
        service.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<CityDTO> update(@RequestBody CityDTO cityDTO){
        City city=mapper.toCity(cityDTO);
        service.update(city);
        return ResponseEntity.ok(cityDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Timed("city.getAll")
    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<CityDTO>> getAll(@PathVariable Integer page,@PathVariable Integer size){
        Page<City> cityPage=service.getAll(page, size);
        int total=cityPage.getTotalPages();
        List<City> cities=cityPage.getContent();
        List<CityDTO> cityDTOS=mapper.toCityDTOs(cities);
        PagingData<CityDTO> cityDTOPagingData=new PagingData<>(total,page,cityDTOS);
        return ResponseEntity.ok(cityDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable Long id){
        City city=service.findById(id);
        CityDTO cityDTO=mapper.toCityDTO(city);
        return ResponseEntity.ok(cityDTO);
    }
}
