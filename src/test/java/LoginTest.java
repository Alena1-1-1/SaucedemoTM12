import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    /*Ввести верный логин, пароль с ошибкой
    1.Открываем браузер
    2.Вводим в строку поиска  https://www.saucedemo.com/
    3.Ввожим в поле user - standard_user
    4.Ввожим в поле - 123456789
    5.Жмем кнопку login
    6.Проверяем, что мы получили ошибку - Epic sadface: Username and password do not match any user in this service
     */

    @Test
    public void negativeTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();   /*откроет страницу на полноэкранный режим*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  /*ждет 10 сек, чтобы продолжить*/
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); /*находит элемент по айдишке и вводит*/
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test=error]")).getText(); /*тк нет айдишки в коде, то так*/
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }
      /* Ввести верный логин и пароль
       1.Открываем браузер
       2.Вводим в строку поиска  https://www.saucedemo.com/
       3.Ввожим в поле user - standard_user
       4.Ввожим в поле - secret_sauce
       5.Жмем кнопку login
       6.Проверяем, что мы зашли на сайт */
    @Test
    public void positiveTest() {
        WebDriver driver = new ChromeDriver();  /*заходит в Хром*/
        driver.manage().window().maximize();   /*откроет страницу полноэкранный режим*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  /*ждет 10 сек, чтобы продолжить*/
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); /*находит элемент по айдишке и вводит*/
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean title = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed();
        Assert.assertTrue(title);
        driver.quit();
    }

    /*  Ввести неверный логин, пароль оставить корректным
    1.Открываем браузер
    2.Вводим в строку поиска  https://www.saucedemo.com/
    3.Ввожим в поле user - user_standard
    4.Ввожим в поле - secret_sauce
    5.Жмем кнопку login
    6.Проверяем, что мы получили ошибку - Epic sadface: Username and password do not match any user in this service
     */

    @Test
    public void PypypyTest() {
        WebDriver driver = new ChromeDriver(); /*заходит в Хром*/
        driver.manage().window().maximize();   /*откроет страницу полноэкранный режим*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  /*ждет 10 сек, чтобы продолжить*/
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("user_standard"); /*находит элемент по айдишке и вводит*/
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test=error]")).getText(); /*тк нет айдишки в коде, то так*/
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }

    
 /* Поменять местами  логин и пароль
    1.Открываем браузер
    2.Вводим в строку поиска  https://www.saucedemo.com/
    3.Ввожим в поле user - secret_sauce
    4.Ввожим в поле - standard_user
    5.Жмем кнопку login
    6.Проверяем, что мы получили ошибку - Epic sadface: Username and password do not match any user in this service
     */

    @Test
    public void YpypypyTest() {
        WebDriver driver = new ChromeDriver(); /*заходит в Хром*/
        driver.manage().window().maximize();   /*откроет страницу полноэкранный режим*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  /*ждет 10 сек, чтобы продолжить*/
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("secret_sauce"); /*находит элемент по айдишке и вводит*/
        driver.findElement(By.id("password")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test=error]")).getText(); /*тк нет айдишки в коде, то так*/
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }
     /* Использовать спецсимволы в пароле
    1.Открываем браузер
    2.Вводим в строку поиска  https://www.saucedemo.com/
    3.Ввожим в поле user - standard_user
    4.Ввожим в поле - 1*:%$7)
    5.Жмем кнопку login
    6.Проверяем, что мы получили ошибку - Epic sadface: Username and password do not match any user in this service
     */

    @Test
    public void opopopTest() {
        WebDriver driver = new ChromeDriver(); /*заходит в Хром*/
        driver.manage().window().maximize();   /*откроет страницу полноэкранный режим*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  /*ждет 10 сек, чтобы продолжить*/
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); /*находит элемент по айдишке и вводит*/
        driver.findElement(By.id("password")).sendKeys("1*:%$7)");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test=error]")).getText(); /*тк нет айдишки в коде, то так*/
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
}
}
