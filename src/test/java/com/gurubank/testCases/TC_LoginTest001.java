package com.gurubank.testCases;

import com.gurubank.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest001 extends BaseClass
{
    @Test
    public void loginTest() throws InterruptedException {


        logger.info("URL is opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("entered username");
        lp.setPassword(password);
        logger.info("entered password");

        lp.clickSubmit();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
            logger.info("login test passed");
        }
        else
        {
            Assert.assertTrue(false);
            logger.info("login test failed");
        }
    }

}
