package pages;

import org.openqa.selenium.By;

public class Locator {
	
	public static By categoryLoc = By.linkText("%s");
	public static String breadcrump = "//div[@class='main-breadcrumb']";
	public static String productLoc = "//*[@alt=\"%s\"]/../../../following-sibling::div//a";
	public static By sizeDropDownLoc = By.xpath("//div[contains(@class,\"dropdown-toggle\")]/span[@class=\"caret\"]");
	public static By addToBagBtnLoc = By.xpath("//button[@name=\"add-to-bag\"]");
	public static By viewBagBtnLoc = By.xpath("//button[@name=\"viewBag\"]");
	//public static By placeOrderBtnLoc = By.xpath("//button[@name=\"place-order\"]");
	public static By placeOrderBtnLoc = By.name("place-order");
	public static String pageHeaderLoc = "//h1[contains(@class,\"page-header\")]";
	public static String productInShoppingPage = "//div[contains(@class,\"cart-item-info-text\")]/h3/a";
	public static String sizeInShoppingPage = "//div[contains(@class,\"cart-item-product-details\")]//div[contains(@class,\"cart-item-size\")]";
	public static String priceInShoppingPage = "//div[contains(@class,\"cart-item-product-details\")]//div[contains(@class,\"cart-item-unit-price\")]";
	public static String qtyInShoppingPage = "//div[contains(@class,\"cart-item-product-details\")]//div[contains(@class,\"cart-item-quantity\")]";
	public static By proceedToCheckoutBtnLoc = By.xpath("//div[contains(@class,\"cart-buttons\")]/button[text()=\"PROCEED TO CHECKOUT\"] ");
	public static String firstName = "firstname";
	public static String lastName = "lastname";
	public static String addr1 = "streetAddress";
	public static String addr2 = "streetAddress2";
	public static String city = "city";
	public static String postalCode = "postalCode";
	public static String state = "states";
	public static String creditCardNum = "cardNumber";
	public static String expDate = "expirationDate";
	public static String cvv = "securityCode";
	public static String phoneNum = "phoneNumber";
	public static String email = "email";
	public static String login = "//div[contains(@class,\"qa-input-login\")]//input[contains(@placeholder,\"Email\")]";
	public static String password = "//div[contains(@class,\"qa-input-password\")]/input[contains(@placeholder,\"Password\")]";
	public static String confirm_password = "//div[contains(@class,\"qa-input-confirm_password\")]/input[contains(@placeholder,\"Confirm Password\")]";
	public static By subTotalLoc = By.xpath("//div[contains(@class,\"qa-cart-merchandise-value\")]");
	public static By shippingLoc = By.xpath("//div[contains(@class,\"qa-cart-shipping-value\")]");
	public static By orderTotalLoc = By.xpath("//div[contains(@class,\"qa-cart-total-value\")]");
	public static By orderNumberLoc = By.xpath("//p[contains(@class,\"qa-confirmation-message\")]/strong");
	public static By accountIcon = By.xpath("//span[@class=\"utilities-item-title\" and text()=\"Account\"]");
	public static By createAccount = By.xpath("//label[contains(@class,\"aeo-checkbox-label\")]");
	public static By accountLink = By.xpath("//a[contains(@class,\"qa-btn-register\")]");
	public static By registerAccount = By.xpath("//button[contains(@class,\"qa-btn-register\")]");
	public static By signIn = By.xpath("//button[contains(@class,\"qa-btn-signin\")]");
	public static By userName = By.xpath("//input[@name=\"username\"]");
	public static By password_signin = By.xpath("//input[@name=\"password\"]");
	public static By loginBtn = By.xpath("//div[contains(@class,\"qa-account-form\")]/../button[contains(@class,\"qa-btn-login\")]");
	public static By closeIcon = By.xpath("//div[@class=\"modal-content\"]//button[contains(@class,\"qa-btn-cancel\")]/following-sibling::h2/preceding-sibling::button");
	
	
	
	
	
	
	

}
