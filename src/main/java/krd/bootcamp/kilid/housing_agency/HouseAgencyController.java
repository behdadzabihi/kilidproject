package krd.bootcamp.kilid.housing_agency;

import krd.bootcamp.kilid.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/housing_agency/")
@AllArgsConstructor
public class HouseAgencyController {

    private final HouseAgencyService service;

    private final HousingAgencyMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity<HousingAgencyDTO> save(@RequestBody HousingAgencyDTO HousingAgencyDTO){
        HousingAgency housingAgency=mapper.toHousingAgency(HousingAgencyDTO);
        service.save(housingAgency);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<HousingAgencyDTO> update(@RequestBody HousingAgencyDTO HousingAgencyDTO){
        HousingAgency housingAgency=mapper.toHousingAgency(HousingAgencyDTO);
        service.update(housingAgency);
        return ResponseEntity.ok(HousingAgencyDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<HousingAgencyDTO>> getAll(@PathVariable Integer page,@PathVariable Integer size){
        Page<HousingAgency> housingAgenciesPage=service.getAll(page,size);
        int total=housingAgenciesPage.getTotalPages();
        List<HousingAgency> housingAgencies=housingAgenciesPage.getContent();
        List<HousingAgencyDTO> housingAgencyDTOS=mapper.toHousingAgencyDTOs(housingAgencies);
        PagingData<HousingAgencyDTO> housingAgencyDTOPagingData=new PagingData<>(total,page,housingAgencyDTOS);
        return ResponseEntity.ok(housingAgencyDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<HousingAgencyDTO> getById(@PathVariable Long id){
        HousingAgency housingAgency=service.findById(id);
        HousingAgencyDTO HousingAgencyDTO=mapper.toHousingAgencyDTO(housingAgency);
        return ResponseEntity.ok(HousingAgencyDTO);
    }
}
