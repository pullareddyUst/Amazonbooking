package org.freelance.pages;

import org.freelance.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Products_Page extends BasePage {

	public static By hamburgerMenu = By.id("nav-hamburger-menu");

	public static By computersCategory = By.xpath("//a[@class='hmenu-item']//div[text()='Computers']");
	
	public static By headPhonesSubCategory = By.linkText("Headphones");

	public static By electronicsCategory = By.xpath("//a[@class='hmenu-item']//div[text()='Electronics']");

	public static By compAndTabSubCategory = By.linkText("Computers & Tablets");

	public static By brandFilter_compAndTab = By.xpath("//span[@class='a-list-item']//span[text()='SAMSUNG']");

	public static By custReviewFilter = By.xpath("//span[@class='a-list-item']//span[text()='4 Stars & Up']");

	public static By brandFilter_electronics = By.xpath("//span[@class='a-list-item']//span[text()='Sony']");

	public static By priceFilter = By.xpath("//span[@class='a-list-item']//span[text()='$100 to $200']");

	public static By sellerFilter_Electronics = By.xpath("//span[@class='a-list-item']//span[text()='Amazon.com']");

	public static By sellerFilter_Computers = By.xpath("//span[@class='a-list-item']//span[text()='CellularStream']");
	
	public static By selectProduct_electronics = By.xpath("//span[contains(text(),'Sony MDR-XB950B1/B')]");

	public static By selectProduct_cellAndAcc = By.xpath("//span[contains(text(),'Samsung Galaxy Tab 4')]");

	public static By addtoCartBtn = By.id("add-to-cart-button");

	public static By cartBtn = By.cssSelector("a#hlb-view-cart-announce");

	public static By cartIcon = By.id("nav-cart");

	public static By selectQuantity = By.id("quantity");

	public static By productPrice = By.cssSelector("#sc-subtotal-amount-buybox .sc-white-space-nowrap");

	public static void clickHambergurMenu() {
		click(hamburgerMenu);
	}

	public static void clickComputersCategory() {
		click(computersCategory);
	}

	public static void clickElectronicsCategory() {
		click(electronicsCategory);
	}

	public static void clickHeadPhonesSubCategory() {
		click(headPhonesSubCategory);
	}

	public static void clickCellAndAccSubCategory() {
		click(compAndTabSubCategory);
	}

	public static void clickBrandFilterCellAndAcc() {
		click(brandFilter_compAndTab);
	}

	public static void clickCustReviewFilter() {
		click(custReviewFilter);
	}

	public static void clickBrandFilter_electronics() {
		click(brandFilter_electronics);
	}

	public static void clickPriceFilter() {
		click(priceFilter);
	}

	public static void clickSellerFilter_Electronics() {
		click(sellerFilter_Electronics);
	}
	public static void clickSellerFilter_Computers() {
		click(sellerFilter_Computers);
	}

	public static void clickProduct_electronics() {
		click(selectProduct_electronics);
	}

	

	public static void clickProduct_cellAndAcc() {
		click(selectProduct_cellAndAcc);
	}

	public static void clickAddtoCartBtn() {
		click(addtoCartBtn);
	}

	public static void clickCartBtn() {
		click(cartBtn);
	}

	public static void clickCartIcon() {
		click(cartIcon);
	}

	public static void selectQuantity(String option) {
		selectDropdownByVisTxt(selectQuantity, option);
	}
	
	public static void verifyPriceDetails(int expPrice){
		String price=driver.findElement(productPrice).getText();
		int actPrice=Integer.valueOf(price);
		Assert.assertEquals(actPrice, expPrice);
	}

}
