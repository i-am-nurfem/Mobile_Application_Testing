import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class BaseSetup {


    /*
    Setting Explicit Wait is important in cases where there are certain elements that naturally take more time to load.
    If one sets an implicit wait command, then the browser will wait for the same time frame before loading every web element.
    This causes an unnecessary delay in executing the test script.
    */

    static WebDriver driver;
    static WebDriverWait wait;
    static TouchAction action;
    static LocalTime start, current_Time;
    static List<WebElement> list;
    static long differnce;
    static boolean done = false;
    static int start_Y, end_Y, empty_Economy_Seats, empty_Business_Seats, i = 0, layout = 0, available_Seat_Num, carriage_Num = 1, seat_Num = 1;
    //pass : to control the passenger number
    static int pass = 1, passenger_Num, woman_Num, man_Num, pet_Num, passenger_Type, ride_Choice, is_Reservation;
    static Dimension scrollViewRect;
    static WebElement name, surname, birth_Date_Bar, birth_Day, birth_Month, birth_Year,
            citizenship_ID, phone_Num, mail, password, OK_Button, calculate_Price, carriages, carriage, carriage_Seats, seat,
            _continue, ride_Hour, one_Way, round_Trip, buy_Ticket, departure_Date_Choice, return_Date, return_Date_Choice,
            pop_Up, ride, empty_Economy, empty_Business, from, station_Bar, from_Station_Choice,
            to, to_Station_Choice, departure_Date, plus_Button, choose_Ride_Btn, choose_Seat_Btn, reservation, down_Btn, up_Btn;


    public static void main(String[] args) throws Exception {

        ride_Choice = 1;
        is_Reservation = 2;
        passenger_Num = 1;


        TCDD_setUp();
        TCDD_Login();
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


    @Test
    public static void TCDD_Register() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        pop_Up.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement account_Logo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView"));
        account_Logo.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement new_Member = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[4]/android.widget.LinearLayout/android.widget.Button[1]"));
        new_Member.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        name = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText"));
        name.sendKeys("Merve Nurfem");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        surname = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText"));
        surname.sendKeys("Taysı");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
        mail.sendKeys("merve.nurfem@gmail.com");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement password = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.EditText"));
        password.sendKeys("Mnt.49450785822");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement repeat_Password = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.EditText"));
        repeat_Password.sendKeys("Mnt.49450785822");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        phone_Num = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.EditText"));
        phone_Num.sendKeys("05539491998");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement sex = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView"));
        sex.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement sex_Woman = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.CheckedTextView[2]"));
        sex_Woman.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        citizenship_ID = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.EditText"));
        citizenship_ID.sendKeys("49450785822");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        birth_Date_Bar = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
        birth_Date_Bar.click();
        birth_Day = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText"));
        birth_Day.sendKeys("17");
        birth_Month = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText"));
        birth_Month.sendKeys("Haz");
        birth_Year = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText"));
        birth_Year.sendKeys("1998");

        OK_Button = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        OK_Button.click();

        scrollViewRect = driver.manage().window().getSize();
        start_Y = (int) (scrollViewRect.getHeight() * 0.9);
        end_Y = (int) (scrollViewRect.getHeight() * 0.6);

        vertical_Scroll(scrollViewRect.getWidth() / 2, start_Y, scrollViewRect.getWidth() / 2, end_Y);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement register_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[9]/android.widget.RelativeLayout"));
        register_Btn.click();


        //eğer bilgiler yanlış girildiyse
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
            pop_Up.click();
        } finally {
            driver.navigate().back();
        }

    }

    @Test
    public static void TCDD_Login() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        pop_Up.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement account_Logo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView"));
        account_Logo.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.EditText"));
        mail.sendKeys("merve.nurfem@gmail.com");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        password = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.EditText"));
        password.sendKeys("Mnt.49450785822");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement login = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[3]"));
        login.click();

        /*
        //eğer bilgiler yanlış girildiyse
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
            pop_Up.click();
        }finally {
            driver.navigate().back();
        }
        */


        //aktivasyon yapılmamış ise çıkacak olan pop up
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
        //pop_Up.click();

        driver.navigate().back();
    }

    public static void choose_Seat() throws InterruptedException {
        while (true) {

            /***
             *   farklı vagon numaraları için durumu handle et
             */

            if (carriage_Num < 8) {
                carriage_Seats = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[" + carriage_Num + "]/android.widget.TextView[2]"));
                available_Seat_Num = Integer.parseInt(carriage_Seats.getText());

                //boş koltuklu sefere girdikten sonra boş koltukların bitip bitmeme durumuna bakıyorum
                if (available_Seat_Num == 0) {
                    //o vagonda boş yok, devam ediyorum
                    carriage_Num++;
                } else {
                    //bulunduğum vagonda boş koltuk var demek
                    //bulunduğum vagon numarasını ticket_Purchase() e parametre olarak vermem gerek
                    carriage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[" + carriage_Num + "]"));
                    carriage.click();

                    //  UiScrollable scrollable = new UiScrollable(new UiSelector().className(
                    //      android.widget.ListView.class).scrollable(true))
                    //      .setAsVerticalList();
                    //WebElement seat_No =  driver.findElement(MobileBy.androidUIAutomator("new UiScrollable(new UiSelector().xpath(/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.GridLayout/android.widget.Button[\" + seat_Num + \"]).enabled(true))"));
                    //System.out.println(seat_No.getText());

                    //WebElement seat_No1 =  driver.findElement(MobileBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"**/Put some text of scroll screen/**\").enabled(true)"));
                    //seat_No1.click();

                    //ThreadLocalDriver.getTLDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+element+"\").instance(0))"));


                    //koltuk seçimi
                    while (true) {

                        //Thread.sleep(100);
                        //list = driver.findElements(By.className("android.widget.Button"));

                        seat = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.GridLayout/android.widget.Button[" + seat_Num + "]"));

                        if (seat.isEnabled()) {
                                seat.click();
                                break;
                            } else {
                                seat_Num++;
                            }
                        }

                    }
                }

            OK_Button = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]"));
            OK_Button.click();

            //koltuk seçiminden sonra devam ediyorum.
            _continue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout"));
            _continue.click();

            name = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.EditText"));
            name.sendKeys("Merve Nurfem");

            surname = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.EditText"));
            surname.sendKeys("Taysı");


            //doğum tarihi
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            birth_Date_Bar = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
            birth_Date_Bar.click();
            birth_Day = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText"));
            birth_Day.sendKeys("17");
            birth_Month = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText"));
            birth_Month.sendKeys("Haz");
            birth_Year = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText"));
            birth_Year.sendKeys("1998");

            OK_Button = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
            OK_Button.click();

            citizenship_ID = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.EditText"));
            citizenship_ID.sendKeys("49450785822");

            phone_Num = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.EditText[1]"));
            phone_Num.sendKeys("05539491998");

            mail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.EditText[2]"));
            mail.sendKeys("merve.nurfem@gmail.com");

            //bir kere dönüyor
            break;
        }
    }


    public static void scrollToElement(AndroidDriver driver, String elementName, boolean scrollDown) {
        String listID = ((RemoteWebElement) driver.findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")"))).getId();

        String direction;
        if (scrollDown) {
            direction = "down";
        } else {
            direction = "up";
        }
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        scrollObject.put("element", listID);
        scrollObject.put("text", elementName);
        driver.executeScript("mobile: scrollTo", scrollObject);
    }

    public static void passenger_Info() {

        name = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.EditText"));
        name.sendKeys("Merve Nurfem");

        surname = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.EditText"));
        surname.sendKeys("Taysı");


        //doğum tarihi
                        /*
                        birth_Date_Bar = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
                        birth_Date_Bar.click();
                        birth_Day = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText"));
                        while(!Objects.equals(birth_Day.getText(), "17")){
                            down_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.Button[2]"));
                            down_Btn.click();
                        }
                        //birth_Day.sendKeys("17");

                        birth_Month = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText"));
                        while(!Objects.equals(birth_Month.getText(), "Haz")){
                            down_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.Button[2]"));
                            down_Btn.click();
                        }
                        //birth_Month.sendKeys("Haz");

                        birth_Year = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText"));
                        while(!Objects.equals(birth_Year.getText(), "1998")){
                            up_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.Button[1]"));
                            up_Btn.click();
                        }
                        //birth_Year.sendKeys("1998");

                        OK_Button = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
                        OK_Button.click();

                         */

        citizenship_ID = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.EditText"));
        citizenship_ID.sendKeys("49450785822");

        phone_Num = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.EditText[1]"));
        phone_Num.sendKeys("05539491998");

        mail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout[3]/android.widget.EditText[2]"));
        mail.sendKeys("merve.nurfem@gmail.com");
    }

    public static void ride_Direction(int ride_Choice) {

        //tek yön
        if (ride_Choice == 1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            one_Way = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioGroup/android.widget.RadioButton[1]"));
            one_Way.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            from = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]"));
            from.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            station_Bar = driver.findElement(By.id("tr.gov.tcdd.tasimacilik:id/etSearchStation"));
            station_Bar.sendKeys("ankara");

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            from_Station_Choice = driver.findElement(By.id("tr.gov.tcdd.tasimacilik:id/list_view"));
            from_Station_Choice.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            to = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[2]"));
            to.click();

            station_Bar.sendKeys("Söğüt");

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            to_Station_Choice = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[1]"));
            to_Station_Choice.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            departure_Date = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.RelativeLayout[4]/android.widget.TextView"));
            departure_Date.click();


        }
        //bu kısma tekrar bak
        //gidiş - dönüş
        else if (ride_Choice == 2) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            round_Trip = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioGroup/android.widget.RadioButton[2]"));
            round_Trip.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            from = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]"));
            from.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            station_Bar = driver.findElement(By.id("tr.gov.tcdd.tasimacilik:id/etSearchStation"));
            station_Bar.sendKeys("ankara");

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            from_Station_Choice = driver.findElement(By.id("tr.gov.tcdd.tasimacilik:id/list_view"));
            from_Station_Choice.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            to = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[2]"));
            to.click();

            station_Bar.sendKeys("Söğüt");

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            to_Station_Choice = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[1]"));
            to_Station_Choice.click();

            //gidiş butonu
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            departure_Date = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView"));
            departure_Date.click();

            //gidiş tarihi seçimi
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            departure_Date_Choice = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.RelativeLayout[4]/android.widget.TextView"));
            departure_Date_Choice.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            departure_Date = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.RelativeLayout[4]/android.widget.TextView"));
            departure_Date.click();

            //otomatik olarak dönüş kısmına atıyor ama yine de sağlama almış ol :)
            //dönüş butonu
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return_Date = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioGroup/android.widget.RadioButton[2]"));
            return_Date.click();

            //dönüş tarihi seçimi (farazi bi seçim yaptım, değiştir bunu daha sonra)
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return_Date_Choice = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.RelativeLayout[5]/android.widget.TextView"));
            return_Date_Choice.click();

        }
    }

    @Test
    public static void TCDD_Ticket_Purchase() throws Exception {

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //WebElement pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
        //pop_Up.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        buy_Ticket = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView"));
        buy_Ticket.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        one_Way = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioGroup/android.widget.RadioButton[1]"));
        one_Way.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        from = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]"));
        from.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        station_Bar = driver.findElement(By.id("tr.gov.tcdd.tasimacilik:id/etSearchStation"));
        station_Bar.sendKeys("ankara");

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        from_Station_Choice = driver.findElement(By.id("tr.gov.tcdd.tasimacilik:id/list_view"));
        from_Station_Choice.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        to = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[2]"));
        to.click();

        station_Bar.sendKeys("Söğüt");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        to_Station_Choice = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[1]"));
        to_Station_Choice.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        departure_Date = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.RelativeLayout[4]/android.widget.TextView"));
        departure_Date.click();

        //rezervasyon yok
        //normal sürece devam et

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        choose_Ride_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout"));
        choose_Ride_Btn.click();

        while (!done) {

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            ride = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.RelativeLayout[" + (layout + 1) + "]"));
            ride.click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            empty_Economy = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView[2]"));
            empty_Economy_Seats = Integer.parseInt(empty_Economy.getText());

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            empty_Business = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[2]"));
            empty_Business_Seats = Integer.parseInt(empty_Business.getText());

            //ilk bakışta boş koltuk varsa
            if (empty_Economy_Seats > 0 || empty_Business_Seats > 0) {
                choose_Seat_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout"));
                choose_Seat_Btn.click();

                carriages = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.Spinner"));
                carriages.click();

                choose_Seat();
                passenger_Info();

                calculate_Price = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout"));
                calculate_Price.click();

            }


            //else de ise boş koltuk olmayan seferde, son ana kadar boş koltuk olup olmadığını kontrol et
            else {
                while (true) {

                    ride_Hour = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ExpandableListView/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));

                    start = LocalTime.parse(ride_Hour.getText());
                    current_Time = LocalTime.now();

                    differnce = current_Time.until(start, ChronoUnit.SECONDS);

                    //kalkana kadar ss alacağım
                    File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                    //sefer saati geldi ya da boş koltuk kalmadı
                    if (differnce <= 0 /*|| (empty_Business_Seats == 0 && empty_Economy_Seats == 0 */) {
                        break;
                    }

                    if (empty_Business_Seats > 0 || empty_Economy_Seats > 0) {
                        choose_Seat_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout"));
                        choose_Seat_Btn.click();

                        choose_Seat();

                        //OK_Button = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]"));
                        //OK_Button.click();

                        //koltuk seçiminden sonra devam ediyorum.
                        _continue = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout"));
                        _continue.click();

                        passenger_Info();

                        //eğer bilgiler yanlış girildiyse
                        try {
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
                            pop_Up.click();
                        } finally {
                            OK_Button = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
                            OK_Button.click();
                        }
                        calculate_Price = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout"));
                        calculate_Price.click();


                    } else {
                        current_Time = LocalTime.now();
                        differnce = current_Time.until(start, ChronoUnit.SECONDS);

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
            System.out.println("bilet satin alindi");
        }
    }


    /*

        //kişi sayısını ayarlıyorum
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        plus_Button = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Arttır\"]"));
        //pass : to keep control of pass_Num
        while (pass <= passenger_Num) {
            plus_Button.click();
            pass++;
        }

        if (is_Reservation == 1) {
            //Rezervasyon
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            reservation = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Rezervasyon yapmak istiyorum\"]"));
            reservation.click();

            //belirtilen tarih için rezervasyon yapılmıyorsa çıkacak olan pop up
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button"));
            pop_Up.click();

            //programı sonlandır? Rezervasyonsuz devam et?

        } else {
            //rezervasyon yok

            //normal sürece devam et


            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            choose_Ride_Btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout"));
            choose_Ride_Btn.click();

        }

        //gerekli eklemeleri yapmayı unutma

    }

    //pop up çıkmazsa nasıl yapacak


    //geç saatlerdeki seferler için scroll
    //scrollViewRect = driver.manage().window().getSize();
    //start_Y = (int) (scrollViewRect.height * 0.9);
    //end_Y = (int) (scrollViewRect.height * 0.2);
    //vertical_Scroll(start_Y, end_Y);

*/
    static void vertical_Scroll(int from_X, int from_Y, int to_X, int to_Y) {


        action = new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(from_X, from_Y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(to_X, to_Y))
                .release();

    }

    @BeforeMethod
    public static void THY_setUp() throws MalformedURLException { //MalformedURLException: specifically, when the protocol that is provided is missing or invalid.

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy Alpha");
        caps.setCapability("udid", "4100b32e45b68177");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platfromVersion", "5.0.2");
        caps.setCapability("app", "C:\\Users\\manager\\Downloads\\Türk Hava Yolları Uçak Bileti_1.22.2_apkcombo.com.apk"); //
        caps.setCapability("appWaitForLaunch", false);
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);

        URL baseURL = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver(baseURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public static void THY_Register() throws InterruptedException {
        //thy register
        //wait.until(ExpectedConditions.visibilityOfElementLocated(thy_Logo)).click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        WebElement pop_Up = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.Button"));
        pop_Up.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(pop_Up)).click();
        //actions.moveToElement(pop_Up).click();


        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement hmbgr_Menu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Turkish Airlines\"]"));
        hmbgr_Menu.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(hmbgr_Menu)).click();
        //actions.moveToElement(hmbgr_Menu);


        //actions.moveToElement(login);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement login = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView"));
        login.click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //actions.moveToElement(register1);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(register1)).click();
        WebElement register1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.widget.Button[2]"));
        register1.click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //actions.moveToElement(sex);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(sex)).click();
        WebElement sex = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.View/android.view.View/android.view.View/android.widget.CheckBox[1]"));
        sex.click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //actions.moveToElement(lang_Selection);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(lang_Selection)).click();
        WebElement lang_Selection = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
        lang_Selection.click();
        //driver.findElements(By.id("com.turkishairlines.mobile:id/spinnerAdapter_tvText")).get(1).click();
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //actions.moveToElement(lang);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(lang)).click();
        WebElement lang = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"));
        lang.click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //actions.moveToElement(nationality_Selection);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(nationality_Selection)).click();
        WebElement nationality_Selection = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
        nationality_Selection.click();
        //driver.findElements(By.id("com.turkishairlines.mobile:id/spinnerAdapter_tvText")).get(1).click();

        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //actions.moveToElement(nationality);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(nationality)).click();
        WebElement nationality = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"));
        nationality.click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //actions.moveToElement(name);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys("Merve Nurfem");
        WebElement name = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"));
        name.sendKeys("Merve Nurfem");

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //actions.moveToElement(surname);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(surname)).sendKeys("Taysı");
        WebElement surname = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
        surname.sendKeys("Taysı");

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //actions.moveToElement(citizen_ID);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(citizen_ID)).sendKeys("49450785822");
        WebElement citizen_ID = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText"));
        citizen_ID.sendKeys("49450785822");


        /*
        WebElement date_Of_Birth = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.EditText"));
        date_Of_Birth.click();


        WebElement birth_Day = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText"));
        birth_Day.click();
        birth_Day.sendKeys("17");

        WebElement birth_Month = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText"));
        birth_Month.sendKeys("Haz");
        WebElement birth_Year = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText"));
        birth_Year.sendKeys("1998");//WebElement date_Of_Birth_Done = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[2]"));


        WebElement date_Of_Birth_Done = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[2]"));
        date_Of_Birth_Done.click();


         */

        /*
        wait.until(ExpectedConditions.visibilityOfElementLocated(date_Of_Birth)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(birth_Day)).sendKeys("17");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(birth_Month)).sendKeys("Haz");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(birth_Year)).sendKeys("1998");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(date_Of_Birth_Done)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        */


        //dimension of the current screen
        scrollViewRect = driver.manage().window().getSize();
        start_Y = (int) (scrollViewRect.height * 0.9);
        end_Y = (int) (scrollViewRect.height * 0.3);

        vertical_Scroll(scrollViewRect.getWidth() / 2, start_Y, scrollViewRect.getWidth() / 2, end_Y);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(adress_Type)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement adress_Type = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
        adress_Type.click();
        //driver.findElements(By.id("com.turkishairlines.mobile:id/spinnerAdapter_tvText")).get(1).click();

        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement home_Adress = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(home_Adress)).click();
        home_Adress.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(adress1)).sendKeys("Tepebaşı Mah. Foça Sok. Akman Apt. 33/3 Keçiören/Ankara");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement adress1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"));
        adress1.sendKeys("Tepebaşı Mah. Foça Sok. Akman Apt. 33/3 Keçiören/Ankara");

        //wait.until(ExpectedConditions.visibilityOfElementLocated(country_Selection)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement country_Selection = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
        country_Selection.click();

        //select = new Select(driver.findElement(By.id("00000000-0000-0982-7fff-ffff0000009a")));
        //select.selectByVisibleText("Türkiye");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(country)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement country = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"));
        country.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(city_Selection)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement city_Selection_Bar = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
        city_Selection_Bar.click();

        //select = new Select(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")));
        //select.selectByVisibleText("Ankara");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(city)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement city = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"));
        city.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(county_Selection)).click();


        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement county_Selection_Bar = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
        county_Selection_Bar.click();


        //wait.until(ExpectedConditions.visibilityOfElementLocated(city)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement county = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"));
        county.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(phone_Region_Selection)).click();


        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement phone_Region_Selection = driver.findElement(By.id("com.turkishairlines.mobile:id/frSignup_etMobilePhoneCode"));
        phone_Region_Selection.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(phone_Region)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement phone_Region = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.view.View/android.widget.FrameLayout[1]/android.widget.LinearLayout"));
        phone_Region.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(phone_Num)).sendKeys("5539491998");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement phone_Num = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
        phone_Num.sendKeys("5539491998");

        //wait.until(ExpectedConditions.visibilityOfElementLocated(email_Box)).sendKeys("merve.nurfem@gmail.com");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement email_Box = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.EditText"));
        email_Box.sendKeys("merve.nurfem@gmail.com");


        //dimension of the current screen
        scrollViewRect = driver.manage().window().getSize();
        start_Y = (int) (scrollViewRect.height * 0.9);
        end_Y = (int) (scrollViewRect.height * 0.3);

        vertical_Scroll(scrollViewRect.getWidth() / 2, start_Y, scrollViewRect.getWidth() / 2, end_Y);


        //wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("merve.nurfem");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement password = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText"));
        password.sendKeys("merve.nurfem");

        //wait.until(ExpectedConditions.visibilityOfElementLocated(password_Repetition)).sendKeys("merve.nurfem");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement password_Repetition = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
        password_Repetition.sendKeys("merve.nurfem");

        //wait.until(ExpectedConditions.visibilityOfElementLocated(safety_Q_Choice)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement safety_Q_Choice_Bar = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
        safety_Q_Choice_Bar.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(safety_Q)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement safety_Q_Choice = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]"));
        safety_Q_Choice.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(safety_A)).sendKeys("mina");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement safety_A = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText"));
        safety_A.sendKeys("nurşima");


        //dimension of the current screen
        scrollViewRect = driver.manage().window().getSize();
        start_Y = (int) (scrollViewRect.height * 0.9);
        end_Y = (int) (scrollViewRect.height * 0.2);

        vertical_Scroll(scrollViewRect.getWidth() / 2, start_Y, scrollViewRect.getWidth() / 2, end_Y);


        //wait.until(ExpectedConditions.visibilityOfElementLocated(check_Box_1)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement check_Box_1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.CheckBox"));
        check_Box_1.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(check_Box_2)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement check_Box_2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.CheckBox"));
        check_Box_2.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(check_Box_3)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement check_Box_3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.CheckBox"));
        check_Box_3.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(register2)).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement register2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button"));
        register2.click();

        //static By selection_Bar = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[1]/android.widget.Spinner");
        //static By _choice = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
        //static By _choice_ID = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
        //static By password = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.TextView");
        //static By sign_In = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.widget.Button[1]");


        /*

        //left: left coordinate of the scroll bounding area
        //top: top coordinate of the scroll bounding area
        //width: The width of the scroll bounding area
        //height: The height of the scroll bounding area
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 0, "top", 0, "width", 720, "height", 1280,
                "direction", "down",
                "percent", 3.0
        ));

        for (int i = 0; i < 5; i++) {
            if (canScrollMore) {

            } else
                break;
        }
        */

        /*
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 720, "height", 1280,
                "direction", "down",
                "percent", 3.0
        ));

         */

    }


    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }


}





