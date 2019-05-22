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
package org.apache.sling.testing.paxexam;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.UUID;

import javax.inject.Inject;

import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.options.ModifiableCompositeOption;
import org.ops4j.pax.exam.util.PathUtils;
import org.ops4j.pax.tinybundles.core.TinyBundle;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.sling.testing.paxexam.SlingOptions.paxTinybundles;
import static org.ops4j.pax.exam.CoreOptions.bundle;
import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.frameworkProperty;
import static org.ops4j.pax.exam.CoreOptions.keepCaches;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.repository;
import static org.ops4j.pax.exam.CoreOptions.streamBundle;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.vmOption;
import static org.ops4j.pax.exam.CoreOptions.when;
import static org.ops4j.pax.tinybundles.core.TinyBundles.withBnd;

public abstract class TestSupport {

    private final String workingDirectory = String.format("%s/target/paxexam/%s/%s", PathUtils.getBaseDir(), getClass().getSimpleName(), UUID.randomUUID());
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    protected ConfigurationAdmin configurationAdmin;

    protected String workingDirectory() {
        return workingDirectory;
    }

    protected synchronized int findFreePort() {
        try {
            final ServerSocket serverSocket = new ServerSocket(0);
            final int port = serverSocket.getLocalPort();
            serverSocket.close();
            return port;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected int httpPort() throws IOException {
        final Dictionary<String, Object> properties = configurationAdmin.getConfiguration("org.apache.felix.http").getProperties();
        return Integer.parseInt(properties.get("org.osgi.service.http.port").toString());
    }

    protected ModifiableCompositeOption baseConfiguration() {
        return composite(
            failOnUnresolvedBundles(),
            keepCaches(),
            localMavenRepo(),
            repository("https://repository.apache.org/snapshots/").id("apache-snapshots").allowSnapshots(),
            CoreOptions.workingDirectory(workingDirectory()),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.testing.paxexam").versionAsInProject(),
            paxTinybundles()
        );
    }

    protected Option failOnUnresolvedBundles() {
        return systemProperty("pax.exam.osgi.unresolved.fail").value("true");
    }

    protected Option localMavenRepo() {
        final String localRepository = System.getProperty("maven.repo.local", ""); // PAXEXAM-543
        return when(localRepository.length() > 0).useOptions(
            systemProperty("org.ops4j.pax.url.mvn.localRepository").value(localRepository)
        );
    }

    protected Option testBundle(final String systemProperty) {
        final String filename = System.getProperty(systemProperty);
        final File file = new File(filename);
        return bundle(file.toURI().toString());
    }

    protected Option buildBundleWithBnd(final Class... classes) {
        final TinyBundle bundle = org.ops4j.pax.tinybundles.core.TinyBundles.bundle();
        for (final Class clazz : classes) {
            bundle.add(clazz);
        }
        return streamBundle(
            bundle.build(withBnd())
        ).start();
    }

    public Option jvmSetup() {
        Option[] configuration = new Option[0];
        try {
            int javaVersion = Integer.parseInt(System.getProperty("java.specification.version"));
            if (javaVersion >= 9 && javaVersion < 11) {
                configuration = Arrays.copyOf(configuration, configuration.length + 1);
                configuration[configuration.length - 1] = vmOption("--add-modules=java.se.ee");
                logger.info("Using the following options for Java {}:\n{}", javaVersion, configuration);
            }
            if (javaVersion >= 11) {
                configuration = Arrays.copyOf(configuration, configuration.length + 1);
                configuration[configuration.length -1] = composite(
                        frameworkProperty("org.osgi.framework.system.packages.extra")
                                .value("javax.xml.stream;version=\"1.1.0\",javax.xml.stream.events;" +
                                        "version=\"1.1.0\""),
                        mavenBundle("org.apache.geronimo.specs", "geronimo-annotation_1.3_spec", "1.1"),
                        mavenBundle("org.apache.geronimo.specs", "geronimo-activation_1.1_spec", "1.1"),
                        mavenBundle("org.apache.servicemix.specs", "org.apache.servicemix.specs.jaxb-api-2.2", "2.9.0"),
                        mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.jaxb-impl", "2.2.11_1")
                );
                logger.info("Using the following options for Java {}:\n{}", javaVersion, configuration);
            }
        } catch (NumberFormatException e) {
            logger.info("No special setup needed for Java 8.");
        }
        return CoreOptions.composite(configuration);
    }

}
