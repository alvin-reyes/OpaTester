package com.ora.jpreyes.view.backing;

import com.ora.jpreyes.com.ora.jpreyes.impl.intf.SessionEJBLocal;

import javax.annotation.Generated;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.swing.JOptionPane;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

@ManagedBean(name = "OpaIndexBBean")
@RequestScoped
@Generated(value = "1index.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class OpaIndexBean {
    
    @EJB
    private SessionEJBLocal sessionEjb;
    private RichOutputText outputText;
    
    public void hello() {}
    public String hitMe() {
        System.out.println("Hit Me");
        return "success";
    }
    public String helloEjb() {
        this.outputText.setValue(">>");
        return sessionEjb.sayHello();
    }

    public void setOutputText(RichOutputText outputText) {
        this.outputText = outputText;
    }

    public RichOutputText getOutputText() {
        return outputText;
    }
}
