/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import DAO.DAOProduct;
import java.util.List;
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
public class ProductTest {
    public ProductTest() {
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
  public void GetRecordTest() {
    System.out.println("Test Get All Record");
    Product instance = new Product();
    int expResult = 9;
    List<Product> result = instance.getAllRecords();
    assertEquals(expResult, result.toArray().length);
  }

  @Test
  public void GetIdTest() {
    System.out.println("Test Get by ID");
      
    Product instance = new Product();
    instance.setId(1);
    
    String expResult = "dashboard";
    String result = instance.getById();

    assertEquals(expResult, result);
  }

  @Test
  public void SaveProductTest() {
    System.out.println("Test Save Product");
    
    Product instance = new Product();
    instance.setRoomType("standart");
    instance.setAgeCategory("Other");
    instance.setAvailable("");
   
    
    String expResult = "dashboard";
    String result = instance.saveProduct();

    assertEquals(expResult, result);
  }

  @Test
  public void EditProductTest() {
    System.out.println("editProduct");
    
    Product instance = new Product();
    instance.setId(7);
instance.setRoomType("standart");
    instance.setAgeCategory("Other");
    instance.setAvailable("");
  
    
    String expResult = "dashboard";
    String result = instance.editProduct();

    assertEquals(expResult, result);
  }
  
  @Test
  public void DeleteProductTest() {
    System.out.println("deleteProduct");
    
    Product instance = new Product();
    instance.setId(10);
    
    String expResult = "dashboard";
    String result = instance.deleteProduct();
    
    assertEquals(expResult, result);
  }
}
