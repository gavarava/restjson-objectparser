package org.restjson.json.deserialize;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.restjson.client.http.HttpClientUtils;
import org.model.Comment;
import org.model.Post;
import org.junit.Test;

public class JSONUtilsTest {

    private static String POST_SRC_URL = "https://jsonplaceholder.typicode.com/posts";
    private static String COMMENT_SRC_URL = "https://jsonplaceholder.typicode.com/comments";

    @Test
    public void thatJSONDeserializerCanConvertJSONObjectToJavaObject() throws IOException {
        String testJSONString = "{\"testIntegerProperty\": \"8\"}";
        TestJSON result = JSONUtils.deserializeString(testJSONString, new TestJSON());
        assert result.getTestIntegerProperty() == 8;

    }

    @Test
    public void thatJSONDeserializerCanConvertJSONToListOfPosts() throws IOException {
        final String allPostsFromURL = HttpClientUtils.readURLResponseAsString(POST_SRC_URL);
        Post postTemplate = new Post();
        List<Post> allPosts = JSONUtils.deserializeArray(allPostsFromURL, postTemplate);
        assertThat(allPosts.get(0), is(instanceOf(Post.class)));
    }

    @Test
    public void thatJSONDeserializerCanConvertJSONToListOfComments() throws IOException {
        final String allCommentsFromURL = HttpClientUtils.readURLResponseAsString(COMMENT_SRC_URL);
        Comment commentTemplate = new Comment();
        List<Comment> commentList = JSONUtils.deserializeArray(allCommentsFromURL, commentTemplate);
        assertThat(commentList.get(0), is(instanceOf(Comment.class)));
    }

}
