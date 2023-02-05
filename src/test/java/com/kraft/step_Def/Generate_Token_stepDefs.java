package com.kraft.step_Def;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Generate_Token_stepDefs {
    Register register=new Register();

    @Given("Input valid credentials")
    public void ınputValidCredentials() {
        register.generateToken();

    }

    @Then("verify token Status Code")
    public void verifyTokenStatusCode() {
        register.verifyToken();

    }
}
