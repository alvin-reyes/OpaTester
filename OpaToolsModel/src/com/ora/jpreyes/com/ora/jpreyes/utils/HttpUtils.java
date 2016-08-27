package com.ora.jpreyes.com.ora.jpreyes.utils;

import HTTPClient.HttpURLConnection;
import com.ora.jpreyes.com.ora.jpreyes.params.CallRequest;
import com.ora.jpreyes.com.ora.jpreyes.params.CallResponse;
import com.ora.jpreyes.com.ora.jpreyes.params.CallResult;
import com.ora.jpreyes.com.ora.jpreyes.params.CallUrl;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Author: Alvin Reyes
 * This is the utility the sends out the request to a specific Web Service
 */
public class HttpUtils {
    
    public HttpUtils() {
        super();
    }
    
    /**
     * This method is just a basic call to a specific URL.
     * It will return a CallResult object that has the response metadata.
     * @param callUrl
     * @return
     */
    public CallResult callHttpUrl(CallUrl callUrl) throws IOException {
        // Return the String response (even if error);
        CallResult callResult = new CallResult();
        //  Create the connection (must be http connection).
        URL url = new URL(callUrl.getUrlString());
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) urlConnection;
        
        callResult.setResponseCode(httpConn.getResponseCode());
        callResult.setResponseMessage(httpConn.getResponseMessage());
        return callResult;
    }
    
    public CallResult callHttpUrl(CallRequest callRequest, CallUrl callUrl) {
        return null;
    }
    
    public boolean checkHttpUrlAvailability(CallUrl urlParam) {
        return true;
    }
    
    
    
}
