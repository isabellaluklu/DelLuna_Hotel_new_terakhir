/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DAOLogin;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Employees;

/**
 *
 * @author SEAN
 */
public class DAOAdminTest {
    public DAOAdminTest() {
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
    
  }

  @Test
  public void GetLoginTest() {
    System.out.println("Test Login");
    String uEmail = "admin@gmail.com";
    String uPass = "123";   
    int empty = 0;
    DAOLogin instance = new DAOLogin();
    List<Employees> result = instance.getBy(uEmail, uPass);
    System.out.println(result.toArray().length);
    assertThat(result.toArray().length, is(not(equalTo(empty))));
  }

  @Test
  public void AddAdminTest() {
    System.out.println("Test Register");
    
    Employees user = new Employees();
    user.setEmail("admin2@gmail.com");
    user.setName("Admin2");
    user.setPassword("123");
    
    DAOLogin instance = new DAOLogin();
    String expResult = "index";
    String result = instance.add_user(user);
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
  }
}
