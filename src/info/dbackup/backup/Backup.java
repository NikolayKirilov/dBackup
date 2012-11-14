package info.dbackup.backup;

import java.io.File;
import java.util.List;

public interface Backup {

	List<File> getBackupFolders();

	void addFolderToBackup(File folder);

	void backupFiles();

}
