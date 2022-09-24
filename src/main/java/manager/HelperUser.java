package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLogForm() {
        WebElement logInTab = wd.findElement(By.cssSelector("a[href ^='/login']"));
        //WebElement logInTab = wd.findElement(By.cssSelector("a[href ^='/login']")); кусок текста с начала
        //WebElement logInTab = wd.findElement(By.xpath("//a[text()='Log in']")); часть текста

        logInTab.click();
    }

    public void fillLogForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }


    public void fillLogForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public String getMessage() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5)); //задержка на 5 сек
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container")))); //пока не появится нужная форма
        return wd.findElement(By.cssSelector("h2.message")).getText();
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Logout']"));
    }

    public void logOut() {
        wd.findElement(By.xpath("//a[text()=' Logout']"));
    }


    public void clickOkButton() {
        List<WebElement> list1 = wd.findElements(By.xpath("//button[text()='Ok']"));
        if(list1.size()>0){
            click(By.xpath("//button[text()='Ok']"));
            wd.quit();

        }else
        {
            wd.quit();
        }

    }



        //  click(By.xpath("//button[text()='Ok']"));


    public String getMessageWrongEmail() {
       return wd.findElement(By.cssSelector("div.error")).getText();

    }

    public String AuthorizationError() {
        return wd.findElement(By.xpath("//h1[text()='Authorization error']")).getText();

    }

     //public boolean buttonYallaNotActive() {
      //  WebElement buttonYalla = wd.findElement(By.xpath("//button"))
      // List<WebElement> list = wd.findElements(By.cssSelector("button.1"));
      //  return list.size() > 0;
   // }
}
