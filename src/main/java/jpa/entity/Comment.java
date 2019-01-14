package jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Comment extends BaseEntity {
    private String commentContent;
    private String nick;
}
