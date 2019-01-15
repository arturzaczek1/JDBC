package jpa.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass //annotation allows inheritance
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)  //annotation required in Calendar and Data types
    private Date addedDate;
}
