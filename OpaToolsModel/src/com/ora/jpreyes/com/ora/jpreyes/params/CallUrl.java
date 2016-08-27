package com.ora.jpreyes.com.ora.jpreyes.params;

import java.io.Serializable;

public class CallUrl implements Serializable {
    //  Required.
    private final String url;
    //  Optional.
    private final String name;
    private final String description;
    
    public static class Builder {
        //  Required
        private final String url;
        
        //  Optional.
        private String name;
        private String description;
    
        public Builder(String url) {
            this.url = url;
            
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder description(String value) {
            description = value;
            return this;
        }
        public CallUrl build() {
            return new CallUrl(this);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private CallUrl(Builder builder) {
        url = builder.url;
        name = builder.name;
        description = builder.description;
    }
}
