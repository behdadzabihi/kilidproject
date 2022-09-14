package krd.bootcamp.kilid.image;

import jdk.dynalink.linker.LinkerServices;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotoMapper {

    Photo toPhoto(PhotoDTO photoDTO);

    PhotoDTO toPhotoDTOs(Photo photo);

    List<Photo> toPhotos(List<PhotoDTO> photoDTOS);

    List<PhotoDTO> toPhotoDTOs(List<Photo> photos);
}
