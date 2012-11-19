dBackup is simple utility program for backing up a local files on remote servers.


Some draft design notes below (mostly memos from skype)

Here are some design notes 

encrypt class
defined separately (so we can test it)
Backup depends on Encrypt (two types of backup - friend and global?)

a field (in backup/device)  encryptor depending on friendly device we'll encrypt

Behaviour Driven Development
for example see /test/resource/info/dbackup/backup/simple_backup.feature
This file is paresed to a BackupStory.java test