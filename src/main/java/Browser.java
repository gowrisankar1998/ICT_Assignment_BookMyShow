import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    public static WebDriver openBrowser(String browser) throws Exception {
        WebDriver driver;
        String baseDirectory = System.getProperty("user.dir");
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", baseDirectory + "/src/main/resources/ubuntu/geckodriver");
//            System.setProperty("webdriver.gecko.driver", baseDirectory + "/src/main/resources/windows/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://in.bookmyshow.com/");
            return driver;
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", baseDirectory + "/src/main/resources/ubuntu/chromedriver");
//            System.setProperty("webdriver.chrome.driver", baseDirectory + "/src/main/resources/windows/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://in.bookmyshow.com/");
            return driver;
        } else {
            throw new Exception("Browser is not correct");
        }
    }

    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }
}

