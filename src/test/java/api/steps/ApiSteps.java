package api.steps;

import api.util.Data;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Serenity steps to log in report
 * @author Aleem
 */
public class ApiSteps extends ScenarioSteps {

    //API call to create user
    @Step
    public Response createUser() {
        return SerenityRest.given().contentType(ContentType.JSON)
                .and().body(Data.USER)
                .when().post(Data.URI);
    }

    //API call to get all users
    @Step
    public Response getUsers() {
        return SerenityRest.given().contentType(ContentType.JSON)
                .when().get(Data.URI);
    }

    //API call to get single user
    @Step
    public Response getUser() {
        return SerenityRest.given().contentType(ContentType.JSON)
                .when().get(Data.URI + "/2");
    }

    //API call to update user
    @Step
    public Response upDateUser() {
        return SerenityRest.given().contentType(ContentType.JSON)
                .and().body(Data.USER_UPDATE)
                .when().put(Data.URI + "/20");
    }

    //API call to delete user
    @Step
    public Response deleteUser() {
        return SerenityRest.given().contentType(ContentType.JSON)
                .when().delete(Data.URI + "/20");
    }

    //API call for user not found
    @Step
    public Response userNotFound() {
        return SerenityRest.given().contentType(ContentType.JSON)
                .when().get(Data.URI + "/23");
    }


}
