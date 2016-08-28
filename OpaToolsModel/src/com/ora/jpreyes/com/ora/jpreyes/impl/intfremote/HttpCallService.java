package com.ora.jpreyes.com.ora.jpreyes.impl.intfremote;

import com.ora.jpreyes.com.ora.jpreyes.params.CallResponse;
import com.ora.jpreyes.com.ora.jpreyes.params.CallUrl;

import javax.ejb.Remote;

@Remote
public interface HttpCallService {
    public boolean checkUrl(String callUrl);
}
