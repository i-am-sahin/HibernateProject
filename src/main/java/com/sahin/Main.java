package com.sahin;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("sahin");
        s1.setRollNo(5);
        s1.setsAge(21);
        Student s2 = null;


//        Configuration config = new Configuration();
//        config.addAnnotatedClass(com.sahin.Student.class);
//        config.configure(); //this file loads the xml


        SessionFactory sf =  new Configuration()
                    .addAnnotatedClass(com.sahin.Student.class)
                .configure()
                        .buildSessionFactory();             //config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction(); //Transaction is an interface, For that we to call `session.beginTransaction();` it returns a Transaction Object!

            //Save data into DB;
//        session.persist(s1);

//              Fetching The data from Database
//        s2 = session.find(Student.class,4);



        //Update the Object value from the database
//        session.merge(s1); //If data in present in the database It'll change the data,Else it'll insert the Data!


        //Delete Data from Database
        s2 = session.find(Student.class,5);
        session.remove(s2);

        transaction.commit();



        session.close();
        sf.close();


        System.out.println(s1);
    }
}