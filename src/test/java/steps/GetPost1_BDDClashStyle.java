package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


public class GetPost1_BDDClashStyle {
    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        System.out.println("I perform GEToperation for posts");
        given().contentType(ContentType.JSON);
    }



    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //uh oh ! then(). cant exist on its own
        //this is when cuccumber and Rest Assured BDD styles are reduntant
        //the given, when, then Rest Assured is BDD by itself
        //It doesn't make sense to have 2 styles of similar BDD in the same project
        //So instead split this into
        //Arrange
        //Act
        //Assert
        //BDD Scheme

    }

    @And("^I perform GET for the post number \"([^\"]*)\"$")
    public void iPerformGETForThePostNumber(String postNumber) throws Throwable {
        System.out.println("I perform GET fir the post number "+postNumber);
        when().get(String.format("http://localhost:3000/posts/%s", postNumber)). //then().body("author", containsInAnyOrder("saransh1337", "saransh1337", null)).
                then().body("author", is("saransh1337")).
                statusCode(200); // <<--------------------- This seems wrong !
        //I am forced to write rest assured 'then' here as it cant exist  as an orphan in the next step !
    }

    @And("^I perform GET for the post number \"([^\"]*)\" THEN see author name as \"([^\"]*)\"$")
    public void iPerformGETForThePostNumberTHENSeeAuthorNameAs(String postNumber, String authorName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        when().get(String.format("http://localhost:3000/posts/%s", postNumber)).     // <<<-------------- BIG PROBLEM ! BDD Rest Assured - Cuccumber clash !
                then().body("author", is("saransh1337"));
    }
}
