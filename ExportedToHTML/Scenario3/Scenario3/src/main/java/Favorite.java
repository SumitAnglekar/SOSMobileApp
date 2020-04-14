import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Favorite extends JunitHTMLReporter {

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
    public void scenario1() throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "D:\\QA Testin\\chromedriver_win32\\chromedriver.exe");
        driver.get("https://myneu.neu.edu");

        Thread.sleep(2000);

        WebElement Go_To_Login_btn = driver.findElement(By.xpath("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_GhAIpHlwoE3O\"]/div/div/div/div[2]/div/div[2]/div/a"));
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case1/loginBefore.png");
        Go_To_Login_btn.click();

        Thread.sleep(2000);

        WebElement username = driver.findElement(By.id("username"));

        username.sendKeys("anglekar.s");

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.id("password"));

        password.sendKeys("Sumit@1998");
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case1/loginAfter.png");

        WebElement Login_btn = driver.findElement(By.xpath("/html/body/section/div/div[1]/div/form/div[3]/button"));

        Login_btn.click();

        Thread.sleep(12000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/section[1]/div/div[2]/a/img")));
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case1/homee_page.png");

        WebElement search = driver.findElement(By.xpath("/html/body/div/section[1]/div/div[2]/a/img"));
        search.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app-typeahead")));
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case1/search_tab_bar.png");

        WebElement service = driver.findElement(By.className("app-typeahead"));

        service.sendKeys("campus employment");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/div/div/div[1]/div/div[3]")));
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case1/add_campus_employment.png");
        Thread.sleep(2000);

        WebElement favourite = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/div/div/div[1]/div/div[3]"));
        favourite.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/a")));
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case1/add_to_favorite.png");

        Thread.sleep(2000);

        WebElement closetab = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/a"));
        closetab.click();
        Thread.sleep(1000);
        //driver.quit();
        //driver.quit();
    }

    @Test
    public void scenario3() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "D:\\QA Testin\\chromedriver_win32\\chromedriver.exe");
        driver.get("https://my.northeastern.edu/c/portal/login");
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/loginBefore.png");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("anglekar.s");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sumit@1998");
        Thread.sleep(1000);
        //Take a screenshoot of homepage
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/loginAfter.png");
        driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
        Thread.sleep(15000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/homepage.png");
        driver.findElement(By.xpath("//nav[@id='navigation']")).click();
        driver.findElement(By.xpath("//a[@href='https://my.northeastern.edu/group/student/services-links']")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/ServicesAndLinks.png");
        driver.findElement(By.xpath("//a[contains(text(),' Course Registration (NEW) ')]")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterSelectingServicesAndLinks.png");
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.xpath("//a[@id='classSearchLink']")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterClassSearchLink.png");
        driver.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/SelectingAnElement.png");
        driver.findElement(By.xpath("//div[@id='202050']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/BeforeClickingIS.png");
        driver.findElement(By.xpath("//input[@id='s2id_autogen1']")).sendKeys("Information Systems Program");
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/SearchingISP1.png");
        driver.findElement(By.xpath("//div[@id='INFO']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
        Thread.sleep(5000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/SearchingCourse.png");
        driver.findElement(By.xpath("//a[contains(text(),'Student')]")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/BeforePlanningLink.png");
        driver.findElement(By.xpath("//a[@id='planningLink']")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/SelectingPlanningLink.png");
        driver.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/SelectingGivenOption.png");
        driver.findElement(By.xpath("//div[@id='202050']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterContinuing.png");
        driver.findElement(By.xpath("//button[@id='createPlan']")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterCreatingAPlanforIt.png");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='s2id_autogen1']")).sendKeys("Information Systems Program");
        Thread.sleep(3000);
        //this.takeSnapShot(driver,"D:/QA Testin/ScreenShots/case3/rchingISP22.png");
        driver.findElement(By.xpath("//div[@id='INFO']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
        Thread.sleep(3000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/SearchingafterClick123.png");
        for (int i = 0; i < 3; i++) {
            driver.findElements(By.xpath("//button[contains(text(),'Add Course')]")).get(i).click();
            Thread.sleep(1000);
        }
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterAddingCourses.png");
        driver.findElement(By.xpath("//button[contains(text(),'Save Plan')]")).click();
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterClickingSavePlan.png");
        driver.findElement(By.xpath("//input[@id='txt_planDesc']")).sendKeys("selenium");
        Thread.sleep(1000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterTypingSelenium.png");
        driver.findElement(By.xpath("//button/span[contains(text(),'Save')]")).click();
        Thread.sleep(3000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterClickSave.png");
        driver.findElement(By.xpath("//a[contains(text(),'Select A Plan')]")).click();
        Thread.sleep(5000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterSelectingPlan.png");
        driver.close();
        driver.switchTo().window(winHandleBefore);
        Thread.sleep(10000);
    }

    @Test
    public void scenario_5_searchClass() throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "D:\\QA Testin\\chromedriver_win32\\chromedriver.exe");
        driver.get("https://my.northeastern.edu/c/portal/login");
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/loginBefore.png");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("anglekar.s");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sumit@1998");
        Thread.sleep(1000);
        //Take a screenshoot of homepage
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/loginAfter.png");
        driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
        Thread.sleep(15000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/homepage.png");
        driver.findElement(By.xpath("//nav[@id='navigation']")).click();
        driver.findElement(By.xpath("//a[@href='https://my.northeastern.edu/group/student/services-links']")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/ServicesAndLinks.png");
        driver.findElement(By.xpath("//a[contains(text(),' Course Registration (NEW) ')]")).click();
        Thread.sleep(2000);
        this.takeSnapShot(driver, "D:/QA Testin/ScreenShots/case3/AfterSelectingServicesAndLinks.png");
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

            //Navigate to Class Search Page
            driver.findElement(By.xpath("//*[@id=\"planningLink\"]/span[1]")).click();
            //this.takeSnapShot(driver,"/Users/star/Desktop/INFO 6225/ScreenShots/case3/classsearch.png");
            Thread.sleep(2000);

            //Choose a specific semester
            //To be solved ...
            driver.findElement(By.id("select2-chosen-1")).click();
            this.takeSnapShot(driver,"D:/QA Testin/ScreenShots/case5/list.png");
            driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Summer Full 2020 Semester");

            driver.findElement(By.cssSelector("#\\32 02110")).click();
            this.takeSnapShot(driver,"D:/QA Testin/ScreenShots/case5/choose_semester.png");
            driver.findElement(By.id("term-go")).click();
            Thread.sleep(5000);

            driver.findElement(By.id("createPlan")).click();
            Thread.sleep(2000);

//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-go")));
            this.takeSnapShot(driver,"D:/QA Testin/ScreenShots/case5/choose_class.png");
            Thread.sleep(2000);

            driver.findElement(By.id("search-go")).click();
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("results-title")));
            this.takeSnapShot(driver,"D:/QA Testin/ScreenShots/case5/final_result.png");
            Thread.sleep(2000);


        }

    @After
    public void afterTest() {
        driver.quit();
    }
}