Feature:
  Demonstrate Rest Assured Ext Use for Get Post

  Scenario: Verify a GET request using RestAssuredExt
    Given I perform GET using Rest Assured Ext GET op for "/posts"
    Then I should RestAssuredExt see the author name as "saransh1337"