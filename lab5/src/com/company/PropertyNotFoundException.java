package com.company;


public class PropertyNotFoundException extends Exception {
    protected String key = "";

    public PropertyNotFoundException(String key) {
        this.key = key;
    }

    @Override
    public String getMessage() {
        return "Key '" + this.key + "' property not found";
    }
}
