package OrderFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class KongaOrderFlowTests {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.konga.com/");

        Thread.sleep(5000);

        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Click on the SignIn/Signup button to sign in or register
       /* driver.findElement(By.xpath("//div[@class='_12e27_1r3kc']//a[1]")).click();
        //Enter your valid username
        driver.findElement(By.name("username")).sendKeys("emriky@gmail.com");
        //Enter your registered password
        driver.findElement(By.name("password")).sendKeys("bVuGmNLv");
        //Click on the log in button to sign in as a registered user
        driver.findElement(By.xpath("//div[@class='_2aac2_3bwnD _841f1_1RZK9']//button[1]")).click();
        //Create a new action "category" to enable mouse-hover pin point a web element "Home and Kitchen"
        Actions category = new Actions(driver);
        WebElement Home_Kitchen = driver.findElement(By.linkText("Home and Kitchen"));
        category.moveToElement(Home_Kitchen).build().perform();
        Thread.sleep(3500);
        //Click the sub-category "Top Brands"
        driver.findElement(By.linkText("Top Brands")).click();
        Thread.sleep(3500);*/
        //Enter the item you intend to purchase into the search box which is "Sunlight 2in1 Spring Sensations Handwash Washing Powder 2kg" in this case
        driver.findElement(By.xpath("//form[@class='f6ed2_25oVd']//input[@id='jsSearchInput']")).sendKeys("Sunlight 2in1 Spring Sensations Handwash Washing Powder 2kg");
        //Click on the search button to narrow down search of item in the search box
        driver.findElement(By.xpath("//section[@id='app-content-wrapper']//div//nav//div//div//div//div//form//button")).click();

        //Click on Add to Cart button to add item to cart
        Thread.sleep(3500);
        driver.findElement(By.cssSelector("div.ais-InstantSearch__root section.d6575_J-kZm._1eecb_eqPMu div.c6dfe_HidJc:nth-child(5) section._0863a_3x99A main._050ef_K0hT7 section._9cac3_2I9l4:nth-child(3) section.fc90c_2fTuR section._06822_e7mpG section._588b5_3MtNs ul.b49ee_2pjyI._58c31_2R34y._22339_3gQb9 li.bbe45_3oExY._22339_3gQb9 div.a2cf5_2S5q5.cf5dc_3HhOq div._4941f_1HCZm form:nth-child(2) div._2aac2_3bwnD._549f7_zvZ8u._49c0c_3Cv2D._977c5_2vBMq:nth-child(10) > button._0a08a_3czMG")).click();
        //Click on the My Cart menu to proceed to cart
        Thread.sleep(3500);
        driver.findElement(By.xpath("//a[contains(@class,'_79484_1sLEt _7ad32_SD12Y _16536_xxIKG')]//span[contains(text(),'My Cart')]")).click();
        //Increase the number of items in the cart to 4
        Thread.sleep(3500);
        driver.findElement(By.xpath("//button[contains(@name,'increment')]")).click();


    }
    public static void main(String[] args) throws InterruptedException {
        KongaOrderFlowTests test = new KongaOrderFlowTests();
        test.setUp();
    }
}
