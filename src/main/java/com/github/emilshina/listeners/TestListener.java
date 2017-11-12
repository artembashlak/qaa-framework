package com.github.emilshina.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Listeners for test methods.
 */
@Slf4j
public class TestListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod()) {
            log.info("METHOD NAME: {} ", method.getTestMethod().getMethodName());
        }
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod() && !testResult.isSuccess()) {
            log.info("FAILURE.");
        }
    }
}
