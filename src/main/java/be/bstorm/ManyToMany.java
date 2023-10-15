package be.bstorm;

import be.bstorm.entities.Instrument;
import be.bstorm.entities.Musician;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToMany {
    public static void DemoManyToMany(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;


        //Ajout de musiciens
        Musician frusciante = new Musician();
        frusciante.setNom("Frusciante");

        Musician flea = new Musician();
        flea.setNom("Flea");

        //Ajout d'instruments
        Instrument piano = new Instrument();
        piano.setNom("piano");
        piano.setMarque("Yamaha");

        Instrument guitare = new Instrument();
        guitare.setNom("guitare");
        guitare.setMarque("Fender");

        Instrument trompette = new Instrument();
        trompette.setNom("trompette");
        trompette.setMarque("Bach");

        Instrument bass = new Instrument();
        bass.setNom("bass");
        bass.setMarque("Fender");

        //Lier les instruments aux musiciens
        frusciante.ajouter(guitare);
        frusciante.ajouter(piano);
        flea.ajouter(bass);
        flea.ajouter(trompette);


        //Début de la transaction et envoi en DB
        tx = session.beginTransaction();

        session.persist(frusciante);
        session.persist(flea);
        session.persist(guitare);
        session.persist(bass);
        session.persist(trompette);
        session.persist(piano);


        //Commit provoque le flush()
        tx.commit();
    }
}
