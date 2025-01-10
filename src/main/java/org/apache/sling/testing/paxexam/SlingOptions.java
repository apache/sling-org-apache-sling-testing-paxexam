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

import org.ops4j.pax.exam.options.MavenArtifactProvisionOption;
import org.ops4j.pax.exam.options.ModifiableCompositeOption;
import org.ops4j.pax.exam.util.PathUtils;

import static org.ops4j.pax.exam.CoreOptions.bootClasspathLibrary;
import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.vmOption;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.cm.ConfigurationAdminOptions.newConfiguration;

/**
 * Sling's Options for Pax Exam created from Sling's Karaf Features.
 *
 * <p>NOTE: This file is generated from Sling's Karaf Features
 */
@SuppressWarnings("java:S1192")
public final class SlingOptions {

    @SuppressWarnings({"java:S1104", "java:S1444", "checkstyle:VisibilityModifier"})
    public static SlingVersionResolver versionResolver = new SlingVersionResolver();

    private SlingOptions() { //
    }

    public static ModifiableCompositeOption awaitility() {
        return composite(
            mavenBundle().groupId("org.awaitility").artifactId("awaitility").version(versionResolver),
            mavenBundle().groupId("org.hamcrest").artifactId("hamcrest").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption bnd() {
        return composite(
            mavenBundle().groupId("biz.aQute.bnd").artifactId("biz.aQute.bndlib").version(versionResolver),
            mavenBundle().groupId("biz.aQute.bnd").artifactId("biz.aQute.bnd.util").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.service.repository").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.util.function").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.util.promise").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption backing() {
        final int version = SlingVersionResolver.getJavaVersion();
        if (version >= 11) {
            return composite(
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.annotation-api-1.3").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.activation-api-1.1").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.stax-api-1.2").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.jaxb-api-2.3").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.jaxb-impl").version(versionResolver)
            );
        } else if (version >= 9) {
            return composite(
                vmOption("--add-modules=java.se.ee")
            );
        } else {
            return composite();
        }
    }

    public static ModifiableCompositeOption config() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.configadmin").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption eventadmin() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.eventadmin").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption felixHealthcheck() {
        return composite(
            eventadmin(),
            scr(),
            webconsole(),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.api").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.core").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.generalchecks").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.webconsoleplugin").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption greenmail() {
        final MavenArtifactProvisionOption greenmail = mavenBundle().groupId("com.icegreen").artifactId("greenmail").version(versionResolver);
        final MavenArtifactProvisionOption slf4jApi = mavenBundle().groupId("org.slf4j").artifactId("slf4j-api").version(versionResolver);
        final MavenArtifactProvisionOption slf4jSimple = mavenBundle().groupId("org.slf4j").artifactId("slf4j-simple").version(versionResolver);
        return composite(
            greenmail,
            mavenBundle().groupId("jakarta.mail").artifactId("jakarta.mail-api").version(versionResolver),
            mavenBundle().groupId("org.eclipse.angus").artifactId("jakarta.mail").version(versionResolver),
            mavenBundle().groupId("jakarta.activation").artifactId("jakarta.activation-api").version(versionResolver),
            junit(),
            // add GreenMail to boot classpath *also* to allow setting ssl.SocketFactory.provider to GreenMail's DummySSLSocketFactory
            bootClasspathLibrary(greenmail).afterFramework(),
            bootClasspathLibrary(slf4jApi).afterFramework(), // GreenMail dependency
            bootClasspathLibrary(slf4jSimple).afterFramework() // GreenMail dependency
        );
    }

    public static ModifiableCompositeOption hamcrest() {
        return composite(
            mavenBundle().groupId("org.hamcrest").artifactId("hamcrest").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption httpcomponentsClient() {
        return composite(
            config(),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpclient-osgi").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpcore-osgi").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption http() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.jetty12").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.servlet-api").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption httpWhiteboard() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.whiteboard").version(versionResolver),
            http()
        );
    }

    public static ModifiableCompositeOption jackson() {
        return composite(
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-annotations").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-core").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-databind").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption junit() {
        return composite(
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.junit").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption logback() {
        final String filename = String.format("file:%s/src/test/resources/logback.xml", PathUtils.getBaseDir());
        return composite(
            systemProperty("logback.configurationFile").value(filename),
            mavenBundle().groupId("org.slf4j").artifactId("slf4j-api").version(versionResolver),
            mavenBundle().groupId("org.slf4j").artifactId("jcl-over-slf4j").version(versionResolver),
            mavenBundle().groupId("ch.qos.logback").artifactId("logback-core").version(versionResolver),
            mavenBundle().groupId("ch.qos.logback").artifactId("logback-classic").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption management() {
        return composite(
            mavenBundle().groupId("org.apache.aries").artifactId("org.apache.aries.util").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.jmx").artifactId("org.apache.aries.jmx.api").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.jmx").artifactId("org.apache.aries.jmx.core").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.jmx").artifactId("org.apache.aries.jmx.whiteboard").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption paxLoggingApi() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.logging").artifactId("pax-logging-api").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption paxLoggingLog4j2(final String configurationFile) {
        return composite(
            paxLoggingApi(),
            newConfiguration("org.ops4j.pax.logging")
                .put("org.ops4j.pax.logging.log4j2.config.file", configurationFile)
                .asOption(),
            mavenBundle().groupId("org.ops4j.pax.logging").artifactId("pax-logging-log4j2").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption paxLoggingLog4j2() {
        final String filename = String.format("%s/src/test/resources/log4j2.xml", PathUtils.getBaseDir());
        return paxLoggingLog4j2(filename);
    }

    public static ModifiableCompositeOption paxLoggingLogback(final String configurationFile) {
        return composite(
            paxLoggingApi(),
            newConfiguration("org.ops4j.pax.logging")
                .put("org.ops4j.pax.logging.logback.config.file", configurationFile)
                .asOption(),
            mavenBundle().groupId("org.ops4j.pax.logging").artifactId("pax-logging-logback").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption paxLoggingLogback() {
        final String filename = String.format("%s/src/test/resources/logback.xml", PathUtils.getBaseDir());
        return paxLoggingLogback(filename);
    }

    public static ModifiableCompositeOption paxTinybundles() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.tinybundles").artifactId("tinybundles").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-store").version(versionResolver),
            bnd()
        );
    }

    public static ModifiableCompositeOption paxUrl() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-commons").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-lang").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util-property").version(versionResolver),
            mavenBundle().groupId("org.ops4j.pax.swissbox").artifactId("pax-swissbox-property").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption paxUrlClasspath() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-classpath").version(versionResolver),
            paxUrl()
        );
    }

    public static ModifiableCompositeOption paxUrlWrap() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-wrap").version(versionResolver),
            mavenBundle().groupId("org.ops4j.pax.swissbox").artifactId("pax-swissbox-bnd").version(versionResolver),
            paxUrl(),
            bnd()
        );
    }

    public static ModifiableCompositeOption restassured() {
        return composite(
            config(),
            mavenBundle().groupId("io.rest-assured").artifactId("rest-assured").version(versionResolver),
            mavenBundle().groupId("io.rest-assured").artifactId("rest-assured-common").version(versionResolver),
            mavenBundle().groupId("io.rest-assured").artifactId("json-path").version(versionResolver),
            mavenBundle().groupId("io.rest-assured").artifactId("xml-path").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver),
            mavenBundle().groupId("org.apache.groovy").artifactId("groovy").version(versionResolver),
            mavenBundle().groupId("org.apache.groovy").artifactId("groovy-json").version(versionResolver),
            mavenBundle().groupId("org.apache.groovy").artifactId("groovy-xml").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.jaxb-impl").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.tagsoup").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.activation-api-1.1").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.jaxb-api-2.3").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.stax-api-1.2").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpcore-osgi").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpclient-osgi").version(versionResolver),
            hamcrest()
        );
    }

    public static ModifiableCompositeOption scr() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.metatype").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.scr").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.service.component").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.util.function").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.util.promise").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption slingCommonsCrypto() {
        return composite(
            scr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.crypto").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.jasypt").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsMetrics() {
        return composite(
            scr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.metrics").version(versionResolver),
            mavenBundle().groupId("io.dropwizard.metrics").artifactId("metrics-core").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsScheduler() {
        return composite(
            scr(),
            slingCommonsMetrics(),
            slingCommonsThreads(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.scheduler").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.servlet-api").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-jta_1.1_spec").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsThreads() {
        return composite(
            config(),
            slingCommonsMetrics(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.threads").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption spifly() {
        return composite(
            mavenBundle().groupId("org.apache.aries.spifly").artifactId("org.apache.aries.spifly.dynamic.framework.extension").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption testcontainers() {
        return composite(
            junit(),
            paxUrlWrap(),
            wrappedBundle(mavenBundle().groupId("org.rnorth.duct-tape").artifactId("duct-tape").version(versionResolver)),
            wrappedBundle(mavenBundle().groupId("org.testcontainers").artifactId("testcontainers").version(versionResolver))
        );
    }

    public static ModifiableCompositeOption thymeleaf() {
        return composite(
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.thymeleaf").version(versionResolver),
            mavenBundle().groupId("org.attoparser").artifactId("attoparser").version(versionResolver),
            mavenBundle().groupId("org.unbescape").artifactId("unbescape").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.ognl").version(versionResolver),
            mavenBundle().groupId("org.javassist").artifactId("javassist").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption webconsole() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.webconsole").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.inventory").version(versionResolver),
            mavenBundle().groupId("commons-fileupload").artifactId("commons-fileupload").version(versionResolver),
            mavenBundle().groupId("commons-io").artifactId("commons-io").version(versionResolver),
            mavenBundle().groupId("org.owasp.encoder").artifactId("encoder").version(versionResolver),
            http()
        );
    }

}
