package stepDefinitions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;

import config.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Locator;
import util.UtilConstants;

public class Placeorder_Steps implements BaseTest {

	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		navigateMethods.navigateTo(UtilConstants.DEFAULT_URL);
	}

	@When("^user navigate to category as \"([^\"]*)\",sub category as \"([^\"]*)\"$")
	public void user_navigate_to_category_as_sub_category_as(String category, String subcategory) throws Throwable {
		// waitMethods.wait(UtilConstants.MIN_WAITTIME);
		navigateMethods.hoverOverElement(By.linkText(category));
		clickElementsMethods.click(By.linkText(subcategory));

	}

	@Then("^user is on \"([^\"]*)\" results page$")
	public void user_is_on_results_page(String subcategory) throws Throwable {
		Assert.assertTrue(subcategory + " not loaded",
				assertionMethods.getElementText("xpath", Locator.breadcrump).contains(subcategory));

	}

	@When("^user click the product as \"([^\"]*)\"$")
	public void user_click_the_product_as(String product) throws Throwable {
		clickElementsMethods.click(By.xpath(String.format(Locator.productLoc, product)));
	}

	@When("^user select the size as \"([^\"]*)\" and qty as \"([^\"]*)\"$")
	public void user_select_the_size_as_and_qty_as(String size, String qty) throws Throwable {
		waitMethods.wait(UtilConstants.MIN_WAITTIME);
		navigateMethods.scrollToElement(Locator.sizeDropDownLoc);
		clickElementsMethods.click(Locator.sizeDropDownLoc);
		clickElementsMethods.click(By.linkText(size));

	}

	@When("^user click the Add To Bag$")
	public void user_click_the_Add_To_Bag() throws Throwable {
		clickElementsMethods.click(Locator.addToBagBtnLoc);
	}

	@When("^user click View bag$")
	public void user_click_View_bag() throws Throwable {
		clickElementsMethods.click(Locator.viewBagBtnLoc);
	}

	@Then("^user is on Shopping Bag Page$")
	public void user_is_on_Shopping_Bag_Page() throws Throwable {
		waitMethods.wait(UtilConstants.MIN_WAITTIME);
		Assert.assertTrue("Shopping bag page not opened",
				assertionMethods.getElementText("xpath", Locator.pageHeaderLoc).equals("SHOPPING BAG"));
	}

	@Then("^user click to proceed to checkout$")
	public void user_click_to_proceed_to_checkout() throws Throwable {
		clickElementsMethods.click(Locator.proceedToCheckoutBtnLoc);
	}

	@Then("^user is on checkout page$")
	public void user_is_on_checkout_page() throws Throwable {
		waitMethods.wait(UtilConstants.MIN_WAITTIME);
		Assert.assertTrue("Shopping bag page not opened",
				assertionMethods.getElementText("xpath", Locator.pageHeaderLoc).equals("CHECKOUT"));
	}

	@When("^user enter shipping address$")
	public void user_enter_shipping_address() throws Throwable {
		inputMethods.clearText("name", Locator.firstName);
		inputMethods.clearText("name", Locator.lastName);
		inputMethods.clearText("name", Locator.addr1);
		inputMethods.clearText("name", Locator.addr2);
		inputMethods.clearText("name", Locator.city);
		inputMethods.clearText("name", Locator.postalCode);
		inputMethods.enterText("name", UtilConstants.FIRSTNAME, Locator.firstName);
		inputMethods.enterText("name", UtilConstants.LASTNAME, Locator.lastName);
		inputMethods.enterText("name", UtilConstants.ADDR1, Locator.addr1);
		inputMethods.enterText("name", UtilConstants.ADDR2, Locator.addr2);
		inputMethods.enterText("name", UtilConstants.CITY, Locator.city);
		inputMethods.enterText("name", UtilConstants.ZIP, Locator.postalCode);
		inputMethods.selectOptionFromDropdown("name", "text", UtilConstants.STATE, Locator.state);
	}

	@When("^user select the \"([^\"]*)\"$")
	public void user_select_the(String shippingMethod) throws Throwable {
		if (shippingMethod.equalsIgnoreCase("standard"))
			System.out.println("By default,selected shipping method is standard");
		else if ((shippingMethod.equalsIgnoreCase("two day"))) {
			System.out.println("selected shipping method is two day");
		} else {
			System.out.println("selected shipping method is same day");
		}

	}

	@When("^user enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" in the payment section$")
	public void user_enter_and_in_the_payment_section(String ccNum, String expDate, String cvv, String phNum)
			throws Throwable {
		inputMethods.clearText("name", Locator.creditCardNum);
		inputMethods.clearText("name", Locator.expDate);
		inputMethods.clearText("name", Locator.cvv);
		inputMethods.clearText("name", Locator.phoneNum);
		inputMethods.enterText("name", ccNum, Locator.creditCardNum);
		inputMethods.enterText("name", expDate, Locator.expDate);
		inputMethods.enterText("name", cvv, Locator.cvv);
		inputMethods.enterText("name", phNum, Locator.phoneNum);
	}

	@When("^user enter the \"([^\"]*)\"$")
	public void user_enter_the(String email) throws Throwable {
		if (driver.findElements(By.name(Locator.email)).size() != 0)
			inputMethods.enterText("name", email, Locator.email);
	}

	@Then("^user review the \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_review_the_and(String subTotal, String shippingCharge, String tax, String orderTotal)
			throws Throwable {
		Assert.assertTrue("Sub total mismatch",
				assertionMethods.getElementTextByLoc(Locator.subTotalLoc).equals(subTotal));
		Assert.assertTrue("shippingCharge mismatch",
				assertionMethods.getElementTextByLoc(Locator.shippingLoc).equals(shippingCharge));
		Assert.assertTrue("orderTotal mismatch",
				assertionMethods.getElementTextByLoc(Locator.orderTotalLoc).equals(orderTotal));

	}

	@Then("^user click the place order$")
	public void user_click_the_place_order() throws Throwable {
		navigateMethods.scrollToElement(Locator.placeOrderBtnLoc);
		clickElementsMethods.click(Locator.placeOrderBtnLoc);
	}

	@Then("^user should see the order number in the order confirmation page$")
	public void user_should_see_the_order_number_in_the_order_confirmation_page() throws Throwable {

		for (int count = 0; count < 3; count++) {
			if (driver.findElements(Locator.orderNumberLoc).size() != 0) {
				Pattern p = Pattern.compile("[0-9]");
				Matcher m = p.matcher(assertionMethods.getElementTextByLoc(Locator.orderNumberLoc));
				Assert.assertTrue("OrderNumber not generated", m.find());
				break;

			} else if (driver.findElements(By.name("talkable-offer-iframe")).size() != 0) {
				navigateMethods.switchFrameByNameorId("talkable-offer-iframe");
				clickElementsMethods.click(By.xpath("//div[contains(@class,\"popup-close\")]"));
				navigateMethods.switchToDefaultContent();
				continue;
			}
		}

	}

	@When("^user click account icon$")
	public void user_click_account_icon() throws Throwable {
		clickElementsMethods.click(Locator.accountIcon);
	}

	@Then("^user click create account button$")
	public void user_click_create_account_button() throws Throwable {
		clickElementsMethods.click(Locator.accountLink);
	}

	@Then("^user fill the new account form$")
	public void user_fill_the_new_account_form() throws Throwable {
		// Random random = new Random();
		waitMethods.wait(UtilConstants.MIN_WAITTIME);
		clickElementsMethods.click("xpath", Locator.login);
		// inputMethods.enterText("xpath", UtilConstants.EMAIL+String.format("%04d",
		// random.nextInt(10000))+UtilConstants.EMAIL_DOMAIN, Locator.login);
		inputMethods.enterText("xpath", UtilConstants.EMAIL + UtilConstants.EMAIL_DOMAIN, Locator.login);
		inputMethods.enterText("name", UtilConstants.FIRSTNAME, Locator.firstName);
		inputMethods.enterText("name", UtilConstants.LASTNAME, Locator.lastName);
		inputMethods.enterText("name", UtilConstants.MOBILE, Locator.phoneNum);
		clickElementsMethods.click("xpath", Locator.password);
		inputMethods.enterText("xpath", UtilConstants.PASSWORD, Locator.password);
		inputMethods.enterText("xpath", UtilConstants.PASSWORD, Locator.confirm_password);

	}

	@Then("^user click create account$")
	public void createAccount() {
		clickElementsMethods.click(Locator.registerAccount);
	}

	@Then("^user signIn with their account details$")
	public void signIn() throws NumberFormatException, InterruptedException {
		if (driver.findElements(Locator.signIn).size() != 0) {
			clickElementsMethods.click(Locator.signIn);
			clickElementsMethods.click(Locator.userName);
			inputMethods.enterText(Locator.userName, UtilConstants.EMAIL);
			clickElementsMethods.click(Locator.password_signin);
			inputMethods.enterText(Locator.password_signin, UtilConstants.PASSWORD);
			clickElementsMethods.click(Locator.loginBtn);
		}

		waitMethods.wait(UtilConstants.MIN_WAITTIME);
		clickElementsMethods.click(Locator.closeIcon);

	}

}
