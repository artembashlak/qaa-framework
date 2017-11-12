package com.github.emilshina.assertions;

import com.github.emilshina.model.User;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * Custom asserts for testing User entity.
 */

public class UserAssert extends AbstractAssert<UserAssert, User> {
    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of:\n<%s>\nto be: <%s>\n but was:\n<%s>";

    public UserAssert(final User user) {
        super(user, UserAssert.class);
    }

    public UserAssert hasUsername(final String username) {
        isNotNull();

        final String name = actual.getUserName();

        if (!Objects.areEqual(name, username)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Username", actual, username, name);
        }
        return this;
    }
}
