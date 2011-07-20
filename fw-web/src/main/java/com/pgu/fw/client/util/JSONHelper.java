package com.pgu.fw.client.util;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class JSONHelper {

    private JSONHelper() {
        throw new UnsupportedOperationException();
    }

    public static String toString(final JSONValue v) {
        if (null == v) {
            return "";
        }
        final JSONString s = v.isString();
        if (null == s) {
            return "";
        }
        final String str = s.stringValue();
        if (StringHelper.isBlank(str)) {
            return "";
        }
        return str.trim();
    }

    public static JSONObject toObject(final JSONValue v) {
        checkNotNull(v);
        final JSONObject o = v.isObject();
        if (null == o) {
            throw new IllegalArgumentException("Entry is not a valid jsonObject! " + v.toString());
        }
        return o;
    }

    public static JSONArray toArray(final JSONValue v) {
        checkNotNull(v);
        final JSONArray a = v.isArray();
        if (null == a) {
            throw new IllegalArgumentException("Entry is not a valid jsonArray! " + v.toString());
        }
        return a;
    }

    public static int toInt(final JSONValue v) {
        checkNotNull(v);
        final JSONNumber n = v.isNumber();
        if (null == n) {
            throw new IllegalArgumentException("Entry is not a valid jsonNumber! " + v.toString());
        }
        return (int) n.doubleValue();
    }

    private static void checkNotNull(final JSONValue v) {
        if (null == v) {
            throw new NullPointerException();
        }
    }

}
