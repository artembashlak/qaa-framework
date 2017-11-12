package com.github.emilshina.testcases;

import com.github.emilshina.model.User;
import io.github.sskorol.core.DataSupplier;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

/**
 * Data suppliers' methods for tests.
 */
@Slf4j
public class DataSuppliers {

    @DataSupplier
    public StreamEx usersWithInvalidCredentials(final Method method) {
        final String dataSource = ofNullable(method.getDeclaredAnnotation(Data.class))
                .map(Data::source)
                .orElse("dummy.json");
        log.info("DATA SOURCE: {}", dataSource);

        return StreamEx.of(
                new User(380507654321L, "pswd1", "username1"),
                new User(380667654321L, "pswd2", "username2"),
                new User(380677654321L, "pswd3", "username3")
        );
    }

    @DataSupplier
    public String invalidPassword() {
        return "passwordInvalid";
    }

    @DataSupplier
    public Map<String, String> userCredentials() {
        final HashMap<String, String> credentials = new HashMap<>();
        credentials.put("0501234567", "password1");
        credentials.put("0671234567", "password2");
        credentials.put("0991234567", "password3");
        return credentials;
    }
}
