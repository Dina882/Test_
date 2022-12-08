package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderElements {

    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/"; //URL
    private By buttonUpOrder = By.className("Button_Button__ra12g"); //проверка кнопки "Заказать" вверху страницы
    private By buttonDownOrder = By.className("Home_FinishButton__1_cWm"); //проверка кнопки "Заказать" внизу страницы
    private By cookieMessage = By.className("App_CookieButton__3cvqF"); //куки

    private By orderHeaderText = By.className("Order_Header__BZXOb");
    // Поля для ввода данных заказа
    private By orderName = By.xpath(".//input[@placeholder='* Имя']"); //поле "Имя"
    private By orderSurnameName = By.xpath(".//input[@placeholder='* Фамилия']"); //поле "Фамилия"
    private By orderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //поле "Адрес"
    private By orderMetroStation = By.xpath(".//input[@placeholder='* Станция метро']"); //поле "МСтанция метро"
    private By orderChoiceMetro = By.xpath(".//div[@class='Order_Text__2broi']"); //выбор метро
    private By orderPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //поле "Телефон"
    private By orderNextButton = By.xpath(".//button[text()='Далее']");
    private By orderZakazButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]"); //кнопака "Заказать"

    private By orderHeaderTextSecondPage = By.className("Order_Header__BZXOb"); //вторая страница
    private By orderWhen = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //поле "Когда привезти самокат"
    private By orderWhenCalendar = By.xpath(".//div[contains(@aria-label, 'Choose')]");
    private By orderHowLong = By.className("Dropdown-placeholder");
    private By orderHowLongTwoDays = By.xpath(".//div[text()='сутки']"); //поле "срок аренды"
    private By orderColorBlack = By.xpath(".//input[@id='black']"); //поле "Цвет самоката"
    private By orderCommentCour = By.xpath(".//input[@placeholder='Комментарий для курьера']"); //поле "Комментарий для курьера"
    //подтверждение оформления заказа
    private By orderAskingText = By.className("Order_ModalHeader__3FDaJ");
    private By orderYesButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Да')]");
    private By orderDoneHeader = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderElements(WebDriver driver) {

        this.driver = driver;
    }
    public OrderElements open() {
        driver.get(url);
        return this;
    }
    public String checkOrderIsDone() {
        return driver.findElement(orderDoneHeader).getText();
    }
    // Методы кликов на кнопки
    public void clickCookieButton() {
        driver.findElement(cookieMessage).click();
    }
    public void clickButtonUpOrder() {
        driver.findElement(buttonUpOrder).click();
    } // Метод клика на Заказ вверху страницы
    public void clickButtonDownOrder() {
        driver.findElement(buttonDownOrder).click();
    } // Метод клика на заказ внизу страницы

    public void clickNextButton() {
        driver.findElement(orderNextButton).click();
    } // Метод клика на кнопку "Далее"
    public void clickZakazButton() {
        driver.findElement(orderZakazButton).click();
    } // Метод клика на кнопку "Заказать"
    public void clickYesButton() {
        driver.findElement(orderYesButton).click();
    }// Метод клика на кнопку "да"
    public void setName(String name) {
        driver.findElement(orderName).sendKeys(name);
    } // Имя
    public void setSurnameName(String surnameName) { //Фамилия
        driver.findElement(orderSurnameName).sendKeys(surnameName);
    }
    public void setAddress(String addressPoint) {
        driver.findElement(orderAddress).sendKeys(addressPoint);
    } //Адрес
    public void clickMetroStation() {
        driver.findElement(orderMetroStation).click();
    } // клик Метро
    public void clickChoiceMetro() {
        driver.findElement(orderChoiceMetro).click();
    } //выбор Метро
    public void setOrderPhoneNumber(String phoneNumber) {
        driver.findElement(orderPhoneNumber).sendKeys(phoneNumber);
    } // Телефон
    public void clickWhen() {
        driver.findElement(orderWhen).click();
    }
    public void clickWhenCalendar() {
        driver.findElement(orderWhenCalendar).click();
    }
    public void clickHowLong() {
        driver.findElement(orderHowLong).click();
    }
    public void clickHowLongTwoDays() {
        driver.findElement(orderHowLongTwoDays).click();
    }
    public void clickColorBlack() {
        driver.findElement(orderColorBlack).click();
    }
    public void setCommentCour(String commentCour) {
        driver.findElement(orderCommentCour).sendKeys(commentCour);
    }
    // Объединение методов
    public void fillFirstPage(String name, String surnameName, String address, String phoneNumber) {
        setName(name);
        setSurnameName(surnameName);
        setAddress(address);
        setOrderPhoneNumber(phoneNumber);
        clickMetroStation();
        clickChoiceMetro();
        clickNextButton();
    }
    public void fillSecondPage(String commentCour) {
        clickWhen();
        clickWhenCalendar();
        clickHowLong();
        clickHowLongTwoDays();
        clickColorBlack();
        setCommentCour(commentCour);
        clickZakazButton();
    }

}
