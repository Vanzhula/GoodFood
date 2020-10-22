
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetings {
    public ChromeDriver driver;

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","d:/AutoTests/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("The buy food of Goodfood is started");
    }

    @After
    public void clous (){
        System.out.println("The buy food of Goodfood is finished");
        driver.quit();
    }

}
