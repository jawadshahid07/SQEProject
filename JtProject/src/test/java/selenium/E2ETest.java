package selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E2ETest {

    private static ExtentReports extent;
    @BeforeAll
    public static void setUp() {
        // Specify the path for the Extent HTML report
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    @Test
    public void testAddCategory()  {

        System.setProperty("webdriver.chrome.driver", "C:/Users/jawad/IdeaProjects/SQEProject/JtProject/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/admin/login");

        //login page
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();

        //admin dashboard
        driver.findElement(By.cssSelector("a.card-link.btn.btn-primary")).click();

        //categories page
        driver.findElement(By.cssSelector("button.btn.btn-primary[data-toggle=\"modal\"][data-target=\"#exampleModalCenter\"]")).click();
        //add category
        String categoryName = "testCategory";
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        driver.findElement(By.id("name")).sendKeys(categoryName);
        driver.findElement(By.cssSelector("input[type='submit'][value='Save Changes'].btn.btn-primary")).click();
        // verify if category is added
        WebElement tableBody = driver.findElement(By.cssSelector("table.table tbody"));
        boolean isCategoryAdded = isElementPresentInTable(tableBody, categoryName);

        //now delete the added category
        String addedCategoryId = getCategoryId(driver, categoryName);
        String cssSelector = "input[name='id'][value='" + addedCategoryId + "'] + input.btn.btn-danger";
        driver.findElement(By.cssSelector(cssSelector)).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("a.nav-link[href='logout']")).click();
        driver.quit();

        // reports
        ExtentTest test = extent.createTest("Test Case: testAddCategory");
        if (isCategoryAdded) {
            test.pass("Category added successfully");
        } else {
            test.fail("Failed to add category");
        }

        // Assert that the category is present in the table
        assertTrue(isCategoryAdded);


    }
    @Test
    public void testLogin()  {

        System.setProperty("webdriver.chrome.driver", "C:/Users/jawad/IdeaProjects/SQEProject/JtProject/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/admin/login");

        //login page
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();

        // reports
        ExtentTest test = extent.createTest("Test Case: testLogin");
        if (driver.findElement(By.cssSelector("h1.display-4\n")).getText().equals("Welcome Back, Admin")) {
            test.pass("Login Successful");
        }
        else {
            test.fail("Login Failed");
        }

        driver.quit();


    }
    @AfterAll
    public static void tearDown() {

        extent.flush();
    }


    private boolean isElementPresentInTable(WebElement tableBody, String elementText) {
        java.util.List<WebElement> rows = tableBody.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(elementText)) {
                    return true;
                }
            }
        }

        return false;
    }

    private String getCategoryId(WebDriver driver, String categoryName) {
        WebElement tableBody = driver.findElement(By.cssSelector("table.table tbody"));
        java.util.List<WebElement> rows = tableBody.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            java.util.List<WebElement> cells = row.findElements(By.tagName("td"));

            WebElement categoryNameElement = cells.get(1);
            String currentCategoryName = categoryNameElement.getText().trim();

            if (currentCategoryName.equals(categoryName)) {
                WebElement categoryIdElement = cells.get(0);
                return categoryIdElement.getText().trim();
            }
        }

        return "Category ID not found";
    }
}
