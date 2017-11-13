package com.github.emilshina.assertions;

import com.github.emilshina.model.User;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

import java.util.List;

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

    public UserAssert hasPassword(final String password) {
        isNotNull();

        final String pass = actual.getPassword();

        if (!Objects.areEqual(pass, password)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Password", actual, password, pass);
        }
        return this;
    }

    public UserAssert hasEmails(final List<String> expectedEmails) {
        isNotNull();

        final List<String> actualEmails = actual.getEmails();

        if (!Objects.areEqual(actualEmails, expectedEmails)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Emails", actual, expectedEmails, actualEmails);
        }
        return this;
    }
}
