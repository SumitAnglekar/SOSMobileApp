import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import java.io.File;
import java.io.IOException;

public class SOS extends JunitHTMLReporter {

    private static WebDriver driver;
    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver","D:\\QA Testin\\chromedriver_win32\\chromedriver.exe");
        driver= new ChromeDriver();
        System.out.println("Driver"+driver);
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        System.out.println(SrcFile.getAbsolutePath());
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        System.out.println(DestFile.getPath());
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            System.err.println("n IOException was caught :" + e.getMessage());
        }
    }

    @Test
    public void SignUp() throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "D:\\QA Testin\\chromedriver_win32\\chromedriver.exe");
        driver.get("C:\\Users\\Sumit\\OneDrive\\Desktop\\UIUXImages\\onboardingpage.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[9]/img")).click();
        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/onboardingScreen.png");
        Thread.sleep(2000);


        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/onboardingScreenLocationTrack.png");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div[6]/img")).click();
        Thread.sleep(2000);


        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/onboardingDm.png");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div[16]/img")).click();
        Thread.sleep(2000);


        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/getStarted.png");
        driver.findElement(By.xpath(" /html/body/div[1]/div[4]/div/p/span")).click();
        Thread.sleep(2000);

        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/selectRole.png");
        driver.findElement(By.xpath("  /html/body/div/div[3]/div")).click();
        Thread.sleep(2000);

        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/adminLoginPage.png");
        driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div[10]/div[2]/p/span")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div[9]/input")).sendKeys("Sumit");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[10]/input")).sendKeys("Sumit");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div[16]/div/p/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[9]/input")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[10]/input")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[9]/input")).sendKeys("Admin");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[10]/input")).sendKeys("Admin");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[11]/input")).sendKeys("1111111111");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[12]/input")).sendKeys("admin@us.org");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[13]/input")).sendKeys("Admin@123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[14]/input")).sendKeys("Admin@123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[16]/div/p/span")).click();
        Thread.sleep(2000);
    }

@Test
    public void SignIn() throws InterruptedException {
    driver.get("C:\\Users\\Sumit\\OneDrive\\Desktop\\UIUXImages\\onboardingpage.html");
    driver.manage().window().maximize();
    Thread.sleep(1000);

    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[9]/img")).click();
    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/onboardingScreen.png");
    Thread.sleep(2000);


    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/onboardingScreenLocationTrack.png");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div[6]/img")).click();
    Thread.sleep(2000);


    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/onboardingDm.png");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div[16]/img")).click();
    Thread.sleep(2000);


    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/getStarted.png");
    driver.findElement(By.xpath(" /html/body/div[1]/div[4]/div/p/span")).click();
    Thread.sleep(2000);

    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/selectRole.png");
    driver.findElement(By.xpath("  /html/body/div/div[3]/div")).click();
    Thread.sleep(2000);

    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/adminLoginPageBefore.png");
    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/input")).sendKeys("sumit@us.org");
    Thread.sleep(2000);

    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[4]/input")).sendKeys("Sumit@123");
    Thread.sleep(2000);
    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/adminLoginPageAfter.png");

    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[5]/div/p/span")).click();
    Thread.sleep(5000);

    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/input")).clear();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[4]/input")).clear();
    Thread.sleep(2000);

    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/adminLoginPageBefore.png");
    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/input")).sendKeys("admin@us.org");
    Thread.sleep(2000);

    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[4]/input")).sendKeys("Admin@123");
    Thread.sleep(2000);
    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/adminLoginPageAfter.png");

    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[5]/div/p/span")).click();
    Thread.sleep(2000);
    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/adminOTPBefore.png");

    driver.findElement(By.xpath(" /html/body/div[1]/div[4]/input")).sendKeys("5");
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[5]/input")).sendKeys("2");
    Thread.sleep(1000);
    driver.findElement(By.xpath(" /html/body/div[1]/div[6]/input")).sendKeys("6");
    Thread.sleep(1000);
    driver.findElement(By.xpath(" /html/body/div[1]/div[7]/input")).sendKeys("3");
    Thread.sleep(1000);
    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/adminOTPAfter.png");

    driver.findElement(By.xpath(" /html/body/div[1]/div[8]/div/p/span")).click();
    Thread.sleep(1000);
    this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/adminOTPBefore.png");

    Thread.sleep(5000);
}

    @Test
    public void ForgotPassword() throws InterruptedException {
        driver.get("C:\\Users\\Sumit\\OneDrive\\Desktop\\UIUXImages\\onboardingpage.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[9]/img")).click();
        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/onboardingScreen.png");
        Thread.sleep(2000);


        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/onboardingScreenLocationTrack.png");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div[6]/img")).click();
        Thread.sleep(2000);


        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/onboardingDm.png");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div[16]/img")).click();
        Thread.sleep(2000);


        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/getStarted.png");
        driver.findElement(By.xpath(" /html/body/div[1]/div[4]/div/p/span")).click();
        Thread.sleep(2000);

        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/selectRole.png");
        driver.findElement(By.xpath("  /html/body/div/div[3]/div")).click();
        Thread.sleep(2000);

        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/selectRole.png");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[7]/div[2]/p/span")).click();
        Thread.sleep(2000);

        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/forgotPassword.png");
        driver.findElement(By.xpath("/html/body/div/div[11]/input")).sendKeys("1111111111");
        Thread.sleep(2000);

        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/forgotPassword.png");
        driver.findElement(By.xpath("/html/body/div/div[4]/div/p/span")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(" /html/body/div[1]/div[4]/input")).sendKeys("5");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/input")).sendKeys("2");
        Thread.sleep(1000);
        driver.findElement(By.xpath(" /html/body/div[1]/div[6]/input")).sendKeys("6");
        Thread.sleep(1000);
        driver.findElement(By.xpath(" /html/body/div[1]/div[7]/input")).sendKeys("3");
        Thread.sleep(1000);
        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/adminOTPAfter.png");

        driver.findElement(By.xpath(" /html/body/div[1]/div[8]/div/p/span")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[1]/div[11]/input")).sendKeys("Admin@123");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[1]/div[13]/input")).sendKeys("Admin@123");
        Thread.sleep(1000);

        this.takeSnapShot(driver, "C:/Users/Sumit/OneDrive/Desktop/UIUXImages/Page Screenshots/afterEnteringNewPassword.png");
        driver.findElement(By.xpath("/html/body/div/div[3]/div/p/span")).click();
        Thread.sleep(1000);

    }


    @After
    public void afterTest() {
        driver.quit();
    }
}