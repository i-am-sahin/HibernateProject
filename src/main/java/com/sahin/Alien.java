package com.sahin;


import jakarta.persistence.*;

import java.util.List;

@Entity   //(name = "alien_table")
//@Table(name = "alien_table") //This is the table name in the database
public class Alien {
    @Id
    private int aid;
//    @Column(name ="alien_name")
    private String aname;

//    @Transient //This field will not be stored in the database

        //    sometime, when you build application, you want certain fields to be therefor the processing, right?Maybe you want to perform some operation,maybe you want to store some data only in the object but not in database.
    private String tech;
//@OneToOne
//    @OneToMany(mappedBy = "alien")
    @OneToMany
    private List<Laptop> laptops;






    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }



    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}
