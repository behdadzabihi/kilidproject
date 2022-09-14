package krd.bootcamp.kilid.municipality;

import krd.bootcamp.kilid.common.PagingData;
import krd.bootcamp.kilid.common.exception.RestExceptionHandler;
import krd.bootcamp.kilid.house.House;
import krd.bootcamp.kilid.house.HouseDTO;
import krd.bootcamp.kilid.image.Photo;
import krd.bootcamp.kilid.image.PhotoDTO;
import krd.bootcamp.kilid.image.PhotoMapper;
import krd.bootcamp.kilid.image.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/municipality/")
@AllArgsConstructor
public class MunicipalityController {

    private final MunicipalityService service;

    private final MunicipalityMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity<MunicipalityDTO> save(@RequestBody MunicipalityDTO municipalityDTO){
        Municipality municipality=mapper.toMunicipality(municipalityDTO);
        service.save(municipality);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<MunicipalityDTO> update(@RequestBody MunicipalityDTO municipalityDTO){
        Municipality municipality=mapper.toMunicipality(municipalityDTO);
        service.update(municipality);
        return ResponseEntity.ok(municipalityDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<MunicipalityDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Municipality> municipalityPage=service.getAll(page,size);
        Integer totalPage=municipalityPage.getTotalPages();
        List<Municipality> municipalities=municipalityPage.getContent();
        List<MunicipalityDTO> municipalityDTOS=mapper.toMunicipalityDTOs(municipalities);
        PagingData<MunicipalityDTO> municipalityDTOPagingData=new PagingData<>(totalPage,page,municipalityDTOS);
        return ResponseEntity.ok(municipalityDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<MunicipalityDTO> getById(@PathVariable Long id){
        Municipality municipality=service.findById(id);
        MunicipalityDTO municipalityDTO=mapper.toMunicipalityDTO(municipality);
        return ResponseEntity.ok(municipalityDTO);
    }

    @GetMapping("/v1/filter-by-city/{page}/{size}/{id}")
    public ResponseEntity<PagingData<MunicipalityDTO>> findAllByCity(@PathVariable Integer page, @PathVariable Integer size, @PathVariable Long id){
        Page<Municipality> municipalityPage=service.findByCity(page,size,id);
        int totalPage=municipalityPage.getTotalPages();
        List<Municipality> municipalities=municipalityPage.getContent();
        List<MunicipalityDTO> municipalityDTOS=mapper.toMunicipalityDTOs(municipalities);
        PagingData<MunicipalityDTO> municipalityDTOPagingData=new PagingData<>(totalPage,page,municipalityDTOS);
        return ResponseEntity.ok(municipalityDTOPagingData);
    }

}
