package pages;

import bases.BaseTest;
import methods.Methods;
import org.openqa.selenium.By;


public class FlyPage extends BaseTest {

    Methods method;
    By fly = By.id("com.m.qr:id/rvmp_item_search_result_root_view");
    By selectEco = By.id("com.m.qr:id/fragment_rtow_flight_cabin_class_text_view");
    By clickEcoButton = By.xpath("(//android.widget.RadioButton[@resource-id='com.m.qr:id/cabin_selection_row_radio_button'])[1]");
    By flyTime = By.id("com.m.qr:id/to_time");
    public void selectRandomFly() {
        method.clickRandomElement(fly);
    }

    public void selectEconomyClass() {
        method.clickElement(selectEco);
        method.waitBySeconds(3);
        method.clickElement(clickEcoButton);
    }

    public void controlFlyDetails() {
        method.controlElement(flyTime,"13:10");
    }
}
