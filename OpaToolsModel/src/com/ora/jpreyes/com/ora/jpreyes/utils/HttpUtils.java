package com.ora.jpreyes.com.ora.jpreyes.utils;

import com.ora.jpreyes.com.ora.jpreyes.params.CallRequest;
import com.ora.jpreyes.com.ora.jpreyes.params.CallResponse;
import com.ora.jpreyes.com.ora.jpreyes.params.CallUrl;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Author: Alvin Reyes
 * This is the utility the sends out the request to a specific Web Service
 */
public class HttpUtils {
    

    
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
    
    public static boolean checkHttpUrlAvailability(String urlStr) throws IOException {
        // Return the String response (even if error);
        
        //  Create the connection (must be http connection).
        URL url = new URL(urlStr);
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
    
    /**
     * This method is used to call a SOAP Web Service
     * @param callRequest
     * @param callUrl
     * @return callResponse - that has the response message and code.
     * @throws IOException
     */
    public static CallResponse callHttpUrl(CallRequest callRequest, CallUrl callUrl) throws IOException {
        String inputLine;
        URL url = new URL(callUrl.getUrl());
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) urlConnection;
        
        FileInputStream fin = new FileInputStream(callRequest.getPayloadFileXml().getParentFile());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
            
        // Copy the SOAP file to the open connection.
        copy(fin,bout);
        fin.close();

        byte[] b = bout.toByteArray();

        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length",String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type","text/xml; charset=utf-8");
        httpConn.setRequestMethod(callRequest.getMethod());
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        // Everything's set up; send the XML that was read in to b.
        OutputStream out = httpConn.getOutputStream();
        out.write(b);    
        out.close();

        // Read the response and write it to standard out.
        InputStreamReader isr =
            new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);

       

        while ((inputLine = in.readLine()) != null)
            inputLine += inputLine;

        in.close();
        
        CallResponse callResponse = new CallResponse.Builder()
            .responseMessage(httpConn.getResponseMessage())
            .responseCode(httpConn.getResponseCode())
            .build();
        
        return callResponse;
    }
    
    /**
     * This is a private method that copies the input stream to the ouput stream file. We need to have it synchronize to
     * avoid deadlocks.
     * @param in
     * @param out
     * @throws IOException
     */
    private static void copy(InputStream in, OutputStream out) 
       throws IOException {

        //  Don't allow other threads to use this.
        synchronized (in) {
          synchronized (out) {

            byte[] buffer = new byte[256];
            while (true) {
              int bytesRead = in.read(buffer);
              if (bytesRead == -1) break;
              out.write(buffer, 0, bytesRead);
            }
          }
        }
      } 
    
}
