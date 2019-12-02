package steps;

import cucumber.api.java.Before;
import utilities.RestAssuredExtension;

public class TestInit {

    @Before
    public void TestSetup() {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }

}
