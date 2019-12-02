package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class GetPost2_AAA_BDD {
    @Given("^I AAA_BDD perform GET operation for \"([^\"]*)\"$")
    public void iAAA_BDDPerformGETOperationFor(String url) throws Throwable {

        System.out.println("I AAA_BDD perform GET operation for posts");
        given().contentType(ContentType.JSON);
    }

    @And("^I AAA_BDD perform GET for the post number \"([^\"]*)\"$")
    public void iAAA_BDDPerformGETForThePostNumber(String postNumber) throws Throwable {

        when().get(String.format("http://localhost:3000/posts%s",postNumber));

    }

    @Then("^I AAA_BDD should see the author name as \"([^\"]*)\"$")
    public void iAAA_BDDShouldSeeTheAuthorNameAs(String name) throws Throwable {

    }

    @And("^I AAA_BDD perform GET for the post number \"([^\"]*)\" THEN see author name as \"([^\"]*)\"$")
    public void iAAA_BDDPerformGETForThePostNumberTHENSeeAuthorNameAs(String authorName) throws Throwable {


    }
}
