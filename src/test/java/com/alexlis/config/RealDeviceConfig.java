package com.alexlis.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/realdevice.properties"})
public interface RealDeviceConfig extends Config {

    String deviceName();
}
