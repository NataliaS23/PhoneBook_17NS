import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class RegistrationTest extends TestBase {

    //    WebDriver wd;
//
    @BeforeMethod
    public void preCondition() {
      if(isLogged()) {
            logout();
        }
    }


    @Test
    public void registrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@gmail.com";
        String password = "Economist000!";
        System.out.println(email);


        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitRegistration();

        pause(5);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "gmail.com";
        String password = "Economist000!";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitRegistration();
        pause(3);
        Assert.assertFalse(isElementPresent(By.xpath("//button")));


    }


    @AfterMethod
    public void tearDown() {
        //wd.quit();
    }
}
