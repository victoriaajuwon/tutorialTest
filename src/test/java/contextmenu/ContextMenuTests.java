package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test

    public void testRightClickBox(){
        var menuPage = homePage.clickContextMenu();
        menuPage.rightClickBox();
        String text = menuPage.getAlertText();
        menuPage.acceptAlert();
        assertEquals(text, "You selected a context menu", "Alert Message incorrect");

    }
}
