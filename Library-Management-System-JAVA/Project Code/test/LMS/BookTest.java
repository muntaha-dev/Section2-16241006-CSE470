/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import java.util.ArrayList;
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

public class BookTest {
    Book b;
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    
    public void setUp() {
         b = new Book(1,"Java Programing 101","CSE","Random guy 01", true);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testGetTitle() {
        
        assertEquals("Java Programing 101", b.getTitle());
        
    }

    /**
     * Test of getSubject method, of class Book.
     */
    @Test
    public void testGetSubject() {
      
        assertEquals("CSE", b.getSubject());
        
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
        
        assertEquals("Random guy 01", b.getAuthor());
        
    }

    
}
