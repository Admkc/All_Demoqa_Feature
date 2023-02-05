package com.kraft.step_Def;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class DeleteAccount_stepDef {

    Register register=new Register();

    @Given("User should delete account")
    public void user_should_delete_account() {
        register.deleteAccount();

    }

    @Then("User should verify delete account status code")
    public void user_should_verify_delete_account_status_code() {

        register.deleteAccount();
    }
}
