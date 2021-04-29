import DataProviders.DataProvider_Repository;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.IOException;

public class BookMyShow {
    private WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws Exception {
        //For selecting Google Chrome use chrome inside openBrowser method
        //For selecting Mozilla Firefox use firefox inside openBrowser method
        driver = Browser.openBrowser("chrome");
    }


    @Test(dataProviderClass = DataProvider_Repository.class, dataProvider = "BothData")
//    Scenario 01 & 02 : Search Movie Positive & Negative Scenario
    public void movieSearch(String MovieName, String ReportSearch) throws IOException {
        Reports.createTest(ReportSearch);
        TC_01_02 TC01_02 = new TC_01_02(driver);
        TC01_02.searchMovie(MovieName);
    }

    @Test(priority = 1, dataProviderClass = DataProvider_Repository.class, dataProvider = "BothData")
//     Scenario 03 & 04: Search for Cast and Crew - Positive & Negative Scenario
    public void castCrew(String ActorName, String CrewName, String MovieName, String ReportCrew) throws IOException {
        Reports.createTest(ReportCrew);
        TC_03_04 TC03_04 = new TC_03_04(driver);
        TC03_04.crewCast(ActorName, CrewName, MovieName);

    }

    @Test(priority = 2)
    //Scenario 05 : List Your Show-What can you Host
    public void showHost() throws IOException {
        Reports.createTest("Scenario 05/List Your Show-What can you Host");
        TC_05 TC05 = new TC_05(driver);
        TC05.hostShow();
    }

    @Test(priority = 3)
    //Scenario 06 : List Your Show-What are the services we offer
    public void serviceOffer() throws IOException {
        Reports.createTest("Scenario 06/List Your Show-What are the services we offer");
        TC_06 TC06 = new TC_06(driver);
        TC06.offerService();
    }

    @Test(priority = 4)
    //Scenario 07 : List Your Show-Reports & Business insights details
    public void showReports() throws IOException {
        Reports.createTest("Scenario 07/List Your Show-Reports & Business insights details");
        TC_07 TC07 = new TC_07(driver);
        TC07.reportShow();

    }

    @Test(priority = 5)
    //Scenario 08 : Check Offers
    public void checkOffer() throws IOException {
        Reports.createTest("Scenario 08/Check Offers");
        TC_08 TC08 = new TC_08(driver);
        TC08.offersCheck();
    }

    @Test(priority = 6, dataProviderClass = DataProvider_Repository.class, dataProvider = "BothData")
    //Scenario 09: Search Offers-Positive & Negative scenario
    public void searchOffer(String Offer, String ReportOffer) {
        Reports.createTest(ReportOffer);
        TC_09_10 TC09_10 = new TC_09_10(driver);
        TC09_10.searchOffer(Offer);
    }

    @Test(priority = 7)
    //Scenario 11 : Footer Text Validation
    public void footer() throws IOException {
        Reports.createTest("Scenario 11/Footer Text Validation");
        TC_11 TC_11 = new TC_11(driver);
        TC_11.footerText();
    }

    @Test(priority = 8)
    //Scenario 12 : Validate Menu
    public void validateMenU() throws IOException {
        Reports.createTest("Scenario 12/Validate Menu");
        TC_12 TC_12 = new TC_12(driver);
        TC_12.menuValidate();
    }

    @Parameters({"City"})
    @Test(priority = 9)
    //Scenario 13 : Choose City
    public void chooseCity(@Optional("Goa") String City) throws IOException {
        Reports.createTest("Scenario 13/ Choose City");
        TC_13 TC_13 = new TC_13(driver);
        TC_13.verifyCity(City);
    }

    @Test(priority = 10)
    //Scenario 14 : Validate Sorted Product
    public void validateSort() throws IOException {
        Reports.createTest("Scenario 14/Validate Sorted Product");
        TC_14 TC_14 = new TC_14(driver);
        TC_14.sortValidate();
    }

    @Test(priority = 11)
    //Scenario 15 : Validate Filter by Price Doubts
    public void validateFilter() throws IOException {
        Reports.createTest("Scenario 15/Validate Filter by Price");
        TC_15 TC_15 = new TC_15(driver);
        TC_15.filterValidate();
    }

    @AfterMethod
    public void closeBrowser() {
        Browser.closeBrowser(driver);
    }
}
