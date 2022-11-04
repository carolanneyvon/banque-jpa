package entites;

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

		transaction.commit();
	}

}
