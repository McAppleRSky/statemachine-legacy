package ru.mrs.statemachine.entity.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@Entity
@Table(name = "s_state"/*, schema="system"*/)
public class State {

    @Id
    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "id_assignments", length=50, unique = true, nullable = false, insertable = false, updatable = false)
//    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "wo_name", length=100, nullable = false)
    private String woName;

    @Column(name = "wo_state", length=100, nullable = false)
    private String woState;

}
