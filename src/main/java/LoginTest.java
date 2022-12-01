import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    //WebDriver wd;
    @BeforeMethod
    public void preCondition() {
        if (isLogged()) {
            logout();
        }
    }

    @Test
    public void loginPositiveTest() {
        //open login/registration form
//        WebElement loginBtn = wd.findElement(By.xpath("//a[text() = 'LOGIN']"));
//        loginBtn.click();
        openLoginRegistrationForm();


        //fill login/registration form
        String email = "name2475@gmail.com";//from Registration Test
        String password = "Economist000!";
        fillLoginRegistrationForm(email, password);
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("Test70@gmail.com");
//
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Economist_000");
        submitLogin();

        //click on Login button
        //wd.findElement(By.xpath("//button[1]")).click();


        //Assert
        pause(5);
        Assert.assertTrue(wd.findElement(By.xpath("//a[@href='/add']"))!=null);


    }

    @Test
    public void loginWrongEmail() {
        openLoginRegistrationForm();
        String email = "Test71gmail.com";
        String password = "Economist000!";
        fillLoginRegistrationForm(email, password);


        submitRegistration();
        pause(5);
        Assert.assertFalse(isElementPresent(By.xpath("//button")));

    }

        @AfterMethod
        public void tearDown() {
            //wd.quit();
        }
}
