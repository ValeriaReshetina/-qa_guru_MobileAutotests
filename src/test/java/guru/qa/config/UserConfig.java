package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:user.properties"
})

public interface UserConfig extends Config {
    @Key("username")
    String getUsername();

    @Key("userPassword")
    String getPassword();

    @Key("remoteUrl")
    String getRemoteUrl();
}
