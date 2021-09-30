package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void departments_instantiatesCorrectly_true() throws Exception{
            Departments testDepartments = setupDepartment();
            assertTrue(testDepartments instanceof Departments);
    }

    @Test
    public void departments_instantiatesWithCorrectName() throws Exception{
        Departments testDepartments = setupDepartment();
        assertEquals("Politics", testDepartments.getName());
    }

//    @Test
//    public void departments_setsName() throws Exception{
//        Departments testDepartments = setupDepartment();
//        assertEquals("sports", testDepartments.setName("sports"));
//    }

    @Test
    public void departments_instantiatesWithCorrectDescription() throws Exception{
        Departments testDepartments = setupDepartment();
        assertEquals("Get all information in the world of politics", testDepartments.getDescription());
    }

    @Test
    public void departments_instantiatesWithCorrectMembers() throws Exception{
        Departments testDepartments = setupDepartment();
        assertEquals(5, testDepartments.getMembers());
    }

    
    // Helper methods
    public Departments setupDepartment() {
        return new Departments("Politics", "Get all information in the world of politics", 4);
    }
}