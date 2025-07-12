package com.sahin.HQL;


import com.sahin.HQL.Laptop_From_HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String[] args) {

        Laptop_From_HQL lap = new Laptop_From_HQL();
        lap.setLid(1);
        lap.setBrand("Dell");
        lap.setModel("Inspiron");
        lap.setRam(8);


        Laptop_From_HQL lap2 = new Laptop_From_HQL();
        lap2.setLid(2);
        lap2.setBrand("MSI");
        lap2.setModel("GF63");
        lap2.setRam(16);

        Laptop_From_HQL lap3 = new Laptop_From_HQL();
        lap3.setLid(3);
        lap3.setBrand("Asus");
        lap3.setModel("ROG");
        lap3.setRam(32);


        Laptop_From_HQL lap4 = new Laptop_From_HQL();
        lap4.setLid(4);
        lap4.setBrand("Asus");
        lap4.setModel("TUF");
        lap4.setRam(16);

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.sahin.HQL.Laptop_From_HQL.class);
        config.configure();

        SessionFactory sf = config.buildSessionFactory();
        Session s = sf.openSession();

        s.persist(lap);
        s.persist(lap2);
        s.persist(lap3);
        s.persist(lap4);


        Transaction transaction = s.beginTransaction();
        transaction.commit();
        s.close();


    }
}
