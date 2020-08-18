package stepsDefinition;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.BaseUtil;
import util.Constants;

public class SearchAndAddProduct extends BaseUtil {
	
	public BaseUtil base;
	
	public SearchAndAddProduct(BaseUtil base) {
		this.base = base;
	}
	
	@Given("^that user is on the search page$")
	public void that_user_is_on_the_search_page() {
		 try {
		    	base.log.info("Get to Search Page");
		    	
		    	// Get to Search page
		    	base.keyword.getToSearchPage();
		    	
		    	// check element exists
		    	boolean result = base.keyword.checkElementExists("searchpageLabel");
				base.keyword.waitUntilPageLoadsComplelety();
				Assert.assertTrue(result);
				base.log.info("User is on the Search page");
			}  catch (Exception e) {
				base.log.fatal("Exception - User is NOT on the Search page");
				Assert.fail(e.getMessage());
			} catch (AssertionError e) {
				base.log.error("AssertionError - User is NOT on the Search page");
				Assert.fail(e.getMessage());
			}
	}

	@When("^the user enters \"([^\"]*)\" into \"([^\"]*)\"$")
	public void user_enters_into(String data, String object) {
		try {
			base.log.info("* When the user enters " + data + " into " + object);
			base.keyword.waitUntilElementIsVisible(object);
			base.keyword.type(object, data);
			base.keyword.sleep(Constants.sleepTimeOneSecond);

			// Click option from the auto complete suggested locations
			base.keyword.waitUntilElementIsVisible("autoCompleteSearchLocationLink");
			base.keyword.click("autoCompleteSearchLocationLink");
			
			base.keyword.sleep(Constants.sleepTimeThreeSeconds);
		} catch (Exception e) {
			base.log.fatal("Exception - User enters location");
			Assert.fail(e.getMessage());
		} 
	}
	
	@And("^checks \"([^\"]*)\"$")
	public void checks(String object) {
				 try {
				    	
				    	// check element exists
					    base.keyword.waitUntilPageLoadsComplelety();
				    	boolean result = base.keyword.checkElementExists("headerTitleLabel");
				    	Assert.assertTrue(result);
						base.log.info("User is on the searched product page");
					}  catch (Exception e) {
						base.log.fatal("Exception - User is not on the searched product page");
						Assert.fail(e.getMessage());
					} catch (AssertionError e) {
						base.log.error("AssertionError - User is not on the searched product page");
						Assert.fail(e.getMessage());
					}
		   
		}

	
	@And("^checks product \"([^\"]*)\"$")
	public void checks_product(String object) {
		 try {
			
			    // check element exists
			 base.keyword.waitUntilPageLoadsComplelety();
		     boolean result = base.keyword.checkElementExists("logo1");	
				Assert.assertTrue(result);
				base.log.info("User is on the selected product page");
			}  catch (Exception e) {
				base.log.fatal("Exception - User is not on the selected product page");
				Assert.fail(e.getMessage());
			} catch (AssertionError e) {
				base.log.error("AssertionError - User is not on the selected product page");
				Assert.fail(e.getMessage());
			}
}
	

	@And("^checks basket \"([^\"]*)\"$")
	public void checks_basket(String string) {
		try {
			
			// check element exists
	 		 base.keyword.waitUntilPageLoadsComplelety();
			 boolean result = base.keyword.checkElementExists("icon");
			 Assert.assertTrue(result);
			base.log.info("User is on the basket page");
		}  catch (Exception e) {
			base.log.fatal("Exception - User is not on the basket page");
			Assert.fail(e.getMessage());
		} catch (AssertionError e) {
			base.log.error("AssertionError - User is not on the basket page");
			Assert.fail(e.getMessage());
		}
	}


	@Then("^the added product for result page \"([^\"]*)\" should show \"([^\"]*)\"$")
	public void the_added_product_for_result_page_should_show(String object, String expected) {
		try {
			base.keyword.waitUntilPageLoadsComplelety();
			base.log.info("* the added product for result page " + expected);
			// Capture the header text
			String actual = base.keyword.readLabel(object);

			// Compare
			Assert.assertTrue(actual.contains(expected));
			base.log.info("Header title location Assertion Passed ");

			// For next data iteration
			
		} catch (Exception e) {
			base.log.fatal("Exception - product results page");
			Assert.fail(e.getMessage());
		} catch (AssertionError e) {
			base.log.error("AssertionError - product results page");
			Assert.fail(e.getMessage());
		}
	}
}


