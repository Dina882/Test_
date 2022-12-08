package order;
import pageObject.OrderElements;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.containsString;

public class MakeOrder {
    private WebDriver driver;

    @Before
    public void setUp() { //выбираем браузер
        driver = new ChromeDriver();
//      driver = new FirefoxDriver(); //для проверки браузера Firefox
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void firstСheck() {
        OrderElements objOrderElements = new OrderElements(driver);
        objOrderElements.open();
        objOrderElements.clickCookieButton(); // клик на кнопку "Заказать"
        objOrderElements.clickButtonUpOrder(); // Заказ через верхнюю кнопку "Заказать"
        objOrderElements.fillFirstPage("Иван", "Иванов", "Фонтанная 1, 10", "+79221234567"); // заполнение данных
        objOrderElements.fillSecondPage("Домофон не работает"); // подтверждение оформления заказа
        objOrderElements.clickYesButton();
        String actualOrderText = objOrderElements.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }
    @Test
    public void secondСheck() {
        OrderElements objOrderElements = new OrderElements(driver);
        objOrderElements.open();
        objOrderElements.clickCookieButton(); // Скроллим
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); // Заказ через нижнюю кнопку "Заказать"
        objOrderElements.clickButtonDownOrder();
        objOrderElements.fillFirstPage("Иванка", "Петрова", "Красная 25, 5", "+79125896347"); // заполнение данных
        objOrderElements.fillSecondPage("Communication is disabled"); // подтверждение оформления заказа
        objOrderElements.clickYesButton();
        String actualOrderText = objOrderElements.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }

    @After
    public void teardown() {
        driver.quit(); // Закрытие браузера
    }

}

