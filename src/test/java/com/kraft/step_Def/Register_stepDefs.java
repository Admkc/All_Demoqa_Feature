package com.kraft.step_Def;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Register_stepDefs {

    Register register=new Register();

    @Given("User should register with valid credentials")
    public void user_should_register_with_valid_credentials() {

        register.registerNewUser();

    }
    @Then("User should verify status code")
    public void user_should_verify_status_code() {
        register.verifyRegister();

    }


}
