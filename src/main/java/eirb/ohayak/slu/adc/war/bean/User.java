package eirb.ohayak.slu.adc.war.bean;

public class User implements Comparable<User> {

	private String login;
	private String nom;
	private String prenom;
	private String password;
	
	public User(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public User(String nom, String prenom, String login, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() { return login;}
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + "]";
	}

	@Override
	public int compareTo(User o) {
		if (o.getLogin().equals(login)
				&& o.getNom().equals(nom)
				&& o.getPrenom().equals(prenom)) {
			return 1;
		} else {
			return 0;
		}
	}
}
