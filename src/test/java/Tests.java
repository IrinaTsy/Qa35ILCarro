import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests extends TestBase{

    //irina.tsygankova61@gmail.com, Iira7945$

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();

        }

        }
    @Test
    public void loginSucces(){

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm("irina.tsygankova61@gmail.com","Iira7945$");
        app.getHelperUser().submitYalla();
        app.getHelperUser().pause(3000);

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }

    @Test
    public void loginSuccesModels(){

        User user = new User().withEmail("irina.tsygankova61@gmail.com").withPassword("Iira7945$");
        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submitYalla();
        app.getHelperUser().pause(3000);

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }

    @Test
    public void negativeWrongEmail(){
        User user = new User().withEmail("irina.tsygankova61gmail.com").withPassword("Iira7945$");
        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submitYalla();
        Assert.assertEquals(app.getHelperUser().getMessageWrongEmail(),"It'snot look like email");
       // Assert.assertTrue(app.getHelperUser().buttonYallaNotActive());
    }

    @Test
    public void negativeWrongPassword(){
        User user = new User().withEmail("irina.tsygankova61@gmail.com").withPassword("Ii75");
        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submitYalla();
        Assert.assertEquals(app.getHelperUser().AuthorizationError(),"Authorization error");

    }


   // @AfterMethod
   public void postCondition()
   {
       app.getHelperUser().clickOkButton();
   }
}

