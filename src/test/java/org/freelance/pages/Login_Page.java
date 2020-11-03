package org.freelance.pages;

import org.freelance.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Login_Page extends BasePage {
	
    public static By signIn_landinPage=By.cssSelector("div#nav-flyout-ya-signin  .nav-action-inner");
	public static By email = By.id("ap_email");
	public static By continueBtn = By.id("continue");
	public static By password = By.id("ap_password");
	public static By signInBtn = By.id("signInSubmit");
    public static By accountIcon = By.id("nav-link-accountList");
    public static By signOutBtn = By.id("nav-item-signout");
	
	
	
	

	public static void clickSigninBtn_LandingPage() {
		performMoueOver(accountIcon);
		click(signIn_landinPage);
	}
	public static void enterEmail(String emailID) {
		typeText(email, emailID);
	}

	public static void clickContinueBtn() {
		click(continueBtn);
	}

	public static void enterPassword(String passW) {
		typeText(password, passW);
	}

	public static void clickSignInBtn() {
		click(signInBtn);
	}

	public static void clickSignOutBtn() {
		performMoueOver(accountIcon);
		click(signOutBtn);
	}
	
	public static void verifyUserNavToHomePage(String expTitle){
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

}
