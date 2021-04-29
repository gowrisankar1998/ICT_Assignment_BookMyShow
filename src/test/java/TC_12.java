import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_12 extends BasePage {

    public TC_12(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void menuValidate() throws IOException {
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://in.bookmyshow.com/");
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            List<String> validate = Arrays.asList("Movies", "Stream", "Events", "Plays", "Sports", "Activities", "Fanhood", "Buzz");
            List<WebElement> menu = driver.findElements(By.xpath("//a[@class='sc-iGrrsa FYYCw']"));
            int num = 0;
            for (WebElement webElement : menu) {
                String text_menu = webElement.getText();
                text_menu = text_menu.replace("NEW", "");
                text_menu = text_menu.replaceAll("\\s", "");
                if (validate.contains(text_menu)) {
                    System.out.println(text_menu);
                    Reports.extentTest.log(Status.INFO, text_menu);
                    num++;
                }
            }
            if (num == 8) {
                System.out.println("Correct number of Menu");
                Reports.extentTest.log(Status.PASS, "Correct number of Menu");
                takeScreenshot("/Scenario12/", "menuValidate");
            } else {
                System.out.println("Incorrect number of Menu");
                Reports.extentTest.log(Status.FAIL, "Incorrect number of Menu");
                takeScreenshot("/Scenario12/", "menuValidate");

            }
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("/Scenario12/", "menuValidate_failed");
        }
    }
}
