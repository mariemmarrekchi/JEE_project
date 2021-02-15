package metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMetierImpl implements userMetierInterface {
public void addUser(Malade m) {
	Connection conn=DbConnexion.getConnection();
	try {
		// préparer la requête SQL
		PreparedStatement ps = conn.prepareStatement("insert into malade values (0,?,?,?,?,?)");
		// passer les paramètres
		ps.setString(1, m.getCin());
		ps.setString(2, m.getNom());
		ps.setString(3, m.getPrenom());
		
		ps.setString(4, m.getDate_ar());
		ps.setString(5, m.getDate_dep());
		// executer la requête
		ps.executeUpdate();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}	
}

public List <Malade> listUsers() {
	//Définir une liste vide pour stocker les objets "User"
	List<Malade> users= new ArrayList<Malade>();
	//récupérer une connexion à la BD
	Connection conn= DbConnexion.getConnection();
	try {
	// préparer la requête SQL
	PreparedStatement ps = conn.prepareStatement(" select * from Malade");
	// Récupérer le résultat de la requête
	ResultSet rs= ps.executeQuery();
	if (rs!=null)
	{
	//parcourir le résultat
	while(rs.next())
	{
	//Construire un objet "User" puis lui affecter les
	
	// et enfin l'ajouter dans la liste
	Malade m = new Malade();
	m.setId(rs.getInt("id"));
	m.setCin(rs.getString("cin"));
	m.setNom(rs.getString("nom"));
	m.setPrenom(rs.getString("prenom"));
	m.setDate_ar(rs.getString("date_ar"));
	m.setDate_dep(rs.getString("date_dep"));
	// ajouter l'objet "User" dans la liste
	users.add(m);
	}
	}
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	//retoturner la liste
	return users;
	}
public User getUserByLoginAndPassword(String l, String p) {
	//récupérer une connexion à la BD
	Connection conn= DbConnexion.getConnection();
	User u= null;
	try{
		PreparedStatement ps = conn.prepareStatement(" select * from User where login =? and password = ?");
				ps.setString(1, l);
				ps.setString(2, p);
				ResultSet rs= ps.executeQuery();
				if (rs!=null)
				{
				while(rs.next())
				{
				u = new User();
				u.setId(rs.getInt("id"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setLogin(rs.getString("login"));
				u.setPassword(rs.getString("password"));
				}

	}ps.close();
				
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return u;
	}

public Malade getUserByNameAndPrenom(String l, String p) {
	//récupérer une connexion à la BD
	Connection conn= DbConnexion.getConnection();
	Malade m= null;
	try{
		PreparedStatement ps = conn.prepareStatement(" select * from User where login =? and password = ?");
				ps.setString(1, l);
				ps.setString(2, p);
				ResultSet rs= ps.executeQuery();
				if (rs!=null)
				{
				while(rs.next())
				{
				m = new Malade();
				m.setId(rs.getInt("id"));
				m.setCin(rs.getString("cin"));
				m.setNom(rs.getString("nom"));
				m.setPrenom(rs.getString("prenom"));
				m.setDate_ar(rs.getString("date_ar"));
				m.setDate_dep(rs.getString("date_dep"));
				}

	}ps.close();
				
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return m;
	}

public void updateUser(Malade u) {
	//récupérer une connexion à la BD
	Connection conn= DbConnexion.getConnection();
	try {
	// préparer la requête SQL
	PreparedStatement ps = conn.prepareStatement(" update malade set cin=?, nom= ?, prenom=?, date_ar=?, date_dep =? where id=? ");
	ps.setString(2, u.getCin());
	ps.setString(3, u.getNom());
	ps.setString(4, u.getPrenom());
	ps.setString(5, u.getDate_ar());
	ps.setString(6, u.getDate_dep());
	ps.setInt(7, u.getId());
	ps.executeUpdate();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

}
public void deleteUser(int id) {
	//récupérer une connexion à la BD
	Connection conn= DbConnexion.getConnection();
	try {
	// préparer la requête SQL
	PreparedStatement ps = conn.prepareStatement(" delete from malade where id=? ");
	ps.setInt(1, id);
	ps.executeUpdate();
}catch(SQLException e) {
	e.printStackTrace();
}
	
}
public Malade getUserById(int id) {
	Connection conn= DbConnexion.getConnection();
	Malade u= null;
	try {
		PreparedStatement ps = conn.prepareStatement("select * from Malade where id = ?");
				ps.setInt(1,id);
				ResultSet rs= ps.executeQuery();
				if (rs!=null)
				{
				while(rs.next())
				{
				u = new Malade();
				u.setId(rs.getInt("id"));
				u.setCin(rs.getString("cin"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setDate_ar(rs.getString("date_ar"));
				u.setDate_dep(rs.getString("date_dep"));
				}
				}
				ps.close();

	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return u;
	
}

public 	List <Malade> recherche(String l) {
	List <Malade> li =new ArrayList<Malade>();
	//récupérer une connexion à la BD
	Connection conn= DbConnexion.getConnection();
	Malade u= null;
	try{
		PreparedStatement ps = conn.prepareStatement(" select * from Malade where nom=?  ");
				ps.setString(1, l);
				
				ResultSet rs= ps.executeQuery();
				if (rs!=null)
				{
				while(rs.next())
				{
				u = new Malade();
				u.setId(rs.getInt("id"));
				u.setCin(rs.getString("cin"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setDate_ar(rs.getString("date_ar"));
				u.setDate_dep(rs.getString("date_dep"));
				li.add(u);
				}

	}ps.close();
				
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return li;
	}
public 	List <Malade> rechercheCin(String l) {
	List <Malade> li =new ArrayList<Malade>();
	//récupérer une connexion à la BD
	Connection conn= DbConnexion.getConnection();
	Malade u= null;
	try{
		PreparedStatement ps = conn.prepareStatement(" select * from Malade where cin=?  ");
				ps.setString(1, l);
				
				ResultSet rs= ps.executeQuery();
				if (rs!=null)
				{
				while(rs.next())
				{
				u = new Malade();
				u.setId(rs.getInt("id"));
				u.setCin(rs.getString("cin"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setDate_ar(rs.getString("date_ar"));
				u.setDate_dep(rs.getString("date_dep"));
				li.add(u);
				}

	}ps.close();
				
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return li;
	}
}


