import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TCDD {

    static WebDriver driver; static WebDriverWait wait; static TouchAction action;
    static LocalTime start, current_Time; static long difference;
    static boolean done = false; static File ss;
    static List<WebElement> list;
    static int start_Y, end_Y, empty_Economy_Seats, empty_Business_Seats, /* i alınan ss ler için index numarası */ i = 0, layout = 0, carriage_Num, available_Seat_Num;
    static Dimension scrollViewRect;
    static WebElement name, surname, birth_Date_Bar, birth_Day, birth_Month, birth_Year, account_Logo, new_Member, login, register_Btn,
            citizenship_ID, phone_Num, mail, password, OK_Button, ride_Hour, one_Way, buy_Ticket, carriage_Seats, carriage, choose_Seat_Btn, carriages,
            pop_Up, ride, empty_Economy, empty_Business, from, station_Bar, from_Station_Choice,
            to, to_Station_Choice, departure_Date, choose_Ride_Btn, sex, sex_Woman;


    public static void main(String[] args) throws Exception {


        TCDD_setUp();
        TCDD_Ticket_Purchase();

        tearDown();

    }

    @BeforeMethod
    public static void TCDD_setUp() throws MalformedURLException { //MalformedURLException: specifically, when the protocol that is provided is missing or invalid.

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "Galaxy Alpha");
        caps.setCapability("udid", "4100b32e45b68177");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platfromVersion", "5.0.2");
        caps.setCapability("app", "C:\\Users\\manager\\Downloads\\TCDD Taşımacılık Eybis_2.0.0_apkcombo.com.apk");
        caps.setCapability("appWaitForLaunch", false);
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);

        caps.setCapability("appium:connectHardwareKeyboard", true);

        URL baseURL = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(baseURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }

    //registration as woman
    @Test
    public static void TCDD_Register() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        pop_Up.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        account_Logo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView"));
        account_Logo.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        new_Member = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[4]/android.widget.LinearLayout/android.widget.Button[1]"));
        new_Member.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        name = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText"));
        name.sendKeys(/*buraya adınızı girinz*/);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        surname = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText"));
        surname.sendKeys(/*buraya soyadınızı girinz*/);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
        mail.sendKeys(/*buraya mailinizi girinz*/);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        password = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.EditText"));
        password.sendKeys(/*buraya şifrenizi girinz*/);

        //repeating password
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        password = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.EditText"));
        password.sendKeys(/*buraya şifrenizi tekrar girinz*/);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        phone_Num = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.EditText"));
        phone_Num.sendKeys(/*buraya telefon numaranızı girinz*/);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        sex = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView"));
        sex.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        sex_Woman = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.CheckedTextView[2]"));
        sex_Woman.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        citizenship_ID = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.EditText"));
        citizenship_ID.sendKeys(/*buraya tc kimlik numaranızı girinz*/);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        birth_Date_Bar = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
        birth_Date_Bar.click();
        birth_Day = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText"));
        birth_Day.sendKeys(/*buraya doğduğunuz günü girinz*/);
        birth_Month = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText"));
        birth_Month.sendKeys(/*buraya doğduğunuz ayı girinz*/);
        birth_Year = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText"));
        birth_Year.sendKeys(/*buraya doğduğunuz yılı girinz*/);

        OK_Button = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        OK_Button.click();

        scrollViewRect = driver.manage().window().getSize();
        start_Y = (int) (scrollViewRect.getHeight() * 0.9);
        end_Y = (int) (scrollViewRect.getHeight() * 0.6);

        vertical_Scroll(scrollViewRect.getWidth() / 2, start_Y, scrollViewRect.getWidth() / 2, end_Y);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        register_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[9]/android.widget.RelativeLayout"));
        register_Btn.click();


        //eğer bilgiler yanlış girildiyse
        /*
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
            pop_Up.click();
        } finally {
            driver.navigate().back();
        }
        */

    }

    @Test
    public static void TCDD_Login() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        pop_Up.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        account_Logo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView"));
        account_Logo.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.EditText"));
        mail.sendKeys(/*buraya mailinizi girinz*/);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        password = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.EditText"));
        password.sendKeys(/*buraya şifrenizi girinz*/);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        login = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[3]"));
        login.click();

        //eğer bilgiler yanlış girildiyse veya aktivasyon yapılmamış ise çıkacak olan pop up
        /*
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
            pop_Up.click();
        }finally {
            driver.navigate().back();
        }
        */

        driver.navigate().back();
    }

    @Test
    public static void TCDD_Ticket_Purchase() throws Exception  {

        //main de login fonksiyonu ile çalışıtırılmayacaksa TCDD_Ticket_Purchase()
        //buradaki yorum satırları açılmalı
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        pop_Up.click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        buy_Ticket = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView"));
        buy_Ticket.click();

        //buradna itibaren tek yön ve sefer saati seçimi
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        one_Way = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioGroup/android.widget.RadioButton[1]"));
        one_Way.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        from = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]"));
        from.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        station_Bar = driver.findElement(By.id("tr.gov.tcdd.tasimacilik:id/etSearchStation"));
        station_Bar.sendKeys(/*buraya bulunduğunuz şehri girinz*/);

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        from_Station_Choice = driver.findElement(By.id("tr.gov.tcdd.tasimacilik:id/list_view"));
        from_Station_Choice.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        to = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[2]"));
        to.click();

        station_Bar.sendKeys(/*buraya gideceğiniz şehri girinz*/);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        to_Station_Choice = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[1]"));
        to_Station_Choice.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        departure_Date = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.RelativeLayout[3]/android.widget.TextView"));
        departure_Date.click();

        //rezervasyon yok
        //normal sürece devam et

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        choose_Ride_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout"));
        choose_Ride_Btn.click();

        /*
        try{
            //sefer yok pop up
            pop_Up = driver.findElement(By.xpath("hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
            pop_Up.click();

        }finally {
            //tekrar bak bu kısma
            choose_Ride_Btn.click();
        }

         */

        while (!done) {

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            ride = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.RelativeLayout[3]"));
            ride.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            empty_Economy = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView[2]"));
            empty_Economy_Seats = Integer.parseInt(empty_Economy.getText());

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            empty_Business = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[2]"));
            empty_Business_Seats = Integer.parseInt(empty_Business.getText());

            //ilk bakışta boş koltuk varsa
            if (empty_Economy_Seats + empty_Business_Seats > 2) {

                choose_Seat_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout"));
                choose_Seat_Btn.click();

                carriages = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.Spinner"));
                carriages.click();

                while (true) {

                /***
                 *   farklı vagon numaraları için durumu handle et
                 */

                if (carriage_Num < 6) {
                    carriage_Seats = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[" + carriage_Num + "]/android.widget.TextView[2]"));
                    available_Seat_Num = Integer.parseInt(carriage_Seats.getText());

                    //boş koltuklu sefere girdikten sonra boş koltukların bitip bitmeme durumuna bakıyorum
                    if (available_Seat_Num == 0) {
                        //o vagonda boş yok, devam ediyorum
                        carriage_Num++;
                    } else {
                        //bulunduğum vagonda boş koltuk var demek

                        //boş olan yerin satırı
                        //carriage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[" + carriage_Num + "]"));

                        //boş olan yerin vagon numarası
                        carriage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[" + carriage_Num + "]/android.widget.TextView[1]"));
                        //boş koltuk olduğuna dair
                        System.out.println("bos koltuk var ->" + carriage.getText());
                        break;
                    }
                }


                //boş koltuk olduğuna dair ss
                ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(ss, new File((i + 1) + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
                i++;

                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

            }
            }
            //else de ise boş koltuk olmayan seferde, son ana kadar boş koltuk olup olmadığını kontrol et
            else {
                while (true) {

                    ride_Hour = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));

                    start = LocalTime.parse(ride_Hour.getText());
                    current_Time = LocalTime.now();

                    difference = current_Time.until(start, ChronoUnit.SECONDS);

                    //sefer saati geldi ya da boş koltuk kalmadı
                    if (difference <= 0 /*|| (empty_Business_Seats == 0 && empty_Economy_Seats == 0 */) {
                        break;
                    }

                    if (empty_Business_Seats + empty_Economy_Seats > 2) {

                        choose_Seat_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout"));
                        choose_Seat_Btn.click();

                        carriages = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.Spinner"));
                        carriages.click();

                        while (true) {

                            /***
                             *   farklı vagon numaraları için durumu handle et
                             */

                            if (carriage_Num < list.size()) {
                                carriage_Seats = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[" + carriage_Num + "]/android.widget.TextView[2]"));
                                available_Seat_Num = Integer.parseInt(carriage_Seats.getText());

                                //boş koltuklu sefere girdikten sonra boş koltukların bitip bitmeme durumuna bakıyorum
                                if (available_Seat_Num == 0) {
                                    //o vagonda boş yok, devam ediyorum
                                    carriage_Num++;
                                } else {
                                    //bulunduğum vagonda boş koltuk var demek

                                    //boş olan yerin satırı
                                    //carriage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[" + carriage_Num + "]"));

                                    //boş olan yerin vagon numarası
                                    carriage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[" + carriage_Num + "]/android.widget.TextView[1]"));
                                    //boş koltuk var olduğuna dair
                                    System.out.println("bos koltuk var -> " + carriage.getText());
                                    break;
                                }
                            }


                        ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        //boş koltuk olduğuna dair ss
                        FileUtils.copyFile(ss, new File((i + 1) + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
                        i++;

                        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);


                    } }
                    else {
                        current_Time = LocalTime.now();
                        difference = current_Time.until(start, ChronoUnit.SECONDS);

                        ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        FileUtils.copyFile(ss, new File((i + 1) + ".jpg"), StandardCopyOption.COPY_ATTRIBUTES);
                        i++;
                    }

                    driver.navigate().back();
                    choose_Ride_Btn.click();

                    ride = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.RelativeLayout[" + (layout + 1) + "]"));
                    ride.click();

                    empty_Economy = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView[2]"));
                    empty_Economy_Seats = Integer.parseInt(empty_Economy.getText());

                    empty_Business = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[2]"));
                    empty_Business_Seats = Integer.parseInt(empty_Business.getText());

                }

            }
            done = true;
        }
        System.out.println("bilet satin alindi");
    }

    static void vertical_Scroll(int from_X, int from_Y, int to_X, int to_Y) {


        action = new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(from_X, from_Y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(to_X, to_Y))
                .release();

    }



}
