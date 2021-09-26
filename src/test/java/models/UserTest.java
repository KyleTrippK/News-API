package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void  user_instantiatesCorrectly() throws Exception{
        User testUser = setUpUser();
        assertTrue(testUser instanceof User);
    }

    @Test
    public void user_instantiatesWithCorrectName() throws Exception{
        User testUser = setUpUser();
        assertEquals("Ken Miles", testUser.getName());
    }

    @Test
    public void user_instantiatesWithCorrectUserPosition() throws Exception{
        User testUser = setUpUser();
        assertEquals("Editor", testUser.getUserPosition());
    }

    @Test
    public void user_instantiatesWithDepartment() throws Exception{
        User testUser = setUpUser();
        assertEquals("Sports", testUser.getUserDepartment());
    }

    @Test
    public void user_instantiatesWithRole() throws Exception{
        User testUser = setUpUser();
        assertEquals("Sports news", testUser.getRole());
    }
    
    // Helper methods
    public User setUpUser(){
        return new User("Ken Miles","Editor", "Sports", "Sports news");
    }
}