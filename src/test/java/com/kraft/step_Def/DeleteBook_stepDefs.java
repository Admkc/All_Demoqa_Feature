package com.kraft.step_Def;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteBook_stepDefs {

    Register register=new Register();



    @Given("User should delete a book")
    public void user_should_delete_a_book() {
        register.deletebook();

    }

    @Then("User should verify delete status code")
    public void user_should_verify_delete_status_code() {
       register.verifyDelete();
    }
}
