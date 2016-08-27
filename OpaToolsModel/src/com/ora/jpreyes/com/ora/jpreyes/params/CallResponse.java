package com.ora.jpreyes.com.ora.jpreyes.params;

import java.io.Serializable;

public class CallResponse implements Serializable {
    private String responseMessage;
    private int responseCode;
    public String getResponseMessage() {
        return responseMessage;
    }
    public int getResponseCode() {
        return responseCode;
    }
    public static class Builder {
        private String responseMessage;
        private int responseCode;
        
        public Builder() {
            
        }
        public Builder(String responseMessage, int responseCode){
            this.responseMessage = responseMessage;
            this.responseCode = responseCode;
        }
        
        public Builder(String responseMessage) {
            this.responseMessage = responseMessage;
        }
        
        public Builder(int responseCode) {
            this.responseCode = responseCode;
        }
        
        public Builder responseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
            return this;
        }
        public Builder responseCode(int responseCode) {
            this.responseCode = responseCode;
            return this;
        }
        
        public CallResponse build() {
            return new CallResponse(this);
        }
    }
    private CallResponse(Builder builder) {
        responseMessage = builder.responseMessage;
        responseCode = builder.responseCode;
    }
    
}
