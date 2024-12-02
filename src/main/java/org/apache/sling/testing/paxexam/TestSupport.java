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
import org.ops4j.pax.exam.options.ModifiableCompositeOption;
import org.ops4j.pax.exam.options.OptionalCompositeOption;
import org.ops4j.pax.exam.options.SystemPropertyOption;
import org.ops4j.pax.exam.options.UrlProvisionOption;
import org.ops4j.pax.exam.options.extra.VMOption;
import org.ops4j.pax.exam.util.PathUtils;
import org.ops4j.pax.tinybundles.TinyBundle;
import org.osgi.service.cm.ConfigurationAdmin;

import static org.apache.sling.testing.paxexam.SlingOptions.backing;
import static org.apache.sling.testing.paxexam.SlingOptions.paxTinybundles;
import static org.apache.sling.testing.paxexam.SlingOptions.spifly;
import static org.apache.sling.testing.paxexam.SlingOptions.versionResolver;
import static org.ops4j.pax.exam.CoreOptions.bundle;
import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.junitBundles;
import static org.ops4j.pax.exam.CoreOptions.keepCaches;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.repository;
import static org.ops4j.pax.exam.CoreOptions.streamBundle;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.vmOption;
import static org.ops4j.pax.exam.CoreOptions.when;

/**
 * Test Support for OPS4J Pax Exam.
 */
public abstract class TestSupport {

    private static final String WORKING_DIRECTORY_PROPERTY_KEY = "sling.testing.paxexam.workingDirectory";

    @Inject
    @SuppressWarnings("checkstyle:VisibilityModifier")
    protected ConfigurationAdmin configurationAdmin;

    private final String workingDirectory = String.format("%s/target/paxexam/%s/%s", PathUtils.getBaseDir(), getClass().getSimpleName(), UUID.randomUUID());

    /**
     * Provides a random path for a working directory below Maven's build target directory.
     *
     * @return the absolute path for working directory
     */
    protected String workingDirectory() {
        return workingDirectory;
    }

    /**
     * Provides Felix HTTP Service's HTTP port ({@code org.osgi.service.http.port}).
     *
     * @return the HTTP port
     * @throws IOException if reading OSGi configuration fails
     */
    protected int httpPort() throws IOException {
        final Dictionary<String, Object> properties = configurationAdmin.getConfiguration("org.apache.felix.http").getProperties();
        return Integer.parseInt(properties.get("org.osgi.service.http.port").toString());
    }

    /**
     * Provides the Jacoco VM option when System property {@code jacoco.command} is set.
     *
     * @return the property option
     */
    protected OptionalCompositeOption jacoco() {
        final String jacocoCommand = System.getProperty("jacoco.it.command");
        @SuppressWarnings("checkstyle:AvoidInlineConditionals")
        final VMOption option = Objects.nonNull(jacocoCommand) && !jacocoCommand.trim().isBlank() ? vmOption(jacocoCommand) : null;
        return when(Objects.nonNull(option)).useOptions(option);
    }

    /**
     * Provides commons property and provisioning options for both default and server mode.
     *
     * @return the composite option
     */
    protected ModifiableCompositeOption commonConfiguration() {
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

    /**
     * Provides base property and provisioning options for default mode.
     *
     * @return the composite option
     */
    protected ModifiableCompositeOption baseConfiguration() {
        return composite(
            commonConfiguration(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.testing.paxexam").versionAsInProject(),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.hamcrest").version(versionResolver),
            junitBundles()
        );
    }

    /**
     * Provides base property and provisioning options for server mode.
     *
     * @return the composite option
     */
    protected ModifiableCompositeOption serverBaseConfiguration() {
        return commonConfiguration();
    }

    /**
     * Finds a free local port.
     *
     * @return the free local port
     */
    @SuppressWarnings({"java:S112", "checkstyle:IllegalCatch"})
    public static int findFreePort() {
        try (ServerSocket serverSocket = new ServerSocket(0)) {
            return serverSocket.getLocalPort();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Provides an option to set the System property {@code pax.exam.osgi.unresolved.fail} to {@code "true"}.
     *
     * @return the property option
     */
    public static SystemPropertyOption failOnUnresolvedBundles() {
        return systemProperty("pax.exam.osgi.unresolved.fail").value("true");
    }

    /**
     * Reads the System property {@code maven.repo.local} and provides an option to set the System property {@code org.ops4j.pax.url.mvn.localRepository} when former is not empty.
     *
     * @return the property option
     */
    public static OptionalCompositeOption localMavenRepo() {
        final String localRepository = System.getProperty("maven.repo.local", ""); // PAXEXAM-543
        return when(!localRepository.isBlank()).useOptions(
            systemProperty("org.ops4j.pax.url.mvn.localRepository").value(localRepository)
        );
    }

    /**
     * Reads the pathname of the test bundle from the given System property and provides a provisioning option.
     *
     * @param systemProperty the System property which contains the pathname of the test bundle
     * @return the provisioning option
     */
    public static UrlProvisionOption testBundle(final String systemProperty) {
        final String pathname = System.getProperty(systemProperty);
        final File file = new File(pathname);
        return bundle(file.toURI().toString());
    }

    /**
     * Builds an OSGi bundle with bnd from given classes and provides it as provisioning option.
     *
     * @param classes the classes to include in the OSGi bundle
     * @return the provisioning option
     */
    public static UrlProvisionOption buildBundleWithBnd(final Class... classes) {
        final TinyBundle bundle = org.ops4j.pax.tinybundles.TinyBundles.bundle();
        for (final Class clazz : classes) {
            bundle.addClass(clazz);
        }
        return streamBundle(
            bundle.build()
        ).start();
    }

}
