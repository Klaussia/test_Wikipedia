package Settings.CrossPlatformClasses;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
