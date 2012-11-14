package info.dbackup.user;


import org.junit.Test;

import junit.framework.Assert;

public class UserManagerTest {

	private UserManager userManager;

	@Test
	public void registerUser() {

		final String name = "muncho";
		final String password = "123456";

		Assert.assertTrue(userManager.registerUser(name, password));
	}

	@Test
	public void registerDuplicatingUser() {

		final String name = "muncho";
		final String password = "123456";

		Assert.assertTrue(userManager.registerUser(name, password));

		//TODO: return false, or throw exception???
		Assert.assertFalse(userManager.registerUser(name, password));
	}

	@Test
	public void registerUserWithTooShortPassword() {

		final String name = "muncho";
		final String password = "123";

		//TODO: return false, or throw exception???
		Assert.assertFalse(userManager.registerUser(name, password));
	}

	@Test
	public void authenticate() {
		final String name = "asdfghj";
		final String password = "123456";

		Assert.assertTrue(userManager.registerUser(name, password));

		final User user = userManager.authenticate(name, password);

		Assert.assertEquals(name, user.name);
	}
}
