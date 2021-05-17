package Proj.Spring.AppCoVacc19.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Component
	@Entity
	@Table(name = "Centre_Vaccination")
	public class Centre_Vaccination {
	//Centre_Vaccination(idCentre, nomCentre, adresseCentre, nbPersonnel, stockVacc, #CIN_A)
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "idCentre" , unique=true)
		private Integer idCentre;
		@Column(name = "nomCentre")
		private String nomCentre;
		@Column(name = "adresseCentre")
		private String adresseCentre;
		@Column(name = "nbPersonnel")
		private int nbPersonnel;
		@Column(name = "stockVacc")
		private int stockVacc;
		@OneToOne
		private Administrateur admin;
		public Centre_Vaccination(Integer idCentre, String nomCentre, String adresseCentre, int nbPersonnel, int stockVacc,
				Administrateur admin) {
			super();
			this.idCentre = idCentre;
			this.nomCentre = nomCentre;
			this.adresseCentre = adresseCentre;
			this.nbPersonnel = nbPersonnel;
			this.stockVacc = stockVacc;
			this.admin = admin;
		}
		public Centre_Vaccination() {
			super();
		}
		public Integer getIdCentre() {
			return idCentre;
		}
		public void setIdCentre(Integer idCentre) {
			this.idCentre = idCentre;
		}
		public String getNomCentre() {
			return nomCentre;
		}
		public void setNomCentre(String nomCentre) {
			this.nomCentre = nomCentre;
		}
		public String getAdresseCentre() {
			return adresseCentre;
		}
		public void setAdresseCentre(String adresseCentre) {
			this.adresseCentre = adresseCentre;
		}
		public int getNbPersonnel() {
			return nbPersonnel;
		}
		public void setNbPersonnel(int nbPersonnel) {
			this.nbPersonnel = nbPersonnel;
		}
		public int getStockVacc() {
			return stockVacc;
		}
		public void setStockVacc(int stockVacc) {
			this.stockVacc = stockVacc;
		}
		public Administrateur getAdmin() {
			return admin;
		}
		public void setAdmin(Administrateur admin) {
			this.admin = admin;
		}
		@Override
		public String toString() {
			return "Centre_Vaccination [idCentre=" + idCentre + ", nomCentre=" + nomCentre + ", adresseCentre="
					+ adresseCentre + ", nbPersonnel=" + nbPersonnel + ", stockVacc=" + stockVacc + ", admin=" + admin
					+ "]";
		}
	}
