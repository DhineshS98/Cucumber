Feature: To create individual cutomer

  Scenario: To create individual cutomer
    When homepage is opened navigate to usermenu
    And click on individual customer
    Then input cust details.
    And verify whether refernce number is generated.
