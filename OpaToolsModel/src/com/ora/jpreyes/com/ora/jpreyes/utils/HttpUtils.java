package com.ora.jpreyes.com.ora.jpreyes.utils;

import com.ora.jpreyes.com.ora.jpreyes.params.CallRequest;
import com.ora.jpreyes.com.ora.jpreyes.params.CallResponse;
import com.ora.jpreyes.com.ora.jpreyes.params.CallUrl;
import java.io.IOException;

import java.net.HttpURLConnection;
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
    public static CallResponse callHttpUrl(CallUrl callUrl) throws IOException {
        // Return the String response (even if error);
        
        //  Create the connection (must be http connection).
        URL url = new URL(callUrl.getUrl());
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) urlConnection;
        
        //  Build the response object.
        CallResponse callResponse = new CallResponse.Builder(
                    httpConn.getResponseMessage(), 
                    httpConn.getResponseCode())
            .build();
        return callResponse;
    }
    
    /**
     * This method is used to just check the HTTP URL if it's alive or not.
     * @param callUrl
     * @return true if the url is available, otherwise, false.
     * @throws IOException
     */
    public static boolean checkHttpUrlAvailability(CallUrl callUrl) throws IOException {
        // Return the String response (even if error);
        //  Create the connection (must be http connection).
        URL url = new URL(callUrl.getUrl());
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) urlConnection;
        
        if(httpConn.getResponseCode() != HttpURLConnection.HTTP_OK){
            return false;
        }
        return true;
    }
    
    /**
     * This method is used to check the http url response message only.
     * @param callUrl
     * @return the response message
     * @throws IOException
     */
    public static String checkHttpUrlResponseMessage(CallUrl callUrl) throws IOException {
        // Return the String response (even if error);
        //  Create the connection (must be http connection).
        URL url = new URL(callUrl.getUrl());
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) urlConnection;
        
        return httpConn.getResponseMessage();
    }
    
    /**
     * This method is used to check the response code only.
     * @param callUrl
     * @return the response code
     * @throws IOException
     */
    public static int checkHttpUrlResponseCode(CallUrl callUrl) throws IOException {
        // Return the String response (even if error);
        //  Create the connection (must be http connection).
        URL url = new URL(callUrl.getUrl());
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) urlConnection;
        
        return httpConn.getResponseCode();
    }
    
    public static CallResponse callHttpUrl(CallRequest callRequest, CallUrl callUrl) throws IOException {
        return null;
    }
}
