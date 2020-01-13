Feature:
  Verify PUT and POST

  Scenario: Verify PUT operation after POST
    Given I ensure to perform POST operation for "/posts" with body as
      | id | title                  | author           |
      | 10  | The Red Book | Carl Marx |
    And I perform PUT operation for "/posts/{postid}/"
      | id | title                  | author           |
      | 10  | The Red Book mod | Carl Marx |
    And I perform Get operation with path parameters for "/posts/{postid}"
      | postid |
      | 10  |
    Then I "should not" see the body with title as "This is not a GreenBook"
