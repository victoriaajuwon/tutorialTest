package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "Hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1+text2, "Text from editor is incorrect");
    }

    @Test
    public void testNestedFramesText(){
        var nestedFrame = homePage.clickFramePage().clickNestedFramePage();
        //nestedFrame.clickNestedFramePage();
        assertEquals(nestedFrame.getLeftFrameText(), "LEFT", "Left Frame text incorrect");
        assertEquals(nestedFrame.getBottomFrameText(), "BOTTOM", "Bottom Frame Text incorrect");
        assertEquals(nestedFrame.getMiddleFrameText(), "MIDDLE", "Middle Frame text incorrect");
        assertEquals(nestedFrame.getRightFrameText(), "RIGHT", "Right Frame Text incorrect");
    }
}
