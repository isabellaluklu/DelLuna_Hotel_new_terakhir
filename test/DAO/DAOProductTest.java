/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DAOProduct;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import junit.framework.AssertionFailedError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Product;
import org.hibernate.exception.ConstraintViolationException;
import pojo.RajaErbaUtil;

/**
 *
 * @author SEAN
 */
public class DAOProductTest {
    public DAOProductTest() {
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
  public void RetrveTblProductTest() {
    System.out.println("Test List Product");
    DAOProduct instance = new DAOProduct();
    List<Product> result = instance.retrveTblproduct();
    System.out.println("Total Product: " + result.toArray().length);
    assertFalse(result.isEmpty());
  }
  
  @Test
  public void GetByIdTest() {
      System.out.println("Test Search by ID");
      String idProduct = "2";
      DAOProduct instance = new DAOProduct();
      List<Product> result = instance.getbyID(idProduct);
      assertFalse(result.isEmpty());
  }
  

  @Test
  public void AddProductTest() {
    System.out.println("Test Create Product");
    
    Product product = new Product();
    product.setRoomType("Standart");
    product.setAgeCategory("Adult");
    product.setAvailable("10");
    
    DAOProduct instance = new DAOProduct();
    instance.addProduct(product);
    
    assertNotNull(product);
  }


  @Test
  public void DeleteTest() {
    System.out.println("Test Delete Product");
    
    Integer idProduct = 9;
    DAOProduct instance = new DAOProduct(); 
    Transaction transaction = null;
    Session session = RajaErbaUtil.getSessionFactory().openSession();
    
    transaction = session.beginTransaction();
    instance.deleteUser(idProduct);
    transaction.commit();
    
    Product deletedProduct = (Product) session.get(Product.class, idProduct);
    assertNull(deletedProduct);
  }

  @Test
  public void EditTest() {
    System.out.println("Test Update Product");
    
    DAOProduct instance = new DAOProduct();
    Transaction transaction = null;
    Session session = RajaErbaUtil.getSessionFactory().openSession();
    
    Integer id = 8;
    Product product = new Product();
    product.setId(id);
    product.setRoomType("Standart");
    product.setAgeCategory("Adult");
    product.setAvailable("10");
    
    transaction = session.beginTransaction();
    instance.editUser(product);
    transaction.commit();
    
    Product updatedProduct = (Product) session.get(Product.class, id);
    
    String expResult = "standart";
    String result = updatedProduct.getRoomType();
    
    assertEquals(expResult, result);
  }
}
