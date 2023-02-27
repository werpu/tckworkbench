/*
 * Copyright (c) 2021 Contributors to the Eclipse Foundation.
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

package ee.jakarta.tck.faces.test.javaee8.commandScript_selenium;

import ee.jakarta.tck.faces.test.util.selenium.BaseITNG;
import ee.jakarta.tck.faces.test.util.selenium.ExtendedWebDriver;
import ee.jakarta.tck.faces.test.util.selenium.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static java.lang.System.getProperty;
import static org.jboss.shrinkwrap.api.ShrinkWrap.create;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import jakarta.faces.component.html.HtmlCommandScript;


public class Spec613IT extends BaseITNG {

    /**
     * @see HtmlCommandScript
     * @see https://github.com/jakartaee/faces/issues/613
     */
    @Test
    public void test() throws Exception {
        testCommandScript();
    }

    public void testCommandScript() throws Exception {
        WebPage page = getPage("spec613.xhtml");
        page.wait(Duration.ofMillis(60000));
        ExtendedWebDriver webDriver = getWebDriver();
        assertTrue(webDriver.findElement(By.id("result")).getText().equals("foo"));

        webDriver.getJSExecutor().executeScript("bar()");
        page.wait(Duration.ofMillis(60000));
        assertTrue(webDriver.findElement(By.id("result")).getText().equals("bar"));
    }
}
