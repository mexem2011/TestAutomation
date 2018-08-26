package api.steps;

import api.util.Data;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class ApiSteps extends ScenarioSteps{

    @Step
    public void createUser(){
        Response response = SerenityRest.given().contentType(ContentType.JSON)
                .and().body(Data.USER)
                .when().post(Data.URI);
        Assert.assertEquals(201, response.then().extract().statusCode());
        Assert.assertEquals("morpheus",response.then().extract().body().jsonPath().get("name"));
    }


}
