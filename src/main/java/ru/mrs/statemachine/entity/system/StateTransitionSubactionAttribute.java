package ru.mrs.statemachine.entity.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@Entity
@Table(name = "s_statetransit_subact_attribute"/*, schema="system"*/)
public class StateTransitionSubactionAttribute {

    @Id
    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "id_statetransit_subact", length=50, unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "id_statetransit_subact", length=100, nullable = false)
    private Long idStateTransitionSubaction;

    @Column(name = "id_state_transit", length=100, nullable = false)
    private Long idStateTransition;

    @Column(name = "field_name", length=100, nullable = false)
    private String fieldName;

    @Column(name = "const_value", length=100, nullable = false)
    private String constValue;

}
