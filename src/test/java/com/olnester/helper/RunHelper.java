package com.olnester.helper;

import com.olnester.configs.ConfigReader;
import com.olnester.driver.EmulatorDriver;

public class RunHelper {
    private RunHelper() {
    }

    public static Class<?> getDriverClass() {
        String deviceHost = ConfigReader.testConfig.deviceHost();

        return switch (deviceHost) {
            case "emulator" -> EmulatorDriver.class;
//            case "real" -> RealDriver.class;
            default -> throw new RuntimeException("deviceHost not found in test.properties: emulator/real");
        };
    }
}

