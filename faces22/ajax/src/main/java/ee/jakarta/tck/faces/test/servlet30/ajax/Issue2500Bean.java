/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package ee.jakarta.tck.faces.test.servlet30.ajax;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Named
@SessionScoped
public class Issue2500Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean visible = false;

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getVisible() {
        return visible;
    }

    public void toggle(ActionEvent ae) {
        if (visible) {
            visible = false;
        } else if (!visible) {
            visible = true;
        }

        determineViewStateValueOccurences();
    }

    private String msg = null;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    private void determineViewStateValueOccurences() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map <String, String[]>requestParams = context.getExternalContext().getRequestParameterValuesMap();
        Set s = requestParams.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry)it.next();
            String key = (String)m.getKey();
            String[] values = (String[])m.getValue();
            if (key.equals("jakarta.faces.ViewState")) {
                if (null != values) {
                    if (values.length > 1) {
                        msg = "jakarta.faces.ViewState Has More than One Value";
                    } else if (values.length == 1) {
                        msg = "jakarta.faces.ViewState Has One Value";
                    }
                } 
               break;
           }
        }
    } 
}
