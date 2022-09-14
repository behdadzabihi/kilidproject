package krd.bootcamp.kilid.image;

import krd.bootcamp.kilid.common.PagingData;
import krd.bootcamp.kilid.municipality.Municipality;
import krd.bootcamp.kilid.municipality.MunicipalityDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/photo/")
@AllArgsConstructor
public class PhotoController {

    private final PhotoService service;

    private final PhotoMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity<PhotoDTO> save(@RequestBody PhotoDTO photoDTO){
        Photo photo=mapper.toPhoto(photoDTO);
        service.save(photo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<PhotoDTO> update(@RequestBody PhotoDTO photoDTO){
        Photo photo=mapper.toPhoto(photoDTO);
        service.update(photo);
        return ResponseEntity.ok(photoDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<PhotoDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Photo> photoPage=service.getAll(page,size);
        Integer totalPage=photoPage.getTotalPages();
        List<Photo> photos=photoPage.getContent();
        List<PhotoDTO> photoDTOS=mapper.toPhotoDTOs(photos);
        PagingData<PhotoDTO> photoDTOPagingData=new PagingData<>(totalPage,page,photoDTOS);
        return ResponseEntity.ok(photoDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<PhotoDTO> getById(@PathVariable Long id){
        Photo photo=service.findById(id);
        PhotoDTO photoDTO=mapper.toPhotoDTOs(photo);
        return ResponseEntity.ok(photoDTO);
    }

    @GetMapping("/v1/filter-by-house/{page}/{size}/{id}")
    public ResponseEntity<PagingData<PhotoDTO>> filterByHouse(@PathVariable Integer page, @PathVariable Integer size, @PathVariable Long id){
        Page<Photo> photoPage=service.findByHouse(page,size,id);
        int totalPage=photoPage.getTotalPages();
        List<Photo> photos=photoPage.getContent();
        List<PhotoDTO> photoDTOS=mapper.toPhotoDTOs(photos);
        PagingData<PhotoDTO> photoDTOPagingData=new PagingData<>(totalPage,page,photoDTOS);
        return ResponseEntity.ok(photoDTOPagingData);
    }
}
