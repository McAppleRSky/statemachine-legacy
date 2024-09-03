package ru.mrs.statemachine.entity.catalog.location;

import lombok.Getter;
import lombok.Setter;
import ru.mrs.statemachine.entity.MySpec;

import javax.persistence.*;

@Getter @Setter
//@Entity
public class Space extends MySpec {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "catalog-generator")
    @TableGenerator(name = "catalog-generator", table = "spec_location", pkColumnName = "seq_id", valueColumnName = "seq_value")
    @Column(name = "catalog_id")
    public Long catalogId;



}
