/*
 * Copyright (c) 2017, 2018 Oracle and/or its affiliates. All rights reserved.
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
/**
 * mutation observer does not work on css changes coming from external files
 * we have to use interval for change detection
 * The problem is here, mojarra seems to use the CSS first
 * while MyFaces sticks to the order passed in the component descriptor
 * so this script is executed before the CSS changes
 * MyFaces is very likely correct here in its assumption of
 * first come first serve of the resources
 * @type {number}
 */
document.getElementById("scriptResult").innerHTML = "addedViaInclude";
var css = document.getElementById("stylesheetResult").innerHTML = window.getComputedStyle(document.body).getPropertyValue("background-color");
if(!css.indexOf("rgb(0, 255, 0)") != -1) {
    var cnt = 0;
    var waitInterval = setInterval(function () {
        cnt++;
        css = document.getElementById("stylesheetResult").innerHTML = window.getComputedStyle(document.body).getPropertyValue("background-color");
        if (cnt > 50 || css.indexOf("rgb(0, 255, 0)") != -1) {
            clearInterval(waitInterval);
        }
    }, 10);
}
