package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramePage {

    private WebDriver driver;
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private String topFrame = "frame-top";
    private String middleFrame = "frame-middle";
    private String rightFrame = "frame-right";
    private By body = By.tagName("body");
    private By content = By.id("content");

    public NestedFramePage(WebDriver driver){
        this.driver = driver;
    }

    public String getLeftFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit left frame to top frame
        driver.switchTo().parentFrame(); //exit top frame to main frame
        return text;
    }

    public String getMiddleFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(middleFrame);
        String text = getFrameTextByContent();
        driver.switchTo().parentFrame(); //exit left frame to top frame
        driver.switchTo().parentFrame(); //exit top frame to main frame
        return text;
    }

    public String getRightFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(rightFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit left frame to top frame
        driver.switchTo().parentFrame(); //exit top frame to main frame
        return text;
    }

    public String getBottomFrameText(){
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit bottom to main frame
        return text;
    }
    private String getFrameText(){
        return driver.findElement(body).getText();
    }

    private String getFrameTextByContent(){
        return driver.findElement(content).getText();
    }
}
