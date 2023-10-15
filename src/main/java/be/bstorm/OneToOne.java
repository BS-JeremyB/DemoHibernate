package be.bstorm;

import be.bstorm.entities.Mayor;
import be.bstorm.entities.Municipality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public  class OneToOne {

    public static void demoOneToOne(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {

            // Créer une instance de Municipality
            Municipality municipality = new Municipality();
            municipality.setNom("Charleroi");

            // Créer une instance de Mayor
            Mayor mayor = new Mayor();
            mayor.setNom("Magnette");

            // Créer une instance de Municipality
            Municipality municipality2 = new Municipality();
            municipality2.setNom("Namur");

            // Créer une instance de Mayor
            Mayor mayor2 = new Mayor();
            mayor2.setNom("Prevot");

            // Établir la relation entre Mayor et Municipality
            mayor.setMunicipality(municipality);
            municipality.setMayor(mayor);

            mayor.setMunicipality(municipality);
            municipality2.setMayor(mayor2);


            // Commencer une transaction Hibernate
            tx = session.beginTransaction();

            // Enregistrer les entités dans la base de données
            session.persist(municipality);
            session.persist(mayor);

            session.persist(municipality2);
            session.persist(mayor2);

            // Valider la transaction
            tx.commit();

            System.out.println("Enregistrements ajoutés avec succès !");
        } catch (Exception e) {
            // En cas d'erreur, annuler la transaction
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // Fermer la session Hibernate


            session.close();
            sessionFactory.close();
        }

    }
}
