package Settings.CrossPlatformClasses;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class SetPlatform {
    /** Данные AppiumServer */
    private final static String AppiumServer = "127.0.0.1";
    private final static String AppiumPort = "4723";

    /** Данные для Android */
    private static final String PLATFORM_ANDROID = "Android";
    private final static String deviceNameAndroid = "Oreo";
    private final static String platformVersionAndroid = "8.1";

    /** Данные для iOS */
    private static final String PLATFORM_IOS = "iOS";
    private final static String deviceNameIOS = "iPhone 11";
    private final static String platformVersionIOS = "15.5";


    private static SetPlatform instance;
    public SetPlatform (){}
    public static SetPlatform getInstance(){
        if (instance==null){
            instance = new SetPlatform();
        }
        return instance;
    }

    protected AppiumDriver driver;

    public AppiumDriver getDriver() throws Exception{
        if (this.isAndroid()){
          return initializeAndroidDriver();
        }else if (this.isIOS()){
            return initializeIOSDriver();
        }else {
            throw new Exception("Error, your platform is: " + this.getSystemVar());
        }
    }
    URL appiumURL = null;
    public AppiumDriver initializeAndroidDriver(){
        try {
            appiumURL = new URL("http://" + AppiumServer + ":" + AppiumPort + "/wd/hub");
            this.driver = new AndroidDriver(appiumURL,getAndroidCap());
        }catch (Exception e){
            e.printStackTrace();
        }
        return driver;
    }

    public AppiumDriver initializeIOSDriver(){
        try {
            appiumURL = new URL("http://" + AppiumServer + ":" + AppiumPort + "/wd/hub");
            this.driver = new IOSDriver(appiumURL,getIOSCap());
        }catch (Exception e){
            e.printStackTrace();
        }
        return driver;
    }

    public boolean isAndroid(){
        return isPlatform(PLATFORM_ANDROID);
    }
    public boolean isIOS(){
        return isPlatform(PLATFORM_IOS);
    }


    private DesiredCapabilities getAndroidCap(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceNameAndroid);
        capabilities.setCapability("platformName", PLATFORM_ANDROID);
        capabilities.setCapability("platformVersion", platformVersionAndroid);
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        File file = new File("src/main/resources/AndroidApp", "org.wikipedia.apk");
        capabilities.setCapability("app", file.getAbsolutePath());
        return capabilities;
    }
    private DesiredCapabilities getIOSCap(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceNameIOS);
        capabilities.setCapability("platformName", PLATFORM_IOS);
        capabilities.setCapability("platformVersion", platformVersionIOS);
        File file = new File("src/main/resources/iOSApp", "Wikipedia.app");
        capabilities.setCapability("app", file.getAbsolutePath());
        return capabilities;
    }
    private boolean isPlatform(String my_Platform){
        String platform = this.getSystemVar();
        return my_Platform.equals(platform);
    }
    private String getSystemVar(){
        return System.getenv("PLATFORM");
    }
}
