package com.ora.jpreyes.com.ora.jpreyes.impl;

import com.ora.jpreyes.com.ora.jpreyes.impl.intf.SessionEJBLocal;
import com.ora.jpreyes.com.ora.jpreyes.impl.intfremote.SessionEJB;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.jws.WebService;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@Stateless(name = "SessionEJB", mappedName = "opa-tools-OpaToolsModel-SessionEJB")
@WebService(name = "SessionEJBBeanService", portName = "SessionEJBBeanServicePort")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class SessionEJBBean implements SessionEJB, SessionEJBLocal {
    @Resource
    SessionContext sessionContext;
    public SessionEJBBean() {
    }
    
    @Override
    public String sayHello() {
        return "hello";
    }
}