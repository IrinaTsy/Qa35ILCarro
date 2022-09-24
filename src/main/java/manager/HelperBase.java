package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//родительский класс общиx методов
public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void type(By locator,String text){
        if(text!=null){

            WebElement el = wd.findElement(locator);
            el.click();
            el.clear();
            el.sendKeys(text);
        }
    }

    //общий метод для всеx кнопок
    public void submitYalla() {
        WebElement yalla = wd.findElement(By.xpath("//button[@type='submit']"));
        yalla.click();

    }

    public boolean isElementPresent(By locator){

        return wd.findElements(locator).size()>0;

    }
    public void click(By locator) {
        wd.findElement(locator).click();
    }

    }
