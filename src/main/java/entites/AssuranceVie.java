package entites;
// dateFin, taux

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {
	@Column(name = "DATE_FIN")
	private Date dateFin;

	@Column(name = "TAUX")
	private double taux;

	/**
	 * Constructeur sans argument
	 */
	public AssuranceVie() {
	}

	/** Getter
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
