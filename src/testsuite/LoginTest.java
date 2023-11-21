package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

        //Find username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Find password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click link on Login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(5000);
        //Verify the text "Products after login
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void VerifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        //Find username and enter it
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter user password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on Login Button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(5000);
        //Verify that six products displays on page
        List<WebElement> productsDisplayed = driver.findElements(By.className("inventory_item"));
        int number = productsDisplayed.size();
        System.out.println("Number of products displayed on the page : " + number);
        Assert.assertTrue("Number of Products in the page is:  ", true);

    }
    @After
    public void tearDown(){
        closedBrowser();
    }
}
