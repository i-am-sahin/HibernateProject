package com.sahin;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;


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


        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("DELL");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook air");
        l3.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Sahin");
        a1.setTech("Java");
//        a1.setLaptops(Arrays.asList(l1, l2));


        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Rishu");
        a2.setTech("C++");


//        Alien a3 = new Alien();
//        a3.setAid(103);
//        a3.setAname("Jeet");
//        a3.setTech("C#");


//        a3.setLaptops(Arrays.asList(l1, l2));

//        l1.setAlien(a1);
//        l2.setAlien(a1);

        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l3));
//        a3.setLaptops(Arrays.asList(l1));


//        l1.setAliens(Arrays.asList(a1, a3));
//        l2.setAliens(Arrays.asList(a1,a2));
//        l3.setAliens(Arrays.asList(a2));




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
        session.persist(l2);
        session.persist(l3);


        session.persist(a1);
        session.persist(a2);
//        session.persist(a3);

//              Fetching The data from Database
//        s2 = session.find(Student.class,4);
//        Alien a5 = session.find(Alien.class,101);



        //Update the Object value from the database
//        session.merge(s1); //If data in present in the database It'll change the data,Else it'll insert the Data!


        //Delete Data from Database
//        s2 = session.find(Student.class,5);
//        session.remove(s2);

        transaction.commit();



        session.close();

        Session s2 = sf.openSession();
        Alien a0 = s2.find(Alien.class,102);
        System.out.println(a0);
        s2.close();
        sf.close();


//        System.out.println(s1);
//        System.out.println(a2);
    }
}