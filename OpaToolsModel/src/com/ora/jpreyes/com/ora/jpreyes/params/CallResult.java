package com.ora.jpreyes.com.ora.jpreyes.params;

import java.io.Serializable;

public class CallResult implements Serializable {
    public Integer STATUS_CODE = 0;
    
    private String responseMessage;
    private int responseCode;

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public CallResult() {
        super();
    }
}
