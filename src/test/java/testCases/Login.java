package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import commons.BaseClass;
import pages.LoginPage;
import pages.SignInOptionsPage;
import utilities.ReadXlSData;

public class Login extends BaseClass {

	@Test(dataProviderClass = ReadXlSData.class, dataProvider = "testdata")
	public void LoginTest(String scenario, String email, String password) throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.continueWithEmail();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickContinue();
//		Thread.sleep(1000);

        switch (scenario) {
            case "character limit":
                Assert.assertTrue(loginPage.characterLimit().isDisplayed(), "Character limit error message not seen");
                break;
            case "capital required":
                Assert.assertTrue(loginPage.noCapitalLetter().isDisplayed(), "Capital letter error message not seen");
                break;
            case "number required":
                Assert.assertTrue(loginPage.numberIsMust().isDisplayed(), "Number is must error message not seen");
                break;
            case "blank email pass":
                Assert.assertTrue(loginPage.emailRequired().isDisplayed() && loginPage.passRequired().isDisplayed(),
                        "Email and pass required error message not seen");
                break;
            case "blank email":
                Assert.assertTrue(loginPage.emailRequired().isDisplayed(), "Email required error message not seen");
                break;
            case "special char required":
                Assert.assertTrue(loginPage.specialChar().isDisplayed(), "Special character required error message not seen");
                break;
            case "blank pass":
                Assert.assertTrue(loginPage.passRequired().isDisplayed(), "Password required error message not seen");
                break;
            case "both correct":
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                wait.until(ExpectedConditions.urlToBe(loginPage.expectedURL));
//                Assert.assertTrue(loginPage.logo().isDisplayed(), "Logo not seen");
                Assert.assertEquals(driver.getCurrentUrl(),loginPage.expectedURL,"Did not land on projects page");
                break;
        }
	}

}
