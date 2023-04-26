package laptop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

/*
Create a New Java Project with Name amazon-test create BaseTest and TestSuite
and add all jars.
Automate Following Test.
1. Open the url https://www.amazon.co.uk/
2. Type "Dell Laptop" in the search box and press enter or click on search
   Button.
3. Click on the checkbox brand Dell on the left side.
4. Verify that the  30(May be different) products are displayed on the page.
5. Print all product names in the console.
6. Click on the product name 'Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3" FHD TOUCH'
7. Varify the Product name 'Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3" FHD TOUCH'
5. Close the Browser.
 */
public class TestSuite extends Utility {


    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        // 1. Open the url https://www.amazon.co.uk/
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldAbleToSearchProductOnPageSuccessfully() throws InterruptedException {

        // 2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnMethod(By.xpath("//input[@id='nav-search-submit-button']"));
        //3. Click on the checkbox brand Dell on the left side.
        Thread.sleep(5000);
        clickOnMethod(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));

        //4. Verify that the  30(May be different) products are displayed on the page.

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']"));
        Assert.assertEquals(products.size(),30);

        //5. Print all product names in the console.
        for (WebElement productsName : products) {
            System.out.println(productsName.getText());
        }
        Thread.sleep(5000);
        clickOnMethod(By.xpath("//a[@aria-label='Go to page 2']"));

        Thread.sleep(4000);
        //6. Click on the product name 'Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3" FHD TOUCH'
        clickOnMethod(By.xpath("//span[contains(text(),' CORE I5 8365u 8GB 250GB SSD 13.3\" FHD TOUCH')]"));


        //7. Verify the Product name 'Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3" FHD TOUCH'
        //assertMethod(By.xpath("//span[normalize-space()='LATITUDE 5300']"), "Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3\" FHD TOUCH");
String product=driver.findElement(By.id("productTitle")).getText().trim();
Assert.assertEquals(product,"Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3\" FHD TOUCH");


    }

    @After
    public void tearDown() {

        // 8. Close the Browser.
        // closeBrowser();
    }


}
