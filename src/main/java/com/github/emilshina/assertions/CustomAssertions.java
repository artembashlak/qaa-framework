package com.github.emilshina.assertions;

import com.github.emilshina.model.User;

/**
 * Utility class for custom assertions.
 */

public final class CustomAssertions {

    private CustomAssertions() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    public static UserAssert assertThat(final User user) {
        return new UserAssert(user);
    }
}
