package com.doowup.page_objects;

import com.doowup.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {
    @FindBy(xpath = "//div[@class='Header_button__Ey_Mn undefined']")
    WebElement bookConsultation;
    @FindBy(xpath = "//div[@class='BannerLeadform_placeholder_form__bbgiI']//input[@id='phone']")
    WebElement enterMobileNumber;
    @FindBy(xpath = "//div[@class='BannerLeadform_placeholder_form__bbgiI']//input[@id='name']")
    WebElement enterName;
    @FindBy(xpath = "//div[@class='BannerLeadform_placeholder_form__bbgiI']//input[@id='email']")
    WebElement enterEmail;
    @FindBy(xpath = "//div[@class='BannerLeadform_placeholder_form__bbgiI']//input[@id='pincode']")
    WebElement enterPincode;
    @FindBy(xpath = "//div[@class='BannerLeadform_placeholder_form__bbgiI']//button[@id='button1']")
    WebElement book3DDesignBtn;
    @FindBy(xpath = "//div[@class='BannerLeadform_placeholder_form__bbgiI']//input[@id='otp']")
    WebElement OTP;
    @FindBy(xpath = "//div[@class='BannerLeadform_placeholder_form__bbgiI']//button[@id='submitOtpBtn']")
    WebElement otpSubmitBtn;

    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    public void book3DDesignSession() {
        bookConsultation.click();
        enterMobileNumber.sendKeys(properties.getProperty("mobile"));
        enterName.sendKeys(properties.getProperty("name"));
        enterEmail.sendKeys(properties.getProperty("email"));
        enterPincode.sendKeys(properties.getProperty("pincode"));
        book3DDesignBtn.click();
    }

    public BasicProfilePage submitOTP() {
        OTP.sendKeys(properties.getProperty("otp"));
        otpSubmitBtn.click();
        return new BasicProfilePage();
    }
}
