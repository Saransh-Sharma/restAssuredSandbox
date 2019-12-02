package plainRestAssuredTests;

import io.restassured.builder.RequestSpecBuilder;
import org.junit.Test;

public class RestAssured_AAA_Simple {

    @Test
    public void RestAssuredSimple_AAA() {
        //ARRANGE/ACT/ASSERT pattern

        //ARRANGE
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:300/posts");


    }

}
