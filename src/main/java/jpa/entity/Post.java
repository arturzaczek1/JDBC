package jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Post extends BaseEntity{
    private String postContent;
}
