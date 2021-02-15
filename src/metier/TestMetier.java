package metier;
import java.util.List;
public class TestMetier {
public static void main(String [] args) {
	userMetierInterface metier= new UserMetierImpl();
	List <Malade> li =metier.recherche("mim");
	for (Malade u : li) {
		System.out.println(u.getNom() + u.getPrenom());
	}
	
	System.out.println("------------------------------\n");

	metier.addUser(new Malade ("11111111","Ben Saleh", "Mohamed","11","22"));
	System.out.println("------------------------------\n");

	//Test d'affichage de la liste totale des objets "User"
	List<Malade> users = metier.listUsers();
	for (Malade u: users)
	{
	System.out.println(u);
	}
	System.out.println("------------------------------\n");
	//Test d'affichage d'un objet "User" en donnant le login et le password
	User u = metier.getUserByLoginAndPassword("11", "22");
	System.out.println(u);
	System.out.println("------------------------------\n");
	//Tester la mise à jour
	//u.setNom("Sallemi");
	
	Malade m=metier.getUserByNameAndPrenom("ali", "ali ben ali");
	metier.updateUser(m);
	List<Malade> users2 = metier.listUsers();
	for (Malade u2: users2)
	{
	System.out.println(u2);
	}

}
}
