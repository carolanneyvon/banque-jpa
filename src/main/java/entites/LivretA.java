package entites;
// taux

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
	@Column(name = "TAUX")
	private double taux;

	/**
	 * Constructeur sans argument
	 */
	public LivretA() {
	}

	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
}
