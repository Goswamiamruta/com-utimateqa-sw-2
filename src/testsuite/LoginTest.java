package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Find Sign link and click on it
        driver.findElement(By.linkText("Sign In")).click();
        String expectedText = "Welcome Back!";
        //Verify Text
         driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();

    }
    @Test
    public void verifyTheErrorMessage(){
        //Find Sign link and click on it
        driver.findElement(By.linkText("Sign In")).click();
        //find out username field and type emailId
        driver.findElement(By.id("user[email]")).sendKeys("amruta123@gmail.com");
        //find out password field and type password
        driver.findElement(By.name("user[password]")).sendKeys("Prime23");
        //find out login button and click on it
        driver.findElement(By.xpath("//button [@type='submit']")).click();
        // verify text
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li [@class='form-error__list-item']")).getText();
        Assert.assertEquals(expectedText,actualText);

    }
    @After
    public void tearDown() {
        closeBrowser();

    }

}
