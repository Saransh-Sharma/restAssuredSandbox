package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;
import utilities.RestAssuredExtension;

import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;


public class GetPost4_RAExt {

    private static ResponseOptions<Response> response;

    @Given("^I perform GET using Rest Assured Ext GET op for \"([^\"]*)\"$")
    public void iPerformGetUsingRAExt(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
    }

    @Then("^I should RestAssuredExt see the author name as \"([^\"]*)\"$")
    public void iShouldRestAssuredExtSeeTheAuthorNameAs(String authorName) throws Throwable {
        //assertThat(response.getBody().jsonPath().get("author"), hasItem("saransh1337"));

        System.out.println("******** PRINT RESPONSE ********");
        response.getBody().prettyPrint();
        System.out.println("******** DONE PRINTING ********");

        // ----

        assertThat(response.getBody().jsonPath().get("author"), hasItem("saransh1337"));




    }
}
