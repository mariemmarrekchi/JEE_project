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
 * Servlet implementation class UserListController
 */
@WebServlet("/UserListController")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Déclarer un objet "métier"
		userMetierInterface metier =null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListController() {
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
		//doGet(request, response);

		
		String mc=request.getParameter("nom");
		Malade mod=new Malade();
		
		mod.setNom(mc);
		List  <Malade>lis=metier.recherche(mc);
		
		if (lis.size()>0) {
		mod.setLi(lis);
		
		HttpSession s=request.getSession();
		s.setAttribute("listOfUsers", lis);
		request.getRequestDispatcher("UserList.jsp").forward(request,response);
		
		
	}
		else
		 {
			request.getRequestDispatcher("UserForm.jsp").forward(request,response);
			
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
