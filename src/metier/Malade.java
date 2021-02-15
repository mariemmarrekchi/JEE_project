package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Malade implements Serializable {
	private int id;
private String cin;
	private String nom;
	private String prenom;
	private String date_ar;
	private String date_dep;
	
	private List <Malade> li=new ArrayList<>();

	
	public Malade() {
		super();
		// TODO Auto-generated constructor stub
		}
		public Malade(int id,String cin, String nom, String prenom, String date_ar, String
		date_dep) {
		super();
		this.id = id;
		this.cin=cin;
		this.nom = nom;
		this.prenom = prenom;
		this.date_ar = date_ar;
		this.date_dep= date_dep;
		}
		 public Malade(String cin,String nom, String prenom, String date_ar, String date_dep) {
		super();
	this.cin=cin;
		this.nom = nom;
		this.prenom = prenom;
		this.date_ar = date_ar;
		this.date_dep = date_dep;
		}
		
		public String getCin() {
			return cin;
		}
		public void setCin(String cin) {
			this.cin = cin;
		}
		@Override
		public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom +
		", date arr=" + date_ar + ", date depart=" + date_dep + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public String getDate_ar() {
			return date_ar;
		}
		public void setDate_ar(String date_ar) {
			this.date_ar = date_ar;
		}
		public String getDate_dep() {
			return date_dep;
		}
		public void setDate_dep(String date_dep) {
			this.date_dep = date_dep;
		}
		public List<Malade> getLi() {
			return li;
		}
		public void setLi(List<Malade> li) {
			this.li = li;
		}
}
