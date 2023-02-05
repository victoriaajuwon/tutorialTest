package window;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WindowTests extends BaseTests {
    @Test
    public void testSwitchTab(){
        var buttonPage = homePage.clickDynamicLoading().rightClickExample1();
        getWindowManager().switchToNewTab();
        assertTrue(buttonPage.isStartButtonDisplayed(), "Start button is not displayed");
    }

}
