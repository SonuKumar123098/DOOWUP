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

    public void submitdetail() {
        try {
            selectApartment.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("googleInputField")));

            WebElement searchField = driver.findElement(By.id("googleInputField"));
            searchField.clear(); // Clear existing text (if any)
            searchField.sendKeys("Bengaluru, Karnataka, India");
            searchField.click();

            wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            By autoSuggestionLocator = By.xpath("//div[@class='pac-item']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(autoSuggestionLocator));

            WebElement autoSuggestion = driver.findElement(autoSuggestionLocator);
            autoSuggestion.click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement floorPlanOption = driver.findElement(By
                    .xpath("//p[contains(text(),'My floorplan type is…')]"));
            js.executeScript("arguments[0].scrollIntoView();", floorPlanOption);
            floorplan.click();
            nextBtn.click();
            // Continue with further actions if needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitBasicProfileDetail() throws InterruptedException {
        selectApartment.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", googleInputField);
        googleInputField.clear();
        googleInputField.sendKeys("ben");
        Thread.sleep(2000);
        driver.findElements(By
                .xpath("//div[@class='pac-container pac-logo']//div//span//span")).get(1).click();
        js.executeScript("arguments[0].scrollIntoView();", googleInputField);
        floorplan.click();
        nextBtn.click();
    }

    public void submitBasicProfileDetailWait() throws InterruptedException {
        try {
            selectApartment.click();

            // Scroll to googleInputField
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", googleInputField);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased timeout to 20 seconds
            wait.until(ExpectedConditions.elementToBeClickable(googleInputField));

            googleInputField.clear();
            googleInputField.sendKeys("Bengaluru, Karnataka, India");

            System.out.println("Waiting for auto-suggestion element...");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pac-item']")));

            List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='pac-item']"));
            if (!suggestions.isEmpty()) {
                suggestions.get(0).click(); // Click on the first suggestion
            } else {
                System.out.println("No auto-suggestions found");
            }

            // Scroll to floorplan element and click
            js.executeScript("arguments[0].scrollIntoView();", floorplan);
            floorplan.click();

            // Click nextBtn
            nextBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
