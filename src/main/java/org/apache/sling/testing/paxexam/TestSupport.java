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
import java.util.Dictionary;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;

import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.options.ModifiableCompositeOption;
import org.ops4j.pax.exam.options.OptionalCompositeOption;
import org.ops4j.pax.exam.options.extra.VMOption;
import org.ops4j.pax.exam.util.PathUtils;
import org.ops4j.pax.tinybundles.core.TinyBundle;
import org.osgi.service.cm.ConfigurationAdmin;

import static org.apache.sling.testing.paxexam.SlingOptions.backing;
import static org.apache.sling.testing.paxexam.SlingOptions.paxTinybundles;
import static org.apache.sling.testing.paxexam.SlingOptions.spifly;
import static org.ops4j.pax.exam.CoreOptions.bundle;
import static org.ops4j.pax.exam.CoreOptions.composite;
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

    @Inject
    protected ConfigurationAdmin configurationAdmin;

    private static final String WORKING_DIRECTORY_PROPERTY_KEY = "sling.testing.paxexam.workingDirectory";

    protected String workingDirectory() {
        return workingDirectory;
    }

    protected int httpPort() throws IOException {
        final Dictionary<String, Object> properties = configurationAdmin.getConfiguration("org.apache.felix.http").getProperties();
        return Integer.parseInt(properties.get("org.osgi.service.http.port").toString());
    }

    protected OptionalCompositeOption jacoco() {
        final String jacocoCommand = System.getProperty("jacoco.command");
        final VMOption option = Objects.nonNull(jacocoCommand) && !jacocoCommand.trim().isEmpty() ? vmOption(jacocoCommand) : null;
        return when(Objects.nonNull(option)).useOptions(option);
    }

    private ModifiableCompositeOption configuration() {
        return composite(
            failOnUnresolvedBundles(),
            keepCaches(),
            localMavenRepo(),
            repository("https://repository.apache.org/snapshots/").id("apache-snapshots").allowSnapshots(),
            systemProperty(WORKING_DIRECTORY_PROPERTY_KEY).value(workingDirectory()),
            CoreOptions.workingDirectory(workingDirectory()),
            paxTinybundles(),
            backing(),
            spifly(),
            jacoco()
        );
    }

    protected ModifiableCompositeOption baseConfiguration() {
        return composite(
            configuration(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.testing.paxexam").versionAsInProject()
        );
    }

    protected ModifiableCompositeOption serverBaseConfiguration() {
        return configuration();
    }

    public static int findFreePort() {
        try (final ServerSocket serverSocket = new ServerSocket(0)) {
            return serverSocket.getLocalPort();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Option failOnUnresolvedBundles() {
        return systemProperty("pax.exam.osgi.unresolved.fail").value("true");
    }

    public static Option localMavenRepo() {
        final String localRepository = System.getProperty("maven.repo.local", ""); // PAXEXAM-543
        return when(localRepository.length() > 0).useOptions(
            systemProperty("org.ops4j.pax.url.mvn.localRepository").value(localRepository)
        );
    }

    public static Option testBundle(final String systemProperty) {
        final String filename = System.getProperty(systemProperty);
        final File file = new File(filename);
        return bundle(file.toURI().toString());
    }

    public static Option buildBundleWithBnd(final Class... classes) {
        final TinyBundle bundle = org.ops4j.pax.tinybundles.core.TinyBundles.bundle();
        for (final Class clazz : classes) {
            bundle.add(clazz);
        }
        return streamBundle(
            bundle.build(withBnd())
        ).start();
    }

}
