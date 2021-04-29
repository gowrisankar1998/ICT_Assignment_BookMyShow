import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;

public class TC_15 extends BasePage {

    public TC_15(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //Scenario 15 : Validate Filter by Price(Success) Doubts
    public void filterValidate() throws IOException {
        try {
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            click(By.linkText("Fanhood"));
            String currentTitle = driver.getTitle();
            String url = (currentTitle.contains("Fanhood")) ? "Correct URL" : "Incorrect URL";
            System.out.println(url);
            Actions action = new Actions(driver);
            action.moveToElement(locateElement(By.linkText("Products"))).perform();
            action.moveToElement(locateElement(By.linkText("Books"))).perform();
            click(By.linkText("Planner"));
            List<WebElement> elementName = driver.findElements(By.className("product-item__info-inner"));
            System.out.println("Number of products before filter: " + elementName.size());
            Reports.extentTest.log(Status.INFO, "Number of products before filter: " + elementName.size());
            click(By.cssSelector("[data-tag='0-500']"));
            List<WebElement> elementName1 = driver.findElements(By.className("product-item__info-inner"));
            System.out.println("Number of products after filter: " + elementName1.size());
            takeScreenshot("/Scenario15/", "validateFilter");
            Reports.extentTest.log(Status.PASS, "Number of products after filter: " + elementName1.size());
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("/Scenario15/", "Failed");
        }

    }
}
