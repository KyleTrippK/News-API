package dao;

import models.Departments;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oDepartmentsDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addingPostSetsId() throws Exception {
        Departments testDepartment = setUpDepartment();
        assertEquals(1, testDepartment.getId());
    }

    // Helper methods
    public Departments setUpDepartment(){
        return new Departments("Sports", "Get latest on sports", 6);
    }
}