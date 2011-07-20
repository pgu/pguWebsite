package com.pgu.fw.client.util;

public class StringHelper {

    private StringHelper() {
        throw new UnsupportedOperationException();
    }

    public static boolean isBlank(final String s) {
        return s == null || s.trim().isEmpty();
    }

}
