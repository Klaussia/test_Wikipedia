package Settings.CrossPlatformClasses;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;

import java.io.FileOutputStream;
import java.util.Properties;

public class TestBase extends SetPlatform {

    @BeforeEach
    public void setUp() throws Exception {
        if (isAndroid()){
            this.driver = SetPlatform.getInstance().getDriver();
        }else if (isIOS()) {
            this.driver = SetPlatform.getInstance().getDriver();
        }
    }
    @AfterEach
    public void finish(){
        driver.quit();
    }
}
