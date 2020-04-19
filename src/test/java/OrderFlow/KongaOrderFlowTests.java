package OrderFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.swing.*;
import java.awt.*;
import java.util.List;
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
        driver.findElement(By.xpath("//div[@class='_12e27_1r3kc']//a[1]")).click();
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
        Thread.sleep(3500);
        //Enter the item you intend to purchase into the search box which is "Sunlight 2in1 Spring Sensations Handwash Washing Powder 2kg" in this case
        driver.findElement(By.xpath("//form[@class='f6ed2_25oVd']//input[@id='jsSearchInput']")).sendKeys("Sunlight 2in1 Spring Sensations Handwash Washing Powder 2kg");
        //Click on the search button to narrow down search of item in the search box
        driver.findElement(By.xpath("//section[@id='app-content-wrapper']//div//nav//div//div//div//div//form//button")).click();

        //Click on Add to Cart button to add item to cart
        Thread.sleep(3500);
        driver.findElement(By.xpath("(//div[contains(@class,'_2aac2_3bwnD _549f7_zvZ8u')]//button)[2]")).click();
        Thread.sleep(3500);
        driver.findElement(By.xpath("//a[contains(@class,'_79484_1sLEt _7ad32_SD12Y _16536_xxIKG')]//span[contains(text(),'My Cart')]")).click();
        //Increase the number of items in the cart to 4
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(@name,'increment')]")).click();
        driver.findElement(By.xpath("//button[contains(@name,'increment')]")).click();
        driver.findElement(By.xpath("//button[contains(@name,'increment')]")).click();
        //Click on Check out button to proceed to payment options
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
        //Click on the Pay Now option check button to enable continue to check out
        Thread.sleep(2000);
        driver.findElement(By.name("selectPaymentMethod")).click();
        //Click on the Continue to Payment Button
        Thread.sleep(2000);
        driver.findElement(By.name("placeOrder")).click();
        //Locate the iFrame
        Thread.sleep(2000);
        driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        //Switch into iFrame by id locator
        driver.switchTo().frame("kpg-frame-component");
        //Click on the card within the iFrame
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='channel-template']/div[2]/div/div[1]/button/div/span[1]")).click();
       //Input Your Card details
        driver.findElement(By.id("card-number")).sendKeys("5569 4051 1277 3449");
        driver.findElement(By.id("expiry")).sendKeys("10/21");
        driver.findElement(By.id("cvv")).sendKeys("500");
        driver.findElement(By.id("save-card-container")).sendKeys("1234");
        //Click on the Pay Now button to pay for items
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='validateCardForm']")).click();






    }







    public static void main(String[] args) throws InterruptedException {
        KongaOrderFlowTests test = new KongaOrderFlowTests();
        test.setUp();
    }
}
