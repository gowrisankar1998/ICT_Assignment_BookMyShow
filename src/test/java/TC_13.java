import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_13 extends BasePage {

    public TC_13(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Scenario 13 : Choose City (In progress)
    public void verifyCity(String city) throws IOException {
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://in.bookmyshow.com/");
            List<String> Cities = Arrays.asList("MUMBAI", "NCR", "Bengaluru", "Hyderabad", "Ahmedabad", "Chandigarh", "Chennai", "Pune", "Kolkata", "Kochi");
            if (Cities.contains(city)) {
                int index = Cities.indexOf(city) + 1;
                click(By.cssSelector(".sc-hMrMfs:nth-child(" + (index) + ") .sc-yZwTr"));
                String CurrentCity = getText(By.xpath("//span[@class='sc-RcBXQ dTleyQ ellipsis']"));
                if (city.equals(CurrentCity)) {
                    System.out.println("Correct City : " + city);
                    Reports.extentTest.log(Status.PASS, "Selected City is correct : " + city, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

                } else {
                    System.out.println("Incorrect City : " + city);
                    Reports.extentTest.log(Status.FAIL, "Selected City is incorrect : " + city, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
                }
            } else {
                locateElement(By.cssSelector(".sc-fihHvN")).sendKeys(city + Keys.ENTER);
                String CurrentCity = getText(By.xpath("//span[@class='sc-RcBXQ dTleyQ ellipsis']"));
                if (city.equals(CurrentCity)) {
                    System.out.println("Correct City : " + city);
                    Reports.extentTest.log(Status.PASS, "Selected City is incorrect : " + city, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

                } else {
                    System.out.println("Incorrect City : " + city);
                    Reports.extentTest.log(Status.FAIL, "Selected City is incorrect : " + city, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
                }
            }
            takeScreenshot("/Scenario13/", "verifyCity");
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
    }
}