package info.dbackup.backup;

import info.dbackup.user.User;
import info.dbackup.user.UserManager;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * We test {@link Backup#logIn(String, String)} method, but will provide mocked
 * {@link UserManager}, because the real one will access the database, which is
 * not recommended.
 * 
 * @author kiril
 * 
 */
public class BackupTestWithMocks {
	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();

	@Mock
	public UserManager userManager;

	private Backup backup;

	@Before
	public void setUp() {
		backup = new BackupImpl(userManager);
	}

	/**
	 * This test will fail, because there is no proper expectation for
	 * {@link UserManager}.
	 */
	@Test
	public void test() {
		backup.logIn("kiril", "qwerty");
	}

	/**
	 * The expectation is the following. When the
	 * {@link UserManager#authenticate(String, String)} is invoked with 'kiril'
	 * and 'querty' arguments, it will return some {@link User} defined by us.
	 */
	@Test
	public void testWithExpectation() {
		final User user = new User();

		context.checking(new Expectations() {
			{
				oneOf(userManager).authenticate("kiril", "qwerty");
				will(returnValue(user));
			}
		});

		Assert.assertTrue(backup.logIn("kiril", "qwerty"));
	}

	/**
	 * The expectation is following:
	 * {@link UserManager#authenticate(String, String)} will be invoked, but
	 * will return null user. And therefore,
	 * {@link Backup#logIn(String, String)} will return false.
	 */
	@Test
	public void testWithExpectation2() {
		final User user = new User();

		context.checking(new Expectations() {
			{
				oneOf(userManager).authenticate("kiril", "qwerty");
				will(returnValue(null));
			}
		});

		Assert.assertFalse(backup.logIn("kiril", "qwerty"));
	}
}
