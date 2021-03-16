/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.testing.paxexam.it.tests;

import org.apache.sling.testing.paxexam.TestSupport;
import org.junit.ClassRule;
import org.junit.Test;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExamServer;
import org.ops4j.pax.exam.options.ModifiableCompositeOption;
import org.ops4j.pax.exam.options.extra.VMOption;

import static org.junit.Assert.assertEquals;
import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.when;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;

import static org.apache.sling.testing.paxexam.SlingOptions.http;
import static org.apache.sling.testing.paxexam.SlingOptions.webconsole;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/** Demonstrate HTTP-based integration testing with Pax Exam.
 * 
 *  The PaxExamServer rule starts an OSGi framework instance that
 *  our tests access via HTTP.
 * 
 *  For debugging, note that our tests run in the maven-failsafe-plugin
 *  JVM process, that can be setup for debugging with Dmaven.failsafe.debug
 *  and the OSGi framework in a different JVM process, that can be setup for
 *  debugging using the pax.vm.options system property.
 */
public class SlingOptionsPaxExamServerIT extends TestSupport {

    private static final int httpPort = findFreePort();

    @ClassRule
    public static PaxExamServer serverRule = new PaxExamServer();

    @Configuration
    public Option[] configuration() {
        final String vmOptStr = System.getProperty("pax.vm.options");
        final VMOption vmOption = ( vmOptStr == null || vmOptStr.trim().length() == 0 ) ? null : new VMOption(vmOptStr);

        return options(
            when(vmOption != null).useOptions(vmOption),
            serverBaseConfiguration(),
            http(),
            webconsole(),
            paxLogging(),

            // For some reason, Jetty starts first on port 8080 without this
            systemProperty("org.osgi.service.http.port").value(String.valueOf(httpPort))
        );
    }

    public static ModifiableCompositeOption paxLogging() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.logging").artifactId("pax-logging-api").versionAsInProject(),
            mavenBundle().groupId("org.ops4j.pax.logging").artifactId("pax-logging-logback").versionAsInProject()
        );
    }

    @Test
    public void testHttpAccess() throws IOException {
        final URL url = new URL(String.format("http://localhost:%d/system/console", httpPort));
        final HttpURLConnection c = (HttpURLConnection)url.openConnection();
        final String base64EncodedAdminAdmin = "YWRtaW46YWRtaW4=";
        c.setRequestProperty ("Authorization", "Basic " + base64EncodedAdminAdmin);
        assertEquals(200, c.getResponseCode());
    }

}