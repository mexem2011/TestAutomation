package tests;

import api.steps.ApiSteps;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Serenity Runner class to run the API Tests
 * @author Aleem
 */
@RunWith(SerenityRunner.class)
public class ApiTest {

    //API Steps
    @Steps
    ApiSteps apiSteps;

    /**
     * Test to validate create user call
     */
    @Test
    public void createUserTest() {
        Response response = apiSteps.createUser();
        Assert.assertEquals(201, response.then().extract().statusCode());
        Assert.assertEquals("morpheus", response.then().extract().body().jsonPath().get("name"));
    }

    /**
     * Test to validate get users call
     */
    @Test
    public void getAllUsersTest() {
        Response response = apiSteps.getUsers();
        Assert.assertEquals(200, response.then().extract().statusCode());
        Assert.assertEquals("3", response.then().extract().body().jsonPath().get("per_page").toString());
        Assert.assertEquals("12", response.then().extract().body().jsonPath().get("total").toString());
        Assert.assertEquals("George", response.then().extract().body().jsonPath().get("data[0].first_name"));
    }

    /**
     * Test to validate get user call
     */
    @Test
    public void getSingleUserTest() {
        Response response = apiSteps.getUser();
        Assert.assertEquals(200, response.then().extract().statusCode());
        Assert.assertEquals("Weaver", response.then().extract().body().jsonPath().get("data.last_name"));

    }

    /**
     * Test to validate update user call
     */
    @Test
    public void updateUserTest() {
        Response response = apiSteps.upDateUser();
        Assert.assertEquals(200, response.then().extract().statusCode());
        Assert.assertEquals("manager", response.then().extract().body().jsonPath().get("job"));
    }

    /**
     * Test to validate delete user call
     */
    @Test
    public void deleteUserTest() {
        Response response = apiSteps.deleteUser();
        Assert.assertEquals(204, response.then().extract().statusCode());
    }

    /**
     * Test to validate user not found call
     */
    @Test
    public void userNotFoundTest() {
        Response response = apiSteps.userNotFound();
        Assert.assertEquals(404, response.then().extract().statusCode());
    }

}
