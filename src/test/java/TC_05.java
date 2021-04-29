import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_05 extends BasePage {

    public TC_05(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void hostShow() throws IOException {
        try {
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            click(By.cssSelector(".ddCzTB"));
            List<String> host = Arrays.asList("Online Streaming", "Performances", "Experiences", "Expositions", "Parties", "Sports", "Conferences");
            Assert.assertEquals(driver.getCurrentUrl(),"https://in.bookmyshow.com/s/list-your-show/");
            List<WebElement> hosts = driver.findElements(By.xpath("//div[@class='__txt']"));
            int num = 0;
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)");
            for (int i = 1; i <= hosts.size(); i++) {
                String hostname = getText(By.xpath("(//div[@class='__txt'])[position()=" + i + "]"));
                if (host.contains(hostname)) {
                    System.out.println(hostname);
                    num++;
                    Reports.extentTest.log(Status.INFO, hostname);
                }
            }
            if(num==7){
                System.out.println("Correct number of host");
                Reports.extentTest.log(Status.PASS, "Correct number of host");
            }
            else{
                System.out.println("Incorrect number of host");
                Reports.extentTest.log(Status.FAIL, "Incorrect number of host");
            }
            takeScreenshot("/Scenario05/", "showHost");
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("/Scenario05/", "showHost_Failed");
        }
    }
}
