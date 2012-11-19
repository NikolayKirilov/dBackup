package info.dbackup.user;

public interface UserManager {

	boolean registerUser(String name, String password);

	User authenticate(String name, String password);

}
