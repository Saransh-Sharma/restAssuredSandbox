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
import org.hamcrest.core.IsNot;
import org.junit.runner.Request;
import utilities.RestAssuredExtension;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
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
        assertThat(response.getBody().jsonPath().get("name"), is(name));
    }

    @Given("^I ensure to perform get operation for \"([^\"]*)\" with body as$")
    public void iEnsureToPerformGetOperationForWithBodyAs(String url, DataTable table) throws Throwable {

        var data = table.raw();

        Map<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));

        //perform post
        response = RestAssuredExtension.PostOpsWithBodyParams(url, body);
    }

    @And("^I perform DELETE operation for \"([^\"]*)\"$")
    public void iPerformDELETEOperationFor(String url, DataTable table) throws Throwable {

        var data = table.raw();

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));


        //Perform Delete operation
        response = RestAssuredExtension.DeleteOpsWithParams(url, pathParams);
    }

    @And("^I perform GET operation with path parameter for \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterFor(String url, DataTable table) throws Throwable {

        var data = table.raw();

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));

        response = RestAssuredExtension.GetOpsWithPathParameter(url, pathParams);
    }

//    @Then("^I should not see the body with title as \"([^\"]*)\"$")
    @Then("^I \"([^\"]*)\" see the body with title as \"([^\"]*)\"$")
    public void iShouldNotSeeTheBodyWithTitleAs(String condition, String title) throws Throwable {

        if(condition.equalsIgnoreCase("should not")) {
            assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
        }
        else {
            assertThat(response.getBody().jsonPath().get("title"), is(title));
        }
    }

    @Given("^I ensure to perform POST operation for \"([^\"]*)\" with body as$")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url, DataTable table) {
        var data = table.raw();

        Map<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));

        //perform post
        response = RestAssuredExtension.PostOpsWithBodyParams(url, body);
    }


    @And("^I perform PUT operation for \"([^\"]*)\"$")
    public void iPerformPUTOperationFor(String url, DataTable table) throws Throwable {

        var data = table.raw();
        Map<String, String> body = new HashMap<>();
        Map<String, String> pathParams = new HashMap<>();

        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));
        pathParams.put("postid", data.get(1).get(0));

        response = RestAssuredExtension.PUTOpsWithBodyAndPathParams(url, body, pathParams);

    }

    @And("^I perform Get operation with path parameters for \"([^\"]*)\"$")
    public void iPerformGetOperationWithPathParametersFor(String url, DataTable table) {

        var data = table.raw();

        Map<String, String>pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));

        response = RestAssuredExtension.GetOpsWithPathParameter(url, pathParams);

    }
}
