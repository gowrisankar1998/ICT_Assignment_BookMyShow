import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TC_11 extends BasePage {

    public TC_11(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //Scenario 11 : Footer Text Validation(Success)
    public void footerText() throws IOException {
        try {
            Assert.assertEquals(driver.getCurrentUrl(),"https://in.bookmyshow.com/");
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            String copyright = "The content and images used on this site are copyright protected and copyrights vests with the respective owners. The usage of the content and images on this website is intended to promote the works and no endorsement of the artist shall be implied. Unauthorized use is prohibited and punishable by law.";
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            String copyright_web = (getText(By.xpath("//div[@class='sc-bMVAic bOhLXm']")).replace("Copyright 2021 © Bigtree Entertainment Pvt. Ltd. All Rights Reserved.", "")).replace("\n", "");
            if(copyright.contains(copyright_web)){
                System.out.println("Footer Correct");
                Reports.extentTest.log(Status.PASS, copyright_web);
            }
            else {
                System.out.println("Footer Incorrect");
                Reports.extentTest.log(Status.FAIL, copyright_web);
            }
            takeScreenshot("/Scenario11/", "footerText");
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("/Scenario11/", "Failed");
        }
    }
}
