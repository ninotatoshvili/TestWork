package com.herokuapp.theInternet;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestHerokuApp {


    @Before
     public void  setBrowser()
     {
              Configuration.browser = "chrome";
              Configuration.startMaximized=true;
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nina\\Desktop\\chromedriver.exe");
         open("http://the-internet.herokuapp.com/");
     }
     @Test
     public void AddRemoveTest() throws InterruptedException
     {

      open("http://the-internet.herokuapp.com/");
         $(byText("Add/Remove Elements")).click();
         for(int i=1; i<=3;i++)
         {
             $(".example button").click();
             Thread.sleep(2000);
         }
         for(int i=3;i>=1;i--)
         {

             $$("#elements button").findBy(text("Delete")).click();
             Thread.sleep(2000);
         }

     }

     @Test
     public void EntryAdTest() throws InterruptedException
     {
         open("http://the-internet.herokuapp.com/");
         $(byText("Entry Ad")).click();
         $(".modal-title").shouldHave(text("This is a modal window"));
         Thread.sleep(2000);


     }

     @Test
    public void InputTest() throws InterruptedException
       {
         open("http://the-internet.herokuapp.com/");
         $(byText("Inputs")).click();
         $(".example input").setValue("abc");
         $(".example input").setValue("e-.");
         $(".example input").setValue("e-.1");
         $(".example input").setValue("12");
         $(".example input").shouldHave(type("number"));

         $(".example input").toWebElement().sendKeys(Keys.ARROW_UP);

         Thread.sleep(4000);


       }



     }










