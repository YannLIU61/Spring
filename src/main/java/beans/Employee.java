package beans;

public class Employee {
	private String nom;
	private String prenom;
	private int sold;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Employee(String nom, String prenom, int sold) {
		this.nom = nom;
		this.prenom = prenom;
		this.sold = sold;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	@Override
	public String toString() {
		return "Employee [nom=" + nom + ", prenom=" + prenom + ", sold=" + sold + "]";
	}

}
