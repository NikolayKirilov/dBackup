Feature: Backup some files
  As a user
  I want to backup a file
  So that my files are secure

  Scenario: backup 2 files
    Given a backup scheduler with user with name Kiril
    When I add file /home/user/folder/backupfile for scheduled backup
    And I add file /home/user/folder/backupfile2 for scheduled backup
    And user will backup
    Then all files will be backuped

