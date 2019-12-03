package steps;

import cucumber.api.DataTable;
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
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
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

    @Given("^I perform POST operation for \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationForWithBody(String url, DataTable table) throws Throwable { //this is cucumber DataTable that's being  used

        var data = table.raw(); //Turn table to raw data

        System.out.println("*********************");
        System.out.println("Printing data table values");
        System.out.println("get(0) - " + data.get(0));
        System.out.println("get(1) - " + data.get(1));
        System.out.println("name get(1).get(0)) - " + data.get(1).get(0));
        System.out.println("profileNo get(1).get(1))- " + data.get(1).get(1));
        System.out.println("*********************");

        //Set body
        HashMap<String, String> body = new HashMap<>();
        body.put("name", data.get(1).get(0));

        //Set path params
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("profileNo", data.get(1).get(1));

        response = RestAssuredExtension.PostOpsWithPathAndBodyParams(url, pathParams, body);

    }

    @Then("^I should see the body has name as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyHasNameAs(String name)  {
        System.out.println("###############################");
        System.out.println("#######  Print Response  #######");
        System.out.println(response.getBody().prettyPrint());
        System.out.println("###############################");
        System.out.println("name is: "+response.getBody().jsonPath().get("name"));
        //assertThat(response.getBody().jsonPath().get("name"), hasItem(name));
        assertThat(response.getBody().jsonPath().get("name"), is("Sams"));
    }
}
