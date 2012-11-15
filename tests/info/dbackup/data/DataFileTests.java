package info.dbackup.data;

import junit.framework.Assert;

import org.junit.Test;

public class DataFileTests {
	DataFile fileToTest; // TODO this to be instantiated and set proper name.

	@Test
	public void renameFile() {

		final String name = "file1";
		final String newName = "file2";
		fileToTest.rename(newName);

		Assert.assertEquals(newName, fileToTest.getName());
	}
}
