package krd.bootcamp.kilid.image;

import krd.bootcamp.kilid.common.BaseEntity;
import krd.bootcamp.kilid.house.House;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_photo")
@Data
@Audited
public class Photo extends BaseEntity {

    @NotNull
    @Column(name = "link_img")
    private String image;

    @ManyToOne
    private House house;
}
