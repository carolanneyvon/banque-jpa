package entites;
// beneficiaire 

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {
	@Column(name = "BENEFICIAIRE")
	private String beneficiaire;

	/**
	 * Constructeur sans argument
	 */
	public Virement() {
	}

	/**
	 * Getter
	 * 
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * Setter
	 * 
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
