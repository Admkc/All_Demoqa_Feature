package com.kraft.step_Def;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AuthorizedstepDef {
    Register register=new Register();


    @Given("User should be authorized with valid credentials")
    public void user_should_be_authorized_with_valid_credentials() {
        register.authorized();

    }


    @Then("verify authorized Status Code")
    public void verify_authorized_Status_Code() {
        register.verifyAuthorizedStatusCode();
    }
}
