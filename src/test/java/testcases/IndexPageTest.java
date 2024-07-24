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

    @Test
    public void book3DDesignSessionTest() throws InterruptedException {
        indexPage.book3DDesignSession();
        basicProfilePage = indexPage.submitOTP();
        basicProfilePage.submitBasicProfileDetailWait();
        basicProfilePage.submitUsageDetail();
        basicProfilePage.selectDateAndTime(properties.getProperty("date"));
        Thread.sleep(5000);
        Assert.assertEquals(true, true);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
