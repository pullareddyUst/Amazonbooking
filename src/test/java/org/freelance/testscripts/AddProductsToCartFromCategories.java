package org.freelance.testscripts;

import org.freelance.base.BasePage;
import org.freelance.pages.Login_Page;
import org.freelance.pages.Products_Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddProductsToCartFromCategories {
	
	
	@BeforeTest
	public void initialize(){
		BasePage.launchBrowser();
		BasePage.loadUrl();
		Login_Page.clickSigninBtn_LandingPage();
		Login_Page.enterEmail(BasePage.configProp.getProperty("emailId"));
		Login_Page.clickContinueBtn();
		Login_Page.enterPassword(BasePage.configProp.getProperty("password"));
		Login_Page.clickSignInBtn();
	}
	
	@Test(priority=1)
	public void verifyAddProductFromElectronics(){
		Products_Page.clickHambergurMenu();
		Products_Page.clickElectronicsCategory();
		Products_Page.clickHeadPhonesSubCategory();
		Products_Page.clickCustReviewFilter();
		Products_Page.clickBrandFilter_electronics();
		Products_Page.clickPriceFilter();
		Products_Page.clickSellerFilter_Electronics();
		Products_Page.clickProduct_electronics();
		Products_Page.clickAddtoCartBtn();
		Products_Page.clickCartBtn();
		Products_Page.clickCartIcon();
		Products_Page.selectQuantity("2");
		Products_Page.verifyPriceDetails(250);
	
		
	}
	
	@Test(priority=2)
	public void verifyAddProductFromComputers(){
		Products_Page.clickHambergurMenu();
		Products_Page.clickComputersCategory();
		Products_Page.clickCellAndAccSubCategory();
		Products_Page.clickCustReviewFilter();
		Products_Page.clickBrandFilterCellAndAcc();
		Products_Page.clickPriceFilter();
		Products_Page.clickSellerFilter_Computers();
		Products_Page.clickProduct_cellAndAcc();
		Products_Page.clickAddtoCartBtn();
		Products_Page.clickCartBtn();
		Products_Page.clickCartIcon();
		Products_Page.selectQuantity("3");
		Products_Page.verifyPriceDetails(250);
		
	}
	
	
	@AfterTest
	public void tearDown(){
		BasePage.driver.close();
	}

}
