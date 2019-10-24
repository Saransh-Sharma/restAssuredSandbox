package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;



public class GetPost_BDDClashStyle {
    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        given().contentType(ContentType.JSON);
    }

    @And("^I perform GET for the post number \"([^\"]*)\"$")
    public void iPerformGETForThePostNumber(String postNumber) throws Throwable {
        when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().body("author", is("saransh1337"));
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //uh oh ! then(). cant exist on its own
        //this is when cuccumber and Rest Assured BDD styles are reduntant
        //the given, when, then Rest Assured is BDD by itself
        //It doesnt make sense to have 2 styles of similar BDD in the same project
        //So instead split this into
        //Arrange
        //Act
        //Assert
        //BDD Scheme

    }
}
