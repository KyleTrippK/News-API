package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void post_instantiatesCorrectly() throws Exception{
        Post testPost = setUpPost();
        assertTrue(testPost instanceof Post);
    }

    @Test
    public void post_instantiatesWithCorrectTitle() throws Exception{
        Post testPost = setUpPost();
        assertEquals("Subaru wins Again!!", testPost.getTitle());
    }

    @Test
    public void post_instantiatesWithContent() throws  Exception{
        Post testPost = setUpPost();
        assertEquals("Subaru with quickest manual shifts", testPost.getContent());
    }

    // Helper methods
    public Post setUpPost(){
        return new Post("Subaru wins Again!!", "Subaru with quickest manual shifts");
    }
}