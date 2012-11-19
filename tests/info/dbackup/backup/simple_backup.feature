Feature: Mow a golf course
  As a user
  I want to backup a file
  So that my files are secure

  Scenario: go all east
    Given a backup scheduler with user with name Kiril
    When I pivot the mower to the right
    And I move the mower
    And I move the mower
    And I move the mower
    And I move the mower
    And I move the mower
    Then the mower should be in 5,0 facing east

