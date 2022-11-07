package entites;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class ConnexionJpaBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		// nouvelle banque
		Banque banque1 = new Banque();
		banque1.setNom("LBP");
		em.persist(banque1);

		// nouveau compte
		Compte compte1 = new Compte();
		compte1.setNumero("1233654O");
		compte1.setSolde(1500);
		em.persist(compte1);

		// nouveau client
		Calendar cal = Calendar.getInstance();
		cal.set(1965, 5, 18);

		Adresse adresse1 = new Adresse();
		adresse1.setNumero(15);
		adresse1.setRue("Rue des étoiles");
		adresse1.setCodePostal(34000);
		adresse1.setVille("Lune");

		Client client1 = new Client();
		client1.setNom("Hunt");
		client1.setPrenom("Ethan");
		client1.setDateNaissance(cal.getTime());
		client1.setAdresse(adresse1);
		client1.setBanque(banque1);
		em.persist(client1);

		compte1.getComptes().add(client1);

		transaction.commit();
	}

}
