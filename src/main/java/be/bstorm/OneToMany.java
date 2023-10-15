package be.bstorm;

import be.bstorm.entities.Mayor;
import be.bstorm.entities.Municipality;
import be.bstorm.entities.Province;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {

    public static void demoOneToMany(){

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        //OneToOne.demoOneToOne();

        Province hainaut = new Province();
        hainaut.setNom("Hainaut");

        // Créer une instance de Municipality
        Municipality municipality = new Municipality();
        municipality.setNom("Charleroi");

        // Créer une instance de Mayor
        Mayor mayor = new Mayor();
        mayor.setNom("Magnette");

        // Créer une instance de Municipality
        Municipality municipality2 = new Municipality();
        municipality2.setNom("Mons");

        // Créer une instance de Mayor
        Mayor mayor2 = new Mayor();
        mayor2.setNom("Martin");

        // Établir la relation entre Mayor et Municipality
        mayor.setMunicipality(municipality);
        municipality.setMayor(mayor);
        municipality.setProvince(hainaut);

        mayor2.setMunicipality(municipality2);
        municipality2.setMayor(mayor2);
        municipality2.setProvince(hainaut);

        hainaut.ajouter(municipality);
        hainaut.ajouter(municipality2);

        tx = session.beginTransaction();

        session.persist(hainaut);
        session.persist(municipality);
        session.persist(municipality2);
        session.persist(mayor);
        session.persist(mayor2);

        tx.commit();

    }


}
