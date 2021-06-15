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

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.apache.sling.testing.paxexam.TestSupport;
import org.junit.ClassRule;
import org.junit.Test;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExamServer;

import static org.apache.sling.testing.paxexam.SlingOptions.http;
import static org.apache.sling.testing.paxexam.SlingOptions.paxLoggingLogback;
import static org.apache.sling.testing.paxexam.SlingOptions.webconsole;
import static org.junit.Assert.assertEquals;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;

/**
 * The PaxExamServer rule starts an OSGi framework instance that
 * our tests access via HTTP.
 */
public class ServerTestSupportIT extends TestSupport {

    private static final int httpPort = findFreePort();

    private static final String CREDENTIALS = new String(Base64.getEncoder().encode("admin:admin".getBytes()));

    @ClassRule
    public static PaxExamServer serverRule = new PaxExamServer();

    @Configuration
    public Option[] configuration() {
        return options(
            systemProperty("org.osgi.service.http.port").value(String.valueOf(httpPort)),
            serverBaseConfiguration(),
            http(),
            webconsole(),
            paxLoggingLogback()
        );
    }

    @Test
    public void testHttpAccess() throws IOException {
        final URL url = new URL(String.format("http://localhost:%d/system/console", httpPort));
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Authorization", String.format("Basic %s", CREDENTIALS));
        assertEquals(200, connection.getResponseCode());
    }

}
