package com.ora.jpreyes.com.ora.jpreyes.params;

import java.io.File;

import java.util.HashMap;
import java.util.Map;

public class CallRequest {
    
    //  Just optional parameters.
    private Map<String,String> requestParameters = new HashMap<String,String>();
    private Map<String,String> requestHeaders = new HashMap<String,String>();
    private CallParameters callParameters = new CallParameters();
    
    //  Payloads
    private String payloadXmlString = null;
    private File payloadFileXml = null;

    public Map<String, String> getRequestParameters() {
        return requestParameters;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public String getPayloadXmlString() {
        return payloadXmlString;
    }

    public File getPayloadFileXml() {
        return payloadFileXml;
    }

    public static class Builder {
        private String payloadXmlString = "";
        private File payloadFileXml = null;
        
        //  Optional
        private Map<String,String> requestParameters = null;
        private Map<String,String> requestHeaders = null;
        
        public Builder(String payloadXmlString) {
            this.payloadXmlString  = payloadXmlString;
        }
        public Builder(File payloadFileXml) {
            this.payloadFileXml  = payloadFileXml;
        }
        
        public Builder parameters(Map<String,String> requestParameters) {
            this.requestParameters = requestParameters;
            return this;
        }
        public Builder headers(Map<String,String> requestHeaders) {
            this.requestHeaders = requestHeaders;
            return this;
        }
        
        public CallRequest build() {
            
            //  Parse xml, create a new one an exhange the placeholders {{VAL}}
            //  witht the one's on CallParameter Object.
            
            
            return new CallRequest(this);
        }
    }
    private CallRequest(Builder builder) {
        this.payloadXmlString = builder.payloadXmlString;
        this.payloadFileXml = builder.payloadFileXml;
        this.requestHeaders = builder.requestHeaders;
        this.requestParameters = builder.requestParameters;
        
        //  
    }
}
