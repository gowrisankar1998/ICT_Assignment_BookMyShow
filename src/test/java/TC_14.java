import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TC_14 extends BasePage {

    public TC_14(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //Scenario 14 : Validate Sorted Product(Success)
    public void sortValidate() throws IOException {
        try {
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            click(By.linkText("Fanhood"));
            String currentTitle = driver.getTitle();
            String url = (currentTitle.contains("Fanhood")) ? "Correct URL: " + currentTitle : "Incorrect URL :"+ currentTitle;
            System.out.println(url);
            Actions action = new Actions(driver);
            action.moveToElement(locateElement(By.linkText("Products"))).perform();
            action.moveToElement(locateElement(By.linkText("Bags"))).perform();
            click(By.linkText("Lunch Bags"));
            click(By.id("ajaxSort"));
            Select sort = new Select(locateElement(By.id("ajaxSort")));
            sort.selectByValue("title-descending");
            List<WebElement> elementName = driver.findElements(By.className("product-item__info-inner"));
            ArrayList<String> arr = new ArrayList<>();
            ArrayList<String> arr1 = new ArrayList<>();
            for (WebElement webElement : elementName) {
                arr.add(webElement.getText());
                arr1.add(webElement.getText());
            }
            arr.sort(Collections.reverseOrder());
            if (arr.equals(arr1)){
                System.out.println("Product is sorted");
                Reports.extentTest.log(Status.PASS, "Product is sorted");
            }
            else{
                System.out.println("Product is not sorted");
                Reports.extentTest.log(Status.FAIL, "Product is not sorted");
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
            takeScreenshot("/Scenario14/", "validateSort");


        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("/Scenario14/", "Failed");

        }
    }
}
