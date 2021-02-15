package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.User;
import metier.Malade;
import metier.UserMetierImpl;
import metier.userMetierInterface;

@WebServlet("/UserEditionController")
public class UserEditionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Déclarer un objet "métier"
	userMetierInterface metier = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// instancier le métier
		metier = new UserMetierImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// tableau pour stocker les erreurs éventuelles
		ArrayList erreurs = new ArrayList();

		// Récupérer les paramètres du formulaire
	String login = request.getParameter("login");
	String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String id = request.getParameter("id");
		String cin=request.getParameter("cin");
		String date_ar=request.getParameter("date_ar");
		String date_dep=request.getParameter("date_dep");
		
List <Malade>li=metier.rechercheCin(cin);
		// Contrôler les valeurs saisies
//		if (login == null || login.equals(""))
//			erreurs.add("Veuillez remplir le champ login");
//
//		if (password == null || password.equals(""))
//			erreurs.add("Veuillez remplir le champ password");

		if (nom == null || nom.equals(""))
			erreurs.add("Veuillez remplir le champ nom");

		if (prenom == null || prenom.equals(""))
			erreurs.add("Veuillez remplir le champ prenom");
		if (date_ar == null || date_ar.equals(""))
			erreurs.add("Veuillez remplir le champdate arrivé");
		if (date_dep == null || date_dep.equals(""))
			erreurs.add("Veuillez remplir le champ date depart");
		if(li.size()>0)
			erreurs.add("ce malade est encore exsite trouvable");
		

		if (erreurs.size() != 0) {
			// en cas d'existence de champs nulls
			request.setAttribute("err", erreurs);
			// reenvoyer les paramètres du formulaire s'ils existent sous forme
			// d'un objet 'User' passé comme attribut nommé "user"
			User uf = new User(0, nom, prenom, login, password);
			request.setAttribute("user", uf);

			// retourner au formulaire
			request.getRequestDispatcher("UserForm.jsp").forward(request, response);
		} else // La saisie est correcte
		{

			// lire à partir de la session ( portée session)
			HttpSession session = request.getSession(true);
			// Récupérer le tableau des users de la session
			List<Malade> usersStore = (ArrayList<Malade>) session.getAttribute("listOfUsers");

			// Mode Ajout
			if (id != null && id.equals("0")) {

				
				// Créer une instance "User" en lui passant une valeur pour l'id et les champs
				// récupérés
				Malade u = new Malade(0,cin, nom, prenom, date_ar, date_dep);
                //methode recherche 
				
				// Ajouter le nouvel objet dans la base de données
				metier.addUser(u);
			}
			
			// Mode Edition
			else {
				// Modifier l'objet en question
				Malade u = new Malade(Integer.parseInt(id),cin, nom, prenom, date_ar, date_dep);
				metier.updateUser(u);

			}

			// Charger la liste des utilisateurs;
			usersStore = metier.listUsers();

			// passer le tableau dans le session
			session.setAttribute("listOfUsers", usersStore);
			// passer à la vue de liste des utilisateurs
			request.getRequestDispatcher("UserList.jsp").forward(request, response);

		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Récupérer les paramètres
		String id = request.getParameter("id");
		String mode = request.getParameter("mode");

		// lire le tableau des utilisateurs stocké dans la session
		HttpSession session = request.getSession(true);
		// Récupérer le tableau des users de la session
		List<Malade> usersStore = (ArrayList<Malade>) session.getAttribute("listOfUsers");

		// gérer le mode "Edition"
		if (mode != null && mode.equals("Edition")) {
			
			Malade u = metier.getUserById(Integer.parseInt(id));
			// passer l'objet trouvé comme attribut dans la requête
			request.setAttribute("user", u);
			// passer au formulaire
			request.getRequestDispatcher("UserForm.jsp").forward(request, response);
		}
		// gérer le mode "Suppression"
		if (mode != null && mode.equals("Suppression")) {

			int index = Integer.parseInt(id);
			
			// Supprimer dans la base de données
			metier.deleteUser(index);

			// Charger la liste des utilisateurs;
			usersStore = metier.listUsers();
			// Mettre à jour dans le session
			session.setAttribute("listOfUsers", usersStore);
			// passer à la liste
			request.getRequestDispatcher("UserList.jsp").forward(request, response);
		}

	}

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if (u == null) {
			request.getRequestDispatcher("UserConnexion.jsp").forward(request, response);
		} 
		else {
			super.service(request, response);
		}
	}
}