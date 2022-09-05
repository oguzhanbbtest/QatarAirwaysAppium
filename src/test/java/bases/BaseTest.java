package bases;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected boolean localAndroid=true;
    private static final Logger logger= (Logger) LogManager.getLogger(BaseTest.class);
    @BeforeScenario
    public void StarScenario() throws MalformedURLException {
        if (localAndroid){
            logger.info("======================= TEST BASLIYOR ======================= ");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.m.qr");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.m.qr.home.onboarding.ui.OnBoardingActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver(url,desiredCapabilities);
        }else{
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"İos udid bilgisi girilecek");
            desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,"Ios Uygulamasına ait bundle id bilgisi girilecek");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Lokalde kullanılan cihazın ismi girilecek");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"Localde kullanılan cihazın versiyon bilgisi girilecek");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new IOSDriver(url,desiredCapabilities);
        }
    }
    @AfterScenario
    public void afterScenario(){
        appiumDriver.quit();
        logger.info("======================= TEST BITTI ======================= ");
    }
}
