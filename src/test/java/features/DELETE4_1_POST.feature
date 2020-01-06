Feature:
  Verify different Post & Delete operations using cucumber BDD

  Scenario: Verify DELETE operation after POST
    Given I ensure to perform get operation for "/posts" with body as
      | id | title                  | author           |
      | 9  | Death of the Wehrmacht | Robert M. Citino |
    And I perform DELETE operation for "/posts/{postid}/"
      | postid |
      | 9      |
    Then I should not see the body with title as "API Testing course"


  Scenario: Verify DELETE operation after POST
    Given I ensure to perform get operation for "/posts" with body as
      | id | title                 | author           |
      | 9  | Death of the Wehrmacht | Robert M. Citino |
    And I perform DELETE operation for "/posts/{postid}/"
      | postid |
      | 9      |
   # And I perform GET operation with path parameter for "/posts/{postid}"
    #  | postid |
     # | 9      |
    And I perform GET operation with path parameter for "/posts/{postid}/"
      | postid |
      | 9      |
    Then I should not see the body with title as "API Testing course"
