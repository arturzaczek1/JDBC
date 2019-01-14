package jpa.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
}
