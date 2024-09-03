package ru.mrs.statemachine.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Getter @Setter
//@Entity
public abstract class MySpec {

//    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "spec-generator")
    @TableGenerator(name = "spec-generator", table = "spec", pkColumnName = "seq_id", valueColumnName = "seq_value")
//    @Column(name = "spec_id")
    public Long id;

}
