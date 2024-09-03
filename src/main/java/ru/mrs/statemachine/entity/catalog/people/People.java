package ru.mrs.statemachine.entity.catalog.people;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name="t_people"/*, schema="catalog"*/)
public class People/* implements Serializable*/ {

    @Id
    @GeneratedValue(strategy = IDENTITY)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "spec-generator")
//    @TableGenerator(name = "spec-generator", table = "spec_gen", pkColumnName = "seq_id", valueColumnName = "seq_value")
    @Column(name = "spec_id")
    public Long specId;

    /*@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "people_catalog-generator")
    @TableGenerator(name = "people_catalog-generator", table = "people_catalog_gen", pkColumnName = "seq_id", valueColumnName = "seq_value")
    @Column(name = "catalog_id")
    public Long catalogId;*/

    @Column(name="wFirstNameTX", length=150, nullable=false)
    private String wFirstNameTX;

    @Column(name="wFamilyNameTX", length=150, nullable=false)
    private String wFamilyNameTX;

    @Column(name="wSurnameTX", length=100, nullable=false)
    private String wSurnameTX;

}
