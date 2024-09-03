package ru.mrs.statemachine.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@Entity
@Table(name = "wo_state_transition"/*, schema="system"*/)
public class WorkObjectStateTransition {

    @Id
    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "id_assignments", length=50, unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "wo_name", length=100, nullable = false)
    private String woName;

    @Column(name = "current_state", length=100, nullable = false)
    private String currentState;

    @Column(name = "action_name", length=100, nullable = false)
    private String actionName;

    @Column(name = "action_label", length=100, nullable = false)
    private String actionLabel;

    @Column(name = "next_state", length=100, nullable = false)
    private String nextState;

    @Column(name = "class_name", length=1000)
    private String className;

    @Column(name = "methodName", length=100)
    private String methodName;

    @Column(name = "read_only", nullable = false)
    private boolean read_only;

    @Column(name = "close_screan", nullable = false)
    private boolean closeScrean;

    @Column(name = "secondary_action", nullable = false)
    private boolean secondaryAction;


    @Column(name = "custom_url", length=500)
    private String customUrl;

}
