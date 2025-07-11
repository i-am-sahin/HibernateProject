package com.sahin;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Rishu");
        s1.setRollNo(4);
        s1.setsAge(21);


//        Configuration config = new Configuration();
//        config.addAnnotatedClass(com.sahin.Student.class);
//        config.configure(); //this file loads the xml


        SessionFactory sf =  new Configuration()
                    .addAnnotatedClass(com.sahin.Student.class)
                .configure()
                        .buildSessionFactory();             //config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction(); //Transaction is an interface, For that we to call `session.beginTransaction();` it returns a Transaction Object!

        session.persist(s1);
        transaction.commit();
        session.close();
        sf.close();


        System.out.println(s1);
    }
}