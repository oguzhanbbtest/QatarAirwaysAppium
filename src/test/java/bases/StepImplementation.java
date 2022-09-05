package bases;

import com.thoughtworks.gauge.Step;
import methods.Methods;
import pages.BookingPage;
import pages.FlyPage;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest{
    LoginPage loginPage = new LoginPage();
    Methods methods = new Methods();
    BookingPage bookingPage = new BookingPage();
    FlyPage flyPage = new FlyPage();


    @Step("Uygulamayı aç ve açıldığını kontrol edilir")
    public void appControl(){
        methods.waitBySeconds(8);
        loginPage = new LoginPage();
        loginPage.isAppOpen("Enable location services to fully personalise your experience");
    }

    @Step("Karsilama ekranı “Skip” seçeneği ile geçilir")
    public void skipScreen() {
        methods.waitBySeconds(5);
        loginPage.clickSkip();
    }
    @Step("Alt menüden “Book” tabına geçiş yapılır.")
    public void switchBookTab(){
        methods.waitBySeconds(8);
        loginPage.switchBookTab();
    }

    @Step("Seyehat tipi olarak “One Way” seçilir.")
    public void selectOneWay(){
        methods.waitBySeconds(5);
        bookingPage.selectTrip();
    }

    @Step("Kalkış havaalanı olarak Berlin seçilir.")
    public void selectDeparture(){
        methods.waitBySeconds(5);
        bookingPage.selectDeparture();
    }

    @Step("Varış havaalanı olarak Istanbul seçilir.")
    public void selectDestination(){
        methods.waitBySeconds(5);
        bookingPage.selectDestination();
    }
    @Step("Bugünün Tarihinde +7 gün olarak bir gidiş tarihi seçilir")
    public void selectFlyDay(){
        methods.waitBySeconds(4);
        bookingPage.selectFlyDay();
    }
    @Step("Arama butonuna tıklanır")
    public void selectFlySearch(){
        methods.waitBySeconds(3);
        bookingPage.clickFlySearchButton();
    }
    @Step("Uçuş seçim ekranının geldiği kontrol edilir")
    public void controlTheFlySelect(){
        methods.waitBySeconds(5);
        bookingPage.controlFlySelect();
    }
    @Step("Rastgele bir uçuş seçilir.")
    public void selectRandomFly(){
        methods.waitBySeconds(4);
        flyPage.selectRandomFly();
    }
    @Step("Economy class seçeneğine tıklanır")
    public void selectEconomyClass(){
        methods.waitBySeconds(5);
        flyPage.selectEconomyClass();
    }
    @Step("Uçuş seçim ekranındaki uçuş saati ile uçuş detayları ekranındaki uçuş saati değeri aynı mı kontrol edilir")
    public void controlFlyDetail(){
        methods.waitBySeconds(4);
        flyPage.controlFlyDetails();
        methods.waitBySeconds(3);
    }

    @Step("<time> saniye bekle")
    public void waitForsecond(int time) {
        methods.waitBySeconds(time);
    }

}
