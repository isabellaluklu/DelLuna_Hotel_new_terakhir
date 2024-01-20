/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import DAO.DAOLogin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SEAN
 */
public class AdminTest {
    public AdminTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    System.out.println("Start Testing");
  }
  
  @AfterClass
  public static void tearDownClass() {
    System.out.println("End Testing");
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
    System.out.println("\n");
  }

  @Test
  public void SaveAdminTest() {
    System.out.println("Test Save User");
    
    Employees instance = new Employees();
    instance.setEmail("Admin3@gmail.com");
    instance.setName("Admin3");
    instance.setPassword("123");
    
    String expResult = "index";
    String result = instance.save_user();
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
  }

  @Test
  public void LoginAdminTest() {
    System.out.println("Test Login User");
   
    Employees instance = new Employees();
    instance.setEmail("naufal@gmail.com");
    instance.setPassword("123"); 
    
    String expResult = "homepage";
    String result = instance.login_user();
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
  }
}
