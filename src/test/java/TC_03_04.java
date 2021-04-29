import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.util.ArrayList;


public class TC_03_04 extends BasePage {

    public TC_03_04(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void crewCast(String actor, String crew, String movie) throws IOException {
        try {
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            click(By.id("4"));
            locateElement(By.cssSelector(".sc-fihHvN")).sendKeys(movie);
            waitFor(By.xpath("//li"));
            click(By.xpath("//li"));
            Assert.assertEquals(getText(By.xpath("//h1[@class='styles__EventHeading-qswwm9-6 mptsd']")),movie);
            System.out.println("Movie :"+getText(By.xpath("//h1[@class='styles__EventHeading-qswwm9-6 mptsd']")));
            ArrayList<String> Name = new ArrayList<>();
            ArrayList<String> Role = new ArrayList<>();
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)");
            for (int i = 1; i <= 9; i++) {
                Name.add(getText(By.xpath("(//*[@class='styles__Title-sc-17p4id8-1 jfGPxs'])[position()=" + i + "]")));
                Role.add((getText(By.xpath("(//*[@class='styles__Subtitle-sc-17p4id8-2 eqRnos'])[position()=" + i + "]"))));
            }
            String Act = (Name.contains(actor)) ? "Actor : "+actor : "Incorrect Actor : "+actor;
            System.out.println(Act);
            Reports.extentTest.log(Status.PASS, Act);
            if(Name.contains(crew))
            {
                System.out.println("Crew Member : " + crew);
                Reports.extentTest.log(Status.PASS,"Crew Member : " + crew);
                if(Role.get(Name.indexOf(crew)).contains("Musician")){
                    System.out.println("Musician");
                    Reports.extentTest.log(Status.PASS,"Musician");
                }
                else{
                    System.out.println("Not Musician");
                    Reports.extentTest.log(Status.PASS,"Not Musician");
                }
            }
            else
            {
                System.out.println("Incorrect Crew Member :"+crew+" and not Musician ");
                Reports.extentTest.log(Status.PASS,"Incorrect Crew Member :"+crew+" and not Musician");
            }
            takeScreenshot("/Scenario03&04/", "castCrew");
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL,e);
            System.out.println(e);
            takeScreenshot("/Scenario03&04/", "castCrew_failed");
        }

    }
}