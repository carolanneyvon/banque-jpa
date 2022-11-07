package entites;
// numero, solde 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "SOLDE")
	private double solde;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations = new ArrayList<Operation>();
	
	@ManyToMany
	@JoinTable(name = "LIEN_COMPTE_CLIENT", 
		joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"))
	private List<Client> comptes = new ArrayList<Client>();
	
	/**
	 * Constructeur sans argument
	 */
	public Compte() {
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", operations=" + operations
				+ ", comptes=" + comptes + "]";
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/** Setter
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/** Getter
	 * @return the operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}

	/** Setter
	 * @param operations the operations to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	/** Getter
	 * @return the comptes
	 */
	public List<Client> getComptes() {
		return comptes;
	}

	/** Setter
	 * @param comptes the comptes to set
	 */
	public void setComptes(List<Client> comptes) {
		this.comptes = comptes;
	}
	
	
}
