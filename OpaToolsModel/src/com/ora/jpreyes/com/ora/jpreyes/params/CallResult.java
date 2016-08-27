package com.ora.jpreyes.com.ora.jpreyes.params;

import java.io.Serializable;

public class CallResult implements Serializable {
    public Integer STATUS_CODE = 0;
    
    private String responseString;
    private String requestString;
    private CallUrl urlParameter;
    
    public CallResult() {
        super();
    }
}
