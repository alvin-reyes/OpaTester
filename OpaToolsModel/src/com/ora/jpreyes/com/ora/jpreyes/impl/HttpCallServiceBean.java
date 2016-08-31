package com.ora.jpreyes.com.ora.jpreyes.impl;

import com.ora.jpreyes.com.ora.jpreyes.impl.intfremote.HttpCallService;

import com.ora.jpreyes.com.ora.jpreyes.params.CallResponse;

import com.ora.jpreyes.com.ora.jpreyes.params.CallUrl;

import com.ora.jpreyes.com.ora.jpreyes.utils.HttpUtils;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/HttpCallService")
public class HttpCallServiceBean implements HttpCallService {
    
    @Override
    @GET
    @Path("/checkUrl")
    public boolean checkUrl(@HeaderParam("urlString") String urlString) {    
        try {
            return HttpUtils.checkHttpUrlAvailability(urlString);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
