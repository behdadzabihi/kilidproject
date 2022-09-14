package krd.bootcamp.kilid.city;

import krd.bootcamp.kilid.common.BaseEntity;
import krd.bootcamp.kilid.municipality.Municipality;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_city")
@Data
@Audited
public class City extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city",cascade = CascadeType.ALL)
    List<Municipality> municipalities;



}
