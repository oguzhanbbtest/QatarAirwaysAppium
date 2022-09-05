package pages;

import bases.BaseTest;
import methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {
    Methods method = new Methods();
    By loginScreenElement = By.id("com.m.qr:id/main_text");
    private final static By skipButton = By.id("com.m.qr:id/skip_button");
    By onboardingSkip = By.id("com.m.qr:id/onboarding_skip_button");
    By consentDecline = By.id("com.m.qr:id/push_consent_decline");
    By bookTab = By.xpath("//android.widget.FrameLayout[@content-desc=\"Book\"]/android.widget.FrameLayout/android.widget.ImageView");

    public void isAppOpen(String text){
        String element = appiumDriver.findElement(loginScreenElement).getText();
        Assert.assertTrue("Uygulama açıldığında location Servis yazısı çıkmıyor",element.equals(text));
        appiumDriver.findElement(loginScreenElement).isDisplayed();
    }

    public void clickSkip() {
        method.clickElement(skipButton);
        method.waitBySeconds(8);
        method.clickElement(onboardingSkip);
        method.waitBySeconds(8);
        method.clickElement(consentDecline);

    }

    public void switchBookTab() {
        method.clickElement(bookTab);
    }
}
