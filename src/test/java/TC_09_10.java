import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;

public class TC_09_10 extends BasePage {

    public TC_09_10(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void searchOffer(String offer) {
        try {
//            click(By.id("wzrk-cancel"));
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            click(By.linkText("Offers"));
            Assert.assertEquals(driver.getCurrentUrl(),"https://in.bookmyshow.com/offers");
            locateElement(By.id("ajax-typeahead")).sendKeys(offer + Keys.RETURN);
            List<WebElement> menu = driver.findElements(By.className("__description"));
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
            int index = 0, num = 0;
            for (int k = 0; k < menu.size(); k++) {
                if (menu.get(k).isDisplayed()) {
                    num++;
                    index = k;
                }
            }
            if (num > 0) {
                if (((menu.get(index).getText()).toLowerCase()).contains(offer.toLowerCase())) {
                    System.out.println("Offer is present : " + offer);
                    Reports.extentTest.log(Status.PASS, "Offer is present :" + offer);

                } else {
                    System.out.println("Offer is not present : " + offer);
                    Reports.extentTest.log(Status.PASS, "Offer is not present :" + offer);
                }
            } else {
                System.out.print("Offer is not present : " + offer);
                Reports.extentTest.log(Status.PASS, "Offer is not present" + offer);
            }
            takeScreenshot("/Scenario09&10/", "searchOffer");

        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
        }
    }
}
