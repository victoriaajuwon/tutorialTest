package base;

import com.beust.jcommander.FuzzyMap;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Base Test without event listener.
 * This is the best test before the event listener chapter
 * It can be used as reference.
 */
public class PracticeBaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // method to implicitly wait
    }

    @BeforeMethod
    public void goHome(){
        driver.get("http://the-internet.herokuapp.com");
    }

    @Test
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterMethod
    public void takeScreenshot(){   //Takes a screenshots of all test done
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        try {
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void recordFailure(ITestResult result){ //Takes screenshots of failed tests.
        if (ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" +result.getName()+ ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

