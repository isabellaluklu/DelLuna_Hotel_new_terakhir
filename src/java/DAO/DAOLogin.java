/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Employees;
import pojo.Product;
import pojo.RajaErbaUtil;

/**
 *
 * 
 */
public class DAOLogin {
    public List<Employees> getBy(String uEmail, String uPass) {
        Transaction trans = null;
        Employees us = new Employees();
        List<Employees> user = new ArrayList();
        Session session = RajaErbaUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Employees where email=:uEmail AND password=:uPass");
            query.setString("uEmail", uEmail);
            query.setString("uPass", uPass);
            us = (Employees) query.uniqueResult();
            user = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
    
    public String add_user(Employees user){
        Transaction trans = null;
        Session session = RajaErbaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
            return "index";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "register_error";
    }

    List<Employees> getBy(String uName, String uEmail, String uPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List<Product> getBy(int idProduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
