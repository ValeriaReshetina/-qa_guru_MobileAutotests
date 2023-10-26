package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:user.properties"
})

public interface UserConfig extends Config {
    @Key("username")
    String getUser();

    @Key("userKey")
    String getKey();

    @Key("remoteUrl")
    String getRemoteUrl();
}
