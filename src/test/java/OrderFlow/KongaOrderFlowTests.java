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
        //Click the sub-cateory "Top Brands"
        driver.findElement(By.linkText("Top Brands")).click();
        Thread.sleep(3500);
        //Enter the item you intend to purchase into the search box which is "Sunlight 2in1 Spring Sensations Handwash Washing Powder 2kg" in this case
        driver.findElement(By.xpath("//form[@class='f6ed2_25oVd']//input[@id='jsSearchInput']")).sendKeys("Sunlight 2in1 Spring Sensations Handwash Washing Powder 2kg");
        Thread.sleep(3500);
        //Click on the search button to narrow down search of item in the search box
        driver.findElement(By.xpath("//section[@id='app-content-wrapper']//div//nav//div//div//div//div//form//button")).click();
        Thread.sleep(3500);
        //Click on item to add to cart and proceed to MyCart menu
        driver.findElement(By.xpath("//h3[contains(text(),'Sunlight 2in1 Spring Sensations Handw...')]")).click();
        Thread.sleep(3500);
        //Click on the increment button 3(three) times to increase the number of selected item in the cart to 4
        driver.findElement(By.xpath("//body//div[@id='__next']//div//div//div//div//div//div//div//div//div[1]//div[1]//button[2]")).click();
        driver.findElement(By.xpath("//body//div[@id='__next']//div//div//div//div//div//div//div//div//div[1]//div[1]//button[2]")).click();
        driver.findElement(By.xpath("//body//div[@id='__next']//div//div//div//div//div//div//div//div//div[1]//div[1]//button[2]")).click();
        Thread.sleep(1500);
        //Click on the the "Buy Now" button to update items in the Cart
        driver.findElement(By.xpath("(//button[@class='_0a08a_3czMG _6d187_pzjfk'])[2]")).click();

    }
    public static void main(String[] args) throws InterruptedException {
        KongaOrderFlowTests test = new KongaOrderFlowTests();
        test.setUp();
    }
}
