package com.doowup.page_objects;

import com.doowup.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicProfilePage extends BaseClass {
    @FindBy(xpath = "//p[normalize-space()='Apartment']")
    WebElement selectApartment;
    @FindBy(xpath = "//input[@id='googleInputField']")
    WebElement googleInputField;
    @FindBy(xpath = "//button[normalize-space()='2BHK']")
    WebElement floorplan;
    @FindBy(xpath = "(//button[@class='BFC_flowSteps_button__QPlj9 BFC_flowSteps_nextStep__H99hJ'][normalize-space()=" +
            "'Next'])[1]")
    WebElement nextBtn;

    public BasicProfilePage() {
        PageFactory.initElements(driver, this);
    }
}
