import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
    Created by Vanzhula QA 22/10/2020
    Цей код замовляє їжу на один день і його легко масштабувати під ваші смаки та різні дати.
 */

public class MainClass extends WebDriverSetings {

    @Test
    public void testLeogamingNet () {
        driver.get("https://orders.gudfood.com.ua/auth/login");
        String pageURL = driver.getCurrentUrl();
        assertEquals(pageURL, "https://orders.gudfood.com.ua/auth/login");
        // Далі вводимо логін. Відправляємо дані для авторизації.
        new WebDriverWait(driver, 100);
        driver.findElement(By.name("form[login]")).sendKeys(" Впишіть Ваш Логін ");
        new WebDriverWait(driver, 100);
        // Далі вводимо пароль.
        driver.findElement(By.name("form[password]")).sendKeys(" Впишіть Ваш Пароль ");
        new WebDriverWait(driver, 10);
        // Клікаємо кнопку "Увійти" і відправляємо дані для авторизації.
        driver.findElement(new By.ByClassName("btn-block")).click();
        new WebDriverWait(driver, 10);
        // Клікаємо кнопку "Зробити замовлення".
        driver.findElement(new By.ByClassName("btn-success")).click();
        new WebDriverWait(driver, 10);
        // Клікаємо кнопку розділа меню "Салати".
        driver.findElement(By.xpath("//a[contains(@href, '#salati')]")).click();
        new WebDriverWait(driver, 10);
        // Клікаємо кнопку "Купити" на улюбленій страві, при цьому прописуємо номер унікальний номер цієї страви (Див. скріншот:https://prnt.sc/v3vd8x)
        driver.findElement(By.xpath("//a[contains(@href, '/order/buy/pid/2757')]")).click();
        new WebDriverWait(driver, 2000);
        // Чекаємо завантаження веб обєктів - довго завантажуються.
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Клікаємо кнопку "Оформити замовлення".
        driver.findElement(By.xpath("//a[contains(text(),'Оформить заказ')]")).click();
        new WebDriverWait(driver, 10);
        // Клікаємо кнопку "Перейти до вибору дати доставки".
        driver.findElement(By.xpath("//form[@id='cart-form']/div[2]/div/button[2]")).click();
        new WebDriverWait(driver, 10);
        // Клікаємо кнопку "Дати на календарю". Вибрати потрібно з HTML коду номера кнопок дат.
        driver.findElement(By.xpath("//table[@id='calendar']/tbody[2]/tr[2]/td[4]/label")).click();
        new WebDriverWait(driver, 10);
        // Клікаємо кнопку "Оформити замовлення".
        driver.findElement(By.xpath("//input[@name='yt0']")).click();
        new WebDriverWait(driver, 10);
        // Клікаємо кнопку "Лого" для повернення на головну сторінку.
        driver.findElement(By.cssSelector("a.navbar-brand > img")).click();
        new WebDriverWait(driver, 10);
        /** Вище написаний код для одного замовлення на одну дату.
          Копіюємо код з 31 строки з коментарем
          (Клікаємо кнопку "Зробити замовлення".)
          до 57 строки та додаемо до коду вище - це буде замовлення на наступну дату.

          Замінюємо айді страв та вибираємо нову дату.
          Такий сценарій вибирає страви на ліміт співробітника і оформляє замовлення на конкретну дату.
          Для підтримки коду, потрібно змінювати лише дати календаря.
          При умові, якщо Ви не будете змінювати страви.
         */
    }

}
