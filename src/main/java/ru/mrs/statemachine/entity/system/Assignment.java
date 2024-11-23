package ru.mrs.statemachine.entity.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@Entity
@Table(name = "s_assignment"/*, schema="wdata"*/)
public class Assignment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "id_assignments", length=50, unique = true, nullable = false, insertable = false, updatable = false)
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "spec_id", length=20, nullable = false)
    private Long specId;

    @Column(name = "wo_name", length=100)
    private String woName;
//    @Column(name = "catalog_id", length=20)
//    private Long catalogId;

    @Column(name = "form_name", length=100)
    private String formName;
//    @Column(name = "form_id", length=20)
//    private Long formId;

    @Column(name = "assoc_name", length=150, nullable = false)
    private String assocName;

    @Column(name = "assoc_spec_id", length=20, nullable = false)
    private Long assocSpecId;

    @Column(name = "assoc_wo_name", length=100)
    private String assocWoName;
    //    @Column(name = "assoc_catalog_id", length=20, nullable = false)
//    private Long assocCatalogId;

    @Column(name = "assoc_form_name", length=100)
    private String assocFormName;
//    @Column(name = "assoc_form_id", length=20)
//    private Long assocFormId;

    @Column(name = "dependent_flag")
    private boolean dependentFlag;

}
