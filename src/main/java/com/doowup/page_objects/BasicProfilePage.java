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

    public BasicProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void submitBasicProfileDetail(){
        selectApartment.click();
        googleInputField.sendKeys("ben");
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        By autoSuggestionLocator = By.className("pac-item"); // Adjust this selector based on your specific auto-suggestion dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(autoSuggestionLocator));
//        By autoSuggestionLocator = By.xpath("//ul[@class='pac-container pac-logo']/li/div[@class='pac-item']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(autoSuggestionLocator));
        WebElement autoSuggestion = driver.findElement(autoSuggestionLocator);
        autoSuggestion.click();
        floorplan.click();
        nextBtn.click();
    }
}
