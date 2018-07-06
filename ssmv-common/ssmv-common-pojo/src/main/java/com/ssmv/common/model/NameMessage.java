package com.ssmv.common.model;

public class NameMessage {

    private boolean use;

    private String message;

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NameMessage{" +
                "use=" + use +
                ", message='" + message + '\'' +
                '}';
    }
}
