package be.bstorm;


import be.bstorm.entities.Mayor;
import be.bstorm.entities.Municipality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;
//
//        try {
//            // Créer une instance de Municipality
//            Municipality municipality = new Municipality();
//            municipality.setNom("Charleroi");
//
//            // Créer une instance de Mayor
//            Mayor mayor = new Mayor();
//            mayor.setNom("Magnette");
//
//            // Établir la relation entre Mayor et Municipality
//            mayor.setMunicipality(municipality);
//            municipality.setMayor(mayor);
//
//            // Commencer une transaction Hibernate
//            tx = session.beginTransaction();
//
//            // Enregistrer les entités dans la base de données
//            session.persist(municipality);
//            session.persist(mayor);
//
//            // Valider la transaction
//            tx.commit();
//
//            System.out.println("Enregistrements ajoutés avec succès !");
//        } catch (Exception e) {
//            // En cas d'erreur, annuler la transaction
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            // Fermer la session Hibernate
//            session.close();
//            sessionFactory.close();
//        }
   }
}







