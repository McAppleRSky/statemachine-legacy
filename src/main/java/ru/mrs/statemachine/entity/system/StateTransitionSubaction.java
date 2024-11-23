package ru.mrs.statemachine.entity.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@Entity
@Table(name = "s_statetransit_subaction"/*, schema="system"*/)
public class StateTransitionSubaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "id_statetransit_subact", unique = true, nullable = false, insertable = false, updatable = false)
    @Column(name = "id_statetransit_subact")
    private Long id;

    @Column(name = "action_name", length=100, nullable = false)
    private String actionName;

    @Column(name = "id_state_transit", length=100, nullable = false)
    private Long idStateTransit;

    @Column(name = "process_name", length=150)
    private String processName;

}
