/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class StaffTest {
    Staff st;
    public StaffTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        st = new Staff(01," Rahim ", "Mohakhali" , 12345 , 5000.00);
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of getSalary method, of class Staff.
     */
    @Test
    public void testGetSalary() {
        
        assertEquals(5000.00, st.getSalary(), 0.0);
       
    }
    
}
