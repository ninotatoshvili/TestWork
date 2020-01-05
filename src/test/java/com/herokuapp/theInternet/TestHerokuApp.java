package com.herokuapp.theInternet;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
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


         $(byText("Add/Remove Elements")).click();
         for(int i=1; i<=3;i++)
         {
             $(".example button").click();
             Thread.sleep(2000);
         }
         for(int i=3;i>=1;i--)
         {

             $("#elements button").click();
             Thread.sleep(2000);
         }

     }

     @Test
     public void EntryAdTest() throws InterruptedException
     {

         $(byText("Entry Ad")).click();
         $(".modal-title").shouldHave(text("This is a modal window"));
         Thread.sleep(2000);


     }

     @Test
    public void InputTest() throws InterruptedException
       {

         $(byText("Inputs")).click();
         $(".example input").setValue("abc");
         $(".example input").shouldHave(value(""));
         $(".example input").setValue(";]").shouldHave(value(""));


         $(".example input").shouldHave(type("number"));
            int numb=12;

         $(".example input").setValue(String.valueOf(numb));


         $(".example input").toWebElement().sendKeys(Keys.ARROW_UP);
         $(".example input").shouldHave(value(String.valueOf(numb+1)));

           Thread.sleep(2000);


       }



     }










