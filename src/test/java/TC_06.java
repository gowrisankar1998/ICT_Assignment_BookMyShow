import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_06 extends BasePage {

    public TC_06(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Scenario 06 : List Your Show-What are the services we offer(Success)
    public void offerService() throws IOException {
        try {
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            click(By.cssSelector(".ddCzTB"));
            List<String> offer = Arrays.asList("Online Sales & Marketing", "Pricing", "Food & beverages, stalls and the works!", "On ground support & gate entry management", "Reports & business insights", "POS, RFID, Turnstiles & more...");
            Assert.assertEquals(driver.getCurrentUrl(),"https://in.bookmyshow.com/s/list-your-show/");
            int num = 0;
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");
            for (int i = 1; i <= 13; i++) {
                String offer_name = getText(By.xpath("(//div[@class='__txt'])[position()=" + i + "]"));
                if (offer.contains(offer_name)) {
                    System.out.println(offer_name);
                    num++;
                    Reports.extentTest.log(Status.PASS, offer_name);
                }

            }
            if (num==6){
                System.out.println("Correct number of offer");
                Reports.extentTest.log(Status.PASS,"Correct number of offer");
            }
            else {
                System.out.println("Incorrect number of offer");
                Reports.extentTest.log(Status.FAIL, "Incorrect number of offer");
            }
            takeScreenshot("/Scenario06/", "serviceOffer");
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("/Scenario06/", "serviceOffer_failed");
        }

    }
}
