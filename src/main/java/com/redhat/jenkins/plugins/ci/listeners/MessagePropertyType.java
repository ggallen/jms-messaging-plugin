package com.redhat.jenkins.plugins.ci.listeners;

import java.util.HashMap;
import java.util.NoSuchElementException;

public enum MessagePropertyType {
    BOOLEAN("Boolean"),
    FLOAT("Float"),
    INTEGER("Integer"),
    STRING("String");

    private String value;

    MessagePropertyType(String value) {
        this.value = value;
    }

    private static HashMap<String, MessagePropertyType> map = new HashMap<String, MessagePropertyType>();
    static {
        for (MessagePropertyType t : MessagePropertyType.values()) {
            map.put(t.toString().toLowerCase(), t);
        }
    }

    public String displayName() {
        return value;
    }

    public static MessagePropertyType fromString(String s) {
        String lc = s.trim().toLowerCase();
        if (map.containsKey(lc)) {
            return map.get(lc);
        }
        throw new NoSuchElementException("MessagePropertyType not found - " + s + ".");
    }
}
