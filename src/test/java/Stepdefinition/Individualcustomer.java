package Stepdefinition;

import java.io.IOException;

import Pageobject.IndividualCIF;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Individualcustomer {
	
	IndividualCIF ic=new IndividualCIF();
	@When("homepage is opened navigate to usermenu")
	public void navigate() {
		ic.navigatetocustomescreen();
	    
	    
	}

	@When("click on individual customer")
	public void individual_customer() {
	    ic.individualcust();
	}

	@Then("input cust details.")
	public void input_cust_details() throws IOException {
	   ic.cifcreation();
	}

	@Then("verify whether refernce number is generated.")
	public void verify_whether_refernce_number_is_generated() {
	   ic.CIFIDverification();
	}

}
