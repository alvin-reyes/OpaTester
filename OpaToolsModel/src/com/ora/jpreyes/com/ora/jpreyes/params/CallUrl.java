package com.ora.jpreyes.com.ora.jpreyes.params;

import java.io.Serializable;

public class CallUrl implements Serializable {
    
    private String urlString;
    public CallUrl(String url) {
        
    }
    public CallUrl(String url, String name, String description) {
        super();
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public String getUrlString() {
        return urlString;
    }
}
