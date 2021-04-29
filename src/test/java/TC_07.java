import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_07 extends BasePage {

    public TC_07(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //Scenario 07 : List Your Show-Reports & Business insights details(Success)
    public void reportShow() throws IOException {
        try {
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            click(By.cssSelector(".ddCzTB"));
            Assert.assertEquals(driver.getCurrentUrl(),"https://in.bookmyshow.com/s/list-your-show/");
            click(By.cssSelector(".\\__card-color:nth-child(5) > .\\__txt"));
            List<String> show = Arrays.asList("In depth reports", "Access registration data", "behavioural insights");
            int num = 0;
            for (int i = 1; i < 4; i++) {
                String s = getText(By.xpath("//*[@id='Reports']/div/div[2]/div[2]/div[" + i + "]/div[2]"));
                if (show.contains(s)) {
                    System.out.println(s);
                    num++;
                    Reports.extentTest.log(Status.INFO, s);
                }
            }
            if (num == 3) {
                System.out.println("Correct");
                Reports.extentTest.log(Status.PASS,"Correct");
            }
            else{
                System.out.println("Incorrect");
                Reports.extentTest.log(Status.FAIL,"Incorrect");
            }
            takeScreenshot("/Scenario07/", "showReports");
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("/Scenario07/", "showReports_failed");
        }

    }
}
