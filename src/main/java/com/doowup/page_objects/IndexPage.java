package com.doowup.page_objects;

import com.doowup.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class IndexPage extends BaseClass {
    @FindBy(xpath = "//div[@class='Header_button__Ey_Mn undefined']")
    WebElement bookConsultation;
    @FindBy(xpath = "(//input[@id='phone'])[1]")
    WebElement enterMobileNumber;
    @FindBy(xpath = "(//input[@id='name'])[1]")
    WebElement enterName;
    @FindBy(xpath = "(//input[@id='email'])[1]")
    WebElement enterEmail;
    @FindBy(xpath = "(//input[@id='pincode'])[1]")
    WebElement enterPincode;
    @FindBy(xpath = "(//button[@id='button1'])[1]")
    WebElement book3DDesignBtn;
    @FindBy(xpath = "//input[@id='otp']")
    WebElement OTP;
    @FindBy(id = "submitOtpBtn")
    WebElement otpSubmitBtn;

    public IndexPage(){
        PageFactory.initElements(driver, this);
    }

    public static void main(String[] args) {
        new IndexPage().book3DDesignSession();
    }
    public void book3DDesignSession() {
        launchApp();
        bookConsultation.click();
//        driver.findElement(By.xpath("//div[@class='Header_button__Ey_Mn undefined']")).click();
        enterMobileNumber.sendKeys(properties.getProperty("mobile"));
        enterName.sendKeys(properties.getProperty("name"));
        enterEmail.sendKeys(properties.getProperty("email"));
        enterPincode.sendKeys(properties.getProperty("pincode"));
        bookConsultation.click();
    }
    public void submitOTP(){
        OTP.sendKeys(properties.getProperty("otp"));
        otpSubmitBtn.click();
        return new
    }
}
