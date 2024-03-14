## Cucumber appium tests

### Run tests in Idea

In order to run tests, you have to have:

- installed appium server
- running virtual or real android device with android version starting from 16 to 22 including  
- installed java 17 (due to compatibility of the latest version of appium client with java 17 or higher) and mvn 3.6.0 and higher

Configure emulator.properties:

    deviceName - virtual device name
    remoteUrl - setup appium server ip and port

To run tests and generate cucumber reports, use:

    mvn clean verify

Cucumber reports can be found here:

    target/cucumber-reports/Cucumber.html 
    
or here

    target/cucumber-html-reports/report-feature_92201338.html

or by url in the output test result console like this:

        View your Cucumber Report at:      
        https://reports.cucumber.io/reports/8a5309b7-5741-4034-a06e-c94618b16ee6