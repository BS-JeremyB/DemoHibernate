package be.bstorm;


import be.bstorm.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Demo Relation One to One
        OneToOne.demoOneToOne();

        //Demo Relation One to Many
        OneToMany.demoOneToMany();

        //Demo Relation Many toMany
        ManyToMany.DemoManyToMany();


   }
}







