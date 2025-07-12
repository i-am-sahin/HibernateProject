package com.sahin.HQL;


import com.sahin.HQL.Laptop_From_HQL;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Demo {
    public static void main(String[] args) {



//        Configuration config = new Configuration();
//        config.addAnnotatedClass(com.sahin.HQL.Laptop_From_HQL.class);
//        config.configure();

        SessionFactory sf = new Configuration().
        addAnnotatedClass(com.sahin.HQL.Laptop_From_HQL.class).
        configure().buildSessionFactory();
        Session s = sf.openSession();

//        System.out.println(s.find(Laptop_From_HQL.class,2));


        //select * from Laptop_From_HQL where lid=2; --> SQL
        //from Laptop_From_HQL where lid=2 --> HQL
        String brand = "Asus";
        int ram = 8;
        Query query = s.createQuery("select brand , model from Laptop_From_HQL where brand like ?1");
        query.setParameter(1,brand);
//        query.setParameter(2,ram);
       List<Object[]> laptops =  query.getResultList();

       for(Object[] data : laptops){
           System.out.println((String) data[0] + " " + (String) data[1]);
       }
        System.out.println(laptops);


        s.close();


    }
}
