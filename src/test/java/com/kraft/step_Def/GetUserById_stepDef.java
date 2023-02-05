package com.kraft.step_Def;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GetUserById_stepDef {

    Register register=new Register();


    @Given("User should see the book list")
    public void user_should_see_the_book_list() {
        register.getUserById();

    }

    @Then("User should verify the book status code")
    public void user_should_verify_the_book_status_code() {

        register.verifyUser();

    }
}
