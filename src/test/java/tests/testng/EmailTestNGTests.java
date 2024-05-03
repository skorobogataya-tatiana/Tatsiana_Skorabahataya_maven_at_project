package tests.testng;

import org.testng.annotations.Test;
import pages.trashmail.TrashMailHomePage;

public class EmailTestNGTests {
    private TrashMailHomePage trashMailHomePage = new TrashMailHomePage();

    @Test
    public void createNewTrashMailEmail() {
        trashMailHomePage.openTrashMail();
        trashMailHomePage.inputRealEmailValue("tanchiktest87@gmail.com");
        trashMailHomePage.requestToGenerateEmail();
    }
}
