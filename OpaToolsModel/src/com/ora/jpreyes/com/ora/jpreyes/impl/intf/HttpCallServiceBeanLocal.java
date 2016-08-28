package com.ora.jpreyes.com.ora.jpreyes.impl.intf;

import com.ora.jpreyes.com.ora.jpreyes.params.CallResponse;
import com.ora.jpreyes.com.ora.jpreyes.params.CallUrl;

import javax.ejb.Local;

@Local
public interface HttpCallServiceBeanLocal {
    public boolean checkUrl(String callUrl);
}
