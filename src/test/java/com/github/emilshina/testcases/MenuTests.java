package com.github.emilshina.testcases;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for verification of Menu options.
 */
@Slf4j
public class MenuTests extends BaseClass {

    @BeforeMethod
    public void beforeEachMethod() {
        log.info("Before method of Menu class.");
    }

    @AfterMethod
    public void afterEachMethod() {
        log.info("After method of Menu class.");
    }

    @Test
    public void userCanOpenContactsPage() {
        log.info("Contacts page was opened.");
    }

    @Data(source = "data.json")
    @Test
    public void userCanOpenAboutPage() {
        log.info("About page was opened.");
    }
}
