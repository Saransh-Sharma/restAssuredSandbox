package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetPost3_BDDClashSolution {

    String  post = "0";

    @Given("^I perform BDD style GET operation for \"([^\"]*)\"$")
    public void iPerformBDDStyleGETOperationFor(String url) throws Throwable {
    }

    @And("^I perform BDD style GET for post number \"([^\"]*)\"$")
    public void iPerformBDDStyleGETForPostNumber(String postNumber) throws Throwable {

        BDDStyleMethod.SimpleGETPost(postNumber);
//        setPostNumber(postNumber);
    }

    @Then("^I BDD style should see the author name as \"([^\"]*)\"$")
    public void iBDDStyleShouldSeeTheAuthorNameAs(String name) throws Throwable {
        //BDDStyleMethod.SimpleGETPost(postNumber);
    }

    @Then("^I BDD style should see all the author names$")
    public void iBDDStyleShouldSeeAllTheAuthorNames() {
        BDDStyleMethod.PerformContainsCollection();
    }
}
