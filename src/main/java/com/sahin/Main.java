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
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();


        session.persist(s1);


        System.out.println(s1);
    }
}