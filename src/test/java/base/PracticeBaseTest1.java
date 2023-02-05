package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.List;

/*
// Playing around with switching window size and finding web element
 */
public class PracticeBaseTest1 {

        private WebDriver driver;
        protected HomePage homePage;

        @BeforeClass
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://the-internet.herokuapp.com");

            //1 - Maximize the window
            driver.manage().window().maximize();

            //2 - Full Screen Mode
            driver.manage().window().fullscreen();

            // 3 - Specific width (show Chrome iPhoneX emulator)
            Dimension size = new Dimension(375,812);
            driver.manage().window().setSize(size);

            //To get the list of all web element with the tage name 'a' and display the number of elements with the tag
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println(links.size());

            //To get the web element by link text 'Inputs' and click the element
            WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
            inputsLink.click();


            //To get the web element by link text 'Shifting Content' and click the element
            WebElement shiftingLinks = driver.findElement(By.linkText("Shifting Content"));
            shiftingLinks.click();

            //To get the web element by link text 'Example 1: Menu Element' and click the element
            WebElement menuLinks = driver.findElement(By.linkText("Example 1: Menu Element"));
            menuLinks.click();

            //To get the list of all web element with the tage name 'li' and display the number of elements with the tag
            List<WebElement> menuItems = driver.findElements(By.tagName("li"));
            System.out.println("Number of menu items: " +menuItems.size());

            //To get the title of the current page
            System.out.println(driver.getTitle());

            //To close the browser and end the session, alternatively you case use driver.close() to just close the browser



            homePage = new HomePage(driver);
        }

        @AfterClass
        public void tearDown(){
            driver.quit();
        }
    }
