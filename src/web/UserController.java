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

import metier.Malade;
import metier.User;
import metier.UserMetierImpl;
import metier.userMetierInterface;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Déclarer un objet "métier"
	userMetierInterface metier =null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// instancier le métier
		metier =new UserMetierImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Malade> users = metier.listUsers();
		//Récupérer une session			
		HttpSession session =request.getSession(true);
		session.setAttribute("listOfUsers", users);
		request.getRequestDispatcher("UserList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//Récupérer la valeur du paramètre login"
		String l = request.getParameter("login");
		//Afficher la valeur du paramètre
		out.println("La valeur du nom est:"+l);
		//Récupérer la valeur du paramètre password"
		String pwd = request.getParameter("password");
		//Afficher la valeur du paramètre
		out.println("La valeur du mot de passe est:"+pwd);
		// Création d'un tableau vide d"erreurs
		ArrayList<String> erreurs =new ArrayList<String>();
		// validation
		if (l!=null && l.equals(""))
		{
			erreurs.add("Champs login vide. Merci de spécifier une valeur..");
		}
		if (pwd!=null && pwd.equals(""))
		{
			erreurs.add("Champs password vide. Merci de spécifier une valeur..");
		}
		if (erreurs.isEmpty())
		{
			// En cas d'absence d'erreurs de saisie
			// Appeler l'objet métier pour vérifier les paramètres de connexion
			User u = metier.getUserByLoginAndPassword(l, pwd);
			if( u!=null)
			{	
			// utilisateur reconnu
			//Récupérer une session			
			HttpSession session =request.getSession(true);
			//Placer l'objet "User" comma attribut dans la session
			session.setAttribute("user", u);
			// Aller à la page d'accueil
			request.getRequestDispatcher("accueil.jsp").forward(request, response);
			}
			else
			{
				// utilisateur non reconnu
				// Editer un message d'erreur et revenir à la page de connexion
				erreurs.add("Utilisateur non reconnu..");
				//Placer le login comme un attribut nommé "login" dans l'objet "request"
				request.setAttribute("login", l);
				//Placer le password comme un attribut nommé "password" dans l'objet "request"
				request.setAttribute("password", pwd);
				request.setAttribute("tab_err", erreurs);
				request.getRequestDispatcher("UserConnexion.jsp").forward(request, response);
			}
		}
		else
		{
		//Placer le login comme un attribut nommé "login" dans l'objet "request"
		request.setAttribute("login", l);
		//Placer le password comme un attribut nommé "password" dans l'objet "request"
		request.setAttribute("password", pwd);
		//Placer le tableau des erreurs comme attribut nommé "tab_err" dans l'objet "request"
		request.setAttribute("tab_err", erreurs);
		//Se rediriger vers la page "connexion.jsp"
		request.getRequestDispatcher("UserConnexion.jsp").forward(request, response);
		}

	}
	

}
