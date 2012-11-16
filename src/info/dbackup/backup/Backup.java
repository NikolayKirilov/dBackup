package info.dbackup.backup;

import java.io.File;
import java.util.List;

public interface Backup {

	List<File> getBackupFolders();

	void addFolderToBackup(File folder);

	void backupFiles();
	
	//TODO add methods (or different class to be used with composition) for 
	//file types ignore lists (like .gitignore)
	
	//Also to add methods for priority of the backup?

}
