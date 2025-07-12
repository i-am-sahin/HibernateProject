package com.sahin;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;



public class Main {
    public static void main(String[] args) {
//        Student s1 = new Student();
//        s1.setsName("sahin");
//        s1.setRollNo(5);
//        s1.setsAge(21);
//        Student s2 = null;

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("MSI");
        l1.setModel("GF63");
        l1.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Sahin");
        a1.setTech("Java");
        a1.setLaptop(l1);



//        Configuration config = new Configuration();
//        config.addAnnotatedClass(com.sahin.Student.class);
//        config.configure(); //this file loads the xml


        SessionFactory sf =  new Configuration()
                    .addAnnotatedClass(com.sahin.Alien.class)
                .addAnnotatedClass(com.sahin.Laptop.class)
                .configure()
                        .buildSessionFactory();             //config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction(); //Transaction is an interface, For that we to call `session.beginTransaction();` it returns a Transaction Object!

            //Save data into DB;
//        session.persist(s1);
        session.persist(l1);
        session.persist(a1);

//              Fetching The data from Database
//        s2 = session.find(Student.class,4);
        Alien a2 = session.find(Alien.class,1);



        //Update the Object value from the database
//        session.merge(s1); //If data in present in the database It'll change the data,Else it'll insert the Data!


        //Delete Data from Database
//        s2 = session.find(Student.class,5);
//        session.remove(s2);

        transaction.commit();



        session.close();
        sf.close();


//        System.out.println(s1);
        System.out.println(a2);
    }
}