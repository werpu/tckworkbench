package org.glassfish.mojarra.faces40.ajax;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Spec1567ITBean {

    private String form1input1;
    private String form1input2;
    private String form1input3;
    
    private String form2input1;
    private String form2input2;
    private String form2input3;

    private String form3input1;
    private String form3input2;
    private String form3input3;

    private static void addMessage(String clientId, String message) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(message));
    }

    public String getForm1input1() {
        return form1input1;
    }

    public void setForm1input1(String form1input1) {
        addMessage("form1", "setForm1input1:" + form1input1);
        this.form1input1 = form1input1 + "x";
    }

    public String getForm1input2() {
        return form1input2;
    }

    public void setForm1input2(String form1input2) {
        addMessage("form1", "setForm1input2:" + form1input2);
        this.form1input2 = form1input2 + "x";
    }

    public String getForm1input3() {
        return form1input3;
    }

    public void setForm1input3(String form1input3) {
        addMessage("form1", "setForm1input3:" + form1input3);
        this.form1input3 = form1input3 + "x";
    }

    public String getForm2input1() {
        return form2input1;
    }

    public void setForm2input1(String form2input1) {
        addMessage("form2", "setForm2input1:" + form2input1);
        this.form2input1 = form2input1 + "x";
    }

    public String getForm2input2() {
        return form2input2;
    }

    public void setForm2input2(String form2input2) {
        addMessage("form2", "setForm2input2:" + form2input2);
        this.form2input2 = form2input2 + "x";
    }

    public String getForm2input3() {
        return form2input3;
    }

    public void setForm2input3(String form2input3) {
        addMessage("form2", "setForm2input3:" + form2input3);
        this.form2input3 = form2input3 + "x";
    }

    public String getForm3input1() {
        return form3input1;
    }

    public void setForm3input1(String form3input1) {
        addMessage("form3", "setForm3input1:" + form3input1);
        this.form3input1 = form3input1 + "x";
    }

    public String getForm3input2() {
        return form3input2;
    }

    public void setForm3input2(String form3input2) {
        addMessage("form3", "setForm3input2:" + form3input2);
        this.form3input2 = form3input2 + "x";
    }

    public String getForm3input3() {
        return form3input3;
    }

    public void setForm3input3(String form3input3) {
        addMessage("form3", "setForm3input3:" + form3input3);
        this.form3input3 = form3input3 + "x";
    }

}
