package com.alexlis.config;

import org.aeonbits.owner.Config;

@BrowserStackConfig.Sources({
        "classpath:config/credentials.properties"
})
public interface BrowserStackConfig extends Config {

    @Config.Key("userName")
    String getUserName();

    @Config.Key("accessKey")
    String getAccessKey();

    @Config.Key("url")
    String getUrl();
}
