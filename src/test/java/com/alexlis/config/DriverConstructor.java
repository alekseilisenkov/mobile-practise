package com.alexlis.config;

import org.aeonbits.owner.ConfigFactory;

public class DriverConstructor {

    public static BrowserStackConfig browserStackConfig = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());
    public static LocalEmulatorConfig localEmulatorConfig = ConfigFactory.create(LocalEmulatorConfig.class, System.getProperties());
    public static RealDeviceConfig realDeviceConfig = ConfigFactory.create(RealDeviceConfig.class, System.getProperties());
    public static SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class, System.getProperties());
}
