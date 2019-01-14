package jpa;

import jpa.entity.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaAPI {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistence-unit");

    public void addComment(Post post) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();
    }
}
