package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //Singleton driver class

    private static WebDriver driver;

    private Driver() {}// new keyword'u ile bu classtan obje oluşturulmasının önüne geçilir.

    public static WebDriver getDriver() {

        if (driver == null) {//Driver daha önce oluşturulmamış ise

            String browserParamFromEnv = System.getProperty("browser"); // null or any browser (firefox)
            String browser = browserParamFromEnv == null ? ConfigReader.getProperty("browser") : browserParamFromEnv;

            switch (browser) {

                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "chrome-headless":
                    System.out.println("browser = " + browser);
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
                    break;
                default:
                    driver = new ChromeDriver();

            }

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//Driver daha önce kapatılmamışsa

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            driver.quit();
            driver = null;//Kapanan drivera null ataması yaparak getDriver methodu ile tekrar çağrılabilmesini sağlıyoruz
        }
    }
}


