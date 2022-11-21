package com.alexlis.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/selenoid.properties"})
public interface SelenoidConfig extends Config {

    String url();
    String platformName();
    String deviceName();
    String version();
}
