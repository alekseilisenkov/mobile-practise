package com.alexlis.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/emulator.properties")
public interface LocalEmulatorConfig extends Config {

    String url();
    String deviceName();
}
