package jpa;

import jpa.entity.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;

public class JpaAPI {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit2");

    public void updatePost(Integer id, String postContent) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Long longId = Long.parseLong(id + "");
        Post post = em.find(Post.class, longId);
        em.getTransaction().begin();
        post.setPostContent(postContent);
        em.getTransaction().commit();
        em.close();
    }

    public void deletePostWithId(Integer id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Long longId = Long.parseLong(id + "");
        Post post = em.find(Post.class, longId);
        em.getTransaction().begin();
        em.remove(post);
        em.getTransaction().commit();
        em.close();
    }

    public List<Post> getSomePost(String postTitle) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        postTitle = "%" + postTitle + "%";
        String jpql = "SELECT p FROM Post p WHERE postTitle LIKE :postTitle";
        List<Post> list = em.createQuery(jpql, Post.class).setParameter("postTitle", postTitle).getResultList();
        return list;
    }

//    public void addComment(Post post) {
//        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(post);
//        em.getTransaction().commit();
//    }

    public List<Post> getPostList() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String jpql = "SELECT p FROM Post p";
        TypedQuery<Post> list2 = em.createQuery(jpql, Post.class);
        return list2.getResultList();
    }

    public void addPost() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Post post1 = new Post();
        Post post2 = new Post();
        post1.setPostContent("first post");
        post1.setPostTitle("#1");
        post1.setAddedDate(Calendar.getInstance().getTime());
        post2.setPostContent("second post");
        post2.setPostTitle("#2");
        post2.setAddedDate(Calendar.getInstance().getTime());

        em.getTransaction().begin();
        em.persist(post1);
        em.persist(post2);
        em.getTransaction().commit();
        em.close();
    }
}
