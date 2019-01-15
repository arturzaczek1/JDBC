import jpa.JpaAPI;
import jpa.entity.Post;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JpaTest {
    JpaAPI api = new JpaAPI();

    @Test
    public void checkUpdateMethod() {
        api.updatePost(2, "third post");
        List<Post> list = api.getPostList();
        list.forEach(a -> System.out.println(a.toString()));
    }

    @Test
    public void checkDeleteMethod() {
        api.deletePostWithId(1);
        List<Post> list = api.getPostList();
        list.forEach(a -> System.out.println(a.toString()));
    }

    @Test
    public void checkAddPostMethod() {
        api.addPost();
    }

    @Test
    public void checkGetPostListMethod() {
        List<Post> list = api.getPostList();
        list.forEach(a -> System.out.println(a.toString()));
    }

    @Test
    public void checkGetSomePostMethod() {
        List<Post> list = api.getSomePost("#");
        list.iterator().forEachRemaining(a -> System.out.println(a.toString()));
    }

//    @Test
//    public void addPostTest() {
//        Post post = new Post();
//        post.setPostContent("First Post");
//        post.setPostTitle("#1");
//        post.setAddedDate(Calendar.getInstance().getTime());
//
//        api.addComment(post);
//    }

    @Test
    public void getAllPosts() {
        List<Post> list = api.getPostList();
        for (Post post : list) {
            System.out.println(post.toString());
        }
    }
}
