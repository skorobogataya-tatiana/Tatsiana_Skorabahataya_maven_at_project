package tests.junit;

import org.junit.Test;
import pages.trashmail.TrashMailHomePage;
import tests.BaseTest;

public class EmailTests extends BaseTest {
    private TrashMailHomePage trashMailHomePage = new TrashMailHomePage();

    @Test
    public void createNewTrashMailEmail() {
        trashMailHomePage.openTrashMail();
        trashMailHomePage.inputRealEmailValue("tanchiktest87@gmail.com");
        trashMailHomePage.requestToGenerateEmail();
    }
}
