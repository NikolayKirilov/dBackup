package info.dbackup.user;

import java.util.HashMap;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;

/**
 * This class is created for sole purpose of using mocks. The Interface
 * {@link UserManager} will be mocked, because this class uses a database
 * reference, which is hard to test. Also if we use the real database, we will
 * need a to use some test database.
 * 
 * @author kiril
 * 
 */
public class UserManagerImpl implements UserManager {

	private DB database;

	@Override
	public boolean registerUser(final String name, final String password) {

		final DBObject user = new BasicDBObject(new HashMap<String, Object>() {
			{
				put("name", name);
				put("password", password);
			}
		});

		try {
			database.getCollection(User.class.getName()).insert(user);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public User authenticate(final String name, final String password) {
		final DBObject query = new BasicDBObject(new HashMap<String, Object>() {
			{
				put("name", name);
				put("password", password);
			}
		});
		
		final DBObject found = database.getCollection(User.class.getName()).findOne(query);
		
		User user = new User();
		user.name = (String) found.get("name");
		user.password = (String) found.get("password");
		
		return user;
	}

}
