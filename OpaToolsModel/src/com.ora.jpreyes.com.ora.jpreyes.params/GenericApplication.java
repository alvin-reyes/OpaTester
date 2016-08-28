package com.ora.jpreyes.com.ora.jpreyes.params;

import com.ora.jpreyes.com.ora.jpreyes.impl.HttpCallServiceBean;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class GenericApplication extends Application {
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        // Register root resources.
        classes.add(HttpCallServiceBean.class);

        // Register provider classes.

        return classes;
    }
}
