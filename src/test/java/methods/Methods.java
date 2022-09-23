package methods;

import bases.BaseTest;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Random;

public class Methods extends BaseTest {
    private static final Logger logger= (Logger) LogManager.getLogger(Methods.class);

    public void waitByMilliSeconds(long milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (milliSeconds % 1000 != 0)
            logger.info(milliSeconds + " milisaniye beklendi");
    }

    public void waitBySeconds(long seconds){
        waitByMilliSeconds(1000*seconds);
        logger.info(seconds + " saniye beklendi");
    }

    public void clickElement(By by){
        appiumDriver.findElement(by).click();
        logger.info(by.toString()+ " elementine tiklandi");
    }
    public void clickById(String id){
        appiumDriver.findElement(By.id(id)).click();
        System.out.println("Element tıklandı.");
    }

    public void clickByxpath(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
        System.out.println("Element tıklandı.");
    }

    public void sendKeys(By by , String text){
        appiumDriver.findElement(by).sendKeys(text);
        logger.info(appiumDriver.findElement(by) + " elementine " + text +" text'i yazdirildi"); // by.toString()

    }

    public void sendKeysByXpath(String xpath, String text){
        appiumDriver.findElement(By.xpath(xpath)).sendKeys(text);
        System.out.println(text +"değeri yazıldı");
    }

    public void controlElement(By by,String text){
        MobileElement element = appiumDriver.findElement(by);
        System.out.println("Alınan elementın text değeri " + element.getText());
        Assert.assertTrue("Verilen text değeri ile alınan text değeri eşit değil",element.getText().equals(text));
    }

    public void clickRandomElement(By by){
        List<MobileElement> elements = appiumDriver.findElements(by);
        System.out.println("Total elements : " + elements.size());
        Random rand = new Random();
        int index = rand.nextInt(elements.size()-1);
        System.out.println("idex====" + index);
        elements.get(index).click();
    }



}
