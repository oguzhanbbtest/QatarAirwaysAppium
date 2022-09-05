package pages;

import bases.BaseTest;
import methods.Methods;
import org.openqa.selenium.By;

public class BookingPage extends BaseTest {
    Methods method = new Methods();
    By oneWayTrip = By.xpath("//android.widget.LinearLayout[@content-desc=\"One-way\"]/android.widget.TextView");
    By selectDeparturePlace = By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_holder_city_name_text_view");
    By selectBerlin = By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.m.qr:id/rvmp_item_ond_selection_list_text_view_holder\"])[1]");
    By selectDestinationPlace = By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_select_destination_text_view");
    By cityKey = By.xpath("//android.widget.TextView[@resource-id=\"com.m.qr:id/textinput_placeholder\"]");
    By selectIstanbul = By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.m.qr:id/rvmp_item_ond_selection_list_text_view_holder\"])[2]");
    By depFlyD = By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_departure_date_holder");
    By flyDay = By.xpath("(//android.widget.TextView[@resource-id=\"com.m.qr:id/rvmp_booking_calendar_day_text_view\"])[17]");
    By bookingConfrim = By.id("com.m.qr:id/fragment_calendar_confirm_button");
    By flySearchButton = By.id("com.m.qr:id/rvmp_booking_search_flights_button");
    By flyselectScreen = By.id("com.m.qr:id/booking_activity_conversational_message");

    public void selectTrip(){
        method.clickElement(oneWayTrip);
    }
    public void selectDeparture(){
        method.clickElement(selectDeparturePlace);
        method.clickElement(cityKey);
        method.sendKeys(selectDeparturePlace,"Berlin");
        method.clickElement(selectBerlin);
    }
   public void selectDestination(){
       method.clickElement(selectDestinationPlace);
       method.clickElement(cityKey);
       method.sendKeys(cityKey,"Istanbul");
       method.clickElement(selectIstanbul);
   }

   public void selectFlyDay(){
        method.clickElement(depFlyD);
        method.clickElement(flyDay);
        method.clickElement(bookingConfrim);
   }
   public void clickFlySearchButton(){
        method.clickElement(flySearchButton);
   }

    public void controlFlySelect() {
        method.controlElement(flyselectScreen,"Select your departure");
    }
}
