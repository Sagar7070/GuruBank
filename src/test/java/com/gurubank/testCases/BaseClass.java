package com.gurubank.testCases;

import com.gurubank.utilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getApplicationURL();
    public String username= readconfig.getUsername();
    public String password= readconfig.getPassword();
    public WebDriver driver;
    public static Logger logger;

    @Parameters ("browser")
    @BeforeClass
    public void setUp(String br)
    {
        logger =Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");

//       System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
            driver = new ChromeDriver();
        }
        else if (br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxPath());
            driver = new FirefoxDriver();
        }
        else if(br.equals("edge")){
            System.setProperty("webdriver.edge.driver", readconfig.getedgePath());
            driver = new EdgeDriver();
        }
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
