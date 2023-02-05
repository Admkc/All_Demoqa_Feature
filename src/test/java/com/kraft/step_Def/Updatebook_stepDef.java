package com.kraft.step_Def;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Updatebook_stepDef {
    Register register=new Register();



    @Given("User should update the collection")
    public void user_should_update_the_collection() {
        register.updateBook();
    }

    @Then("User should verify the update status code")
    public void user_should_verify_the_update_status_code() {
       register.verifyUpdate();
    }

}
