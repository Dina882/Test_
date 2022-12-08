package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private final String url = "https://qa-scooter.praktikum-services.ru/"; // url входа
    private final By howMuch = By.xpath(".//div[@id='accordion__heading-0']");     // вопрос "Сколько это стоит? И как оплатить?"
    private final By answerHowMuch = By.id("accordion__panel-0");     // ответ на вопрос
    private final By wantSeveralScooters = By.xpath(".//div[@id='accordion__heading-1']");     // вопрос "Хочу сразу несколько самокатов! Так можно?"
    private final By answerSeveralScooters = By.id("accordion__panel-1");     // ответ вопрос
    private final By howRentalTimeCalculated = By.xpath(".//div[@id='accordion__heading-2']");     // вопрос "Как рассчитывается время аренды?"
    private final By answerHowRentalTimeCalculated = By.id("accordion__panel-2");     // ответ на вопрос
    private final By todayOrder = By.xpath(".//div[@id='accordion__heading-3']");     // вопрос Можно ли заказать самокат прямо на сегодня?
    private final By answerTodayOrder = By.id("accordion__panel-3");     // ответ на вопрос
    private final By extendOrder = By.xpath(".//div[@id='accordion__heading-4']");     // вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By answerExtendOrder = By.id("accordion__panel-4");     // ответ на вопрос
    private final By charging = By.xpath(".//div[@id='accordion__heading-5']");     // вопрос "Вы привозите зарядку вместе с самокатом?"
    private final By answerCharging = By.id("accordion__panel-5");     // ответ на  вопрос
    private final By canOrderCancellation = By.xpath(".//div[@id='accordion__heading-6']");     // вопрос "Можно ли отменить заказ?"
    private final By answerCanOrderCancellation = By.id("accordion__panel-6");     // ответ на вопрос
    private final By liveOutsideMoscow = By.xpath(".//div[@id='accordion__heading-7']");     // вопрос "Я жизу за МКАДом, привезёте?"
    private final By answerLiveOutsideMoscow = By.id("accordion__panel-7");     // ответ на вопрос

    private WebDriver driver;
    //private static final String RANDOM_ORDER_NUMBER = randomString();
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() { //переход по ссылке
        driver.get(url);
    }
    public void clickCookie() { //закрываем куки
        driver.findElement(By.id("rcc-confirm-button")).click();
    }
    public void scrollHowMuch() { // скролл вниз
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END); //скролл страницы
    }
    public void clickHowMuch() { //клик на 1й вопрос
        driver.findElement(howMuch).click();
    }
    public boolean isAnswerHowMuch() { // проверка наличия текста в ответе на 1й вопрос
        return driver.findElements(answerHowMuch).size() > 0;
    }
    public void clickWantSeveralScooters() { //клик на 2й вопрос
        driver.findElement(wantSeveralScooters).click();
    }
    public boolean isAnswerSeveralScooters() { // проверка наличия текста в ответе на 2й вопрос
        return driver.findElements(answerSeveralScooters).size() > 0;
    }
    public void clickHowRentalTimeCalculated() { //клик на 3й  вопрос
        driver.findElement(howRentalTimeCalculated).click();
    }
    public boolean isAnswerHowRentalTimeCalculated() { // проверка наличия текста в ответе на 3й вопрос
        return driver.findElements(answerHowRentalTimeCalculated).size() > 0;
    }
    public void clickTodayOrder() { //клик на 4й  вопрос
        driver.findElement(todayOrder).click();
    }
    public boolean isAnswerTodayOrder() { // проверка наличия текста в ответе на 4й вопрос
        return driver.findElements(answerTodayOrder).size() > 0;
    }
    public void clickExtendOrder() { //клик на 5й  вопрос
        driver.findElement(extendOrder).click();
    }
    public boolean isAnswerExtendOrder() { // проверка наличия текста в ответе на 5й вопрос
        return driver.findElements(answerExtendOrder).size() > 0;
    }
    public void clickCharging() { //клик на 6й  вопрос
        driver.findElement(charging).click();
    }
    public boolean isAnswerCharging() { // проверка наличия текста в ответе на 6й вопрос
        return driver.findElements(answerCharging).size() > 0;
    }
    public void clickCanOrderCancellation() { //клик на 7й  вопрос
        driver.findElement(canOrderCancellation).click();
    }
    public boolean isAnswerCanOrderCancellation() { // проверка наличия текста в ответе на 7й вопрос
        return driver.findElements(answerCanOrderCancellation).size() > 0;
    }
    public void clickLiveOutsideMoscow() { //клик на 8й  вопрос
        driver.findElement(liveOutsideMoscow).click();
    }
    public boolean isAnswerLiveOutsideMoscow() { // проверка наличия текста в ответе на 8й вопрос
        return driver.findElements(answerLiveOutsideMoscow).size() > 0;
    }
    public OrderElements orderPage() {
        return new OrderElements(driver);
    }
}

