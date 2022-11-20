package com.alexlis.helpers;

import com.alexlis.config.StartConfig;
import com.alexlis.drivers.BrowserStackMobileDriver;
import com.alexlis.drivers.EmulatorMobileDriver;
import com.alexlis.drivers.RealDeviceDriver;
import com.alexlis.drivers.SelenoidMobileDriver;
import org.aeonbits.owner.ConfigFactory;

public class RunConfiguration {

    private final StartConfig config = ConfigFactory.create(StartConfig.class, System.getProperties());

    private RunConfiguration() {
    }

    public static RunConfiguration runHelper() {
        return new RunConfiguration();
    }

    public Class<?> getDriverClass() {
        switch (config.deviceHost()) {
            case "browserstack":
                return BrowserStackMobileDriver.class;
            case "local":
                return EmulatorMobileDriver.class;
            case "real":
                return RealDeviceDriver.class;
            case "selenoid":
                return SelenoidMobileDriver.class;
            default:
                throw new RuntimeException("Incorrect device host");
        }
    }
}
