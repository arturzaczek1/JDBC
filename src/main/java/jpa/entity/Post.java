package jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Post extends BaseEntity {
    private String postTitle;
    private String postContent;

    @Override
    public String toString() {
        return "Post: " + postTitle + " " + postContent + " " + this.getAddedDate();
    }
}
