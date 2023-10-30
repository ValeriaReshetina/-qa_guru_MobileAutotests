package guru.qa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import guru.qa.config.MobileConfig;
import guru.qa.config.UserConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MobileConfig mobile = ConfigFactory.create(MobileConfig.class, System.getProperties());
        UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());

        MutableCapabilities mutableCapabilities = new MutableCapabilities();

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", userConfig.getUsername());
        mutableCapabilities.setCapability("browserstack.key", userConfig.getPassword());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", mobile.getApp());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", mobile.getDevice());
        mutableCapabilities.setCapability("os_version", mobile.getVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(userConfig.getRemoteUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
