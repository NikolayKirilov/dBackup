package info.dbackup.backup;

import info.dbackup.user.UserManager;
import info.dbackup.user.UserManagerImpl;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is test without mocks. It means that when we try to test
 * {@link Backup#logIn(String, String)} method, we will need to access a real
 * database, which is not recommended.
 * 
 * @author kiril
 * 
 */
public class BackupTest {

	private Backup backup;

	@Before
	public void setUp() {
		UserManager userManager = new UserManagerImpl();
		backup = new BackupImpl(userManager);
	}

	@Test
	public void test() {
		backup.logIn("kiril", "qwerty");
	}

}
