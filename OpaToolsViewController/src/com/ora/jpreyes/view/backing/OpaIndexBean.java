package com.ora.jpreyes.view.backing;



import javax.annotation.Generated;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

@ManagedBean(name="OpaIndexBBean")
@RequestScoped
@Generated(value = "1index.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class OpaIndexBean {
    
    private RichOutputText outputText;
    
    public void hello() {}
    public String hitMe() {
        System.out.println("Hit Me");
        return "success";
    }
    public String helloEjb() {
        this.outputText.setValue(">>");
        return "";
    }

    public void setOutputText(RichOutputText outputText) {
        this.outputText = outputText;
    }

    public RichOutputText getOutputText() {
        return outputText;
    }
}
