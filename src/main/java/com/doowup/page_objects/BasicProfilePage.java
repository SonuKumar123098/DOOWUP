package com.doowup.page_objects;

import com.doowup.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasicProfilePage extends BaseClass {
    @FindBy(xpath = "//p[normalize-space()='Apartment']")
    WebElement selectApartment;
    @FindBy(id = "googleInputField")
    WebElement googleInputField;
    @FindBy(xpath = "//button[normalize-space()='2BHK']")
    WebElement floorplan;
    @FindBy(css = "div[id='nextAndBack_optionStep1'] button[class='BFC_flowSteps_button__QPlj9 BFC_flowSteps_nextStep__H99hJ']")
    WebElement nextBtn;
    @FindBy(xpath = "//button[normalize-space()='Move In']")
    WebElement selectPlan;
    @FindBy(xpath = "//button[normalize-space()='End-to-end Interiors']")
    WebElement selectChoice;
    @FindBy(xpath = "//p[normalize-space()='Select Budget']")
    WebElement budgetDropDownBtn;
    @FindBy(id = "budgetDropValueStep_2")
    WebElement selectBudget;
    @FindBy(xpath = "//p[contains(@class,'BFC_flowSteps_button__QPlj9')]")
    WebElement flowStepBtn;
    @FindBy(id = "possession_month_dropdown_0")
    WebElement selectFlow;
    @FindBy(xpath = "//div[@id='nextAndBack_optionStep2']//button[@class='BFC_flowSteps_button__QPlj9 BFC_flowSteps_nextStep__H99hJ'][normalize-space()='Next']")
    WebElement submitUsageBtn;
    @FindBy(xpath = "//p[normalize-space()='Doowup RT Nagar showroom']")
    WebElement nearestExperienceCenter;
    @FindBy(id = "820")
    WebElement selectNearestExperienceCenter;
    @FindBy(id = "bfc_step_booking")
    WebElement bookSessionBtn;

    public BasicProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void selectDateAndTime(String date) {
        nearestExperienceCenter.click();
        selectNearestExperienceCenter.click();

        List<WebElement> allDates = driver.findElements(By.xpath("//div[@role='listbox']//div//div"));
        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }

        List<WebElement> allTime = driver.findElements(By
                .xpath("//*[@class='BFC_flowSteps_dropdown_options__6w8M5']"));
        for (WebElement time : allTime) {
            time.click();
            break;
        }

        bookSessionBtn.click();
    }

    public void submitUsageDetail() {
        selectPlan.click();
        selectChoice.click();
        budgetDropDownBtn.click();
        selectBudget.click();
        flowStepBtn.click();
        selectFlow.click();
        submitUsageBtn.click();
    }

    public void submitBasicProfileDetail() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//declaration
        selectApartment.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", googleInputField);
        googleInputField.sendKeys("ben");
        js.executeScript("arguments[0].click()", googleInputField);
//        By autoSuggestionLocator = By.xpath("//div[@class='pac-container pac-logo']//div[1]");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(autoSuggestionLocator));
//        WebElement autoSuggestion = driver.findElement(autoSuggestionLocator);
//        Thread.sleep(500);
//        autoSuggestion.click();
//        WebElement location = myWait.until(ExpectedConditions.visibilityOfElementLocated(By
//                .xpath("//div[@class='pac-container pac-logo']//div[1]")));
//        List<WebElement> locations = driver.findElements(By.
//                xpath("//div[@class='pac-container pac-logo']//div"));
//        for (WebElement location : locations){
//            location.click();
//            break;
//        }
        googleInputField.click();
        WebElement location = driver.findElement(By
                .xpath("//div[@class='pac-container pac-logo']//div[1]"));
        js.executeScript("arguments[0].click()", location);
        floorplan.click();
        nextBtn.click();
    }
}
