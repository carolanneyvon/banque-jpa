package entites;

import java.util.Calendar;
import java.util.Date;

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

		// nouvelles banques
		Banque banque1 = new Banque();
		banque1.setNom("LBP");
		em.persist(banque1);

		Banque banque2 = new Banque();
		banque2.setNom("Caisse epargne");
		em.persist(banque2);

		Banque banque3 = new Banque();
		banque3.setNom("N26");
		em.persist(banque3);

		// nouveaux comptes
		Compte compte1 = new Compte();
		compte1.setNumero("1233654O");
		compte1.setSolde(1500);
		em.persist(compte1);

		LivretA livret1 = new LivretA();
		livret1.setNumero("258974Ab23");
		livret1.setSolde(3610);
		livret1.setTaux(3);
		em.persist(livret1);

		Calendar cal2 = Calendar.getInstance();
		cal2.set(2050, 5, 18);

		AssuranceVie assurance1 = new AssuranceVie();
		assurance1.setNumero("258974Ab23");
		assurance1.setSolde(3610);
		assurance1.setDateFin(cal2.getTime());
		assurance1.setTaux(4);
		em.persist(assurance1);

		// nouveaux clients
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

		Calendar cal3 = Calendar.getInstance();
		cal3.set(1988, 5, 18);

		Adresse adresse2 = new Adresse();
		adresse2.setNumero(15);
		adresse2.setRue("Rue des étoiles");
		adresse2.setCodePostal(34000);
		adresse2.setVille("Lune");

		Client client2 = new Client();
		client2.setNom("Faust");
		client2.setPrenom("Ilsa");
		client2.setDateNaissance(cal3.getTime());
		client2.setAdresse(adresse2);
		client2.setBanque(banque1);
		em.persist(client2);

		// ajout du compte1 au client1 et client2
		compte1.getComptes().add(client1);
		compte1.getComptes().add(client2);

		// ajout des comptes livret1 et assurance1 au client1
		livret1.getComptes().add(client1);
		assurance1.getComptes().add(client1);
		
		// creation operation type operation sur un compte
		Operation operation1 = new Operation();
		operation1.setDate(new Date());
		operation1.setMontant(350);
		operation1.setMotif("Noël");
		operation1.setCompte(compte1);
		em.persist(operation1);
		
		// ajout de operations1 dans operations
		compte1.getOperations().add(operation1);
		
		// creation operation type virement sur un compte
		Virement virement1 = new Virement();
		virement1.setDate(new Date());
		virement1.setMontant(350);
		virement1.setMotif("Anniversaire");
		virement1.setCompte(livret1);
		virement1.setBeneficiaire("Maë");
		em.persist(virement1);
		
		// ajout de virement1 dans operations
		livret1.getOperations().add(virement1);
		
		
		
		transaction.commit();
	}

}
