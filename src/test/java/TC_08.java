import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_08 extends BasePage {

    public TC_08(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //Scenario 08 : Check Offers(Success)
    public void offersCheck() throws IOException {
        try {
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            click(By.linkText("Offers"));
            click(By.xpath("//li[6]/span"));
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)");
            List<String> offer = Arrays.asList("Reward Points Redemption", "PAYBACK POINTS", "SimplyCLICK SBI Card Rewards Offer");
            Assert.assertEquals(driver.getCurrentUrl(),"https://in.bookmyshow.com/offers");
            int num = 0;
            for (int i = 0; i < 3; i++) {
                String a = offer.get(i).replace(" ", "-");
                String offerCheck = getText(By.cssSelector("[data-id='offers-" + a + "']"));
                offer.set(i, offer.get(i).toLowerCase());
                if (offer.contains(offerCheck.toLowerCase())) {
                    System.out.println(offerCheck);
                    Reports.extentTest.log(Status.INFO, offerCheck);
                    num++;
                }
            }
            if(num==3){
                System.out.println("Correct number of offers");
                Reports.extentTest.log(Status.PASS,"Correct number of offers");
                takeScreenshot("/Scenario08/", "checkOffers");
            }
            else{
                System.out.println("Incorrect number of offers");
                Reports.extentTest.log(Status.FAIL,"Incorrect number of offers");
                takeScreenshot("/Scenario08/", "checkOffers");
            }
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("/Scenario08/", "checkOffers_failed");
        }
    }
}
