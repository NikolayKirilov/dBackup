package info.dbackup.backup;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class BackupTest {

	private Backup backup;

	@Before
	public void setUp() {
		//this.backup = new BackupImpl();
	}

	@Test
	public void empty() {

		//TODO not to use file - use backupData or something like that instead
		//I think we'll need to extend the standard file with some additional features.
		final List<File> list = this.backup.getBackupFolders();

		Assert.assertEquals(0, list.size());

	}

	@Test
	public void addOneFolder() {
		final File folder = new File("/home/user/folder");
		this.backup.addFolderToBackup(folder);

		Assert.assertEquals(1, backup.getBackupFolders().size());
	}

	@Test
	public void addDuplicatingFolder() {
		final File folder = new File("/home/user/folder");
		this.backup.addFolderToBackup(folder);
		Assert.assertEquals(1, backup.getBackupFolders().size());
		
		this.backup.addFolderToBackup(folder);
		Assert.assertEquals(1, backup.getBackupFolders().size());
	}

	@Test
	public void addSubfolder(){
		final File folder = new File("/home/user/folder");
		this.backup.addFolderToBackup(folder);
		
	    final File subfolder = new File(folder, "subfolder");
	    this.backup.addFolderToBackup(subfolder);
	
	    Assert.assertEquals(1, backup.getBackupFolders().size());
	}
	
	@Test
	public void backupAllFiles()
	{
		//TODO: what expectation???
		backup.backupFiles();
	}
}
