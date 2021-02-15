package metier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class User implements Serializable
{
private int id;
private String nom;
private String prenom;
private String login;
private String password;
private List <User> li=new ArrayList<>();
public List<User> getLi() {
	return li;
}
public void setLi(List<User> li) {
	this.li = li;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public User() {
super();
// TODO Auto-generated constructor stub
}
public User(int id, String nom, String prenom, String login, String
password) {
super();
this.id = id;
this.nom = nom;
this.prenom = prenom;
this.login = login;
this.password = password;
}
 public User(String nom, String prenom, String login, String password) {
super();
this.nom = nom;
this.prenom = prenom;
this.login = login;
this.password = password;
}
@Override
public String toString() {
return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom +
", login=" + login + ", password=" + password + "]";
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
public String getLogin() {
return login;
}
public void setLogin(String login) {
this.login = login;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
}
