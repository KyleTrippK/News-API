package dao;

import models.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Set;

import static org.junit.Assert.*;

public class Sql2oPostsDaoTest {
    private Connection conn;
    private Sql2oPostsDao postsDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        postsDao = new Sql2oPostsDao(sql2o);
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingPostSetsId() throws Exception {
        Post testPost = setUpPost();
        assertEquals(1, testPost.getId());
    }

    @Test
    public void getAll() throws Exception{
        Post testPost = setUpPost();
        Post AnotherPost = setUpPost();
        assertEquals(2,postsDao.getAll().size());
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void clearAll() {
    }

    // Helper methods
    public Post setUpPost(){
        return new Post("Lucky Dube", "Guns and Roses", "They care about the dollar");
    }
}