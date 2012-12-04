package info.dbackup.backup;

import info.dbackup.user.User;
import info.dbackup.user.UserManager;

import java.io.File;
import java.util.List;

public class BackupImpl implements Backup {

	private final UserManager userManager;
	private User user;

	public BackupImpl(final UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public List<File> getBackupFolders() {
		return null;
	}

	@Override
	public void addFolderToBackup(File folder) {

	}

	@Override
	public void backupFiles() {

	}

	@Override
	public boolean allFilesAreBackuped() {
		return false;
	}

	@Override
	public boolean logIn(String name, String password) {
		this.user = userManager.authenticate(name, password);
		
		return (user != null);
	}

}
