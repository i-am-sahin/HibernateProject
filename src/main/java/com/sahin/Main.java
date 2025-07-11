package com.sahin;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Sahin");
        s1.setRollNo(626);
        s1.setsAge(22);


        Configuration config = new Configuration();
        config.addAnnotatedClass(com.sahin.Student.class);
        config.configure(); //this file loads the xml


        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction(); //Transaction is an interface, For that we to call `session.beginTransaction();` it returns a Transaction Object!

        session.persist(s1);
        transaction.commit();


        System.out.println(s1);
    }
}