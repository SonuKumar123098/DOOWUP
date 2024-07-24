package com.doowup.page_objects;

import com.doowup.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public BasicProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void submitUsageDetail(){
        selectPlan.click();
        selectChoice.click();
        budgetDropDownBtn.click();
        selectBudget.click();
        flowStepBtn.click();
        selectFlow.click();
        submitUsageBtn.click();
    }

    public void submitBasicProfileDetail() {
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(50));//declaration
        selectApartment.click();
        googleInputField.sendKeys("ben");
        googleInputField.click();
//        WebElement location = myWait.until(ExpectedConditions.visibilityOfElementLocated(By
//                .xpath("//div[@class='pac-container pac-logo']//div/span")));
        WebElement location = driver.findElement(By.xpath("//div[@class='pac-container pac-logo']//div/span"));
        location.click();
        floorplan.click();
        nextBtn.click();
    }
}
