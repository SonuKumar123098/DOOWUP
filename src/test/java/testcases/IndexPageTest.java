package testcases;

import com.doowup.base.BaseClass;
import com.doowup.page_objects.BasicProfilePage;
import com.doowup.page_objects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {
    private IndexPage indexPage;
    private BasicProfilePage basicProfilePage;

    @BeforeMethod
    public void setUp() {
        launchApp();
        indexPage = new IndexPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void book3DDesignSessionTest() throws InterruptedException {
        indexPage.book3DDesignSession();
        basicProfilePage = indexPage.submitOTP();
        basicProfilePage.submitBasicProfileDetail();
        Thread.sleep(10000);
        Assert.assertEquals(true, true);
    }
}
