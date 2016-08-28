package com.ora.jpreyes.com.ora.jpreyes.impl;

import com.ora.jpreyes.com.ora.jpreyes.impl.intf.HttpCallServiceBeanLocal;
import com.ora.jpreyes.com.ora.jpreyes.impl.intfremote.HttpCallService;

import com.ora.jpreyes.com.ora.jpreyes.params.CallResponse;

import com.ora.jpreyes.com.ora.jpreyes.params.CallUrl;

import com.ora.jpreyes.com.ora.jpreyes.utils.HttpUtils;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ws.rs.PathParam;

@Stateless(name = "HttpCallServiceBean", mappedName = "opa-tools-OpaToolsModel-HttpCallServiceBean")
public class HttpCallServiceBean implements HttpCallService, HttpCallServiceBeanLocal {
    @Resource
    SessionContext sessionContext;
    
    @Override
    public boolean checkUrl(@PathParam(value="-1") String urlString) {    
        try {
            return HttpUtils.checkHttpUrlAvailability(urlString);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}