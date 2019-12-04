package main.java.ua.nure.itkn179.skrynnik.usermanagement.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Messages {

    private static final String BUNDLE_NAME = "messages";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    public Messages() {
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
