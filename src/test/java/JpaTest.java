import jpa.JpaAPI;
import jpa.entity.Post;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class JpaTest {

    @Test
    public void addPostTest() {
        JpaAPI jpaAPI = new JpaAPI();

        Post post = new Post();
        post.setPostContent("First Post");
        post.setAddedDate(Calendar.getInstance().getTime());

        jpaAPI.addComment(post);

    }
}
