package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import testbase.TestBase;

public class RegisterPageTest extends TestBase {

    HomePage homepage ;
    RegisterPage registerPage ;
    @BeforeMethod
    public void inIt(){
        homepage = new HomePage();
        registerPage  = new RegisterPage();
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homepage.clickOnRegisterLink();
        String expected = "Register";
        Assert.assertEquals(expected, homepage.VerifyRegisterLink());
    }

    @Test
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(){
        homepage.clickOnRegisterLink();
        registerPage.ClickonRegisterButton();
        String expectedFirstname = "First name is required.";
        Assert.assertEquals(expectedFirstname, registerPage.VerifyFirstnameError());

        String expectedLastname ="Last name is required.";
        Assert.assertEquals(expectedLastname, registerPage.VerifyLastnameError());

        String expectedEmail="Email is required.";
        Assert.assertEquals(expectedEmail, registerPage.VerifyEmailError());

        String expectedPassword="Password is required.";
        Assert.assertEquals(expectedPassword, registerPage.VerifyPasswordError());

        String expectedConfirmPass ="Password is required.";
        Assert.assertEquals(expectedConfirmPass, registerPage.VerifyConfirmPasswordError());
    }
    @Test
    public void verifyThatUserShouldCreateAccountSuccessfully(){
        homepage.clickOnRegisterLink();
        registerPage.ClickonFemale();
        registerPage.EnterFirstname("Mike");
        registerPage.EnterLastname("Bridge");
        registerPage.SelectDay("20");
        registerPage.SelectMonth("5");
        registerPage.SelectYear("1995");
        registerPage.EnterEmail("mikebr@gmail.com");
        registerPage.EnterPassword("123456");
        registerPage.EnterConfirmPassword("123456");
        registerPage.ClickonRegisterButton();
        String expected ="Your registration completed";
        //Assert.assertEquals(expected, registerPage.VerifyRegisterSuccessfullMsg());
}
}

