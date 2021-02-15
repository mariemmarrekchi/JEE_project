package metier;
import java.util.List;
public interface userMetierInterface {
public void addUser(Malade m);
public List<Malade> listUsers();
public User getUserByLoginAndPassword(String l, String p);
public Malade getUserByNameAndPrenom(String l, String p);

public void updateUser(Malade u);

public void deleteUser(int id);
public Malade getUserById(int id);
public List<Malade> recherche(String l);
public List<Malade> rechercheCin(String l);
}
