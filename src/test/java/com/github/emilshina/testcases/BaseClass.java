package com.github.emilshina.testcases;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * The base class for all test classes.
 */
@Slf4j
public class BaseClass {

    @BeforeClass
    public void beforeMethod() {
        log.info("BASE_CLASS: Run before each class.");
    }

    @AfterClass
    public void afterMethod() {
        log.info("BASE_CLASS: Run after each class.");
    }
}
