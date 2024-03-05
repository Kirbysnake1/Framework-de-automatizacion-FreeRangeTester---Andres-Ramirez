package steps;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
 
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import pages.BasePage;
 
public class Hooks extends BasePage {
 
    public Hooks() {
        super(driver);
    }
 
    @After
public void tearDown(Scenario scenario) {
    try {
        if (scenario.isFailed()) {
            scenario.log("Scenario failing, please refer to the image attached to this report");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot of the error");
        }
    } finally {
        // Agregar una captura de pantalla adicional al final de la ejecución
        final byte[] finalScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(finalScreenshot, "image/png", "Final screenshot");
    }

}
}