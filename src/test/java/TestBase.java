import manager.AppManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    WebDriver wd;

    static AppManager app = new AppManager();


    @BeforeSuite //отработает перед каждым методом с аннотацией Test
    public void setUp(){

        app.init();
    }

    @AfterSuite //отработает после каждого метода Test
    public void tearDown(){

        app.stop();

    }
}
