package com.alexlis.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:deviceHost.properties")
public interface StartConfig extends Config {

//    @Config.Key("deviceHost")
//    @Config.DefaultValue("browserstack")
//    String deviceHost();
}
